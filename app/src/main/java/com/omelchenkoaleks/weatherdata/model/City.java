package com.omelchenkoaleks.weatherdata.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class City implements Serializable {
    @SerializedName("name")
    private String mName;

    @SerializedName("weather")
    private List<Weather> mWeathers;

    @SerializedName("main")
    private Main mMain;

    @SerializedName("wind")
    private Wind mWind;

    public City() {
    }

    public City(@NonNull String name) {
        mName = name;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    public void setName(@NonNull String name) {
        mName = name;
    }

    @Nullable
    public Weather getWeather() {
        if (mWeathers == null || mWeathers.isEmpty()) {
            return null;
        }
        return mWeathers.get(0);
    }

    @Nullable
    public Main getMain() {
        return mMain;
    }

    @Nullable
    public Wind getWind() {
        return mWind;
    }
}
