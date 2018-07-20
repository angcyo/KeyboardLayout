package com.angcyo.keyboardlayout;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;

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

    @Override
    public Drawable getDrawable() {
        Log.i("angcyo", "getDrawable");
        //return new ColorDrawable(Color.RED);
        return null;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Log.i("angcyo", "getSize");
        //return super.getSize(paint, text, start, end, fm);
        size = (int) paint.measureText(text.subSequence(start, end).toString());

        if (fm != null) {
            fm.ascent = -40;
            fm.descent = 40;

//            fm.top = 300;
//            fm.bottom = 300;

            fm.top = fm.ascent;
            fm.bottom = fm.descent;
        }

        return size;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        //super.draw(canvas, text, start, end, x, top, y, bottom, paint);
        Log.i("angcyo", "draw");
        int oldColor = paint.getColor();
        paint.setColor(Color.RED);
        if (mRectF == null) {
            mRectF = new RectF();
        }
        int offset = 4;
        mRectF.set(x - offset, top - offset, x + size + offset, y + offset * 2);
        canvas.drawRoundRect(mRectF, 20f, 20f, paint);
        paint.setColor(oldColor);
        canvas.drawText(text, start, end, x, y, paint);
    }
}
