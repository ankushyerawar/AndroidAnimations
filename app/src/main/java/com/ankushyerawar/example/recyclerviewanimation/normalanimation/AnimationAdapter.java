package com.ankushyerawar.example.recyclerviewanimation.normalanimation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        holder.mTxtDescription.setText(mModelList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    class AnimViewHolder extends RecyclerView.ViewHolder {

        private TextView mTxtTitle, mTxtDescription;

        AnimViewHolder(@NonNull View itemView) {
            super(itemView);

            mTxtTitle = itemView.findViewById(R.id.txt_title);
            mTxtDescription = itemView.findViewById(R.id.txt_desc);


        }
    }
}
