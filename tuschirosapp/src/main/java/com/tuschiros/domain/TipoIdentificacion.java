package com.tuschiros.domain;

/**
 * Representa el tipo de identificación que puede tener un cliente.
 *
 * @author gbuitrag
 * 
 */
public class TipoIdentificacion implements Identificable {
	private long id;
	private TipoIdentificacionAbreviacion abreviacion;

	public TipoIdentificacion(long id, TipoIdentificacionAbreviacion abreviacion) {
		super();

		this.id = id;
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

	public TipoIdentificacionAbreviacion getAbreviacion() {
		return abreviacion;
	}

	public void setAbreviacion(TipoIdentificacionAbreviacion abreviacion) {
		this.abreviacion = abreviacion;
	}
}
