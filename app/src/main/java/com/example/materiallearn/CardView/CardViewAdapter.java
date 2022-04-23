package com.example.materiallearn.CardView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.materiallearn.R;
import com.example.materiallearn.CardView.bean.Animals;

import java.util.List;

public class CardViewAdapter  extends  RecyclerView.Adapter<CardViewAdapter.ViewHolder>{
    private Context mContext;
    private List<Animals> mAnimalList;


    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView animalImage;
        TextView animalName;

        public ViewHolder( View view) {
            super(view);
            cardView = (CardView) view;
            animalImage =(ImageView) view.findViewById(R.id.animals_image);
            animalName = (TextView) view.findViewById(R.id.animals_name);

        }
    }

    public CardViewAdapter(List<Animals> animalList){
        mAnimalList = animalList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext == null)
        {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_list,parent,false);

        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Animals people = mAnimalList.get(position);
                Intent intent = new Intent(mContext, AnimalActivity.class);
                intent.putExtra(AnimalActivity.ANIMALS_NAME,people.getName());
                intent.putExtra(AnimalActivity.ANIMALS_IMAGE_ID,people.getImageId());
                mContext.startActivity(intent);
                //Toast.makeText(v.getContext(),"Clicked6666?",Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animals animal = mAnimalList.get(position);
        holder.animalName.setText(animal.getName());
        Glide.with(mContext).load(animal.getImageId()).into(holder.animalImage);

    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }

}
