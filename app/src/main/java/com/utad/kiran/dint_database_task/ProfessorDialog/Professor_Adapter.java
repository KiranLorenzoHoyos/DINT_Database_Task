package com.utad.kiran.dint_database_task.ProfessorDialog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.utad.kiran.dint_database_task.R;

import java.util.List;

public class Professor_Adapter extends RecyclerView.Adapter<Professor_Adapter.ProfessorViewHolder>{
    private List<Professor_Object> dataSet;
    private final OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick (Professor_Object item);
    }

    public Professor_Adapter(List<Professor_Object> myDataSet, Professor_Adapter.OnItemClickListener myListener){
        this.dataSet = myDataSet;
        this.listener = myListener;
    }

    @Override
    public Professor_Adapter.ProfessorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recyclerview, viewGroup, false);
        return new ProfessorViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ProfessorViewHolder professorViewHolder, int i) {
        final Professor_Object item = dataSet.get(i);
        professorViewHolder.textView.setText(item.getProfessorName());
        professorViewHolder.imageView.setImageResource(item.getProfessorImage());
        professorViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    static class ProfessorViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public ProfessorViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
        }
        public void bind (final Professor_Object item, final OnItemClickListener listener){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
