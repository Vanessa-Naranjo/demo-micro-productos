package com.lvnr.demo.micro.producto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvnr.demo.micro.producto.dto.ProductoDto;
import com.lvnr.demo.micro.producto.entity.ProductoEntity;
import com.lvnr.demo.micro.producto.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	public void crearProducto(ProductoDto productoDto) {
		ProductoEntity productoEntity = new ProductoEntity();
		productoEntity.setCodigo(productoDto.getCodigo());
		productoEntity.setNombreProducto(productoDto.getNombreProducto());
		productoEntity.setCantidad(productoDto.getCantidad());
		productoEntity.setValor(productoDto.getValor());

		productoRepository.save(productoEntity);

	}

	public void crearProductos(List<ProductoDto> productos) {
		for (ProductoDto productoDto : productos) {
			ProductoEntity productoEntity = new ProductoEntity();
			productoEntity.setCodigo(productoDto.getCodigo());
			productoEntity.setNombreProducto(productoDto.getNombreProducto());
			productoEntity.setCantidad(productoDto.getCantidad());
			productoEntity.setValor(productoDto.getValor());

			productoRepository.save(productoEntity);
		}
	}

	public List<ProductoDto> consultarProductos() {
		List<ProductoDto> productosDto = new ArrayList<>();

		List<ProductoEntity> productosEntity = productoRepository.findAll();

		for (ProductoEntity productoEntity : productosEntity) {
			ProductoDto productoDto = new ProductoDto();
			productoDto.setId(productoEntity.getId());
			productoDto.setCodigo(productoEntity.getCodigo());
			productoDto.setNombreProducto(productoEntity.getNombreProducto());
			productoDto.setCantidad(productoEntity.getCantidad());
			productoDto.setValor(productoEntity.getValor());

			productosDto.add(productoDto);
		}
		return productosDto;
	}

	public ProductoDto consultarProductoId(Integer Id) {
		ProductoEntity productoEntity = productoRepository.findById(Id).get();

		ProductoDto productoDto = new ProductoDto();
		productoDto.setId(productoEntity.getId());
		productoDto.setCodigo(productoEntity.getCodigo());
		productoDto.setNombreProducto(productoEntity.getNombreProducto());
		productoDto.setCantidad(productoEntity.getCantidad());
		productoDto.setValor(productoEntity.getValor());

		return productoDto;
	}

	public ProductoDto actualizarproducto(Integer Id, ProductoDto productoDto) {
		ProductoEntity productoEntity = productoRepository.findById(Id).get();

		productoEntity.setCodigo(productoDto.getCodigo());
		productoEntity.setNombreProducto(productoDto.getNombreProducto());
		productoEntity.setCantidad(productoDto.getCantidad());
		productoEntity.setValor(productoDto.getValor());

		this.productoRepository.save(productoEntity);
		return productoDto;
	}

	public String eliminarproducto(Integer Id) {
		ProductoEntity productoEntity = productoRepository.findById(Id).orElseGet(() -> null);
		if (productoEntity != null) {
			this.productoRepository.deleteById(Id);
			return "El producto ha sido eliminada: " + Id;
		}
		return "El producto no existe: " + Id;
	}

}