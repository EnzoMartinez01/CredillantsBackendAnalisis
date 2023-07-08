package com.credillants.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Integer idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private Double precioProducto;
    private Boolean estadoProducto;
}
