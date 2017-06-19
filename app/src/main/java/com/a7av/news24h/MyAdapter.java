package com.a7av.news24h;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Custom adapter for RecyclerView
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<FeedItem> feedItems;
    private Context context;

    public MyAdapter(Context context, ArrayList<FeedItem> feedItems) {
        this.feedItems = feedItems;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        YoYo.with(Techniques.FadeIn).playOn(holder.cardView);
        final FeedItem CURRENT_ITEM = feedItems.get(position);
        holder.title.setText(CURRENT_ITEM.getTitle());
        holder.description.setText(CURRENT_ITEM.getDescription());
        holder.pubDate.setText(CURRENT_ITEM.getPubDate());
        Picasso.with(context).load(CURRENT_ITEM.getThumbUrl()).into(holder.thumb);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsShowOut.class);
                intent.putExtra("Link", CURRENT_ITEM.getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //return number of item
        return feedItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;
        private TextView pubDate;
        private ImageView thumb;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text);
            description = (TextView) itemView.findViewById(R.id.description_text);
            pubDate = (TextView) itemView.findViewById(R.id.date_text);
            thumb = (ImageView) itemView.findViewById(R.id.thumb_img);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
