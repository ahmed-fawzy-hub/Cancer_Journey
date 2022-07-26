package com.esraa.CancerJourney.ui.OnBoarding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.esraa.CancerJourneyApp.R;

public class HomeActivity extends AppCompatActivity {
    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private PagesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = findViewById(R.id.pager);
        adapter = new PagesAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    private class PagesAdapter extends FragmentStatePagerAdapter {


        public PagesAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                    return tab1;
                case 1:
                    OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                    return tab2;
                case 2:
                    OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                    return tab3;

            }
            return null;

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
