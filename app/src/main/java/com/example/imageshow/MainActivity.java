package com.example.imageshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.imageshow.adapterclass.AdapterClass;
import com.example.imageshow.model.ImageFeed;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<ImageFeed> imageFeedList = new ArrayList<>();
    private GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://picsum.photos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIInterface apiInterface=retrofit.create(APIInterface.class);
        Call<List<ImageFeed>> call = apiInterface.getImages();

        call.enqueue(new Callback<List<ImageFeed>>() {
            @Override
            public void onResponse(Call<List<ImageFeed>> call, Response<List<ImageFeed>> response) {

                    imageFeedList = response.body();
                    AdapterClass adapterClass = new AdapterClass(imageFeedList,MainActivity.this);
                    gridView.setAdapter(adapterClass);
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(MainActivity.this, ClickImageActivity.class);
                            intent.putExtra("authorName",imageFeedList.get(i).getAuthor());
                            intent.putExtra("uri", "https://picsum.photos/1000/1000?image="+imageFeedList.get(i).getId());
                            startActivity(intent);
                        }
                    });
                    //Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<List<ImageFeed>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();

            }
        });

    }

}