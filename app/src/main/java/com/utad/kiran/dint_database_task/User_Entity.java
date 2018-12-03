package com.utad.kiran.dint_database_task;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "user")
public class User_Entity {
    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    @PrimaryKey
    @NonNull
    private String name;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    public User_Entity(String name, String password){
        this.name = name;
        this.password = password;
    }

}
