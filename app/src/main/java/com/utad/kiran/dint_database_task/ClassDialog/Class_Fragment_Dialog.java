package com.utad.kiran.dint_database_task.ClassDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.utad.kiran.dint_database_task.R;

import java.util.Objects;

public class Class_Fragment_Dialog extends AppCompatDialogFragment {
    private ImageView classImg;
    private TextView className;
    private TextView classYear;
    private TextView classDescriptionTitle;
    private TextView classDescription;
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewManager;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_classdialog, null);
        Class_Data_CardView n_students = new Class_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.students, null), "Nº Students");
        Class_Data_CardView professor = new Class_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.professor, null), "Professor");
        Class_Data_CardView average = new Class_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.average, null), "Average");
        Class_Data_CardView my_average = new Class_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.myaverage, null), "My average");
        Class_Data_CardView ranking = new Class_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.ranking, null), "Ranking");
        Class_Data_CardView[] classDataArray = {n_students, professor, average, my_average, ranking};
        builder.setView(view).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("accept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        classImg = view.findViewById(R.id.classImg);
        className = view.findViewById(R.id.className);
        classYear = view.findViewById(R.id.classYear);
        classDescriptionTitle = view.findViewById(R.id.descriptionTitle);
        classDescription = view.findViewById(R.id.descriptionText);
        drawerLayout = view.findViewById(R.id.drawerLayout);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new Class_Recycler_Adapter(classDataArray);
        recyclerViewManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(recyclerViewManager);
        return builder.create();
    }
}
