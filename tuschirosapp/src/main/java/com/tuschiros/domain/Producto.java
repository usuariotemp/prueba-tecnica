package com.tuschiros.domain;

/**
 * Representa un producto que se puede comprar en la fábrica de ropa.
 * 
 * @author gbuitrag
 * 
 */
public class Producto implements Identificable {
	private long id;
	private TipoProducto tipoProducto;
	private String nombre;
	private String descripcion;

	public Producto(long id, TipoProducto tipoProducto, String nombre, String descripcion) {
		super();

		this.id = id;
		this.tipoProducto = tipoProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
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
