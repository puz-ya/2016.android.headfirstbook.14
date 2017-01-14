package com.yd.pizzamaterialdesign;

/**
 * Created by YD on 13.01.2017.
 */

public class Pizza {

    private String mName;
    private int mImageID;

    public static final Pizza[] mPizzas = {
        new Pizza("Diavolo", R.drawable.diavolo),
        new Pizza("Funhi", R.drawable.funghi)
    };

    public Pizza(String s, int i){
        mName = s;
        mImageID = i;
    }

    public String getName() {
        return mName;
    }
    public int getImageResourceId() {
        return mImageID;
    }
}
