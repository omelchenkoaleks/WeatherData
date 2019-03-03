package com.omelchenkoaleks.weatherdata.screen.weather;

import android.content.Context;

import com.omelchenkoaleks.weatherdata.model.City;
import com.omelchenkoaleks.weatherdata.network.ApiFactory;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

public class WeatherLoader extends AsyncTaskLoader<City> {

    private final String mCityName;

    public WeatherLoader(Context context, @NonNull String cityName) {
        super(context);
        mCityName = cityName;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public City loadInBackground() {
        try {
            return ApiFactory.getWeatherService().getWeather(mCityName).execute().body();
        } catch (IOException e) {
            return null;
        }
    }
}


