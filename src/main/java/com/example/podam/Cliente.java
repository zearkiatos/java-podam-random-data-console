package com.example.podam;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

	//Atributos
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String correo;
	private String telefono;
	private ArrayList<Compra> compras;
	
	public Cliente (String nombre, String correo, String telefono) {
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.compras = new ArrayList<Compra>();
	}
	
	@Override
	public String toString() {
		return "Cliente: " + nombre + " con correo " + correo + " y número de telefono " + telefono;
	}
	
	public void comprar(ArticuloUnitario articulos) {
		ArrayList<ArticuloUnitario> arts = new ArrayList<ArticuloUnitario>();
		arts.add(articulos);
		compras.add(new Compra(arts));
	}
	
	public ArrayList<Compra> getCompras(){
		return compras;
	}
}
