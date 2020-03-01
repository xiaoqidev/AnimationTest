package com.test.animationtest.Utils;

import android.content.Context;
import android.content.Intent;

import com.test.animationtest.SecondActivity;

public class ActionStart {
    public static void actStart(Context context){
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
    }
}
