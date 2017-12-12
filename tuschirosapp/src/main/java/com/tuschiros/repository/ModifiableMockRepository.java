package com.tuschiros.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tuschiros.domain.Identificable;

public abstract class ModifiableMockRepository<T extends Identificable> {
	@Autowired
	private IdGenerator idGenerator;

	private List<T> elements = Collections.synchronizedList(new ArrayList<>());

	public Optional<T> findById(Long id) {
		return elements.stream().filter(e -> id == e.getId()).findFirst();
	}

	public T create(T element) {
		elements.add(element);
		element.setId(idGenerator.getNextId());

		return element;
	}

	public boolean update(Long id, T updated) {

		if (updated == null) {
			return false;
		} else {
			Optional<T> element = findById(id);
			element.ifPresent(original -> updateIfExists(original, updated));

			return element.isPresent();
		}
	}

	protected abstract void updateIfExists(T original, T desired);
}
