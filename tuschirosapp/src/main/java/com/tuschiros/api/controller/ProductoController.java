package com.tuschiros.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tuschiros.api.model.ProductoResource;
import com.tuschiros.core.CoreServiceFactory;
import com.tuschiros.core.facade.CoreServiceFacade;
import com.tuschiros.domain.Producto;

@RestController
public class ProductoController {
	@Autowired
	@Qualifier("coreServiceFactory")
	private CoreServiceFactory coreServiceFactory;

	@RequestMapping("/producto")
	public List<ProductoResource> getProductos() {
		List<ProductoResource> list = new ArrayList<ProductoResource>(0);

		CoreServiceFacade coreServiceFacade = coreServiceFactory.getService("facade");
		List<Producto> productos = coreServiceFacade.obtenerProductos();
		for (Producto producto : productos) {
			list.add(new ProductoResource(producto.getId(), producto.getTipoProducto(), producto.getNombre(),
					producto.getDescripcion()));
		}

		return list;
	}

	@RequestMapping(value = "/producto", params = "tipo", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductoResource> getProductosTipo(@RequestParam("tipo") long idTipoProducto) {
		List<ProductoResource> list = new ArrayList<ProductoResource>(0);

		CoreServiceFacade coreServiceFacade = coreServiceFactory.getService("facade");
		List<Producto> productos = coreServiceFacade.obtenerProductosPorTipo(idTipoProducto);
		for (Producto producto : productos) {
			list.add(new ProductoResource(producto.getId(), producto.getTipoProducto(), producto.getNombre(),
					producto.getDescripcion()));
		}

		return list;
	}
}
