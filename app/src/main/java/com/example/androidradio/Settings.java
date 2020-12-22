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

    public Settings(int setting_id, String desc, boolean value) {
        this.setting_id = setting_id;
        this.settingDesc = desc;
        this.settingValue = value;
    }

}
