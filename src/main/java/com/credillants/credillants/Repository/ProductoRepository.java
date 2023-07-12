package com.credillants.credillants.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credillants.credillants.Entity.ProductosEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductosEntity, Integer>{
    List<ProductosEntity> findByEstadoProducto(Boolean estadoProducto);
  }
