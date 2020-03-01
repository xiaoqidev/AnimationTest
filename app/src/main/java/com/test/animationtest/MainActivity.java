package com.test.animationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.animationtest.Utils.ActionStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    private Button btn;
    private ImageView image;
    private RecyclerView rv;
    private MyAdapter myAdapter;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();

        btn = findViewById(R.id.btn);
        image = findViewById(R.id.image_view);
        rv = findViewById(R.id.recycler_view);
        textview = findViewById(R.id.text_view);



        //自定义TypeEvaluator的全部用法
        Point point1 = new Point(0, 0);
        Point point2 = new Point(300, 300);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), point1, point2);
        anim.setDuration(5000);
        anim.start();

        //属性动画
        //将一个TextView在5秒中内从常规变换成全透明，再从全透明变换成常规
//        ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);
//        animator.setDuration(5000);
//        animator.start();


        //ViewPropertyAnimator的用法，animate()方法就是在Android 3.1系统上新增的一个方法，这个方法的返回值是一个ViewPropertyAnimator对象，也就是说拿到这个对象之后我们就可以调用它的各种方法来实现动画效果了，这里我们调用了alpha()方法并转入0，表示将当前的textview变成透明状态。
//      textview.animate().alpha(0f);
       // textview.animate().x(500).y(500);
        textview.animate().x(500).y(500).setDuration(5000).setInterpolator(new BounceInterpolator());


//TextView进行一次360度的旋转
//        ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);
//        animator.setDuration(5000);
//        animator.start();

//将TextView先向左移出屏幕，然后再移动回来
//        float curTranslationX = textview.getTranslationX();
//        ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "translationX", curTranslationX, -500f, curTranslationX);
//        animator.setDuration(5000);
//        animator.start();

     //   将TextView在垂直方向上放大3倍再还原
//        ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "scaleY", 1f, 3f, 1f);
//        animator.setDuration(5000);
//        animator.start();

        //组合
//        ObjectAnimator moveIn = ObjectAnimator.ofFloat(textview, "translationX", -500f, 0f);
//        ObjectAnimator rotate = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);
//        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);
//        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(rotate).with(fadeInOut).after(moveIn);
//        animSet.setDuration(5000);
//        animSet.start();

        //XML形式组合动画
//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.zuhedonghua);
//        animator.setTarget(textview);
//        animator.start();


        //Activity的切换效果
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionStart.actStart(MainActivity.this);
                overridePendingTransition(R.anim.animation_test,R.anim.anim_layout_item);
            }
        });



//recycleview的item设置出场动画
        rv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(fruitList);
        rv.setAdapter(myAdapter);

        //帧动画
        btn.setBackgroundResource(R.drawable.fram_animation);
        AnimationDrawable drawable =(AnimationDrawable) btn.getBackground();
        drawable.start();

//        image.setBackgroundResource(R.drawable.image_animation);
////        AnimationDrawable drawable1 =(AnimationDrawable) image.getBackground();
////        drawable1.start();
        image.setImageResource(R.drawable.image_animation);
        AnimationDrawable drawable1 =(AnimationDrawable) image.getDrawable();
        drawable1.start();

        //View动画
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_test);
//        btn.startAnimation(animation);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_test);
//                btn.startAnimation(animation);
//
//            }
//        });
//平移
//        TranslateAnimation translateAnimation = new TranslateAnimation(0,50,0,0);
//        translateAnimation.setDuration(3000);
//        btn.startAnimation(translateAnimation);
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(getRandomlengthName("Apple"), R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomlengthName("Banana"), R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomlengthName("Orange"), R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomlengthName("Watermelon"), R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomlengthName("Pear"), R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomlengthName("Grape"), R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomlengthName("Pineapple"), R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomlengthName("Strawberry"), R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomlengthName("Cherry"), R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomlengthName("Mango"), R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }
    private String getRandomlengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i =0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}

