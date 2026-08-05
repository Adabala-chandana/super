package com.ibm.chandana.Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Repository<T extends Identifiable> {

	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private final Map<Long, T> data = new ConcurrentHashMap<>();
	private final int capacity;

	public Repository(int capacity) {
		this.capacity = capacity;
	}

	public void save(T entity) {
		lock.writeLock().lock();
		try {
			Long key = entity.getId();
			if (!data.containsKey(key) && data.size() == capacity) {
				throw new IllegalStateException("Repository is full, capacity: " + capacity);
			}
			data.put(key, entity);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public Optional<T> findById(Long id) {
		lock.readLock().lock();
		try {
			return Optional.ofNullable(data.get(id));
		} finally {
			lock.readLock().unlock();
		}
	}

	public List<T> findAll() {
		lock.readLock().lock();
		try {
			return Collections.unmodifiableList(new ArrayList<>(data.values()));
		} finally {
			lock.readLock().unlock();
		}
	}

	public ProductStats summarizeProducts(Repository<Product> catalog, String namePrefix) {
		List<Product> filterproducts = catalog.findAll().stream().filter(c -> c.getName().startsWith(namePrefix))
				.toList();
		ProductStats p = new ProductStats();
		if (filterproducts.isEmpty()) {
			p.setCount(0);
			p.setTotalPrice(Optional.of(0.0));
			p.setMaxPrice(OptionalDouble.empty());
			return p;
		}
		long count = filterproducts.size();
		Optional<Double> sum = filterproducts.stream().map(c -> c.getPrice()).reduce(Double::sum);
		OptionalDouble maxPrice = filterproducts.stream().mapToDouble(c -> c.getPrice()).reduce(Double::max);
		p.setCount(count);
		p.setTotalPrice(sum);
		p.setMaxPrice(maxPrice);
		return p;

	}

}
