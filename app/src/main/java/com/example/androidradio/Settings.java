package com.example.androidradio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Settings {
    @PrimaryKey(autoGenerate = true) private int setting_id;

    @ColumnInfo(name = "setting_description")
    public String settingDesc;

    @ColumnInfo(name = "setting_value")
    public boolean settingValue;

    public Settings(String desc, boolean value) {
        this.settingDesc = desc;
        this.settingValue = value;
    }

}
