package com.test.animationtest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;

import androidx.annotation.Nullable;

public class MyAnimView extends View {

    private String color;

    public String getColor() {
        return color;
    }
//在setColor()方法当中，我们编写了一个非常简单的逻辑，就是将画笔的颜色设置成方法参数传入的颜色，然后调用了invalidate()方法。这段代码虽然只有三行，但是却执行了一个非常核心的功能，就是在改变了画笔颜色之后立即刷新视图，然后onDraw()方法就会调用。在onDraw()方法当中会根据当前画笔的颜色来进行绘制，这样颜色也就会动态进行改变了。
    public void setColor(String color) {
        this.color = color;
        mpaint.setColor(Color.parseColor(color));
        invalidate();
    }


    public static final float RADIUS = 50f;
    private Point currentPoint;
    private final Paint mpaint;

    public MyAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mpaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint ==null){
            currentPoint = new Point(RADIUS,RADIUS);
            drawCircle(canvas);
            startAnimation2();
        }else {
            drawCircle(canvas);
        }
    }

    private void startAnimation2() {
        Point startPoint = new Point(getWidth() / 2, RADIUS);
        Point endPoint= new Point(getWidth() / 2, getHeight() - RADIUS);
//valueAnimation的高级用法
        //如何通过对Point对象进行动画操作，从而实现整个自定义View的动画效果

        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();

            }
        });

        ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), "#0000FF", "#FF0000");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(anim).with(anim2);
        animatorSet.setInterpolator(new DecelerateAccelerateInterpolator());
        //animatorSet.setInterpolator(new BounceInterpolator());
        //animatorSet.setInterpolator(new AccelerateInterpolator(2f));
        animatorSet.setDuration(5000);
        animatorSet.start();
    }

    private void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x,y,RADIUS,mpaint);
    }
}
