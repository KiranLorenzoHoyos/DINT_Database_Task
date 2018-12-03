package com.utad.kiran.dint_database_task.ProfessorDialog;

import android.graphics.drawable.Drawable;

public class Professor_Data_CardView {
    private Drawable professorPhotos;
    private String professorName;
    public Professor_Data_CardView(Drawable professorPhotos, String professorName){
        this.professorPhotos = professorPhotos;
        this.professorName = professorName;
    }
    public void setProfessorPhotos(Drawable professorPhotos){
        this.professorPhotos = professorPhotos;
    }
    public void setProfessorName(String professorName){
        this.professorName = professorName;
    }
    public Drawable getprofessorPhotos(){
        return professorPhotos;
    }
    public String getprofessorName(){
        return professorName;
    }
}
