package com.utad.kiran.dint_database_task.Qualification;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utad.kiran.dint_database_task.R;

public class Qualification_Recycler_Adapter extends RecyclerView.Adapter<Qualification_Recycler_Adapter.MyViewHolder> {
    private Qualification_Object[] mDataset;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mQualification;
        public TextView mDate;
        public TextView mSubject;
        public TextView mTask;

        public MyViewHolder(View v) {
            super(v);
            mQualification =  v.findViewById(R.id.qualification);
            mDate =  v.findViewById(R.id.date);
            mSubject =  v.findViewById(R.id.subject);
            mTask = v.findViewById(R.id.task);
        }
    }

    public Qualification_Recycler_Adapter(Qualification_Object[] myDataset) {
        mDataset = myDataset;
    }
    @NonNull
    @Override
    public Qualification_Recycler_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_qualification, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Qualification_Object  item = mDataset [position];
        holder.mDate.setText(item.getDates());
        holder.mQualification.setText(item.getQualifications());
        holder.mSubject.setText(item.getSubjects());
        holder.mTask.setText(item.getTasks());
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
