package com.example.demoanim;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Animation anmScale;
    private Animation anmRotate;
    private Animation anmAlpha;
    private Animation anmTranslate;
    private View ctv;

    private Button btnScale;
    private Button btnRotate;
    private Button btnAlpha;
    private Button btnTranslate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        handlerEvent();

    }

    private void initData() {
        ctv = findViewById(R.id.ctv);
        anmScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        anmRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        anmAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        anmTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);


        btnScale = findViewById(R.id.btnScale);
        btnRotate = findViewById(R.id.btnRotate);
        btnAlpha = findViewById(R.id.btnAlpha);
        btnTranslate = findViewById(R.id.btnTranslate);
    }

    private void handlerEvent() {
        btnScale.setOnClickListener(view -> {
            startAnim(anmScale);
        });
        btnRotate.setOnClickListener(view -> {
            startAnim(anmRotate);
        });
        btnAlpha.setOnClickListener(view -> {
            startAnim(anmAlpha);
        });
        btnTranslate.setOnClickListener(view -> {
            startAnim(anmTranslate);
        });
    }

    private void startAnim(Animation anm) {
        if (ctv.getAnimation() != null) {
            ctv.clearAnimation();
        }
        ctv.startAnimation(anm);
    }


}
