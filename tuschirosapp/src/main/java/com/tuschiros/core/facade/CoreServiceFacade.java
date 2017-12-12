package com.tuschiros.core.facade;

import java.util.List;

import com.tuschiros.domain.Producto;
import com.tuschiros.domain.TipoIdentificacion;

public interface CoreServiceFacade {
	public List<TipoIdentificacion> obtenerTiposIdentificacion();

	public List<Producto> obtenerProductos();

	public List<Producto> obtenerProductosPorTipo(long idTipoProducto);
}
