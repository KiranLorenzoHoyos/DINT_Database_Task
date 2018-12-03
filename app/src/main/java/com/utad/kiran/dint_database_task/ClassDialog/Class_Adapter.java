package com.utad.kiran.dint_database_task.ClassDialog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.utad.kiran.dint_database_task.R;

import java.util.List;

public class Class_Adapter extends RecyclerView.Adapter<Class_Adapter.ClassViewHolder>{
private List<Class_Object> dataSet;
private final OnItemClickListener listener;
public interface OnItemClickListener{
    void onItemClick (Class_Object item);
}

    public Class_Adapter(List<Class_Object> myDataSet, Class_Adapter.OnItemClickListener myListener){
        this.dataSet = myDataSet;
        this.listener = myListener;
    }

    @Override
    public Class_Adapter.ClassViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recyclerview, viewGroup, false);
        return new ClassViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ClassViewHolder classViewHolder, int i) {
        final Class_Object item = dataSet.get(i);
        classViewHolder.textView.setText(item.getClassName());
        classViewHolder.imageView.setImageResource(item.getClassImage());
        classViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    static class ClassViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public ClassViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
        }
        public void bind (final Class_Object item, final OnItemClickListener listener){
            imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
        }
    }
}
