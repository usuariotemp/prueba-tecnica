package com.tuschiros;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.tuschiros.core.CoreServiceFactory;
import com.tuschiros.domain.Producto;
import com.tuschiros.domain.TipoIdentificacion;
import com.tuschiros.domain.TipoIdentificacionAbreviacion;
import com.tuschiros.domain.TipoProducto;
import com.tuschiros.repository.ReadOnlyMockRepository;

@org.springframework.context.annotation.Configuration
@EnableAutoConfiguration
@ComponentScan("com.tuschiros.core")
public class Configuration {

	@Bean
	public ServiceLocatorFactoryBean coreServiceFactory() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(CoreServiceFactory.class);

		return factoryBean;
	}

	@Bean
	public ReadOnlyMockRepository<TipoIdentificacion> tipoIdentificacionRepository() {
		List<TipoIdentificacion> list = new ArrayList<TipoIdentificacion>(0);
		list.add(new TipoIdentificacion(1, TipoIdentificacionAbreviacion.CC));
		list.add(new TipoIdentificacion(2, TipoIdentificacionAbreviacion.CE));
		list.add(new TipoIdentificacion(3, TipoIdentificacionAbreviacion.RC));
		list.add(new TipoIdentificacion(4, TipoIdentificacionAbreviacion.TI));
		list.add(new TipoIdentificacion(5, TipoIdentificacionAbreviacion.NIT));

		ReadOnlyMockRepository<TipoIdentificacion> repository = new ReadOnlyMockRepository<TipoIdentificacion>();
		repository.initialize(list);

		return repository;
	}

	@Bean
	public ReadOnlyMockRepository<Producto> productoRepository() {
		List<Producto> list = new ArrayList<Producto>(0);

		// Camisas
		list.add(new Producto(1, new TipoProducto(1, "Camisas Formales", 65000f), "Camisa Calvin Klein cuello inglés",
				"Camisa Calvin Klein cuello inglés"));
		list.add(new Producto(11, new TipoProducto(1, "Camisas Formales", 78000f), "Camisa Tenkey puño abotonado",
				"Camisa Tenkey puño abotonado"));
		list.add(new Producto(12, new TipoProducto(1, "Camisas Formales", 69900f), "Camisa Barbour cuello americano",
				"Camisa Barbour cuello americano"));
		list.add(new Producto(13, new TipoProducto(1, "Camisas Formales", 69900f), "Camisa La Martina puño francés",
				"Camisa La Martina puño francés"));
		list.add(new Producto(14, new TipoProducto(1, "Camisas Formales", 53700f), "Camisa Ben Sherman cuello club",
				"Camisa Ben Sherman cuello club"));

		// Pantalones
		list.add(new Producto(2, new TipoProducto(2, "Pantalones Formales", 95400f), "Pantalon de algodón seersucker",
				"Pantalon de algodón seersucker"));
		list.add(new Producto(21, new TipoProducto(2, "Pantalones Formales", 88200f),
				"Pantalon moleskin de alta resistencia", "Pantalon de algodón seersucker"));
		list.add(new Producto(22, new TipoProducto(2, "Pantalones Formales", 44650f), "Pantalon de pana clásico",
				"Pantalon de pana clásico"));

		// Chaquetas
		list.add(new Producto(3, new TipoProducto(3, "Chaquetas", 146000f), "Chaqueta blazer en satén",
				"Chaqueta blazer en satén"));
		list.add(new Producto(31, new TipoProducto(3, "Chaquetas", 178100f), "Chaqueta cardigan de punto, sin cuello",
				"Chaqueta cardigan de punto, sin cuello"));


		ReadOnlyMockRepository<Producto> repository = new ReadOnlyMockRepository<Producto>();
		repository.initialize(list);

		return repository;
	}
}
