package com.example.materiallearn.CardView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.materiallearn.R;
import com.example.materiallearn.CardView.bean.Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardView extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Animals[] animals = {
            new Animals("Cat", R.drawable.mao),
            new Animals("Dog", R.drawable.gou),
            new Animals("Squirrel", R.drawable.songshu),
            new Animals("Rabbit", R.drawable.tuzi),
            new Animals("Panda", R.drawable.xiongmao),
            new Animals("Tiger", R.drawable.laohu),
            new Animals("Lion", R.drawable.shizi),
            new Animals("Horse", R.drawable.ma)};
    private List<Animals> peopleList = new ArrayList<>();
    private CardViewAdapter adapter;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        initPeople();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CardViewAdapter(peopleList);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.purple_500);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshPeople();
            }
        });
    }

    private void refreshPeople() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initPeople();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initPeople() {
        peopleList.clear();
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int index = random.nextInt(animals.length);
            peopleList.add(animals[index]);            //随机一个
            //peopleList.add(animals[i]);
        }
    }
}