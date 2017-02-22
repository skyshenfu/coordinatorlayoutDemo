package com.pain.viewp;

import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.pain.viewp.animation.DepthPageTransformer;
import com.pain.viewp.animation.RotateDownTransformer;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll= (LinearLayout) findViewById(R.id.ll);
        viewPager= (ViewPager) findViewById(R.id.vp);
        final ScreenSlidePagerAdapter adapter=new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setPageTransformer(true,new GallyPageTransformer());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
/*                View view=(PageFragment2)adapter.getItem(position);
                ObjectAnimator.ofFloat(view,"scaleY",1.0f,1.25f).setDuration(500);*/

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });
        viewPager.setOffscreenPageLimit(4);

    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            if (position==0){
                fragment=new PageFragment1();

            }else if (position==1){
                fragment=new PageFragment2();
            }else if (position==2){
                fragment=new PageFragment3();
            }else if (position==3){
                fragment=new PageFragment4();
            }
            return fragment;
        }
        @Override
        public int getCount() {
            return 4;
        }
    }
}
