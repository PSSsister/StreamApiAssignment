package com.training.streamapiassignment;

public class Transaction {

	private int year;
	private int value;
	private Trader trader;
	/**
	 * 
	 */
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param year
	 * @param value
	 * @param trader
	 */
	public Transaction(int year, int value, Trader trader) {
		super();
		this.year = year;
		this.value = value;
		this.trader = trader;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	@Override
	public String toString() {
		return "Transaction [year=" + year + ", value=" + value + ", trader=" + trader + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trader == null) ? 0 : trader.hashCode());
		result = prime * result + value;
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (trader == null) {
			if (other.trader != null)
				return false;
		} else if (!trader.equals(other.trader))
			return false;
		if (value != other.value)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	
	
}
