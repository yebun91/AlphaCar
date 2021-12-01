package com.example.alphacar;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alphacar.R;

public class ReviewPageActivity extends AppCompatActivity {

    Button btnBack;
    ImageView profileImg, reviewPhoto;
    TextView userID, reviewTitle, reviewContent;
    RatingBar showRating;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.review);

        btnBack = findViewById(R.id.btnBack);
        profileImg = findViewById(R.id.profileImg);
        reviewPhoto = findViewById(R.id.reviewPhoto);
        userID = findViewById(R.id.userID);
        reviewTitle = findViewById(R.id.reviewTitle);
        reviewContent = findViewById(R.id.reviewContent);
        showRating = findViewById(R.id.showRating);



    }

    public void reviewPage() {

        profileImg = findViewById(R.id.profileImg);
        reviewPhoto = findViewById(R.id.reviewPhoto);
        userID = findViewById(R.id.userID);
        reviewTitle = findViewById(R.id.reviewTitle);
        reviewContent = findViewById(R.id.reviewContent);
        showRating = findViewById(R.id.showRating);

        //reviewTitle.setText(ReviewDTO.getTitle());


    }

}
