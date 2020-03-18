package com.ankushyerawar.example.recyclerviewanimation.sequentialanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ankushyerawar.example.recyclerviewanimation.R;
import com.ankushyerawar.example.recyclerviewanimation.normalanimation.AnimationAdapter;
import com.ankushyerawar.example.recyclerviewanimation.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_4);

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view_4);

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

        AnimationAdapter myAdapter = new AnimationAdapter(modelList);

        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(myAdapter, mRecyclerView);
        mRecyclerView.setAdapter(alphaInAnimationAdapter);
    }
}
