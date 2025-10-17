package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    private String city;
    private String province;

    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    String getCityName() {
        return this.city;
    }

    String getProvinceName() {
        return this.province;
    }


    @Override
    /** this method compares cities based on city name field
     * @return -1 if the caller is greater than the city name field of called objects
     */
    public int compareTo(Object o) {
        City city = (City) o; //typecasting
        return this.city.compareTo(city.getCityName());
    }

    /** Value equality
     * we get same city and same province
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City that = (City) o;
        return Objects.equals(city, that.city) &&
                Objects.equals(province, that.province);
    }

    @Override
    public int hashCode(){
        return Objects.hash(city, province);
    }
}