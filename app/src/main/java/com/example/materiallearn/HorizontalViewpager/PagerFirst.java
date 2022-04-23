package com.example.materiallearn.HorizontalViewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.materiallearn.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class PagerFirst extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    List<Fragment> fragmentList = new ArrayList<>();
    String[] titleArr = {"测试一", "测试二"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_first);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager2 = (ViewPager2) findViewById(R.id.pager2);

        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());

        viewPager2.setAdapter(new FragmentAdapter(getSupportFragmentManager(), getLifecycle(), fragmentList));
        viewPager2.setOffscreenPageLimit(2);

        //TabLayout 和 Viewpager2 联系
        TabLayoutMediator tab = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titleArr[position]);
            }
        });
        tab.attach();
    }
}