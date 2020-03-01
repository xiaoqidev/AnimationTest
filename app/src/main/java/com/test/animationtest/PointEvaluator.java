package com.test.animationtest;

import android.animation.TypeEvaluator;

public class PointEvaluator implements TypeEvaluator {
//如何通过对Point对象进行动画操作，从而实现整个自定义View的动画效果

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }

}
