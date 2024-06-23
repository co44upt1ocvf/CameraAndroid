package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class FullImage extends AppCompatActivity {
    ImageView FullImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_image);
        FullImage = findViewById(R.id.full_image);
        String imageUriSrc = getIntent().getStringExtra("image");
        Uri imageUri = Uri.parse(imageUriSrc);
        try{
            InputStream imageStream = getContentResolver().openInputStream(imageUri);
            Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            FullImage.setImageBitmap(selectedImage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}