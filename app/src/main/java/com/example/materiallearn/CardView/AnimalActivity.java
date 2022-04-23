package com.example.materiallearn.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.materiallearn.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AnimalActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String ANIMALS_NAME = "animals_name";
    public static final String ANIMALS_IMAGE_ID = "animals_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Intent intent = getIntent();
        String animalName = intent.getStringExtra(ANIMALS_NAME);
        int animalImagedID = intent.getIntExtra(ANIMALS_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);
        ImageView animalImageView = (ImageView) findViewById(R.id.animal_image_view);
        TextView animalContentText = (TextView) findViewById(R.id.animal_content_text);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatButton);
        floatingActionButton.setOnClickListener(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(animalName);
        Glide.with(this).load(animalImagedID).into(animalImageView);
        String animalContent = generateAnimalContent(animalName);
        animalContentText.setText(animalContent);
    }

    private String generateAnimalContent(String animalName) {
        StringBuilder animalContent = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            animalContent.append(animalName);
            animalContent.append("\n");
        }
        return animalContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatButton:
                Toast.makeText(AnimalActivity.this, "You click the floatButton", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
