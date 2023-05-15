package com.example.podam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import com.example.podam.ArticuloUnitario;

public class Compra implements Serializable {

	// Atributos
	private static final long serialVersionUID = 1L;
	private Date fecha;
	private String estado;
	private double total;
	private ArrayList<ArticuloUnitario> articulos;

	// Metodos
	public Compra(ArrayList<ArticuloUnitario> articulos) {
		this.fecha = new Date(System.currentTimeMillis());
		this.estado = "Pago pendiente";
		this.articulos = articulos;
		double tmp = 0;
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloUnitario act = articulos.get(i);
			tmp = tmp + act.getPrecio();
		}
		this.total = tmp;
	}

	@Override
	public String toString() {
		return "Compra realizada en: " + fecha.toLocaleString() + ", con " + articulos.size()
				+ " articulos, por un total de $" + total + "\nActualmente en estado: " + estado;
	}

	public void cambiarEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<ArticuloUnitario> getArticulos() {

		return articulos;

	}
}
