package com.ankushyerawar.example.recyclerviewanimation.normalanimation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ankushyerawar.example.recyclerviewanimation.Model;
import com.ankushyerawar.example.recyclerviewanimation.R;

import java.util.List;

public class AnimationAdapter extends RecyclerView.Adapter<AnimationAdapter.AnimViewHolder> {

    private List<Model> mModelList;

    public AnimationAdapter(List<Model> modelList) {
        this.mModelList = modelList;
    }

    @NonNull
    @Override
    public AnimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnimViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.adapter_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AnimViewHolder holder, int position) {
        holder.mTxtTitle.setText(mModelList.get(position).getTitle());
        holder.mTxtRelease.setText(mModelList.get(position).getRelease());
        holder.mTxtDescription.setText(mModelList.get(position).getDescription());
        holder.mTxtStars.setText(String.valueOf(mModelList.get(position).getStars()));
        holder.mTxtInfo.setText(mModelList.get(position).getInfo());

        boolean isExpanded = mModelList.get(position).isExpanded();
        holder.mExpandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    class AnimViewHolder extends RecyclerView.ViewHolder {

        private TextView mTxtTitle, mTxtStars, mTxtRelease, mTxtDescription, mTxtInfo;
        private ConstraintLayout mExpandableLayout;

        AnimViewHolder(@NonNull View itemView) {
            super(itemView);

            mTxtTitle = itemView.findViewById(R.id.txt_title);
            mTxtStars = itemView.findViewById(R.id.txt_star);
            mTxtRelease = itemView.findViewById(R.id.txt_Release);
            mTxtDescription = itemView.findViewById(R.id.txt_desc);
            mTxtInfo = itemView.findViewById(R.id.txt_info);
            mExpandableLayout = itemView.findViewById(R.id.expandable_lay);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Model model = mModelList.get(getAdapterPosition());
                    model.setExpanded(!model.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
