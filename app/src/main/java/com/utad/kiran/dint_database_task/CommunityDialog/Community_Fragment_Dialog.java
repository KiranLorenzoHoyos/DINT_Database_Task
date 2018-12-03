package com.utad.kiran.dint_database_task.CommunityDialog;

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

public class Community_Fragment_Dialog extends AppCompatDialogFragment {
    private ImageView communityImg;
    private TextView communityTitle;
    private TextView communityCoordinator;
    private TextView communityTopic;
    private TextView communityDescriptionTitle;
    private TextView communityDescription;
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewManager;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_communitydialog, null);
        Community_Data_CardView numberOfStudents = new Community_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.students, null), "Nº Students");
        Community_Data_CardView classRooms = new Community_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.classroom, null), "Class Rooms");
        Community_Data_CardView events = new Community_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.hackathon, null), "Events");
        Community_Data_CardView projects = new Community_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.disembodied, null), "Projects");
        Community_Data_CardView evaluation   = new Community_Data_CardView(ResourcesCompat.getDrawable(getResources(), R.drawable.evaluation, null), "Evaluation");
        Community_Data_CardView[] communityDataArray = {numberOfStudents, classRooms, events, projects, evaluation};
        builder.setView(view).setPositiveButton("Email", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                String mail = "community@gmail.com";
                intent.putExtra(Intent.EXTRA_EMAIL, mail);
                intent.putExtra(Intent.EXTRA_TEXT,"Thanks");
                startActivity(Intent.createChooser(intent,"Send Email"));
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });

        communityImg = view.findViewById(R.id.communityImg);
        communityTitle = view.findViewById(R.id.communityTitle);
        communityCoordinator = view.findViewById(R.id.communityCoordinator);
        communityTopic = view.findViewById(R.id.communityTopic);
        communityDescriptionTitle = view.findViewById(R.id.descriptionTitle);
        communityDescription = view.findViewById(R.id.descriptionText);
        drawerLayout = view.findViewById(R.id.drawerLayout);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new Community_Recycler_Adapter(communityDataArray);
        recyclerViewManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(recyclerViewManager);
        return builder.create();
    }
}
