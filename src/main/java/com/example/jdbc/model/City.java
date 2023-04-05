package com.example.jdbc.model;

import java.util.Objects;

public class City {
    private String cityName;

    public City() {

    }

    public City(String city_name) {
        this.cityName = city_name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return cityName.equals(city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                '}';
    }
}
