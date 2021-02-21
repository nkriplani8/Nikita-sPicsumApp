package com.example.imageshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ClickImageActivity extends AppCompatActivity {

    private TextView imageAuthor;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_image);

        imageAuthor = findViewById(R.id.imageAuthor);
        imageView2 = findViewById(R.id.imageView2);

        Intent intent = getIntent();
        imageAuthor.setText(intent.getStringExtra("authorName"));
        Picasso.get().load(intent.getStringExtra("uri")).into(imageView2);

    }

}