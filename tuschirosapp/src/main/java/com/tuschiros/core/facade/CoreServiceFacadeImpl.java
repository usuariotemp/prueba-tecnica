package com.tuschiros.core.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tuschiros.core.services.ConsultasService;
import com.tuschiros.domain.Producto;
import com.tuschiros.domain.TipoIdentificacion;

@Component("facade")
public class CoreServiceFacadeImpl implements CoreServiceFacade {

	@Autowired
	private ConsultasService consultasService;

	@Override
	public List<TipoIdentificacion> obtenerTiposIdentificacion() {
		List<TipoIdentificacion> list = consultasService.obtenerTiposIdentificacion();

		return list;
	}

	@Override
	public List<Producto> obtenerProductos() {
		List<Producto> list = consultasService.obtenerProductos();

		return list;
	}

	@Override
	public List<Producto> obtenerProductosPorTipo(long idTipoProducto) {
		List<Producto> list = consultasService.obtenerProductosPorTipo(idTipoProducto);

		return list;
	}
}
