package com.ankushyerawar.example.recyclerviewanimation.sequentialanimation;

import android.view.View;

final class ViewHelper {

    static void clear(View view) {
        view.setAlpha(1.0F);
        view.setAlpha(1.0F);
        view.setScaleY(1.0F);
        view.setScaleX(1.0F);
        view.setTranslationY(0.0F);
        view.setTranslationX(0.0F);
        view.setRotation(0.0F);
        view.setRotationY(0.0F);
        view.setRotationX(0.0F);
        view.setPivotY((float) (view.getMeasuredHeight() / 2));
        view.setPivotX((float) (view.getMeasuredWidth() / 2));
        view.animate().setInterpolator(null);
    }
}

