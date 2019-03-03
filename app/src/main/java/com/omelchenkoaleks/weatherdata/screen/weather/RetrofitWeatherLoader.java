package com.omelchenkoaleks.weatherdata.screen.weather;

import android.content.Context;

import com.omelchenkoaleks.weatherdata.model.City;
import com.omelchenkoaleks.weatherdata.network.ApiFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.Loader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitWeatherLoader extends Loader<City> {

    private final Call<City> mCall;

    @Nullable
    private City mCity;

    public RetrofitWeatherLoader(Context context, @NonNull String cityName) {
        super(context);
        mCall = ApiFactory.getWeatherService().getWeather(cityName);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (mCity != null) {
            deliverResult(mCity);
        } else {
            forceLoad();
        }
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        mCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                mCity = response.body();
                deliverResult(mCity);
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                deliverResult(null);
            }
        });
    }

    @Override
    protected void onStopLoading() {
        mCall.cancel();
        super.onStopLoading();
    }
}

