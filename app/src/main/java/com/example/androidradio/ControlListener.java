package com.example.androidradio;

import java.io.Serializable;

public interface ControlListener extends Serializable {
    void pause();
    void next();
    void previous();
}
