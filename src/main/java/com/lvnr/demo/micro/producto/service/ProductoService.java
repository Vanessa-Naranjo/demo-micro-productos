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

	public List<ProductoDto> consultarProductos() {
		return productos;
	}

	public ProductoDto consultarProductoPorCodigo(String codigo) {
		for (ProductoDto productoDto : productos) {
			if(productoDto.getCodigo().equals(codigo)) {
				return productoDto;
			}
		}return null;
	}

}
