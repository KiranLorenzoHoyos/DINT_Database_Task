package com.utad.kiran.dint_database_task.ClassDialog;

import android.os.Parcel;
import android.os.Parcelable;

public class Class_Object implements Parcelable {
    private String className;
    private int classImage;

    public Class_Object(String className, int classImage) {
        this.classImage = classImage;
        this.className = className;
    }

    public Class_Object(Parcel read) {
        className = read.readString();
        classImage = read.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel write, int flags) {
        write.writeString(className);
        write.writeInt(classImage);
    }

    public static final Parcelable.Creator<Class_Object> CREATOR = new Parcelable.Creator<Class_Object>() {
        @Override
        public Class_Object createFromParcel(Parcel source) {
            return new Class_Object(source);
        }

        @Override
        public Class_Object[] newArray(int size) {
            return new Class_Object[size];
        }
    };

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassImage() {
        return classImage;
    }

    public void setClassImage(int classImage) {
        this.classImage = classImage;
    }
}
