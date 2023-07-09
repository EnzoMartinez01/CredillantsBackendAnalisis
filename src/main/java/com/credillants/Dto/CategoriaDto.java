package com.credillants.Dto;

import java.util.Set;

import com.credillants.credillants.Entity.ProductosEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {
	private Integer idCategoria;
	private String nombreCategoria;
	@JsonIgnore
	private Set<ProductosEntity> productos;
}
