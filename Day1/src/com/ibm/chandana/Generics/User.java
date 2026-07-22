package com.ibm.chandana.Generics;

public class User implements Identifiable {
	private Long id;

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

	public User(long l, String name) {
		this.id = l;
		this.Name = name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + "]";
	}

}
