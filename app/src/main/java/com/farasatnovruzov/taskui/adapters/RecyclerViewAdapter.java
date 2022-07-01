package com.farasatnovruzov.taskui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farasatnovruzov.taskui.models.CardInfoModel;
import com.farasatnovruzov.taskui.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<CardInfoModel> mData;


    public RecyclerViewAdapter(Context context, List<CardInfoModel> mData) {
        this.mContext = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_card,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

//        mData.add("Test",R.drawable.arrow_left_thick);
        holder.fName.setText(mData.get(position).getName());
        holder.img.setImageResource(mData.get(position).getImage());
        holder.dat.setText(mData.get(position).getDate());
        holder.cur.setText(mData.get(position).getCurrency());
        if (mData.get(position).getCurrency().equals("0.5 AZN")){
            holder.cur.setTextColor(Color.RED);
        }else{
            holder.cur.setTextColor(Color.parseColor("#317301"));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView fName;
        private ImageView img;
        private TextView dat;
        private TextView cur;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fName = itemView.findViewById(R.id.first_text);
            img = itemView.findViewById(R.id.img_first);
            dat = itemView.findViewById(R.id.date);
            cur = itemView.findViewById(R.id.currency);

        }
    }
}
