package com.aditya.takeapic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static int REQUEST_IMAGE_CAPTURE= 2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= findViewById(R.id.display_Screen);
    }

    public void TakePic(View view)   {

        Intent intentTakePic= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intentTakePic,REQUEST_IMAGE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)    {
            Bundle extras= data.getExtras();
            Bitmap imageBitmap= (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);

        }
    }
}