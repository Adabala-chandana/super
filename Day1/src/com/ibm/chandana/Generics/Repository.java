package com.ibm.chandana.Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//Implement a generic in-memory Repository<T> that stores entities by id without requiring casts at the call site.
//user & product are the entities..
//Type Parameter-->using this we can specify the data to be used in a class or method during the instantiation without specifying during the declaration.

//Generic class
public class Repository<T extends Identifiable> {
	// generic in-memory
	private Map<Long, T> storing = new HashMap<>();

	// Generic Methods.
	void saveUser(T entity) {
		storing.put(entity.getId(), entity);
	}

	void save(T entity) {
		storing.put(entity.getId(), entity);
	}

	// Optional is a container object..It might return non-null value or no value
	//storing.get(id) if it's not there ..there is a chance of getting Exception..So added ofNullable
	Optional<T> findById(Long id) {
		return Optional.ofNullable(storing.get(id));
	}

	List<T> findAll() {
		List<T> l = new ArrayList<>();
		for (Map.Entry<Long, T> entry : storing.entrySet()) {
			l.add(entry.getValue());
		}
		return l;

	}

}

//Without Generic
class Repository1 {
	// generic in-memory
	private Map<Long, User> storeUser = new HashMap<>();
	private Map<Long, Product> storeProducts = new HashMap<>();

	void saveUser(User entity) {
		storeUser.put(entity.getId(), entity);
	}

	void saveproduct(Product entity) {
		storeProducts.put(entity.getId(), entity);
	}
}
