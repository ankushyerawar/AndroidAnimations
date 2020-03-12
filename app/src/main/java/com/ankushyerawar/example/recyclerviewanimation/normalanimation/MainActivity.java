package com.ankushyerawar.example.recyclerviewanimation.normalanimation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ankushyerawar.example.recyclerviewanimation.Model;
import com.ankushyerawar.example.recyclerviewanimation.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // TODO: 12-03-2020 Choose which Activity to run From Manifest

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);

        List<Model> modelList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {

            modelList.add(
                    new Model(
                            getResources().getString(R.string.dummy_title).concat(String.valueOf(i)),
                            getResources().getString(R.string.dummy_desc)
                    )
            );
        }

        mRecyclerView.setAdapter(new AnimationAdapter(modelList));
    }
}
