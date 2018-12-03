package com.utad.kiran.dint_database_task;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface User_Dao {

    @Insert
    void insert(User user);
}
