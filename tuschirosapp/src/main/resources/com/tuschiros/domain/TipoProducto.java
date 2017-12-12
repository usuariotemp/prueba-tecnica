package com.tuschiros.domain;

/**
 * Representa un tipo de producto que se puede comprar en la fábrica de ropa.
 * 
 * @author gbuitrag
 *
 */
public class TipoProducto {
	private final long id;
	private final String nombre;
	private final float precio;

	public TipoProducto(long id, String nombre, float precio) {
		super();

		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precio;
	}
}
