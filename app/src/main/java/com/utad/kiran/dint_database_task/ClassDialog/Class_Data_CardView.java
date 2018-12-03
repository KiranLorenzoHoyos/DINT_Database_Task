package com.utad.kiran.dint_database_task.ClassDialog;

import android.graphics.drawable.Drawable;

public class Class_Data_CardView {
    private Drawable classPhotos;
    private String className;
    public Class_Data_CardView(Drawable classPhotos, String className){
        this.classPhotos = classPhotos;
        this.className = className;
    }
    public void setClassPhotos(Drawable classPhotos){
        this.classPhotos = classPhotos;
    }
    public void setClassName(String className){
        this.className = className;
    }
    public Drawable getclassPhotos(){
        return classPhotos;
    }
    public String getclassName(){
        return className;
    }
}
