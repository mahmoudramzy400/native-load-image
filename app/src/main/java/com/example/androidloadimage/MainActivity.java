package com.example.androidloadimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    String image1 =
            "https://images.unsplash.com/photo-1669295235408-81174795bd87?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80";
    String image2 =
            "https://images.unsplash.com/photo-1669172461369-ada48f56f011?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=715&q=80";

    String image3 =
            "https://images.unsplash.com/photo-1669218180914-aa25c243eb4b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80";

    int currentImageNumber = 1;

    String getImageUrl() {
        if (currentImageNumber == 1) {
            return image1;
        } else if (currentImageNumber == 2) {
            return image2;
        } else if (currentImageNumber == 3) {
            return image3;
        } else {
            return image1;
        }
    }

    ImageView imageView;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_network);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if (currentImageNumber >= 3) {
                    currentImageNumber = 1;
                } else {
                    currentImageNumber++;
                }

                //Glide.with(MainActivity.this).load(getImageUrl()).into(imageView);
                Picasso.get().load(getImageUrl()).into(imageView);


                handler.postDelayed(this,3000);
            }
        };
        handler.post(runnable);

    }
}