package com.example.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.Test;

public class CityListTest {
    /**
     * Helper method to create a mock CityList containing one city (Edmonton, Alberta).
     * @return a CityList with one default city
     */
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Helper method to create a mock city (Edmonton, Alberta).
     * @return a City object representing Edmonton
     */

    private City mockCity(){
        return new City("Edmonton","Alberta");
    }

    /**
     * Test the add method to ensure a city is added correctly to the list.
     * Also checks that the size increases and that the city is actually in the list.
     */
    @Test
    public void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1,cityList.getCities().size());
        City c = new City("Regina","SK");
        cityList.add(c);
        assertEquals(2,cityList.getCities().size());
        assertTrue(cityList.getCities().contains(c));

    }

    /**
     * Test that adding a duplicate city throws an IllegalArgumentException.
     */

    @Test
    public void testAddException(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);

        });
    }

    /**
     * Test that getCities returns a sorted list of cities based on city names.
     */


    @Test
    public void testgetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Test the hasCity method to verify that it returns true if a city exists,
     * and false if it does not.
     */

    @Test
    public void testHasCity(){
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(cityList.hasCity(new City("Calgary","Alberta")));
    }

    /**
     * Test the delete method to ensure that a city is removed correctly from the list.
     * Also checks that the size decreases and that the city no longer exists in the list.
     */


    @Test
    public void testDelete(){
        CityList cityList = mockCityList();
        City regina = new City("Regina","SK");
        cityList.add(regina);
        assertTrue(cityList.hasCity(regina));
        assertEquals(2,cityList.countCities());
        cityList.delete(regina);
        assertFalse(cityList.hasCity(regina));
        assertEquals(1,cityList.countCities());

    }

    /**
     * Test that deleting a city not in the list throws an IllegalArgumentException.
     */


    @Test
    public void testDeleteException(){
        CityList cityList = mockCityList();
        City notThere = new City("Vancouver","BC");
        assertFalse(cityList.hasCity(notThere));
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(notThere));

    }

    /**
     * Test the countCities method to verify it returns the correct number of cities in the list.
     */

    @Test
    public void testCountCities(){
        CityList cityList = new CityList();
        assertEquals(0,cityList.countCities());
        cityList.add(new City("Halifax","NS"));
        cityList.add(new City("Toronto","ON"));
        assertEquals(2,cityList.countCities());

    }
}
