package com.lvnr.demo.micro.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lvnr.demo.micro.producto.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
	

}
