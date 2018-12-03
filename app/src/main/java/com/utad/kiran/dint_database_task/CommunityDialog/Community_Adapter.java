package com.utad.kiran.dint_database_task.CommunityDialog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.utad.kiran.dint_database_task.R;

import java.util.List;

public class Community_Adapter extends RecyclerView.Adapter<Community_Adapter.CommunityViewHolder>{
    private List<Community_Object> dataSet;
    private final OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick (Community_Object item);
    }

    public Community_Adapter(List<Community_Object> myDataSet, Community_Adapter.OnItemClickListener myListener){
        this.dataSet = myDataSet;
        this.listener = myListener;
    }

    @Override
    public Community_Adapter.CommunityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recyclerview, viewGroup, false);
        return new CommunityViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(CommunityViewHolder communityViewHolder, int i) {
        final Community_Object item = dataSet.get(i);
        communityViewHolder.textView.setText(item.getCommunityName());
        communityViewHolder.imageView.setImageResource(item.getCommunityImage());
        communityViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    static class CommunityViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public CommunityViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
        }
        public void bind (final Community_Object item, final OnItemClickListener listener){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
