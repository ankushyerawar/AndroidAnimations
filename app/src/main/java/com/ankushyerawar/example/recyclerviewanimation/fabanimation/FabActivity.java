package com.ankushyerawar.example.recyclerviewanimation.fabanimation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.ankushyerawar.example.recyclerviewanimation.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FabActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton mFabAdd, mFabOne, mFabTwo;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    private Boolean isFabOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        setAnimation();
        setViews();
    }

    @Override
    public void onClick(View fab) {
        fabAddClicked();
    }

    private void setAnimation() {
        fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);
    }

    private void setViews() {
        mFabAdd = findViewById(R.id.add_fab);
        mFabOne = findViewById(R.id.fab_one);
        mFabTwo = findViewById(R.id.fab_two);
        mFabAdd.setOnClickListener(this);
    }

    private void fabAddClicked() {
        if (isFabOpen) {
            mFabAdd.startAnimation(rotate_backward);
            mFabOne.startAnimation(fab_close);
            mFabTwo.startAnimation(fab_close);
            isFabOpen = false;
        } else {
            mFabAdd.startAnimation(rotate_forward);
            mFabOne.startAnimation(fab_open);
            mFabTwo.startAnimation(fab_open);
            isFabOpen = true;
        }
    }
}
