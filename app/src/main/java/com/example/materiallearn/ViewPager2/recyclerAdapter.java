package com.example.materiallearn.ViewPager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.materiallearn.R;

import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {

    private List<String> mData;
    private ViewPager2 viewPager2;
    private Context context;

    private int[] colorArray = new int[]{R.color.黝黑, R.color.漆黑, R.color.油烟墨
    };

    public recyclerAdapter(Context context, List<String> mData, ViewPager2 viewPager2) {
        this.mData = mData;
        this.context = context;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.textView.setText(animal);
        holder.relativeLayout.setBackgroundResource(colorArray[position]);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView textView;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.container);
            textView = (AppCompatTextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
