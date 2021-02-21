package com.example.imageshow.adapterclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imageshow.model.ImageFeed;
import com.example.imageshow.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterClass extends BaseAdapter {

    private List<ImageFeed> imageFeedList;
    private Context ctx;
    private LayoutInflater layoutInflater;

    public AdapterClass(List<ImageFeed> imageFeedList, Context ctx) {
        this.imageFeedList = imageFeedList;
        this.ctx = ctx;
        this.layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageFeedList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = layoutInflater.inflate(R.layout.card_layout,viewGroup,false);
        }
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView authorName = view.findViewById(R.id.authorName);
        authorName.setText(imageFeedList.get(i).getAuthor());
        Picasso.get().load("https://picsum.photos/480/480?image="+imageFeedList.get(i).getId()).into(imageView);

        return view;
    }
}
