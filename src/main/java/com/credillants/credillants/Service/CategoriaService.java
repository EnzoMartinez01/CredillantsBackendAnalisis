package com.credillants.credillants.Service;

import org.springframework.stereotype.Service;

import com.credillants.Dto.CategoriaDto;
import com.credillants.Dto.ResponseDto;

@Service
public interface CategoriaService {
	public ResponseDto getCategoriasAll();
	public ResponseDto agregarCategoria(CategoriaDto categoria);
	public ResponseDto updateCategoria(CategoriaDto categoria);
	public ResponseDto deletedCategoria(Integer idCategoria);
}
