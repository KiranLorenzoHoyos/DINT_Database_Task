package com.utad.kiran.dint_database_task;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Form_Fragment extends Fragment{
    Form_Activity form_activity;
    private OnFragmentInteractionListener onFragmentInteractionListener;
    private Button btn_go;
    private EditText txtDate;
    private User user;
    private EditText et_name;
    private EditText et_surname;

    @BindView(R.id.etxtSurname2)
    EditText et_second_surname;
    @BindView(R.id.txtDireccion)
    EditText et_address;
    @BindView(R.id.etxtciudad)
    EditText et_postalCode;
    @BindView(R.id.etxtCD)
    EditText et_city;
    @BindView(R.id.etxttelefono)
    EditText et_phone;

    @SuppressLint("ValidFragment")
    Form_Fragment(User user) {
        this.user = user;
    }

    public Form_Fragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        form_activity = new Form_Activity();
        View view = inflater.inflate(R.layout.activity_form, container, false);
        btn_go = view.findViewById(R.id.btngo);
        txtDate = view.findViewById(R.id.txtDate);
        et_name = view.findViewById(R.id.etxtName);
        et_surname = view.findViewById(R.id.etxtSurname);
        clickButtonSaveForm();
        btn_go.setText("NEXT");
        ButterKnife.bind(this, view);
        onClickbirthday();
        return view;
    }

    public void clickButtonSaveForm() {
        user.userName = et_name.toString();
        user.userSurname = et_surname.toString();
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onFragmentInteractionListener != null){
                    onFragmentInteractionListener.nextButtonListener(view, user);
                }
            }
        });
    }

    public void setActivityForm(Form_Activity form_activity) {
        this.form_activity = form_activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            onFragmentInteractionListener = (OnFragmentInteractionListener)context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentInteractionListener = null;
    }

    public void nextButtonListener(View view) {

    }

    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    public void onClickbirthday() {
        txtDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new DatePickerDialog(getLayoutInflater().getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txtDate.setText(sdf.format(myCalendar.getTime()));

    }

    public interface OnFragmentInteractionListener{
        void nextButtonListener(View view, User user);
    }
}

