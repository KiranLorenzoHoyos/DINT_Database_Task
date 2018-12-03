package com.utad.kiran.dint_database_task.CommunityDialog;

import android.os.Parcel;
import android.os.Parcelable;

public class Community_Object implements Parcelable {
    private String communityName;
    private int communityImage;
    public Community_Object(String communityName, int communityImage){
        this.communityImage = communityImage;
        this.communityName = communityName;
    }

    public Community_Object(Parcel read){
        communityName = read.readString();
        communityImage = read.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel write, int flags){
        write.writeString(communityName);
        write.writeInt(communityImage);
    }

    public static final Creator<Community_Object> CREATOR = new Creator<Community_Object>() {
        @Override
        public Community_Object createFromParcel(Parcel source) {
            return new Community_Object(source);
        }

        @Override
        public Community_Object[] newArray(int size) {
            return new Community_Object[size];
        }
    };

    public String getCommunityName(){
        return communityName;
    }

    public void setCommunityName(String communityName){
        this.communityName = communityName;
    }

    public int getCommunityImage(){
        return communityImage;
    }

    public void setCommunityImage(int communityImage){
        this.communityImage = communityImage;
    }
}
