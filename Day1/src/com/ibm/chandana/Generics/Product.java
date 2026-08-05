package com.ibm.chandana.Generics;

public class Product implements Identifiable {
	private Long id;
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Product(long l, String name) {
		this.id = l;
		this.Name = name;
	}

	public Product(Long id, double price, String name) {
		super();
		this.id = id;
		this.price = price;
		Name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", Name=" + Name + "]";
	}

}
