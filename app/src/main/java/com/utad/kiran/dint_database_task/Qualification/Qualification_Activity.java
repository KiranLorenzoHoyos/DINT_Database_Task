package com.utad.kiran.dint_database_task.Qualification;

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

public class Qualification_Activity extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qualification, container, false);
        recyclerView(view);
        adapter();
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Qualification_Activity() {

    }

    public void recyclerView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view_qualifications);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);


    }

    public void adapter() {
        mAdapter = new Qualification_Recycler_Adapter(information());
        mRecyclerView.setAdapter(mAdapter);
    }


    public Qualification_Object[] information() {

        Qualification_Object grade1 = new Qualification_Object("22-10-2018", "Acceso a datos", "AD_UD3_A01_PJSON", "4");
        Qualification_Object grade2 = new Qualification_Object("04-11-2018", "Desarrollo de interfaces", "TASK 3 - Fragments_Lists", "10");
        Qualification_Object grade3 = new Qualification_Object("09-11-2018", "Empresa e iniciativa emprendedora", "Documentacion alta creacion empresas", "5");
        Qualification_Object grade4 = new Qualification_Object("17-12-2018", "Formación en centros de trabajo ", "Preferencias Generales", "7");
        Qualification_Object grade5 = new Qualification_Object("19-12-2018", "Inglés técnico para grado superior", "MARKING CRITERIA WRITING", "9");
        Qualification_Object grade6 = new Qualification_Object("25-12-2018", "Programación de servicios y procesos", "Tarea 2 - Prioridades", "3");
        Qualification_Object[] elements = {grade1, grade2, grade3, grade4, grade5, grade6};
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
