package com.ankushyerawar.example.recyclerviewanimation.normalanimation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ankushyerawar.example.recyclerviewanimation.Model;
import com.ankushyerawar.example.recyclerviewanimation.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // TODO: 12-03-2020 Choose which Activity to run From Manifest
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        fab = findViewById(R.id.fab);
        setOnScrollListener(mRecyclerView);

        List<Model> modelList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {

            modelList.add(
                    new Model(
                            getResources().getString(R.string.dummy_title).concat(String.valueOf(i)),
                            getResources().getString(R.string.dummy_desc),
                            "This is Some Info To Show like Lorem ipsum, " + getResources().getString(R.string.dummy_desc),
                            i + " June 2020",
                            i
                    )
            );
        }

        mRecyclerView.setAdapter(new AnimationAdapter(modelList));
    }

    private void setOnScrollListener(RecyclerView recyclerView) {

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //hide fab button like pop-up
                if (dy > 0 && fab.getVisibility() == View.VISIBLE) {
                    fab.hide();
                } else if (dy < 0 && fab.getVisibility() != View.VISIBLE) {
                    fab.show();
                }

                //hide fab button like sliding
                /*if (dy > 0) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) fab.getLayoutParams();
                    int fab_bottomMargin = layoutParams.bottomMargin;
                    fab.animate().translationY(fab.getHeight() + fab_bottomMargin).setInterpolator(new LinearInterpolator()).start();
                } else if (dy < 0) {
                    fab.animate().translationY(0).setInterpolator(new LinearInterpolator()).start();
                }*/

            }
        });
    }

}
