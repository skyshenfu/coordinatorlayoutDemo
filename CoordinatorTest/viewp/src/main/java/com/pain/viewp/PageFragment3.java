package com.pain.viewp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PageFragment3 extends Fragment {
    private View rootview;
    public PageFragment3() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fg1, container, false);
        ImageView img= (ImageView) rootView.findViewById(R.id.img);
        img.setBackgroundResource(R.mipmap.pn3);
        this.rootview=rootView;
        return rootView;
    }
    public View getRootview() {
        return rootview;
    }
}
