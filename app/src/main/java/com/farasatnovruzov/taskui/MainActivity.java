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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.ArgbEvaluator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import com.farasatnovruzov.taskui.fragments.HomeFragment;
import com.farasatnovruzov.taskui.fragments.LastOperationsFragment;
import com.farasatnovruzov.taskui.fragments.PaymentsFragment;
import com.farasatnovruzov.taskui.fragments.SecondCardFragment;
import com.farasatnovruzov.taskui.fragments.TemplatesFragment;
import com.farasatnovruzov.taskui.fragments.ThirdCardFragment;
import com.farasatnovruzov.taskui.fragments.TransfersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
    Adapter adapter;
    Integer[] colors = null;
    List<Model> models;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    ColorStateList def;
    TextView item1, item2, select;


    private ViewPager viewPager;
    private ViewPager sliderViewPager;
    private Handler sliderHandler = new Handler();


    List<Fragment> fragmentList = new ArrayList<>();
    List<String> tabTitle = new ArrayList<>();


    private Runnable sliderRunnable  = new Runnable() {
        @Override
        public void run() {
            sliderViewPager.setCurrentItem(sliderViewPager.getCurrentItem() + 1);
        }
    };

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

        sliderViewPager = findViewById(R.id.viewPager);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.debit));
        sliderItems.add(new SliderItem(R.drawable.debit));
        sliderItems.add(new SliderItem(R.drawable.debit));
        sliderItems.add(new SliderItem(R.drawable.debit));
//        sliderViewPager.setAdapter(new SliderAdapter(sliderItems, sliderViewPager));
//        sliderViewPager.setClipToPadding(false);
//        sliderViewPager.setClipChildren(false);
//        sliderViewPager.setOffscreenPageLimit(3);
//        sliderViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager.PageTransformer(){

//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r = 1 - Math.abs(position);
//                page.setScaleY(0.85f + r * 0.15f);
//            }
//        });
//
//        sliderViewPager.setPageTransformer(compositePageTransformer);
//        sliderViewPager.registerOnPageChangeCallBack(new ViewPager2.OnPageChangeCallback{
//            @Override
//                    public void onPageSelected(int position){
//                super.onPageSelected(position);
//                sliderHandler.removeCallbacks(sliderRunnable);
//                sliderHandler.postDelayed(sliderRunnable, 3000)
//            }
//        });


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
        models.add(new Model(R.drawable.debit));
        models.add(new Model(R.drawable.debit));
        models.add(new Model(R.drawable.debit));
        adapter = new Adapter(models,this);
//        viewPager = findViewById(R.id.viewPager);

        viewPager = findViewById(R.id.viewPager);
        FragmentViewPagerAdapter fragmentAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        CircleIndicator circleIndicator = findViewById(R.id.indicator);
//        viewPager.setAdapter(new Adapter(models, viewPager));
        viewPager.setAdapter(adapter);

//        viewPager.setAdapter(fragmentAdapter);
        circleIndicator.setViewPager(viewPager);
//        viewPager.setClipToPadding(true);
//        viewPager.setClipChildren(true);
//        viewPager.setOffscreenPageLimit(3);
        viewPager.setPadding(80,0,0,0);
//        viewPager.getChildAt(0).setOverScrollMode(ViewPager.OVER_SCROLL_NEVER);


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
         int mCurrentPage;
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

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        replaceFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

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

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.constrainLayoutMain,fragment);
        fragmentTransaction.commit();
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