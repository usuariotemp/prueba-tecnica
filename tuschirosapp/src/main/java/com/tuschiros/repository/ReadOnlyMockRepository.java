package com.tuschiros.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tuschiros.domain.Identificable;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ReadOnlyMockRepository<T extends Identificable> {

	private List<T> elements;

	public ReadOnlyMockRepository() {
		elements = Collections.synchronizedList(new ArrayList<>(0));
	}

	public void initialize(List<T> list) {
		elements.addAll(list);
	}

	public List<T> findAll() {
		return elements;
	}

	public Optional<T> findById(Long id) {
		return elements.stream().filter(e -> id == e.getId()).findFirst();
	}

	public int getCount() {
		return elements.size();
	}
}
