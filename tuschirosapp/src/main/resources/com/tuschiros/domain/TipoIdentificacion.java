package com.tuschiros.domain;

/**
 * Representa el tipo de identificación que puede tener un cliente.
 *
 * @author gbuitrag
 * 
 */
public class TipoIdentificacion implements Identificable {

	private long id;
	private String nombre;
	private TipoIdentificacionAbreviacion abreviacion;

	public TipoIdentificacion(long id, String nombre, TipoIdentificacionAbreviacion abreviacion) {
		super();

		this.id = id;
		this.nombre = nombre;
		this.abreviacion = abreviacion;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id = id;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoIdentificacionAbreviacion getAbreviacion() {
		return abreviacion;
	}

	public void setAbreviacion(TipoIdentificacionAbreviacion abreviacion) {
		this.abreviacion = abreviacion;
	}
}
