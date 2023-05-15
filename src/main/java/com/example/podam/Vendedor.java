package com.example.podam;

import java.io.Serializable;
import java.util.ArrayList;
import uk.co.jemos.podam.common.PodamExclude;

public class Vendedor implements Serializable {

	//Atributos
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String correo;
	private String telefono;
	private ArrayList<ArticuloUnitario> artDisponibles;
	@PodamExclude
	private ArrayList<ArticuloUnitario> artVendidos;
	
	public Vendedor (String nombre, String correo, String telefono) {
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.artDisponibles = new ArrayList<ArticuloUnitario>();
		this.artVendidos = new ArrayList<ArticuloUnitario>();
	}
	
	@Override
	public String toString() {
		return nombre + ". Correo: " + correo + ", telefono: " + telefono;
	}
	
	public void vender(int index) {
		System.out.println("antes - disp: "+artDisponibles.size() + " - vend: " + artVendidos.size());
		artVendidos.add(artDisponibles.remove(index));
		System.out.println("despues - disp: "+artDisponibles.size() + " - vend: " + artVendidos.size());

	}
	
	public void ofrecer(ArticuloUnitario articulo) {
		artDisponibles.add(articulo);
	}

	public ArrayList<ArticuloUnitario> getVendidos() {
		return artVendidos;
	}
	
	public ArrayList<ArticuloUnitario> getDisponibles() {
		return artDisponibles;
	}
	
	public void imprimirDisponibles() {
    	if(artDisponibles.size() == 0) {
    		System.out.println("Este vendedor no tiene productos disponibles en el momento. Ingrese 0 para regresar");
    	}
    	else {
    		System.out.println("¿Qué producto desea comprar?\nIndique el número del producto");
    		for(int i=0;i<artDisponibles.size();i++) {
    			System.out.println((i+1) + ". " + artDisponibles.get(i).toString());
    		}
    	}
	}
}
