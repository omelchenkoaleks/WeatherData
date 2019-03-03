package com.omelchenkoaleks.weatherdata.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class Weather implements Serializable {
    @SerializedName("main")
    private String mMain;

    @SerializedName("icon")
    private String mIcon;

    @NonNull
    public String getMain() {
        return mMain;
    }

    public void setMain(@NonNull String main) {
        mMain = main;
    }

    @NonNull
    public String getIcon() {
        return mIcon;
    }

    public void setIcon(@NonNull String icon) {
        mIcon = icon;
    }
}
