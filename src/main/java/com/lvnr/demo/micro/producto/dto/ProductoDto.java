package com.lvnr.demo.micro.producto.dto;

public class ProductoDto {

	private String codigo;
	private String nombreProducto;
	private int cantidad;
	private double valor;

	
	public ProductoDto(String codigo, String nombreProducto, int cantidad, double valor) {
		super();
		this.codigo = codigo;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
