package com.tuschiros.domain;

public enum TipoIdentificacionAbreviacion {
	CC("CC", "Cédula Ciudadanía"),
	CE("CE", "Cédula Extranjería"), 
	RC("RC", "Registro Civil"), 
	TI("TI", "Tarjeta de Identidad"), 
	NIT("NIT", "Nit");

	private final String nombre;
	private final String descripcion;

	private TipoIdentificacionAbreviacion(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
