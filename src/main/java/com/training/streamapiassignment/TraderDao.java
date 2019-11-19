package com.training.streamapiassignment;

import java.util.List;
import java.util.stream.Collectors;

public class TraderDao {
	
	/**
	 * 
	 * @param traders
	 * @return List<String>
	 */
	public static List<String> getUniqueCities(List<Trader> traders)
	{
		List<String> uniqueCities=traders.stream()
				  .map(t-> t.getCity())
			      .distinct()
			      .collect(Collectors.toList());
		return uniqueCities;

	}
	/**
	 * 
	 * @param traders
	 * @return List<Trader>
	 */
   public static List<Trader> FindTradersByCityPuneAndSortItByName(List<Trader> traders)
   {
	   List<Trader> PuneTraderInSortedOrderByName=
			    traders.stream()
			   .filter(t->t.getCity().equals("Pune"))
			   .sorted((f1,f2)->{
					return f1.getName().compareTo(f2.getName());
				 
				})
			   .collect(Collectors.toList());
	return PuneTraderInSortedOrderByName;
   }
   /**
    * 
    * @param traders
    * @return List<String>
    */
   public static List<String> getStringOfNamesInAlphabeticalOrder(List<Trader> traders)
   {
	   List<String> getNamesInAlphabeticalOrder=traders.stream()
			   .sorted((t1,t2)->{
					return t1.getName().compareTo(t2.getName());
				 
				})
			   .map(t->t.getName())
			   .collect(Collectors.toList());
	return getNamesInAlphabeticalOrder;
	   
   }
   /**
    * 
    * @param traders
    * @return boolean
    */
   public static boolean getStringOfCityWhereCityIsIndore(List<Trader> traders){
	   boolean getCityIndore=traders.stream()
			   .anyMatch(t->t.getCity().equals("Indore"));
			   
			  
	return getCityIndore;
	   
   }
}
