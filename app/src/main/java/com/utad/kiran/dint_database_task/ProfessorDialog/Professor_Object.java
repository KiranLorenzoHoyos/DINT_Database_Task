package com.utad.kiran.dint_database_task.ProfessorDialog;

import android.os.Parcel;
import android.os.Parcelable;

public class Professor_Object implements Parcelable {
    private String professorName;
    private int professorImage;
    public Professor_Object(String professorName, int professorImage){
        this.professorImage = professorImage;
        this.professorName = professorName;
    }

    public Professor_Object(Parcel read){
        professorName = read.readString();
        professorImage = read.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel write, int flags){
        write.writeString(professorName);
        write.writeInt(professorImage);
    }

    public static final Creator<Professor_Object> CREATOR = new Creator<Professor_Object>() {
        @Override
        public Professor_Object createFromParcel(Parcel source) {
            return new Professor_Object(source);
        }

        @Override
        public Professor_Object[] newArray(int size) {
            return new Professor_Object[size];
        }
    };

    public String getProfessorName(){
        return professorName;
    }

    public void setProfessorName(String professorName){
        this.professorName = professorName;
    }

    public int getProfessorImage(){
        return professorImage;
    }

    public void setProfessorImage(int professorImage){
        this.professorImage = professorImage;
    }
}
