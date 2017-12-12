package com.tuschiros.api.model;

import com.tuschiros.domain.TipoProducto;

public class ProductoResource {
	private long id;
	private TipoProducto tipoProducto;
	private String nombre;
	private String descripcion;

	public ProductoResource(long id, TipoProducto tipoProducto, String nombre, String descripcion) {
		this.id = id;
		this.tipoProducto = tipoProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

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
