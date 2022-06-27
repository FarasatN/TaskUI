package com.farasatnovruzov.taskui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.animation.ArgbEvaluator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.farasatnovruzov.taskui.fragments.BlockedFragment;
import com.farasatnovruzov.taskui.fragments.FirstCardFragment;
import com.farasatnovruzov.taskui.fragments.FourthCardFragment;
import com.farasatnovruzov.taskui.fragments.LastOperationsFragment;
import com.farasatnovruzov.taskui.fragments.SecondCardFragment;
import com.farasatnovruzov.taskui.fragments.ThirdCardFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    boolean clickedEye = false;

    Toolbar toolbar;
//    androidx.appcompat.widget.Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    ViewPager viewPager;
    Adapter adapter;
    Integer[] colors = null;
    List<Model> models;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    ColorStateList def;
    TextView item1, item2, select;




    List<Fragment> fragmentList = new ArrayList<>();
    List<String> tabTitle = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            toolbar = findViewById(R.id.toolbar);
//            setSupportActionBar(toolbar);
//        }

//        toolbar.setTitle("AFBBANK");
//        toolbar.setNavigationIcon(R.drawable.ic_launcher_foreground);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(5f);
        }
//        getSupportActionBar().setHomeAsUpIndicator( R.drawable.menu);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
//        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);




        models = new ArrayList<>();
        models.add(new Model(R.drawable.debit));
        models.add(new Model(R.drawable.debit2));
        models.add(new Model(R.drawable.debit3));
        models.add(new Model(R.drawable.debit4));
        adapter = new Adapter(models,this);
//        viewPager = findViewById(R.id.viewPager);

        ViewPager viewPager = findViewById(R.id.viewPager);
        FragmentViewPagerAdapter fragmentAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        CircleIndicator circleIndicator = findViewById(R.id.indicator);

        viewPager.setAdapter(adapter);

//        viewPager.setAdapter(fragmentAdapter);
        circleIndicator.setViewPager(viewPager);
//        adapter.registerDataSetObserver(indicator.getDataSetObserver());
//        indicator.createIndicators(5,0);
//        indicator.animatePageSelected(2);


//        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(),fragmentList,tabTitle);
//        TabLayout tabLayout = findViewById(R.id.tabLayout);
//        tabLayout.setupWithViewPager(viewPager);



//        LastOperationsFragment lastOperationsFragment = new LastOperationsFragment();
//        fragmentList.add(lastOperationsFragment);
//        tabTitle.add("Son Əməliyyatlar");
//        BlockedFragment blockedFragment = new BlockedFragment();
//        fragmentList.add(blockedFragment);
//        tabTitle.add("Bloklaşdırılmış");






        TabLayout mTabLayout = findViewById(R.id.tabLayout);
        ViewPager mViewPager = findViewById(R.id.tabViewPager);
        ViewPagerAdapter mVPAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        mVPAdapter.addFragment(new FirstCardFragment(),"");
        mVPAdapter.addFragment(new SecondCardFragment(),"");
        mVPAdapter.addFragment(new ThirdCardFragment(),"");
        mVPAdapter.addFragment(new FourthCardFragment(),"");

//        adapter.getAdapterPosition()=mVPAdapter.getAdapterPosition();
//        int pos = viewPager.getCurrentItem();
//        mViewPager.setCurrentItem(pos);
        mTabLayout.setupWithViewPager(mViewPager);
//        System.out.println("pos: "+pos);


//        if(viewPager.getCurrentItem() == 0){
//            mViewPager.setCurrentItem(0);
//        }else if(viewPager.getCurrentItem() == 1){
//            mViewPager.setCurrentItem(1);
//        }else if(viewPager.getCurrentItem() == 2){
//            mViewPager.setCurrentItem(2);
//        }else if(viewPager.getCurrentItem() == 3){
//            mViewPager.setCurrentItem(3);
//        }
        mViewPager.setAdapter(mVPAdapter);
//        viewPager.setAdapter(mVPAdapter);
//        mViewPager.setAdapter(adapter);







        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)

        };
        colors = colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position < (adapter.getCount() - 1) && position < (colors.length-1)){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,colors[position], colors[position+1]));
                }else{
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("current position: "+position);
                if(position == 0){
                    mViewPager.setCurrentItem(0);
                }else if(position == 1){
                    mViewPager.setCurrentItem(1);
                }else if(position == 2){
                    mViewPager.setCurrentItem(2);
                }else if(position == 3){
                    mViewPager.setCurrentItem(3);
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
                System.out.println("current mViewPager position: "+position);
                if(position == 0){
                    viewPager.setCurrentItem(0);
                }else if(position == 1){
                    viewPager.setCurrentItem(1);
                }else if(position == 2){
                    viewPager.setCurrentItem(2);
                }else if(position == 3){
                    viewPager.setCurrentItem(3);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });





        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);

        select = findViewById(R.id.select);
        def = item2.getTextColors();



        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickedEye == false){
                    imageView.setImageResource(R.drawable.eye_off_outline);
                    clickedEye = true;
                }else if(clickedEye == true){
                    imageView.setImageResource(R.drawable.eye_outline);
                    clickedEye = false;
                }
            }
        });
    }

//    public void onEyeClick(){
//
//    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.item1){
            select.animate().x(0).setDuration(100);
//            item1.setTextColor(Color.WHITE);
            item2.setTextColor(def);
            select.setTextColor(Color.BLACK);
        }else if(view.getId() == R.id.item2){
            select.animate().x(0).setDuration(100);
            item1.setTextColor(def);
//            item2.setTextColor(Color.WHITE);
            select.setTextColor(Color.BLACK);
            int size = item2.getWidth();
            select.animate().x(size).setDuration(100);
        }
    }






    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
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
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }



//    class ViewPagerAdapter1 extends FragmentStateAdapter{
//
//
//        private final List<Fragment> fragmentList = new ArrayList<>();
//        private final List<String> fragmentTitleList = new ArrayList<>();
//
//        public ViewPagerAdapter1(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
//            super(fragmentManager, lifecycle);
//        }
//
//        public void addFragment(Fragment fragment, String title){
//            fragmentList.add(fragment);
//            fragmentTitleList.add(title);
//        }
//
//        @NonNull
//        @Override
//        public Fragment createFragment(int position) {
//            return fragmentList.get(position);
//        }
//
//        @Override
//        public int getItemCount() {
//            return fragmentList.size();
//        }
//    }





    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_items_only, menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.menu_item1) {
//            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
//        }
//        else if(item.getItemId() == R.id.menu_item2){
//            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
//        }
//        else if(item.getItemId() == R.id.menu_item3){
//            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
//        }
//            return super.onOptionsItemSelected(item);
//
//}
}