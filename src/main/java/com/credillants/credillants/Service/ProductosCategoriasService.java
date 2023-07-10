package com.credillants.credillants.Service;

import org.springframework.stereotype.Service;

import com.credillants.Dto.ProductoCategoriaDto;
import com.credillants.Dto.ResponseDto;

@Service
public interface ProductosCategoriasService {
	public ResponseDto getAllProductosCategoria();
	public ResponseDto getProductoCurso(Integer idCategoria);
	public ResponseDto createProductoCategoria(ProductoCategoriaDto productoCategoriaDto);
	public ResponseDto updateProductoCategoria(ProductoCategoriaDto productoCategoriaDto);
	public ResponseDto deleteProductoCategoria(Integer idCategoria);
}
