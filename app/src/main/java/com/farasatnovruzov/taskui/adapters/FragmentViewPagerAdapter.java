package com.farasatnovruzov.taskui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.farasatnovruzov.taskui.models.CardModel;
import com.farasatnovruzov.taskui.fragments.Card1Fragment;
import com.farasatnovruzov.taskui.fragments.Card2Fragment;
import com.farasatnovruzov.taskui.fragments.Card3Fragment;
import com.farasatnovruzov.taskui.fragments.Card4Fragment;

import java.util.List;

public class FragmentViewPagerAdapter extends FragmentStatePagerAdapter {


    private List<CardModel> cardModels;
    public FragmentViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Card1Fragment();
            case 1:
                return new Card2Fragment();
            case 3:
                return new Card3Fragment();
            case 4:
                return new Card4Fragment();

            default: return new Card4Fragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


}
