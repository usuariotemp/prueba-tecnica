package com.tuschiros.core.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tuschiros.domain.Producto;
import com.tuschiros.domain.TipoIdentificacion;
import com.tuschiros.repository.ReadOnlyMockRepository;

@Service
public class ConsultasService {
	@Autowired
	@Qualifier("tipoIdentificacionRepository")
	private ReadOnlyMockRepository<TipoIdentificacion> tipoIdentificacionRepository;

	@Autowired
	@Qualifier("productoRepository")
	private ReadOnlyMockRepository<Producto> productoRepository;

	public List<TipoIdentificacion> obtenerTiposIdentificacion() {
		return tipoIdentificacionRepository.findAll();
	}

	public List<Producto> obtenerProductos() {
		return productoRepository.findAll();
	}

	public List<Producto> obtenerProductosPorTipo(long tipoProducto) {
		List<Producto> productsList = productoRepository.findAll();
		List<Producto> result = productsList.stream()
				.filter(a -> Objects.equals(a.getTipoProducto().getId(), tipoProducto))
				.collect(Collectors.toList());

		return result;
	}
}
