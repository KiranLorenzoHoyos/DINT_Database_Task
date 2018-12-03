package com.utad.kiran.dint_database_task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Form_Activity extends AppCompatActivity implements Form_Fragment.OnFragmentInteractionListener, Form2_Fragment.OnFragmentInteractionListener{
    public Form_Fragment form_fragment;
    public Form2_Fragment form2_fragment;
    private User user;
    public static final String USER = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        user = new User();
        if (findViewById(R.id.pager) != null) {
            if (savedInstanceState != null) {
                return;
            }
            form_fragment = new Form_Fragment(user);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.pager, form_fragment).commit();
        }
    }

    public Form_Activity(){

    }

    public void nextButtonListener(View view, User user) {
        form2_fragment = new Form2_Fragment(user);
        Bundle bundle = new Bundle();
        bundle.putParcelable(USER, user);
        form2_fragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.pager, form2_fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void goToMain(View view, User user) {
        Intent intent = new Intent(this, Main_Activity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}