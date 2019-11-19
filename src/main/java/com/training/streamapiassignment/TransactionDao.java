package com.training.streamapiassignment;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionDao {

	/**
	 * 
	 * @param transactions
	 * @return List<Integer>
	 */
	public static List<Integer> getAllTransactionValuesWhereCityIsDelhi(List<Transaction> transactions){
		
		List<Integer> getValuesWhereCityIsDelhi=transactions.stream()
				.filter(trans->trans.getTrader().getCity().equals("Delhi"))
				.map(trans->trans.getValue())
				.collect(Collectors.toList());
		return getValuesWhereCityIsDelhi;
		
	}
	/**
	 * 
	 * @param transactions
	 * @return List<Transaction>
	 */
	
	public static List<Transaction> getTransactionInYearSortedByValue(List<Transaction> transactions)
	{
		List<Transaction> getTransactionInYear=transactions.stream()
				.filter(trans->trans.getYear()==2011)
				.sorted((tran1,tran2)->{
					int result=Integer.compare(tran1.getValue(), tran2.getValue());
				    if(result==0)
				    	return Integer.compare(tran1.getYear(), tran2.getYear());
				    return result;			
				})
				.collect(Collectors.toList());
		return getTransactionInYear;
		
	}
	/**
	 * 
	 * @param transactions
	 * @return int
	 */
	
	public static int getMaxValue(List<Transaction> transactions)
	{
		int max=transactions.stream()
				.map(trans->trans.getValue())
				.max((trans1,trans2)->trans1.compareTo(trans2))
				.get();
		return max;
	}
	/**
	 * 
	 * @param transactions
	 * @return List<Transaction>
	 */
	
	public static List<Transaction> getMinValueTransaction(List<Transaction> transactions)
	{
		List<Transaction> min=transactions.stream()
				.collect(Collectors.minBy((trans1,trans2)->trans1.getValue()-trans2.getValue())).stream()
				.collect(Collectors.toList());
		return min;
				 
				
		
	 
	}
}
