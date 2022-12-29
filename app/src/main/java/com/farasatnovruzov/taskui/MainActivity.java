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

    private ColorStateList def;
    private TextView item1, item2, itemFull, select;
    private ImageView imageView;

    private ViewPager viewPager;

    public void addElements(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getApplication().setTheme();

        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_main);

        addElements();

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

        for(int i=0; i<1500; i++){
            cardModels.add(new CardModel(R.drawable.debit));
        }
        for(int i=0; i<1500; i++){
            cardModels.get(i);
        }

        cardAdapter = new CardAdapter(cardModels, this);
        cardAdapter.notifyDataSetChanged();
        viewPager = findViewById(R.id.viewPager);
        CircleIndicator circleIndicator = findViewById(R.id.indicator);
        viewPager.setAdapter(cardAdapter);

        circleIndicator.setViewPager(viewPager);
        viewPager.setPadding(80, 0, 0, 0);
        cardAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        CustomViewPager mViewPager = findViewById(R.id.tabViewPager);
        ViewPagerAdapter mVPAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        for(int i=0; i<1500; i++){
            mVPAdapter.addFragment(new FirstCardFragment(), "");
        }
        for(int i=0; i<1500; i++){
            mVPAdapter.addFragment(new FirstCardFragment(), "");
        }

        mViewPager.setAdapter(mVPAdapter);
        mViewPager.setPagingEnabled(false);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                for(int i=0; i<1500; i++) {
                    if (position == i) {
                        mViewPager.setCurrentItem(i);
                    }
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