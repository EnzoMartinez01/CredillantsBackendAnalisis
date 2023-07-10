package com.credillants.credillants.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credillants.credillants.Entity.ProductoCategoriaEntity;

@Repository
public interface ProductosCategoriaRepository extends JpaRepository<ProductoCategoriaEntity, Integer>{
	ProductoCategoriaEntity findByIdCategoria(Integer idCategoria);
}
