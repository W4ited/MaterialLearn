package com.example.materiallearn.VerticalViewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.materiallearn.R;
import com.example.materiallearn.HorizontalViewpager.FragmentAdapter;
import com.example.materiallearn.HorizontalViewpager.FragmentOne;
import com.example.materiallearn.HorizontalViewpager.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class VerticalFragment extends AppCompatActivity {

    private ViewPager2 viewPager2;
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_fragment);

        viewPager2 = (ViewPager2) findViewById(R.id.verticalViewPager);

        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());

        viewPager2.setAdapter(new FragmentAdapter(getSupportFragmentManager(),getLifecycle(),fragmentList));
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setCurrentItem(1);
    }
}