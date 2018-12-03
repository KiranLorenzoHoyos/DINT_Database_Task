package com.utad.kiran.dint_database_task.CommunityDialog;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.utad.kiran.dint_database_task.R;

public class Community_Recycler_Adapter extends RecyclerView.Adapter<Community_Recycler_Adapter.myViewHolder>{
    private Community_Data_CardView[] dataSet;
    public static class myViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public myViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.communityName);
            imageView = view.findViewById(R.id.communityImage);
        }
    }

    public Community_Recycler_Adapter(Community_Data_CardView[] myDataSet){
        dataSet = myDataSet;
    }

    @NonNull
    @Override
    public Community_Recycler_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_community, viewGroup, false);
        return new myViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int i) {
        Community_Data_CardView item = dataSet[i];
        holder.textView.setText(item.getCommunityName());
        holder.imageView.setImageDrawable(item.getcommunityPhotos());
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }
}
