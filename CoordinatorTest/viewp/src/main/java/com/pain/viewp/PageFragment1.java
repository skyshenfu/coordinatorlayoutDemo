package com.pain.viewp;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class PageFragment1 extends Fragment {
    private View rootview;
    public PageFragment1() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fg1, container, false);
        ImageView img= (ImageView) rootView.findViewById(R.id.img);
        img.setBackgroundResource(R.mipmap.pn1);
        AnimationSet set=new AnimationSet(true);
        ScaleAnimation scaleAnimation=new ScaleAnimation(1.0f,1.0f,1.0f,0.8f,Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(200);
        AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.8f);
        alphaAnimation.setDuration(200);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);
        set.setFillAfter(true);
        this.rootview=rootView;
        return rootView;
    }

    public View getRootview() {
        return rootview;
    }
}
