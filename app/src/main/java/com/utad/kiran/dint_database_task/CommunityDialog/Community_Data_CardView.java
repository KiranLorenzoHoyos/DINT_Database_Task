package com.utad.kiran.dint_database_task.CommunityDialog;

import android.graphics.drawable.Drawable;

public class Community_Data_CardView {
    private Drawable communityPhotos;
    private String communityName;
    public Community_Data_CardView(Drawable communityPhotos, String communityName){
        this.communityPhotos = communityPhotos;
        this.communityName = communityName;
    }
    public void setcommunityPhotos(Drawable communityPhotos){
        this.communityPhotos = communityPhotos;
    }
    public void setCommunityName(String communityName){
        this.communityName = communityName;
    }
    public Drawable getcommunityPhotos(){
        return communityPhotos;
    }
    public String getCommunityName(){
        return communityName;
    }
}
