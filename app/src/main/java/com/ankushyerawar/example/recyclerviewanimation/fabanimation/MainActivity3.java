package com.ankushyerawar.example.recyclerviewanimation.fabanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.ankushyerawar.example.recyclerviewanimation.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton mFabAdd, mFabAdd1, mFabOne, mFabTwo, mFabThree, mFabFour;
    private Animation fab_open, fab_close, fab_show, fab_hide, rotate_forward, rotate_backward;
    private Boolean isFabOpen = false, isFabVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        setAnimation();
        setViews();
    }

    @Override
    public void onClick(View fab) {
        switch (fab.getId()) {
            case R.id.add_fab:
                fabAddClicked();
                break;

            case R.id.add_fab_1:
                fabAdd1Clicked();
                break;
        }
    }

    private void setAnimation() {
        fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close);
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

        mFabAdd1 = findViewById(R.id.add_fab_1);
        mFabThree = findViewById(R.id.fab_three);
        mFabFour = findViewById(R.id.fab_four);
        mFabAdd1.setOnClickListener(this);
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

    private void fabAdd1Clicked() {
        if (isFabVisible) {
            mFabAdd1.startAnimation(rotate_backward);
            mFabThree.setVisibility(View.GONE);
            mFabFour.setVisibility(View.GONE);
            mFabThree.startAnimation(fab_hide);
            mFabFour.startAnimation(fab_hide);
            isFabVisible = false;
        } else {
            mFabAdd1.startAnimation(rotate_forward);
            mFabThree.setVisibility(View.VISIBLE);
            mFabFour.setVisibility(View.VISIBLE);
            mFabThree.startAnimation(fab_show);
            mFabFour.startAnimation(fab_show);
            isFabVisible = true;
        }
    }
}
