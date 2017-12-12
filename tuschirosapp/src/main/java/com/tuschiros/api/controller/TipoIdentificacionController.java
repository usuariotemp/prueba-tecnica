package com.tuschiros.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuschiros.api.model.TipoIdentificacionResource;
import com.tuschiros.core.CoreServiceFactory;
import com.tuschiros.core.facade.CoreServiceFacade;
import com.tuschiros.domain.TipoIdentificacion;

@RestController
public class TipoIdentificacionController {
	@Autowired
	@Qualifier("coreServiceFactory")
	private CoreServiceFactory coreServiceFactory;

	@RequestMapping("/tipoIdentificacion")
	public List<TipoIdentificacionResource> getTiposIdentificacion() {
		List<TipoIdentificacionResource> list = new ArrayList<TipoIdentificacionResource>(0);

		CoreServiceFacade coreServiceFacade = coreServiceFactory.getService("facade");
		List<TipoIdentificacion> tiposIdentificacion = coreServiceFacade.obtenerTiposIdentificacion();
		for (TipoIdentificacion tipoIdentificacion : tiposIdentificacion) {
			list.add(new TipoIdentificacionResource(tipoIdentificacion.getId(),
					tipoIdentificacion.getAbreviacion().getNombre()));
		}

		return list;
	}
}
