package com.farasatnovruzov.taskui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;



public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    private int adapterPosition;

    public int getAdapterPosition() {
        return adapterPosition;
    }
//    private final List<Fragment> listFragment = new ArrayList<>();
//    private final List<String> listTitles = new ArrayList<>();

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;

    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container,false);

        ImageView imageView;
        imageView = view.findViewById(R.id.image_card);
        imageView.setImageResource(models.get(position).getImageID());

        container.addView(view,0);
        adapterPosition = position;

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


}
