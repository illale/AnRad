package com.example.androidradio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Settings {
    @PrimaryKey int setting_id;

    @ColumnInfo(name = "setting_description")
    public String settingDesc;

    @ColumnInfo(name = "setting_value")
    public boolean settingValue;
}
