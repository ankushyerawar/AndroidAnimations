package com.ankushyerawar.example.recyclerviewanimation.gridanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ankushyerawar.example.recyclerviewanimation.normalanimation.AnimationAdapter;
import com.ankushyerawar.example.recyclerviewanimation.Model;
import com.ankushyerawar.example.recyclerviewanimation.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view_1);

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
