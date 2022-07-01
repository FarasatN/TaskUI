package com.farasatnovruzov.taskui;

import android.animation.ArgbEvaluator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.farasatnovruzov.taskui.adapters.CardAdapter;
import com.farasatnovruzov.taskui.adapters.CustomViewPager;
import com.farasatnovruzov.taskui.adapters.ViewPagerAdapter;
import com.farasatnovruzov.taskui.fragments.FirstCardFragment;
import com.farasatnovruzov.taskui.fragments.FourthCardFragment;
import com.farasatnovruzov.taskui.fragments.HomeFragment;
import com.farasatnovruzov.taskui.fragments.PaymentsFragment;
import com.farasatnovruzov.taskui.fragments.SecondCardFragment;
import com.farasatnovruzov.taskui.fragments.TemplatesFragment;
import com.farasatnovruzov.taskui.fragments.ThirdCardFragment;
import com.farasatnovruzov.taskui.fragments.TransfersFragment;
import com.farasatnovruzov.taskui.models.CardModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private boolean clickedEye = false;

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;
    private CardAdapter cardAdapter;
    private Integer[] colors = null;
    private List<CardModel> cardModels;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    private ColorStateList def;
    private TextView item1, item2, itemFull, select;
    private ImageView imageView;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getApplication().setTheme();
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_main);
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        itemFull = findViewById(R.id.selectFull);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);

        select = findViewById(R.id.select);
        def = item2.getTextColors();


        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        cardModels = new ArrayList<>();
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));
        cardModels.add(new CardModel(R.drawable.debit));

        cardAdapter = new CardAdapter(cardModels, this);
        viewPager = findViewById(R.id.viewPager);
        CircleIndicator circleIndicator = findViewById(R.id.indicator);
        viewPager.setAdapter(cardAdapter);

        circleIndicator.setViewPager(viewPager);
        viewPager.setPadding(80, 0, 0, 0);
        cardAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        CustomViewPager mViewPager = findViewById(R.id.tabViewPager);
        ViewPagerAdapter mVPAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new SecondCardFragment(), "");
        mVPAdapter.addFragment(new ThirdCardFragment(), "");
        mVPAdapter.addFragment(new FourthCardFragment(), "");

        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");
        mVPAdapter.addFragment(new FirstCardFragment(), "");


        mViewPager.setAdapter(mVPAdapter);
        mViewPager.setPagingEnabled(false);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                System.out.println("current position: " + position);
                if (position == 0) {
                    mViewPager.setCurrentItem(0);
                } else if (position == 1) {
                    mViewPager.setCurrentItem(1);
                } else if (position == 2) {
                    mViewPager.setCurrentItem(2);

                } else if (position == 3) {
                    mViewPager.setCurrentItem(3);

                } else if (position == 4) {
                    mViewPager.setCurrentItem(4);
                } else if (position == 5) {
                    mViewPager.setCurrentItem(5);

                } else if (position == 6) {
                    mViewPager.setCurrentItem(6);

                } else if (position == 7) {
                    mViewPager.setCurrentItem(7);
                } else if (position == 8) {
                    mViewPager.setCurrentItem(8);

                } else if (position == 9) {
                    mViewPager.setCurrentItem(9);

                } else if (position == 10) {
                    mViewPager.setCurrentItem(10);
                } else if (position == 11) {
                    mViewPager.setCurrentItem(11);

                } else if (position == 12) {
                    mViewPager.setCurrentItem(12);

                } else if (position == 13) {
                    mViewPager.setCurrentItem(13);
                } else if (position == 14) {
                    mViewPager.setCurrentItem(14);

                } else if (position == 15) {
                    mViewPager.setCurrentItem(15);

                } else if (position == 16) {
                    mViewPager.setCurrentItem(16);
                } else if (position == 17) {
                    mViewPager.setCurrentItem(17);

                } else if (position == 18) {
                    mViewPager.setCurrentItem(18);

                } else if (position == 19) {
                    mViewPager.setCurrentItem(19);
                } else if (position == 20) {
                    mViewPager.setCurrentItem(20);

                } else if (position == 21) {
                    mViewPager.setCurrentItem(21);

                } else if (position == 22) {
                    mViewPager.setCurrentItem(22);
                } else if (position == 23) {
                    mViewPager.setCurrentItem(23);

                } else if (position == 24) {
                    mViewPager.setCurrentItem(24);

                } else if (position == 25) {
                    mViewPager.setCurrentItem(25);
                } else if (position == 26) {
                    mViewPager.setCurrentItem(26);

                } else if (position == 27) {
                    mViewPager.setCurrentItem(27);

                } else if (position == 28) {
                    mViewPager.setCurrentItem(28);
                } else if (position == 29) {
                    mViewPager.setCurrentItem(29);

                } else if (position == 30) {
                    mViewPager.setCurrentItem(30);

                } else if (position == 31) {
                    mViewPager.setCurrentItem(31);
                } else if (position == 32) {
                    mViewPager.setCurrentItem(32);

                } else if (position == 33) {
                    mViewPager.setCurrentItem(33);

                } else if (position == 34) {
                    mViewPager.setCurrentItem(34);
                } else if (position == 35) {
                    mViewPager.setCurrentItem(35);

                } else if (position == 36) {
                    mViewPager.setCurrentItem(36);

                } else if (position == 37) {
                    mViewPager.setCurrentItem(37);
                } else if (position == 38) {
                    mViewPager.setCurrentItem(38);

                } else if (position == 39) {
                    mViewPager.setCurrentItem(39);

                } else if (position == 40) {
                    mViewPager.setCurrentItem(40);
                } else if (position == 41) {
                    mViewPager.setCurrentItem(41);

                } else if (position == 42) {
                    mViewPager.setCurrentItem(42);

                } else if (position == 43) {
                    mViewPager.setCurrentItem(43);
                } else if (position == 44) {
                    mViewPager.setCurrentItem(44);

                } else if (position == 45) {
                    mViewPager.setCurrentItem(45);

                } else if (position == 46) {
                    mViewPager.setCurrentItem(46);
                } else if (position == 47) {
                    mViewPager.setCurrentItem(47);

                } else if (position == 48) {
                    mViewPager.setCurrentItem(48);

                } else if (position == 49) {
                    mViewPager.setCurrentItem(49);
                } else if (position == 50) {
                    mViewPager.setCurrentItem(50);

                } else if (position == 51) {
                    mViewPager.setCurrentItem(51);

                } else if (position == 52) {
                    mViewPager.setCurrentItem(52);
                } else if (position == 53) {
                    mViewPager.setCurrentItem(53);

                } else if (position == 54) {
                    mViewPager.setCurrentItem(54);

                } else if (position == 55) {
                    mViewPager.setCurrentItem(55);
                } else if (position == 56) {
                    mViewPager.setCurrentItem(56);

                } else if (position == 57) {
                    mViewPager.setCurrentItem(57);

                } else if (position == 58) {
                    mViewPager.setCurrentItem(58);
                } else if (position == 59) {
                    mViewPager.setCurrentItem(59);

                } else if (position == 60) {
                    mViewPager.setCurrentItem(60);

                } else if (position == 61) {
                    mViewPager.setCurrentItem(61);
                } else if (position == 62) {
                    mViewPager.setCurrentItem(62);

                } else if (position == 63) {
                    mViewPager.setCurrentItem(63);

                } else if (position == 64) {
                    mViewPager.setCurrentItem(64);
                } else if (position == 65) {
                    mViewPager.setCurrentItem(65);

                } else if (position == 66) {
                    mViewPager.setCurrentItem(66);

                } else if (position == 67) {
                    mViewPager.setCurrentItem(67);
                } else if (position == 68) {
                    mViewPager.setCurrentItem(68);

                } else if (position == 69) {
                    mViewPager.setCurrentItem(69);

                } else if (position == 70) {
                    mViewPager.setCurrentItem(70);
                } else if (position == 71) {
                    mViewPager.setCurrentItem(71);
                } else if (position == 72) {
                    mViewPager.setCurrentItem(72);

                } else if (position == 73) {
                    mViewPager.setCurrentItem(73);

                } else if (position == 74) {
                    mViewPager.setCurrentItem(74);
                } else if (position == 75) {
                    mViewPager.setCurrentItem(75);

                } else if (position == 76) {
                    mViewPager.setCurrentItem(76);

                } else if (position == 77) {
                    mViewPager.setCurrentItem(77);
                } else if (position == 78) {
                    mViewPager.setCurrentItem(78);

                } else if (position == 79) {
                    mViewPager.setCurrentItem(79);

                } else if (position == 80) {
                    mViewPager.setCurrentItem(80);
                } else if (position == 81) {
                    mViewPager.setCurrentItem(81);

                } else if (position == 82) {
                    mViewPager.setCurrentItem(82);

                } else if (position == 83) {
                    mViewPager.setCurrentItem(83);
                } else if (position == 84) {
                    mViewPager.setCurrentItem(84);

                } else if (position == 85) {
                    mViewPager.setCurrentItem(85);

                } else if (position == 86) {
                    mViewPager.setCurrentItem(86);
                } else if (position == 87) {
                    mViewPager.setCurrentItem(87);

                } else if (position == 88) {
                    mViewPager.setCurrentItem(88);

                } else if (position == 89) {
                    mViewPager.setCurrentItem(89);
                } else if (position == 90) {
                    mViewPager.setCurrentItem(90);

                } else if (position == 91) {
                    mViewPager.setCurrentItem(91);

                } else if (position == 92) {
                    mViewPager.setCurrentItem(92);
                } else if (position == 93) {
                    mViewPager.setCurrentItem(93);

                } else if (position == 94) {
                    mViewPager.setCurrentItem(94);

                } else if (position == 95) {
                    mViewPager.setCurrentItem(95);
                } else if (position == 96) {
                    mViewPager.setCurrentItem(96);

                } else if (position == 97) {
                    mViewPager.setCurrentItem(97);

                } else if (position == 98) {
                    mViewPager.setCurrentItem(98);
                } else if (position == 99) {
                    mViewPager.setCurrentItem(99);

                } else if (position == 100) {
                    mViewPager.setCurrentItem(100);

                } else if (position == 101) {
                    mViewPager.setCurrentItem(101);
                } else if (position == 102) {
                    mViewPager.setCurrentItem(102);
                }else if (position == 103) {
                    mViewPager.setCurrentItem(103);

                } else if (position == 104) {
                    mViewPager.setCurrentItem(104);
                } else if (position == 105) {
                    mViewPager.setCurrentItem(105);

                } else if (position == 106) {
                    mViewPager.setCurrentItem(106);

                } else if (position == 107) {
                    mViewPager.setCurrentItem(107);
                } else if (position == 108) {
                    mViewPager.setCurrentItem(108);

                } else if (position == 109) {
                    mViewPager.setCurrentItem(109);

                } else if (position == 110) {
                    mViewPager.setCurrentItem(110);
                } else if (position == 111) {
                    mViewPager.setCurrentItem(111);

                } else if (position == 112) {
                    mViewPager.setCurrentItem(112);

                } else if (position == 113) {
                    mViewPager.setCurrentItem(113);
                } else if (position == 114) {
                    mViewPager.setCurrentItem(114);

                } else if (position == 115) {
                    mViewPager.setCurrentItem(115);

                } else if (position == 116) {
                    mViewPager.setCurrentItem(116);
                } else if (position == 117) {
                    mViewPager.setCurrentItem(117);

                } else if (position == 118) {
                    mViewPager.setCurrentItem(118);

                } else if (position == 119) {
                    mViewPager.setCurrentItem(119);
                } else if (position == 120) {
                    mViewPager.setCurrentItem(120);

                } else if (position == 121) {
                    mViewPager.setCurrentItem(121);

                } else if (position == 122) {
                    mViewPager.setCurrentItem(122);
                } else if (position == 123) {
                    mViewPager.setCurrentItem(123);

                } else if (position == 124) {
                    mViewPager.setCurrentItem(124);

                } else if (position == 125) {
                    mViewPager.setCurrentItem(125);
                } else if (position == 126) {
                    mViewPager.setCurrentItem(126);

                } else if (position == 127) {
                    mViewPager.setCurrentItem(127);

                } else if (position == 128) {
                    mViewPager.setCurrentItem(128);
                } else if (position == 129) {
                    mViewPager.setCurrentItem(129);

                } else if (position == 130) {
                    mViewPager.setCurrentItem(130);

                } else if (position == 131) {
                    mViewPager.setCurrentItem(131);
                } else if (position == 132) {
                    mViewPager.setCurrentItem(132);

                } else if (position == 133) {
                    mViewPager.setCurrentItem(133);

                } else if (position == 134) {
                    mViewPager.setCurrentItem(134);
                } else if (position == 135) {
                    mViewPager.setCurrentItem(135);

                } else if (position == 136) {
                    mViewPager.setCurrentItem(136);

                } else if (position == 137) {
                    mViewPager.setCurrentItem(137);
                } else if (position == 138) {
                    mViewPager.setCurrentItem(138);

                } else if (position == 139) {
                    mViewPager.setCurrentItem(139);

                } else if (position == 140) {
                    mViewPager.setCurrentItem(140);
                } else if (position == 141) {
                    mViewPager.setCurrentItem(141);

                } else if (position == 142) {
                    mViewPager.setCurrentItem(142);

                } else if (position == 143) {
                    mViewPager.setCurrentItem(143);
                } else if (position == 144) {
                    mViewPager.setCurrentItem(144);

                } else if (position == 145) {
                    mViewPager.setCurrentItem(145);

                } else if (position == 146) {
                    mViewPager.setCurrentItem(146);
                } else if (position == 147) {
                    mViewPager.setCurrentItem(147);

                } else if (position == 148) {
                    mViewPager.setCurrentItem(148);

                } else if (position == 149) {
                    mViewPager.setCurrentItem(149);
                } else if (position == 150) {
                    mViewPager.setCurrentItem(150);

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("current mViewPager position: " + position);
                if (position == 0) {
                    itemFull.setVisibility(View.INVISIBLE);
                } else if (position == 1) {
                    itemFull.setVisibility(View.INVISIBLE);
                } else if (position == 2) {
                    itemFull.setVisibility(View.VISIBLE);
                } else if (position == 3) {
                    itemFull.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!clickedEye) {
                    imageView.setImageResource(R.drawable.eye_off_outline);
                    clickedEye = true;
                } else if (clickedEye) {
                    imageView.setImageResource(R.drawable.eye_outline);
                    clickedEye = false;
                }
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        replaceFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.payments:
                    replaceFragment(new PaymentsFragment());
                    break;
                case R.id.transfers:
                    replaceFragment(new TransfersFragment());
                    break;
                case R.id.templates:
                    replaceFragment(new TemplatesFragment());
                    break;
            }

            return true;
        });

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.constrainLayoutMain, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.item1) {
            select.animate().x(0).setDuration(100);
            item2.setTextColor(def);
            select.setTextColor(Color.BLACK);
        } else if (view.getId() == R.id.item2) {
            select.animate().x(0).setDuration(100);
            item1.setTextColor(def);
            select.setTextColor(Color.BLACK);
            int size = item2.getWidth();
            select.animate().x(size).setDuration(100);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item1:
                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item2:
                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item3:
                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item4:
                Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}