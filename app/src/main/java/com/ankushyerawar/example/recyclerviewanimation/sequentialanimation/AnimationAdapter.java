package com.ankushyerawar.example.recyclerviewanimation.sequentialanimation;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AnimationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private Interpolator mInterpolator = new LinearInterpolator();
    private int mLastPosition = -1;
    private int mCounter;
    private boolean mAnimInitialized;

    public AnimationAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        this.mAdapter = adapter;
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return this.mAdapter.onCreateViewHolder(parent, viewType);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        mAdapter.onBindViewHolder(holder, position);
        if (position <= this.mLastPosition) {
            ViewHelper.clear(holder.itemView);
        } else {
            Animator[] animators = getAnimators(holder.itemView);

            LinearLayoutManager layoutManager = ((LinearLayoutManager) getRecyclerView().getLayoutManager());
            assert layoutManager != null;
            int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();

            if (!mAnimInitialized && firstVisiblePosition == 0) {

                for (final Animator anim : animators) {

                    anim.setDuration((long) 300); //set the duration from here
                    anim.setInterpolator(mInterpolator);
                    increaseCounter();

                    anim.setStartDelay(75 * position);
                    anim.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            if (decreaseCounter()) {
                                mAnimInitialized = true;
                            }
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }
                    });
                    anim.start();
                }
            }
            else {
                holder.itemView.setAlpha(1);
            }

            this.mLastPosition = position;
        }
    }

    private synchronized boolean decreaseCounter() {
        mCounter--;
        return mCounter == 0;
    }

    private synchronized void increaseCounter() {
        mCounter++;
    }

    public int getItemCount() {
        return this.mAdapter.getItemCount();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    protected abstract Animator[] getAnimators(View var1);

    protected abstract RecyclerView getRecyclerView();

    public int getItemViewType(int position) {
        return this.mAdapter.getItemViewType(position);
    }

}
