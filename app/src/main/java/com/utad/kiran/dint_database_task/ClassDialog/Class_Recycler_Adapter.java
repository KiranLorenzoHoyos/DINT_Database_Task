package com.utad.kiran.dint_database_task.ClassDialog;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.utad.kiran.dint_database_task.R;

public class Class_Recycler_Adapter extends RecyclerView.Adapter<Class_Recycler_Adapter.myViewHolder>{
    private Class_Data_CardView[] dataSet;
    public static class myViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public myViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.classTextView);
            imageView = view.findViewById(R.id.classImageView);
        }
    }

    public Class_Recycler_Adapter(Class_Data_CardView[] myDataSet){
        dataSet = myDataSet;
    }

    @NonNull
    @Override
    public Class_Recycler_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_class, viewGroup, false);
        return new myViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int i) {
        Class_Data_CardView item = dataSet[i];
        holder.textView.setText(item.getclassName());
        holder.imageView.setImageDrawable(item.getclassPhotos());
    }


    @Override
    public int getItemCount() {
        return dataSet.length;
    }
}
