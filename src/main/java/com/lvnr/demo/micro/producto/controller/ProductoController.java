package com.lvnr.demo.micro.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.producto.dto.ProductoDto;
import com.lvnr.demo.micro.producto.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@PostMapping
	public void crearProducto(@RequestParam String codigo, @RequestParam String nombreProducto,
			@RequestParam int cantidad, @RequestParam double valor) {
		productoService.crearProducto(codigo, nombreProducto, cantidad, valor);
	}

	@PostMapping("/crearproductos")
	public void crearProductos(@RequestBody List<ProductoDto> productoDto) {
		productoService.crearProductos(productoDto);
	}

	@GetMapping
	public List<ProductoDto> consultarProductos() {
		return productoService.consultarProductos();
	}

	@GetMapping("/consultarProductocodigo/{codigo}")
	public ProductoDto consultarProductoPorCodigo(@PathVariable String codigo) {
		return productoService.consultarProductoPorCodigo(codigo);
	}

	@DeleteMapping("/{codigo}")
	public String eliminarProductoPorCodigo(@PathVariable String codigo) {
		return productoService.eliminarProductoPorCodigo(codigo);
	}

	@PutMapping ("/{codigo}")
	public ProductoDto actualizarProducto(@PathVariable String codigo, @RequestBody ProductoDto productoDto) {
		return productoService.actualizarProducto(codigo, productoDto);
	}
}
