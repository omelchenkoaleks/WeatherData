package com.omelchenkoaleks.weatherdata.screen.weatherlist;

import android.view.View;
import android.widget.TextView;

import com.omelchenkoaleks.weatherdata.R;
import com.omelchenkoaleks.weatherdata.model.City;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CityHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.city_name)
    TextView mCityName;

    @BindView(R.id.temperature)
    TextView mTemperature;

    public CityHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(@NonNull City city) {
        mCityName.setText(city.getName());
        if (city.getMain() != null) {
            String temp = mTemperature.getResources().getString(R.string.f_temperature, city.getMain().getTemp());
            mTemperature.setText(temp);
        }
    }
}
