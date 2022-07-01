package com.farasatnovruzov.taskui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class CardAdapter extends PagerAdapter {

    private List<CardModel> cardModels;
    private LayoutInflater layoutInflater;
    private Context context;

    public CardAdapter(List<CardModel> cardModels, Context context) {
        this.cardModels = cardModels;
        this.context = context;

    }

    @Override
    public int getCount() {
        return cardModels.size();
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
        imageView.setImageResource(cardModels.get(position).getImageID());

        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public float getPageWidth(int position) {
        return 0.8999f;
    }

}
