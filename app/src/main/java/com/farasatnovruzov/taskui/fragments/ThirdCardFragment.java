package com.farasatnovruzov.taskui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farasatnovruzov.taskui.R;
import com.farasatnovruzov.taskui.RecyclerViewAdapter;
import com.farasatnovruzov.taskui.TabModel;

import java.util.ArrayList;
import java.util.List;

public class ThirdCardFragment extends Fragment {
    View v;
    private RecyclerView mRecyclerView;
    private List<TabModel> mListModel;

    public ThirdCardFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.third_card_fragment,container,false);
        mRecyclerView = v.findViewById(R.id.third_recycler);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),mListModel);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListModel = new ArrayList<>();
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));
        mListModel.add(new TabModel("Test", R.drawable.arrow_left_thick, "28.06.2022","0.5 AZN"));
        mListModel.add(new TabModel("AFB HEAD OFFICE", R.drawable.arrow_right_thick,"27.06.2022","10 AZN"));

    }
}
