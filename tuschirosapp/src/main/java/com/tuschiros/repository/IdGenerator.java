package com.tuschiros.repository;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Generador de Ids para las entidades de dominio.
 * 
 * @author gbuitrag
 *
 */

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IdGenerator {
	private AtomicLong nextId = new AtomicLong(1);

	public long getNextId() {
		return nextId.getAndIncrement();
	}
}
