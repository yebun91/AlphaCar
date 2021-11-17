package com.example.alphacar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class FavoriteActivity extends AppCompatActivity {

        ImageButton imageButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoriteinside);

        imageButton = findViewById(R.id.imageButton2);
        /* 백버튼 */
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




    }

    @Override
    public void onBackPressed() {
                 super.onBackPressed();

    }
}
