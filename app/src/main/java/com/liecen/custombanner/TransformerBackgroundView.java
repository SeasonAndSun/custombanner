package com.liecen.custombanner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liecen.custombanner.banner.Banner;
import com.liecen.custombanner.banner.listener.OnPageChangeListener;
import com.liecen.custombanner.banner.util.BannerUtils;

import java.util.ArrayList;

/**
 * com.liecen.custombanner
 * Author by MengQianYi, Date on 2021/12/2.
 * Not easy to write code, please indicate.
 */
public class TransformerBackgroundView extends RelativeLayout {

    private View right;
    private Path path;
    private Paint paint;
    private ArrayList<String> colors;
    private int olodPosition;

    public TransformerBackgroundView(@NonNull Context context) {
        this(context, null);
    }

    public TransformerBackgroundView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {

        path = new Path();
        paint = new Paint();

        right = new RoundView(context);
        RelativeLayout.LayoutParams rightParams = new LayoutParams(10, 10);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rightParams.addRule(RelativeLayout.CENTER_VERTICAL);
        right.setLayoutParams(rightParams);

        addView(right);
    }

    @Override
    public void draw(Canvas canvas) {

        path.addCircle(getWidth() / 2,
                -getWidth() * 2
                        + getHeight() / 2       //   弧底居中
                        + BannerUtils.dp2px(10)       //   弧底位置 微调
                , getWidth() * 2
                , Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawPath(path, paint);
        super.draw(canvas);
    }


    public void setupWithViewPager(Banner banner) {

        banner.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                Log.d("MengQianYi", "onPageScrolled: position=" + position + "  positionOffset=" + positionOffset + "     positionOffsetPixels =" + positionOffsetPixels);

//                double sqrt = Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2));

                if (olodPosition > position || (olodPosition == 0 && position == colors.size() - 1)) {      // 左滑

                    Log.d("MengQianYi", "onPageScrolled:  >>>>>>左滑");


                    setBackgroundColor(Color.parseColor(colors.get(position)));

                    if (position == colors.size() - 1) {
                        setBackgroundColor(Color.parseColor(colors.get(colors.size() - 1)));
                        right.setBackgroundColor(Color.parseColor(colors.get(0)));
                    } else {
                        right.setBackgroundColor(Color.parseColor(colors.get(position + 1)));
                    }

                } else if (olodPosition <= position) {
                    //  右滑
                    Log.d("MengQianYi", "onPageScrolled:  <<<<<<右滑");

                    if (position == colors.size() - 1) {
                        right.setBackgroundColor(Color.parseColor(colors.get(0)));
                    } else {
                        right.setBackgroundColor(Color.parseColor(colors.get(position + 1)));
                    }
                }

                if (positionOffset == 0) {
                    right.setScaleX(0);
                    right.setScaleY(0);

                    setBackgroundColor(Color.parseColor(colors.get(position)));


                    olodPosition = position;

                } else {
                    right.setScaleX(getWidth() * positionOffset / right.getWidth() * 4F);
                    right.setScaleY(getWidth() * positionOffset / right.getWidth() * 4F);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setTransformerColors(ArrayList<String> colors) {
        this.colors = colors;
        setBackgroundColor(Color.parseColor(colors.get(0)));
        right.setBackgroundColor(Color.parseColor(colors.get(1)));

    }
}
