package com.training.streamapiassignment.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.training.streamapiassignment.Fruit;
import com.training.streamapiassignment.Trader;
import com.training.streamapiassignment.TraderDao;

public class TraderTest {
	
	List<Trader> traders;
	
	@Before 
	public void setUp() {
		traders=Arrays.asList(
		new Trader("Priyanka","Pune"),
		new Trader("Smita","Mumbai"),
		new Trader("Saras","Sangli"),
		new Trader("Spruha","Pune")
				);
	}

	@Test
	public void testUniqueCities() {
		List<String> expected=Arrays.asList("Pune","Mumbai","Sangli");
		assertEquals(expected,TraderDao.getUniqueCities(traders));
		
	}

	@Test
	public void testFindTradersByCityPuneAndSortItByName() {
	   
		List<Trader> expected=new ArrayList<>(Arrays.asList(
				new Trader("Priyanka","Pune"),
				new Trader("Spruha","Pune")
						));
	    List<Trader> actual = TraderDao.FindTradersByCityPuneAndSortItByName(traders);
		System.out.println(TraderDao.FindTradersByCityPuneAndSortItByName(traders));
		assertEquals(expected, actual);
	}
	
	@Test
	public void  testGetStringOfNamesInAlphabeticalOrder(){
		List<String> expected=Arrays.asList("Priyanka", "Saras", "Smita", "Spruha");
		assertEquals(expected,TraderDao.getStringOfNamesInAlphabeticalOrder(traders));
		
	}
	@Test
	public void testToGetWhereCityIsIndore() {
		List<Trader> traders2=Arrays.asList(
		new Trader("Priyanka","Pune"),
		new Trader("Smita","Mumbai"),
		new Trader("Saras","Sangli"),
		new Trader("Spruha","Pune"),
		new Trader("Asha","Indore")
				);
        
		//List<String> expected=Arrays.asList("Indore");
		assertEquals(true,TraderDao.getStringOfCityWhereCityIsIndore(traders2));
	}
	@Test
	public void testToCheckIsThereAnyCityBasedIndore() {
		assertEquals(false,TraderDao.getStringOfCityWhereCityIsIndore(traders));
	}
	
	
}
