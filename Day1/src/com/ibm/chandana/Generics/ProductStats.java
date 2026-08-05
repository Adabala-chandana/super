package com.ibm.chandana.Generics;

import java.util.Optional;
import java.util.OptionalDouble;

public class ProductStats {
	private long count;
	private Optional<Double> totalPrice;
	private OptionalDouble maxPrice;
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public Optional<Double> getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Optional<Double> totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "ProductStats [count=" + count + ", totalPrice=" + totalPrice + ", maxPrice=" + maxPrice + "]";
	}
	public OptionalDouble getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(OptionalDouble maxPrice) {
		this.maxPrice = maxPrice;
	}

}
