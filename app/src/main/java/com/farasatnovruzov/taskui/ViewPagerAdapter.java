package com.farasatnovruzov.taskui;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.farasatnovruzov.taskui.fragments.FirstCardFragment;
import com.farasatnovruzov.taskui.fragments.FourthCardFragment;
import com.farasatnovruzov.taskui.fragments.SecondCardFragment;
import com.farasatnovruzov.taskui.fragments.ThirdCardFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> listFragment = new ArrayList<>();
    private final List<String> listTitles = new ArrayList<>();

    private int adapterPosition;

    public int getAdapterPosition() {
        return adapterPosition;
    }

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        adapterPosition = position;

        return listFragment.get(position);
//        Adapter adapter = new Adapter()
//        switch (position){
//            case 0:
//                return new FirstCardFragment();
//            case 1:
//                return new SecondCardFragment();
//            case 3:
//                return new ThirdCardFragment();
//            case 4:
//                return new FourthCardFragment();
//            default: return new FirstCardFragment();
//        }
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    public void addFragment (Fragment fragment,String title){
        listFragment.add(fragment);
        listTitles.add(title);
    }
}
