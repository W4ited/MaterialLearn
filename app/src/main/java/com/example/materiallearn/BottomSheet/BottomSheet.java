package com.example.materiallearn.BottomSheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.materiallearn.R;
import com.example.materiallearn.CardView.CardViewAdapter;
import com.example.materiallearn.CardView.bean.Animals;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED;
import static com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED;

public class BottomSheet extends AppCompatActivity implements View.OnClickListener {


    private BottomSheetBehavior mBottomSheetBehavior;

    //BottomSheetBehavior bottomSheetBehavior;
    // private  BottomSheetBehavior behavior;
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
        setContentView(R.layout.activity_bottom_sheet);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sheet_recyclerView);
        initPeople();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CardViewAdapter(peopleList);
        recyclerView.setAdapter(adapter);


        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        //mBottomSheetBehavior.setState(STATE_EXPANDED);
        mBottomSheetBehavior.setState(STATE_COLLAPSED);     //STATE_COLLAPSED 折叠 STATE_EXPANDED 展开
        mBottomSheetBehavior.setPeekHeight(0);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                if (mBottomSheetBehavior.getState() == STATE_COLLAPSED) {
                    mBottomSheetBehavior.setState(STATE_EXPANDED);
                } else if (mBottomSheetBehavior.getState() == STATE_EXPANDED) {
                    mBottomSheetBehavior.setState(STATE_COLLAPSED);
                }
                break;

        }

    }
}