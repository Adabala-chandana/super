package com.ibm.chandana.Generics;

import java.util.List;

public class Generic {
	public static void main(String[] args) {
		Repository<User> users = new Repository<>(100);
		users.save(new User(1L, "Teju"));
		users.save(new User(1L, "Teja sri")); // update — overwrites "Teju"
		User u = users.findById(1L).orElseThrow();
		System.out.println(u);
		Repository<Product> products = new Repository<>(100);
		products.save(new Product(10L, 100, "Keyboard"));
		products.save(new Product(20L, 200, "Mouse"));
		products.save(new Product(30L, 10, "Monitor"));
		products.save(new Product(40L, 2000, "KLaptop"));
		products.findById(30L).ifPresentOrElse(p -> System.out.println(p),
				() -> System.out.println("Product  is found"));
		List<Product> allp = products.findAll();
		System.out.println(allp);
		ProductStats productstatus=products.summarizeProducts(products, "c");
		System.out.println(productstatus.toString());
	}
}
