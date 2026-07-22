package com.ibm.chandana.Generics;


import java.util.List;
import java.util.Optional;

public class Generic {
	public static void main(String args[]) {
		Repository<User> users = new Repository<>();
		users.save(new User(1L, "Teju"));
		Optional<User> ada = users.findById(10L);
		//System.out.println(ada.get()); ->No value present
		if(ada.isPresent())
		{
		System.out.println(ada.get());
		}
		if(ada.isEmpty())
		{
		System.out.println("No value was found");
		}
		//System.out.println(ada.toString());
		Repository<Product> products = new Repository<>();
		//Method caller decides the Type(User or product)
		products.save(new Product(10L, "Keyboard"));
		products.save(new Product(20L, "Keyboard"));
		Product p = products.findById(10L).orElseThrow();
		List<Product> allp=products.findAll();
		System.out.println(allp.toString());	
		
	}
}
//without Generics
 class WithOutGenerics<T>
{
	public static void main(String ags[]) {
		Repository1 r1= new Repository1();
		r1.saveUser(new User(1L,"Ada"));
		r1.saveproduct(new Product(1L,"keyBoard"));
	}
}
