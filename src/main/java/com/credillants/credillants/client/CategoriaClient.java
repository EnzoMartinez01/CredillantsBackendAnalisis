package com.credillants.credillants.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.credillants.Dto.ResponseDto;

@FeignClient(name = "categoria", url = "http://localhost:3306")
public interface CategoriaClient {
	@GetMapping("/categorias")
	ResponseDto readAllCategorias();
	
	@GetMapping("/categorias/{id}")
	ResponseDto readCategoria(@PathVariable("id") Integer idCategoria);
}
