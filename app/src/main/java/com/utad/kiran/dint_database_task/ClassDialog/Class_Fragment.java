package com.utad.kiran.dint_database_task.ClassDialog;

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

public class Class_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    public Class_Fragment(){

    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        configRecyclerViewClass(view);
        configAdapterClass();
        return view;
    }
    public void configRecyclerViewClass(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
    }

    public void configAdapterClass(){
        recyclerViewAdapter = new Class_Adapter(createData(), new Class_Adapter.OnItemClickListener() {

            @Override
            public void onItemClick(Class_Object item) {
                Log.d("row", "information: " + item.toString());
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment fragment = getFragmentManager().findFragmentByTag("dialog");
                if (fragment!= null){
                    transaction.remove(fragment);
                }
                transaction.addToBackStack(null);
                Class_Fragment_Dialog classFragmentDialog = new Class_Fragment_Dialog();
                classFragmentDialog.show(transaction, "dialog");
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public List<Class_Object> createData(){
        Class_Object dint = new Class_Object("DINT", R.drawable.android);
        Class_Object adat = new Class_Object("ADAT", R.drawable.database);
        Class_Object sgem = new Class_Object("SGEM", R.drawable.sgem);
        Class_Object pspr = new Class_Object("PSPR", R.drawable.computing);
        Class_Object pdam = new Class_Object("PDAM", R.drawable.tfg);
        Class_Object eiem = new Class_Object("EIEM", R.drawable.empresa);
        Class_Object fctr = new Class_Object("FCTR", R.drawable.fct);
        Class_Object pmdm = new Class_Object("PMDM", R.drawable.ios);
        Class_Object itgs = new Class_Object("ITGS", R.drawable.english);
        List<Class_Object> data = new ArrayList<>();
        data.add(dint);
        data.add(adat);
        data.add(sgem);
        data.add(pspr);
        data.add(pdam);
        data.add(eiem);
        data.add(pmdm);
        data.add(fctr);
        data.add(itgs);
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