package com.angcyo.keyboardlayout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2018/07/20 16:49
 * 修改人员：Robi
 * 修改时间：2018/07/20 16:49
 * 修改备注：
 * Version: 1.0.0
 */
public class ShapeSpan extends DynamicDrawableSpan {
    int size;
    RectF mRectF;
    int bgColor;
    float roundSize;

    int padding = 0;
    int margin = 0;

    public ShapeSpan(int bgColor, float roundSize) {
        this.bgColor = bgColor;
        this.roundSize = roundSize;
    }

    public ShapeSpan(int bgColor, float roundSize, int padding, int margin) {
        this.bgColor = bgColor;
        this.roundSize = roundSize;
        this.padding = padding;
        this.margin = margin;
    }

    @Override
    public Drawable getDrawable() {
        return null;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        size = (int) paint.measureText(text.subSequence(start, end).toString()) + 2 * padding + 2 * margin;
        return size;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        int oldColor = paint.getColor();
        paint.setColor(bgColor);
        if (mRectF == null) {
            mRectF = new RectF();
        }
        mRectF.set(x + margin, top - margin, x + size - margin, bottom + margin);
        canvas.drawRoundRect(mRectF, roundSize, roundSize, paint);
        paint.setColor(oldColor);
        canvas.drawText(text, start, end, x + margin + padding, y, paint);
    }
}
