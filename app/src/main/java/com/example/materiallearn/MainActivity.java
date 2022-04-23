package com.example.materiallearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.materiallearn.AutoFitTextView.AutoFitTextView;
import com.example.materiallearn.BottomSheet.BottomSheet;
import com.example.materiallearn.CardView.CardView;
import com.example.materiallearn.DiagonalLayout.DiagonalLayout;
import com.example.materiallearn.Html.MainActivity2;
import com.example.materiallearn.HorizontalViewpager.PagerFirst;
import com.example.materiallearn.TextInputEdit.TextInputEdit;
import com.example.materiallearn.Crescento.CrescentoImageView;
import com.example.materiallearn.VerticalViewpager.VerticalFragment;
import com.example.materiallearn.ViewPager2.ViewPager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();     //初始化


    }

    private void init() {
        Button button_edit = (Button) findViewById(R.id.button_edit);
        button_edit.setOnClickListener(this);

        Button recycler_card = (Button) findViewById(R.id.button_recyclerview);
        recycler_card.setOnClickListener(this);

        Button bottomSheet = (Button) findViewById(R.id.button_bottomSheet);
        bottomSheet.setOnClickListener(this);

        Button LiagonalLayout = (Button) findViewById(R.id.DiagonalLayout);
        LiagonalLayout.setOnClickListener(this);

        Button test_design = (Button) findViewById(R.id.CrescentoImageView);
        test_design.setOnClickListener(this);

        Button AutoFitTextView = (Button) findViewById(R.id.AutofitTextView);
        AutoFitTextView.setOnClickListener(this);

        Button webView = (Button) findViewById(R.id.webView);
        webView.setOnClickListener(this);

        Button viewpager2 = (Button) findViewById(R.id.design_viewPager2);
        viewpager2.setOnClickListener(this);

        Button button = (Button) findViewById(R.id.design_viewPager2_second);
        button.setOnClickListener(this);

        Button verticalViewPager = (Button) findViewById(R.id.vertical_ViewPager);
        verticalViewPager.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_edit:
                    Intent intent = new Intent(MainActivity.this, TextInputEdit.class);
                    startActivity(intent);
                    break;
                case R.id.button_recyclerview:
                    Intent intent1 = new Intent(MainActivity.this, CardView.class);
                    startActivity(intent1);
                    break;
                case R.id.button_bottomSheet:
                    Intent intent2 = new Intent(MainActivity.this, BottomSheet.class);
                    startActivity(intent2);
                    break;
                case R.id.DiagonalLayout:
                    Intent intent4 = new Intent(MainActivity.this, DiagonalLayout.class);
                    startActivity(intent4);
                    break;
                case R.id.CrescentoImageView:
                    Intent intent5 = new Intent(MainActivity.this, CrescentoImageView.class);
                    startActivity(intent5);
                    break;
                case R.id.AutofitTextView:
                    Intent intent3 = new Intent(MainActivity.this, AutoFitTextView.class);
                    startActivity(intent3);
                    break;
                case R.id.webView:
                    Intent intent6 = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent6);
                    break;
                case R.id.design_viewPager2:
                    Intent intent7 = new Intent(MainActivity.this, ViewPager.class);
                    startActivity(intent7);
                    break;
                case R.id.design_viewPager2_second:
                    Intent intent8 = new Intent(MainActivity.this, PagerFirst.class);
                    startActivity(intent8);
                    break;
                case R.id.vertical_ViewPager:
                    Intent intent9 = new Intent(MainActivity.this, VerticalFragment.class);
                    startActivity(intent9);
                    break;
            }
    }
}