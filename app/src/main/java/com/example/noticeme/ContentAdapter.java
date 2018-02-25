package com.example.noticeme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 2018/2/24.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {
    private List<Content>  mContentList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1;
        TextView t2;
        View view;

        public ViewHolder(View view){
            super(view);
            t1 = (TextView) view.findViewById(R.id.text);
            t2 = (TextView)view.findViewById(R.id.time);
            this.view = view;
        }
    }
    public ContentAdapter(List list){
        mContentList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        TextView text = holder.t1;
        TextView time = holder.t2;
        final Content content = mContentList.get(position);
        text.setText(content.getContent());
        time.setText(content.getTime());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentActivity.actionStart(holder.view.getContext(),content.getTime(),content.getContent());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mContentList.size();
    }

}
