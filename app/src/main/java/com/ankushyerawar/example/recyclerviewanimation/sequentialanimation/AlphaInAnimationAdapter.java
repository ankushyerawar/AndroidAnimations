package com.ankushyerawar.example.recyclerviewanimation.sequentialanimation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class AlphaInAnimationAdapter extends AnimationAdapter {

    private RecyclerView recyclerView;

    public AlphaInAnimationAdapter(RecyclerView.Adapter adapter, RecyclerView recyclerView) {
        super(adapter);
        this.recyclerView = recyclerView;
    }

    protected Animator[] getAnimators(View view) {
        view.setAlpha(0);
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0F)};
    }

    protected RecyclerView getRecyclerView() {
        return recyclerView;
    }

}
