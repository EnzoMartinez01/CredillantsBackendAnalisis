package com.credillants.Dto;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
	//@Builder.Default
	//@JsonIgnore
	//private Set<ProductosEntity> productos = new LinkedHashSet<>();
}
