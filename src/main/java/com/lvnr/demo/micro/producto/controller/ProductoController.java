package com.lvnr.demo.micro.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.producto.dto.ProductoDto;
import com.lvnr.demo.micro.producto.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@PostMapping
	public void crearProducto(ProductoDto productoDto) {
		productoService.crearProducto(productoDto);
	}

	@PostMapping("/crearproductos")
	public void crearProductos(@RequestBody List<ProductoDto> productos) {
		productoService.crearProductos(productos);
	}

	@GetMapping
	public List<ProductoDto> consultarProductos() {
		return productoService.consultarProductos();
	}

	@GetMapping("/consultarproductoid/{Id}")
	public ProductoDto consultarProductoId(@PathVariable Integer Id) {
		return productoService.consultarProductoId(Id);
	}

	@PutMapping("/actualizarproducto/{Id}")
	public ProductoDto actualizarproducto(@PathVariable Integer Id, @RequestBody ProductoDto productoDto) {
		return productoService.actualizarproducto(Id, productoDto);
	}

	@DeleteMapping("/eliminarproducto/{Id}")
	public String eliminarproducto(@PathVariable Integer Id) {
		return productoService.eliminarproducto(Id);
	}

}
