package com.credillants.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponseDto {
	private List<ProductoDto> productos;
	private Object categoria;
}
