package com.omelchenkoaleks.weatherdata.screen.weatherlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.weatherdata.R;
import com.omelchenkoaleks.weatherdata.model.City;
import com.omelchenkoaleks.weatherdata.screen.general.LoadingDialog;
import com.omelchenkoaleks.weatherdata.screen.general.LoadingView;
import com.omelchenkoaleks.weatherdata.screen.general.SimpleDividerItemDecoration;
import com.omelchenkoaleks.weatherdata.screen.weather.WeatherActivity;

import java.util.ArrayList;
import java.util.List;

public class WeatherListActivity extends AppCompatActivity implements CitiesAdapter.OnItemClick {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.empty)
    View mEmptyView;

    private CitiesAdapter mAdapter;

    private LoadingView mLoadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this, false));
        mAdapter = new CitiesAdapter(getInitialCities(), this);
        mRecyclerView.setAdapter(mAdapter);
        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        /**
         * TODO : task
         *
         * 1) Load all cities forecast using one or multiple loaders
         * 2) Try to run these requests as most parallel as possible
         * or better do as less requests as possible
         * 3) Show loading indicator during loading process
         * 4) Allow to update forecasts with SwipeRefreshLayout
         * 5) Handle configuration changes
         *
         * Note that for the start point you only have cities names, not ids,
         * so you can't load multiple cities in one request.
         *
         * But you should think how to manage this case. I suggest you to start from reading docs mindfully.
         */
    }

    @Override
    public void onItemClick(@NonNull City city) {
        startActivity(WeatherActivity.makeIntent(this, city.getName()));
    }

    @NonNull
    private List<City> getInitialCities() {
        List<City> cities = new ArrayList<>();
        String[] initialCities = getResources().getStringArray(R.array.initial_cities);
        for (String city : initialCities) {
            cities.add(new City(city));
        }
        return cities;
    }
}
