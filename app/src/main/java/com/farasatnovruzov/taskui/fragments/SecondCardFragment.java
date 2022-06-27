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

public class SecondCardFragment extends Fragment {

    View v;
    private RecyclerView mRecyclerView;
    private List<TabModel> mListModel;

    public SecondCardFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.second_card_fragment,container,false);
        mRecyclerView = v.findViewById(R.id.second_recycler);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),mListModel);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListModel = new ArrayList<>();
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));
        mListModel.add(new TabModel("Second Card Data", android.R.drawable.ic_media_play));


    }
}
