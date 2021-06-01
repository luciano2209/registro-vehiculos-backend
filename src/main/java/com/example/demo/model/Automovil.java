package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "automovil")
public class Automovil {
	@Id
	private String _id;
	private String patente;
	private String modelo;
	private String marca;
	private int version;
	private int precio;
	private int cantidadCuota;
	private double interes ;
	private int valorCuota;
	private String estado;
	
	public Automovil() {
		super();
	}

	public Automovil(String _id,String patente, String modelo, String marca, int version, int precio, int cantidadCuota,
			double interes, int valorCuota, String estado) {
		super();
		this._id = _id;
		this.patente = patente;
		this.modelo = modelo;
		this.marca = marca;
		this.version = version;
		this.precio = precio;
		this.cantidadCuota = cantidadCuota;
		this.interes = interes;
		this.valorCuota = valorCuota;
		this.estado = estado;
	}
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this.patente = _id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidadCuota() {
		return cantidadCuota;
	}

	public void setCantidadCuota(int cantidadCuota) {
		this.cantidadCuota = cantidadCuota;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(int valorCuota) {
		this.valorCuota = valorCuota;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
	
	
	

}
