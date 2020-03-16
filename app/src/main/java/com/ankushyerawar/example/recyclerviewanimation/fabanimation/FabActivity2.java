package com.ankushyerawar.example.recyclerviewanimation.fabanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.ankushyerawar.example.recyclerviewanimation.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FabActivity2 extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton mFabAdd, mFabOne, mFabTwo;
    private Animation fab_show, fab_hide, rotate_forward, rotate_backward;
    private Boolean isFabVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_2);
        setAnimation();
        setViews();

    }

    @Override
    public void onClick(View v) {
        fabAddClicked();
    }

    private void setAnimation() {
        fab_show = AnimationUtils.loadAnimation(this, R.anim.layout_fab_show);
        fab_hide = AnimationUtils.loadAnimation(this, R.anim.layout_fab_hide);
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
        if (isFabVisible) {
            mFabAdd.startAnimation(rotate_backward);
            mFabOne.setVisibility(View.GONE);
            mFabTwo.setVisibility(View.GONE);
            mFabOne.startAnimation(fab_hide);
            mFabTwo.startAnimation(fab_hide);
            isFabVisible = false;
        } else {
            mFabAdd.startAnimation(rotate_forward);
            mFabOne.setVisibility(View.VISIBLE);
            mFabTwo.setVisibility(View.VISIBLE);
            mFabOne.startAnimation(fab_show);
            mFabTwo.startAnimation(fab_show);
            isFabVisible = true;
        }
    }

}
