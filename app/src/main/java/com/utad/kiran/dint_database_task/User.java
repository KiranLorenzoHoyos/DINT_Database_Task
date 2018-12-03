package com.utad.kiran.dint_database_task;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

class User implements Parcelable {
    String user;
    String userMail;
    String userName;
    String userSurname;
    String userGender;
    int userAge;
    Uri userImg;

    public User() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Uri getUserImg() { return userImg; }

    public void setUserImg(Uri userImg) { this.userImg = userImg; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(userMail);
        out.writeString(userName);
        out.writeString(userSurname);
        out.writeInt(userAge);
        /*out.writeString(address);
        out.writeString(sec);
        out.writeString(postalcode);
        out.writeString(city);
        out.writeString(phonetype);
        out.writeString(phone);
        out.writeString(url);
        out.writeList(hobbies);
        out.writeString(description);*/
        out.writeString(userGender);

    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in) {
        //hobbies = new ArrayList<User>();
        userMail = in.readString();
        userName = in.readString();
        userSurname = in.readString();
      //  surname2 = in.readString();
        userAge = in.readInt();
        /*address = in.readString();
        postalcode = in.readString();
        city = in.readString();
        phonetype = in.readString();
        phone = in.readString();
        url = in.readString();
        description = in.readString();*/
        userGender = in.readString();
        //hobbies = in.readArrayList(User.class.getClassLoader());
    }
}

