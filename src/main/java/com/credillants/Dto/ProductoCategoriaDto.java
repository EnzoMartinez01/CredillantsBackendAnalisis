package com.credillants.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCategoriaDto {
	private Integer idCategoria;
	private String nombreCategoria;
    private Integer idProducto;
    private String nombreProducto;
    private Double precioProducto;
}
