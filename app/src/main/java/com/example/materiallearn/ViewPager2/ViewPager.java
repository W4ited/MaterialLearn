package com.example.materiallearn.ViewPager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.materiallearn.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPager extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        viewPager2 = (ViewPager2) findViewById(R.id.viewPager2);
        list.add("黝黑");
        list.add("漆黑");
        list.add("油烟墨");


        viewPager2.setAdapter(new recyclerAdapter(this, list, viewPager2));

        //设置初始位置 要放在setAdapter之后
        viewPager2.setCurrentItem(1);

    }
}