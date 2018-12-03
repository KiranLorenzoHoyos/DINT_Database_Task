package com.utad.kiran.dint_database_task.ProfessorDialog;

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

public class Professor_Fragment extends Fragment{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    public Professor_Fragment(){

    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        configRecyclerViewProfessor(view);
        configAdapterProfessor();
        return view;
    }
    public void configRecyclerViewProfessor(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
    }

    public void configAdapterProfessor(){
        recyclerViewAdapter = new Professor_Adapter(createData(), new Professor_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Professor_Object item) {
                Log.d("row", "information: " + item.toString());
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment fragment = getFragmentManager().findFragmentByTag("dialog");
                if (fragment!= null){
                    transaction.remove(fragment);
                }
                transaction.addToBackStack(null);
                Professor_Fragment_Dialog professorFragmentDialog = new Professor_Fragment_Dialog();
                professorFragmentDialog.show(transaction, "dialog");
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
    }
    public List<Professor_Object> createData(){
        Professor_Object david = new Professor_Object("David", R.drawable.david);
        Professor_Object jaime = new Professor_Object("Jaime", R.drawable.jaime);
        Professor_Object laura = new Professor_Object("Laura", R.drawable.sgem);
        Professor_Object pedro = new Professor_Object("Pedro", R.drawable.pedro);
        Professor_Object daniel = new Professor_Object("Daniel", R.drawable.tfg);
        Professor_Object meritxell = new Professor_Object("Meritxell", R.drawable.meritxel);
        Professor_Object carlos = new Professor_Object("Carlos", R.drawable.ios);
        Professor_Object cristina = new Professor_Object("Cristina", R.drawable.english);
        List<Professor_Object> data = new ArrayList<>();
        data.add(david);
        data.add(jaime);
        data.add(laura);
        data.add(pedro);
        data.add(daniel);
        data.add(meritxell);
        data.add(carlos);
        data.add(cristina);
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
