package com.utad.kiran.dint_database_task.CommunityDialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.kiran.dint_database_task.R;

import java.util.ArrayList;
import java.util.List;

public class Community_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    public Community_Fragment(){

    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        configRecyclerViewCommunity(view);
        configAdapterCommunity();
        return view;
    }
    public void configRecyclerViewCommunity(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
    }

    public void configAdapterCommunity(){
        recyclerViewAdapter = new Community_Adapter(createData(), new Community_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Community_Object item) {
                Log.d("row", "information: " + item.toString());
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment fragment = getFragmentManager().findFragmentByTag("dialog");
                if (fragment!= null){
                    transaction.remove(fragment);
                }
                transaction.addToBackStack(null);
                Community_Fragment_Dialog communityFragmentDialog = new Community_Fragment_Dialog();
                communityFragmentDialog.show(transaction, "dialog");
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
    }
    public List<Community_Object> createData(){
        Community_Object cyberSecurity = new Community_Object("Cyber Security", R.drawable.fct);
        Community_Object development = new Community_Object("Development", R.drawable.computing);
        Community_Object bigData = new Community_Object("Big Data", R.drawable.database);
        Community_Object virtualReality = new Community_Object("Virtual Reality", R.drawable.tfg);
        List<Community_Object> data = new ArrayList<>();
        data.add(cyberSecurity);
        data.add(development);
        data.add(bigData);
        data.add(virtualReality);
        return data;
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
