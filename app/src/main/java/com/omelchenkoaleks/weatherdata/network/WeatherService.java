package com.omelchenkoaleks.weatherdata.network;

import com.omelchenkoaleks.weatherdata.model.City;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("data/2.5/weather?units=metric")
    Call<City> getWeather(@NonNull @Query("q") String query);

}
