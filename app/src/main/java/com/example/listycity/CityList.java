package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */

public class CityList {

    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a city to the list if the city does not exist
     * @param city
     *  This is a candidate city to add
     */
    public void add(City city){
        if(cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This Return a sorted list of cities
     * @return
     *  Return a sorted list
     */
    public List<City> getCities(){
        List<City>list = cities;
        Collections.sort(list);
        return list;
    }

    /** Return whether the given city exists in the list
     *
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }


    /**
     * Remove the city if it is present
     * otherwise i will give exception on it
     */
    public void delete(City city){
        if (!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Return how many cities are in the list
     */
    public int countCities(){
        return cities.size();
    }

}
