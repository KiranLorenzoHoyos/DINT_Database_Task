package com.utad.kiran.dint_database_task.Notification;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.kiran.dint_database_task.R;

public class Notification_Activity extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView(view);
        adapter();
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Notification_Activity() {

    }

    public void recyclerView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view_notifications);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void adapter() {
        mAdapter = new Notification_Recycler_Adapter(information());
        mRecyclerView.setAdapter(mAdapter);
    }


    public Notification_Object[] information() {

        Notification_Object notification1 = new Notification_Object("22-10-2018", "Jaime", "Buen trabajo en la ultima tarea");
        Notification_Object notification2 = new Notification_Object("04-11-2018", "Pedro", "No me has entregado el trabajo del martes");
        Notification_Object notification3 = new Notification_Object("09-11-2018", "Laura", "El proximo día hay exámen");

        Notification_Object[] elements = {notification1, notification2, notification3};
        return elements;

    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }

    @Override
    public void onDetach(){
        super.onDetach();
    }
}
