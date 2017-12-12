package com.tuschiros.domain;

/**
 * Representa un item que es agregado a un pedido y que está relacionado con un
 * producto y una cantidad.
 *
 * @author gbuitrag
 *
 */
public class Item {
	private long id;
	private Producto producto;
	private short cantidad;

	public Item() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public short getCantidad() {
		return cantidad;
	}

	public void setCantidad(short cantidad) {
		this.cantidad = cantidad;
	}
}
