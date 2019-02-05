package com.example.sofiane.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment_One.OnFragmentInteractionListener {

    static Fragment_One fragment_one;
    static Fragment_Two fragment_two;
    MyPagerAdapter myPagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_one= new Fragment_One();
        fragment_two = new Fragment_Two();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
         myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
    }

    @Override
    public void onFragmentInteraction(String name, String desc) {
        myPagerAdapter.onFragmentInteraction(name,desc);

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter implements Fragment_One.OnFragmentInteractionListener{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return fragment_one;
                case 1:
                    return fragment_two;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

        @Override
        public void onFragmentInteraction(String name, String desc) {
            fragment_two.onFragmentInteraction(name, desc);
        }
    }
}
