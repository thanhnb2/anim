package com.example.demoanim;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class custom extends View {
    private Paint paintCircle;
    private Paint paintEye;
    private RectF rectF;
    private int mW;
    private int mH;

    public custom(Context context) {
        super(context);
    }

    public custom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paintCircle = new Paint();
        paintCircle.setColor(Color.YELLOW);

        paintEye = new Paint();
        paintEye.setColor(Color.BLACK);
    }

    @SuppressLint({"ResourceAsColor", "DrawAllocation"})
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mH = MeasureSpec.getSize(heightMeasureSpec);
        mW = MeasureSpec.getSize(widthMeasureSpec);
        rectF = new RectF(0f, 0f, mW, mH);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rectF, 30f, 300f, true, paintCircle);
        int mRadiusEye = 25;
        canvas.drawCircle((float) mH / 8 * 5, (float) mW / 4, mRadiusEye, paintEye);
    }
}
