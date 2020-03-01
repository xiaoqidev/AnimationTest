package com.test.animationtest;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

public class MyAdapter extends BaseQuickAdapter<Fruit, BaseViewHolder> {

    public MyAdapter( List data) {
        super(R.layout.fruit_item, data);
    }



    @Override
    protected void convert(BaseViewHolder baseViewHolder, Fruit fruit) {
        baseViewHolder.setText(R.id.fruit_name,fruit.getName());
        baseViewHolder.setImageResource(R.id.fruit_image,fruit.getImageId());
    }
}
