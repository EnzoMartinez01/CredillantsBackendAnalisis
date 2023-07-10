package com.credillants.credillants.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credillants.Dto.ProductoCategoriaDto;
import com.credillants.Dto.ResponseDto;
import com.credillants.credillants.Service.ProductosCategoriasService;

@RestController
@RequestMapping("/productoCategoria")
public class ProductoCategoriaController {
	@Autowired
	private ProductosCategoriasService productosCategoriasService;
	
	@GetMapping("/obtenerProductoCategoria")
	public ResponseEntity<ResponseDto> getAllProductosCategoria(){
		return ResponseEntity.status(HttpStatus.OK).body(productosCategoriasService.getAllProductosCategoria());
	}
	
	@GetMapping("/obtenerProductoCategoria/{id}")
	public ResponseEntity<ResponseDto> getProductoCategoria(@PathVariable("id") Integer idCategoria){
		return ResponseEntity.status(HttpStatus.OK).body(productosCategoriasService.getProductoCurso(idCategoria));
	}
	
	@PostMapping("/implementarProductoCategoria")
	public ResponseEntity<ResponseDto> createProductoCategoria(@RequestBody ProductoCategoriaDto productoCategoriaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productosCategoriasService.createProductoCategoria(productoCategoriaDto));
	}
	
	@PutMapping("/actualizarProductoCategoria")
	public ResponseEntity<ResponseDto> updateProductoCategoria(@RequestBody ProductoCategoriaDto productoCategoriaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productosCategoriasService.updateProductoCategoria(productoCategoriaDto));
	}
	
	@DeleteMapping("/eliminarProductoCategoria/{id}")
	public ResponseEntity<ResponseDto> deletedProductoCategoria(@PathVariable("id") Integer idCategoria){
		return ResponseEntity.status(HttpStatus.OK).body(productosCategoriasService.deleteProductoCategoria(idCategoria));
	}
}
