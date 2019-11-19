package com.training.streamapiassignment.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.training.streamapiassignment.Fruit;
import com.training.streamapiassignment.Trader;
import com.training.streamapiassignment.Transaction;
import com.training.streamapiassignment.TransactionDao;

public class TransactionTest {
	
	List<Transaction> transactions;
	Trader trader;
	
	@Before
	public void setUp()
	{
		transactions=Arrays.asList(
		 new Transaction(2011,5000,new Trader("Asmita","Pune")),
		 new Transaction(2012,15000,new Trader("Ashika","Pune")),
		 new Transaction(2011,45000,new Trader("Pranjal","Delhi")),
		 new Transaction(2009,55000,new Trader("Sanvi","Mumbai")),
		 new Transaction(2011,25000,new Trader("Shesha","Delhi"))
	);
	}
	

	@Test
	public void testGetAllTransactionValuesWhereCityIsDelhi() {
		List<Integer> expected=Arrays.asList(45000, 25000);

		assertEquals(expected,TransactionDao.getAllTransactionValuesWhereCityIsDelhi(transactions));
	}

	@Test
	public void testTransactionInYearSortedByValue() {
		List<Transaction> trans=new ArrayList<>();
		Transaction f1=new Transaction(2011,5000,new Trader("Asmita","Pune"));
		Transaction f2=new Transaction(2011,25000,new Trader("Shesha","Delhi"));
		Transaction f3=new Transaction(2011,45000,new Trader("Pranjal","Delhi"));
		trans.add(f1);
		trans.add(f2);
	    trans.add(f3);
		
		assertEquals(trans,TransactionDao.getTransactionInYearSortedByValue(transactions));
	}
	
	@Test
	public void testMaxValue() {
		int expected=55000;
		assertEquals(expected,TransactionDao.getMaxValue(transactions));
	}
	@Test
	public void testMinValue() {
		List<Transaction> trans=new ArrayList<>();
		Transaction f1=new Transaction(2011,5000,new Trader("Asmita","Pune"));
	    trans.add(f1);
	    assertEquals(trans, TransactionDao.getMinValueTransaction(transactions));
		System.out.println(TransactionDao.getMinValueTransaction(transactions));
	}
}
