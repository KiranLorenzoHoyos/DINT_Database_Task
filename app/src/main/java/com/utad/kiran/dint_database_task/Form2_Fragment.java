package com.utad.kiran.dint_database_task;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static android.app.Activity.RESULT_OK;

public class Form2_Fragment extends Fragment{
    private TextView textName;
    private TextView textSurname;
    private static String textSurname2;
    private static String textDirection;
    private static String textCity;
    private static String textCD;
    private static String textPhone;
    private String mName;
    private String mSurname;
    private String mSurname2;
    private String mDirection;
    private String mCity;
    private String mCD;
    private String mPhone;
    private int fphone;
    private Button btnGo;
    private ImageView btnImage;
    private String stringUri;
    private Uri imageUri;
    private Intent intent_open_galery;
    private User user;
    private OnFragmentInteractionListener onFragmentInteractionListener;

    @SuppressLint("ValidFragment")
    Form2_Fragment(User user) {
        this.user = user;
    }

    public Form2_Fragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("userName", user.userName);
        if (getArguments() == null) {
            mName = getArguments().getString(textName.toString());
            mSurname = getArguments().getString(textSurname.toString());
            mSurname2 = getArguments().getString(textSurname2);
            mDirection = getArguments().getString(textDirection);
            mCity = getArguments().getString(textCity);
            mCD = getArguments().getString(textCD);
            mPhone = getArguments().getString(textPhone);
            fphone = Integer.parseInt(mPhone);
        }
        textName.setText(user.userName);
        textSurname.setText(user.userSurname);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_form2, container, false);
        btnImage = view.findViewById(R.id.btnImage);
        textName.setText(user.userName);
        textSurname.setText(user.userSurname);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_open_galery = new Intent(Intent.ACTION_GET_CONTENT);
                intent_open_galery.addCategory(Intent.CATEGORY_OPENABLE);
                intent_open_galery.setType("image/*");
                startActivityForResult(Intent.createChooser(intent_open_galery, "Select Picture"), 1);
            }
        });
        btnGo = view.findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragmentInteractionListener.goToMain(view, user);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                imageUri = data.getData();
                final InputStream imageStream = getActivity().getApplicationContext().getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                btnImage.setImageBitmap(selectedImage);
                if (imageUri != null) {
                    stringUri = imageUri.toString();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            onFragmentInteractionListener = (OnFragmentInteractionListener) context;
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

    public interface OnFragmentInteractionListener{
        void goToMain(View view, User user);
    }
}



