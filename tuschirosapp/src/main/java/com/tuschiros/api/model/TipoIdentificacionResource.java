package com.tuschiros.api.model;

public class TipoIdentificacionResource {
	private final long id;
	private final String nombre;

	public TipoIdentificacionResource(long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}
