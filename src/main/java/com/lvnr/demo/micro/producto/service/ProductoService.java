package com.lvnr.demo.micro.producto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.producto.dto.ProductoDto;

@Service
public class ProductoService {

	private List<ProductoDto> productos;

	public ProductoService() {
		productos = new ArrayList<>();
	}

	public void crearProducto(String codigo, String nombreProducto, int cantidad, double valor) {
		ProductoDto productoDto = new ProductoDto(codigo, nombreProducto, cantidad, valor);
		this.productos.add(productoDto);
	}

	public void crearProductos(List<ProductoDto> productoDto) {
		this.productos.addAll(productoDto);
	}

	public List<ProductoDto> consultarProductos() {
		return productos;
	}

	public ProductoDto consultarProductoPorCodigo(String codigo) {
		for (ProductoDto productoDto : productos) {
			if (productoDto.getCodigo().equals(codigo)) {
				return productoDto;
			}
		}
		return null;
	}

	public String eliminarProductoPorCodigo(String codigo) {
		ProductoDto productoDto = this.consultarProductoPorCodigo(codigo);
		if (codigo == null) {
			return "El producto no existe: " + codigo;
		}
		this.productos.remove(productoDto);

		return "El producto ha sido eliminado";
	}

	public ProductoDto actualizarProducto(String codigo, ProductoDto productoDto) {
		this.eliminarProductoPorCodigo(codigo);
		productos.add(productoDto);
		return productoDto;
	}
}
