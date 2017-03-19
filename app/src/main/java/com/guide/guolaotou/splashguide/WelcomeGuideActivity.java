package com.guide.guolaotou.splashguide;


import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class WelcomeGuideActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager viewPager;
    private GuideViewPagerAdapter pagerAdapter;
    private List<View> views;
    private Button startBtn;

    private static final int pics[] = {R.layout.guide_view1,R.layout.guide_view2,
            R.layout.guide_view3,R.layout.guide_view4};
    private ImageView[] dots;
    private int currentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_guide);
        views = new ArrayList<>();
        for(int i=0;i<pics.length;i++)
        {
            View view  = LayoutInflater.from(this).inflate(pics[i],null);
            if(i==pics.length-1) {
                startBtn = (Button) findViewById(R.id.btn_1);
                startBtn.setTag("enter");
                startBtn.setOnClickListener(this);
            }
            views.add(view);
        }
        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        pagerAdapter = new GuideViewPagerAdapter(views);
        viewPager.setAdapter(pagerAdapter);
        initDots();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Sp_Utils.putBoolen(WelcomeGuideActivity.this,AppConstants.First_Open,true);
        finish();
    }

    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        dots = new ImageView[pics.length];
        for(int i=0;i<pics.length;i++)
        {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(false);
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(true);
    }
    private void setCurView(int position)
    {
        if(position<0 ||position>=pics.length)
        {
            return ;
        }
        viewPager.setCurrentItem(position);
    }
    private void setCurDot(int position)
    {
        if(position<0||position>=pics.length||position==currentIndex)
        {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
    }
    @Override
    public void onClick(View v) {
    if (v.getTag().equals("enter"))
    {
        enterMainActivity();
        return;
    }
    int position = (int) v.getTag();
        setCurDot(position);
        setCurView(position);
    }
    private void enterMainActivity()
    {
        Intent intent = new Intent(WelcomeGuideActivity.this,
                Splash_Activity.class);
        startActivity(intent);
        Sp_Utils.putBoolen(WelcomeGuideActivity.this,AppConstants.First_Open,true);
        finish();
    }
    private class PageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            setCurDot(state);
        }
    }
}
