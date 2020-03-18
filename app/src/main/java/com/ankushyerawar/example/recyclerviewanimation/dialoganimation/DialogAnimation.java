package com.ankushyerawar.example.recyclerviewanimation.dialoganimation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ankushyerawar.example.recyclerviewanimation.R;

import java.util.Objects;

public class DialogAnimation extends AppCompatActivity implements View.OnClickListener {

    Button mBtnShow;
    private boolean isFade = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_animation);
        setViews();

    }

    private void setViews() {
        mBtnShow = findViewById(R.id.show_dialog);
        mBtnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int type;
        if (isFade) {
            isFade = false;
            type = R.style.DialogFade;

        } else {
            isFade = true;
            type = R.style.DialogScale;
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("This is Dialog Title");
        builder.setMessage("Please read carefully, this is Dialog Message!!");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = type;
        dialog.show();

    }
}
