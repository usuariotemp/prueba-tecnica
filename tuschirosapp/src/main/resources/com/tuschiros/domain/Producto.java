package com.tuschiros.domain;

/**
 * Representa un producto que se puede comprar en la fábrica de ropa.
 * 
 * @author gbuitrag
 * 
 */
public class Producto {
	private final long id;
	private final TipoProducto tipoProducto;
	private final String nombre;
	private final String descripcion;

	public Producto(long id, TipoProducto tipoProducto, String nombre, String descripcion) {
		super();

		this.id = id;
		this.tipoProducto = tipoProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
