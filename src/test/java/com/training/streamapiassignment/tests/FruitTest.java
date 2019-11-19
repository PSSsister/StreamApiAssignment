package com.training.streamapiassignment.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.training.streamapiassignment.Fruit;
import com.training.streamapiassignment.FruitDao;
import com.training.streamapiassignment.exceptions.EnterValidColorException;
import com.training.streamapiassignment.exceptions.ListIsEmptyException;

public class FruitTest {

	List<Fruit> fruits;
	
	@Before
	public void setUp() {
		        fruits = Arrays.asList(
				new Fruit("Apple",167,200,"Red"),
				new Fruit("PineApple", 266,100, "Yellow"),
				new Fruit("Guava", 333,60,"Green"),
				new Fruit("WaterMelon", 50,100,"Green"),
			    new Fruit("Mango", 455,300,"Yellow"),
	  		    new Fruit("Grapes", 40,400,"Black"),
		        new Fruit("StrawBerry",60,400,"Red"));
		
		
	}
	@Test
	public void testCaloriesLessThanHundredFruitNames() {
        List<String> expected=Arrays.asList("StrawBerry","WaterMelon","Grapes");
		assertEquals(expected,FruitDao.caloriesLessThanHundreadFruitNames(fruits));

		

	}
	
	@Test
	public void testGetColorWiseListOfFruitNames() throws EnterValidColorException {
  	List<String>  expected= Arrays.asList("PineApple","Mango");
	assertEquals(expected,FruitDao.getColorWiseListOfFruitNames(fruits, "Yellow"));
	List<String> expected2=Arrays.asList("Guava","WaterMelon");
	assertEquals(expected2,FruitDao.getColorWiseListOfFruitNames(fruits, "Green"));
              
        
		System.out.println(FruitDao.mapByColor(fruits));

	}


	@Test(expected=ListIsEmptyException.class)
	public void testDisplayOnlyRedColorFruitAsPerTheirPriceInAscendingOrderThrowsException() throws ListIsEmptyException
	{
		List<Fruit> fruit1=Arrays.asList();
	     FruitDao.displayOnlyRedColorFruitAsPerTheirPriceInAscendingOrder(fruit1);
		
	}
	@Test
	public void testDisplayOnlyRedColorFruitAsPerTheirPriceInAscendingOrder() throws ListIsEmptyException
	{
	    List<Fruit> fruit=new ArrayList<>();
	    Fruit f1=new Fruit("Apple",167,200,"Red");
	    Fruit f2=new Fruit("StrawBerry",60,400,"Red");
	    fruit.add(f1);
	    fruit.add(f2);
	    
		System.out.println(FruitDao.displayOnlyRedColorFruitAsPerTheirPriceInAscendingOrder(fruits));
		assertEquals(fruit,FruitDao.displayOnlyRedColorFruitAsPerTheirPriceInAscendingOrder(fruits));
	}
}
