package br.com.mochiladepano.foodrestriction;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MessagesTab extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Bundle args;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_tabs);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        args = getIntent().getExtras();

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            Class fragmentClass = null;

            switch (position) {
                case 0:
                    fragmentClass = MessageVegetarian.class;
                    break;
                case 1:
                    fragmentClass = MessageVegan.class;
                    break;
                case 2:
                    if (!MainActivity.getAppSettings().isSeriosMode()) {
                        fragmentClass = MessageCannibal.class;
                    }
                    break;
            }

            if (fragmentClass != null) {
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                    fragment.setArguments(args);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            return fragment;
        }

        @Override
        public int getCount() {
            if (MainActivity.getAppSettings().isSeriosMode()) {
                return 2;
            }

            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.msg_title_vegetarian);
                case 1:
                    return getResources().getString(R.string.msg_title_vegan);
                case 2:
                    if (!MainActivity.getAppSettings().isSeriosMode()) {
                        return getResources().getString(R.string.msg_title_joke_cannibal);
                    }
            }
            return null;
        }
    }
}