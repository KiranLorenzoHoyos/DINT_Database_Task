package com.utad.kiran.dint_database_task.ProfessorDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class Professor_Fragment_Dialog extends AppCompatDialogFragment {
    private ImageView professorImg;
    private TextView professorName;
    private TextView professorSurname;
    private TextView professorDescriptionTitle;
    private TextView professorDescription;
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewManager;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_professordialog, null);
        Professor_Data_CardView prog = new Professor_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.computing, null), "Programming");
        Professor_Data_CardView db   = new Professor_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.database, null), "Data Base");
        Professor_Data_CardView[] professorDataArray = {prog, db};
        builder.setView(view).setPositiveButton("Email", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                String mail = "professor@gmail.com";
                intent.putExtra(Intent.EXTRA_EMAIL, mail);
                intent.putExtra(Intent.EXTRA_TEXT,"Thanks");
                startActivity(Intent.createChooser(intent,"Send Email"));
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });

        professorImg = view.findViewById(R.id.professorImg);
        professorName = view.findViewById(R.id.professorName);
        professorSurname = view.findViewById(R.id.professorSurname);
        professorDescription = view.findViewById(R.id.descriptionText);
        professorDescriptionTitle = view.findViewById(R.id.descriptionTitle);
        drawerLayout = view.findViewById(R.id.drawerLayout);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new Professor_Recycler_Adapter(professorDataArray);
        recyclerViewManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(recyclerViewManager);
        return builder.create();
    }
}
