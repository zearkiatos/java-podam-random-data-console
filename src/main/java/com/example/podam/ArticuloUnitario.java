package com.example.podam;

import java.io.Serializable;

public class ArticuloUnitario implements Serializable {
	
	//Atributos
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private String categoria;
	private double precio;
	
	//Metodos
	public ArticuloUnitario(String nombre, String descripcion, String categoria, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Articulo: " + nombre + " del tipo " + categoria + ". Precio:$" + precio + "\n" + descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}
}
