package com.training.streamapiassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;

import com.training.streamapiassignment.exceptions.EnterValidColorException;
import com.training.streamapiassignment.exceptions.ListIsEmptyException;

public class FruitDao {
	
	/**
	 * 
	 * @param fruits
	 * @return List<String>
	 */
	
	public static List<String> caloriesLessThanHundreadFruitNames(List<Fruit>fruits){
          
            List<String> fruitNames=fruits.stream()
        		        .filter(fruit->  fruit.getCalories()<100)
        		        .sorted((f1,f2)->{
        			      int result=Integer.compare(f2.getCalories(), f1.getCalories());
        			       if(result==0)
        				      return Integer.compare(f1.getPrice(), f2.getPrice());
        			       return result;
        		          })
        		         .map(f -> f.getName())
                         .collect(Collectors.toList());
	return fruitNames;
		

	}
	/**
	 * 
	 * @param fruits
	 * @param color
	 * @return List<String>
	 * @throws EnterValidColorException
	 */
	
    

	public static  HashMap<String, ArrayList<String>> mapByColor(List<Fruit>fruits){


	        HashMap<String, ArrayList<String>> parts = new HashMap<String, ArrayList<String>>();


	        fruits.stream()
	              .forEach(fruit -> {
	                  if (parts.containsKey(fruit.getColor())) {
	                      ArrayList<String> obj = parts.get(fruit.getColor());
	                      obj.add(fruit.getName());
	                      parts.put(fruit.getColor(), obj);
	                  } else {
	                      ArrayList<String> obj = new ArrayList<String>();
	                      obj.add(fruit.getName());
	                      parts.put(fruit.getColor(), obj);
	                  }
	              });
	        return parts;
	    };




	public static List<String> getColorWiseListOfFruitNames(List<Fruit>fruits,String color) throws EnterValidColorException{
		
		
		List<String> ColourFruits=fruits.stream()
				.filter((f->f.getColor().equals(color)))
				.map(f -> f.getName())
		        .collect(Collectors.toList());
		     return ColourFruits;
	}
		

	/**
	 * 
	 * @param fruits
	 * @return List<Fruit>
	 * @throws ListIsEmptyException
	 */
	
	public static List<Fruit> displayOnlyRedColorFruitAsPerTheirPriceInAscendingOrder(List<Fruit>fruits) throws ListIsEmptyException
	{
		if(fruits.isEmpty())
		{
			throw new ListIsEmptyException("The list is empty");
		}
		List<Fruit> fruitWithRedInAscendingOrderOfPrice=fruits.stream()
				.filter(fruit->fruit.getColor().equals("Red"))
				.sorted((f1,f2)->{
					int result=Integer.compare(f1.getPrice(), f2.getPrice());
				  if(result==0)
					  return Integer.compare(f1.getCalories(), f2.getCalories());
				  return result;
				})
				.collect(Collectors.toList());
		return fruitWithRedInAscendingOrderOfPrice;
	}
	      
}
