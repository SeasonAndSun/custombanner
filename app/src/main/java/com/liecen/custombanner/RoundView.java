package com.liecen.custombanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * com.liecen.custombanner
 * Author by MengQianYi, Date on 2021/12/2.
 * Not easy to write code, please indicate.
 */

public class RoundView extends View {

    public RoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundView(Context context) {
        super(context);
    }

    @Override
    public void draw(Canvas canvas) {
        Path path = new Path();
        Paint paint = new Paint();
        path.addCircle(getWidth()/2,getHeight()/2,getWidth()/2,Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawPath(path, paint);
        super.draw(canvas);
    }
}