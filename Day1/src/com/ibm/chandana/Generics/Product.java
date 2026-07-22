package com.ibm.chandana.Generics;

public class Product implements Identifiable {
	private Long id;

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

	@Override
	public String toString() {
		return "Product [id=" + id + ", Name=" + Name + "]";
	}

}
