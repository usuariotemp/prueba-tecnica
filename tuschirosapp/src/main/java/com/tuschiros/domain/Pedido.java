package com.tuschiros.domain;

import java.time.Instant;
import java.util.List;

/**
 * Representa un pedido que realiza un cliente en la fábrica de ropa.
 * 
 * @author gbuitrag
 *
 */
public class Pedido {
	private long id;
	private Cliente cliente;
	private Instant fechaHoraRegistro;
	private String direccionEntrega;
	private Instant fechaHoraEntregaSolicitada;
	private float precioTransporte;
	private List<Item> items;

	public Pedido() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Instant getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(Instant fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public Instant getFechaHoraEntregaSolicitada() {
		return fechaHoraEntregaSolicitada;
	}

	public void setFechaHoraEntregaSolicitada(Instant fechaHoraEntregaSolicitada) {
		this.fechaHoraEntregaSolicitada = fechaHoraEntregaSolicitada;
	}

	public float getPrecioTransporte() {
		return precioTransporte;
	}

	public void setPrecioTransporte(float precioTransporte) {
		this.precioTransporte = precioTransporte;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public float calcularValor() {
		float valor = 0;

		for (Item item : items) {
			valor += item.getProducto().getTipoProducto().getPrecio();
		}

		return valor;
	}
}
