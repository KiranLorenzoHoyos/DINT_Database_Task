package com.utad.kiran.dint_database_task.Notification;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utad.kiran.dint_database_task.R;

public class Notification_Recycler_Adapter extends RecyclerView.Adapter<Notification_Recycler_Adapter.MyViewHolder> {
    private Notification_Object[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mUsername;
        public TextView mDate;
        public TextView mTitle;

        public MyViewHolder(View v) {
            super(v);
            mUsername =  v.findViewById(R.id.userName);
            mDate =  v.findViewById(R.id.date);
            mTitle = v.findViewById(R.id.title);

        }
    }
    public Notification_Recycler_Adapter(Notification_Object[] myDataset) {
        mDataset = myDataset;
    }
    @NonNull
    @Override
    public Notification_Recycler_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_notification, parent, false);
        return new Notification_Recycler_Adapter.MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(Notification_Recycler_Adapter.MyViewHolder holder, int position) {
        Notification_Object  item = mDataset [position];
        holder.mDate.setText(item.getDates());
        holder.mUsername.setText(item.getUsername());
        holder.mTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
