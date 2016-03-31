package com.demo.oc.fakenewsreader;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

/**
 * Created by Erwan on 28/03/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    List<FakeNews> list = FakeNewsList.all;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_title_news, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FakeNews fakeNews = list.get(position);
        holder.display(fakeNews);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        private FakeNews currentNew;

        public MyViewHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), WebNewsActivity.class);
                    intent.putExtra("WEB_CONTENT", currentNew.htmlContent);
                    itemView.getContext().startActivity(intent);
                }
            });

        }

        public void display(FakeNews news){
            currentNew = news;
            title.setText(news.title);
        }

    }

}
