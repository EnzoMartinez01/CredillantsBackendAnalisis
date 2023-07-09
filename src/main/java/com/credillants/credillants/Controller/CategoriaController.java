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

import com.credillants.Dto.CategoriaDto;
import com.credillants.Dto.ResponseDto;
import com.credillants.credillants.Service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService catServ;
	
    //@ApiOperation(value = "Metodo para listar Categorias")
	@GetMapping("/obtenerCategoria")
	public ResponseEntity<ResponseDto> readAllCategorias(){
		return ResponseEntity.status(HttpStatus.OK).body(catServ.getCategoriasAll());
	}
	
    //@ApiOperation(value = "Metodo para agregar Categoria")
	@PostMapping("/agregarCategoria")
	public ResponseEntity<ResponseDto> agregarCategoria(@RequestBody CategoriaDto categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(catServ.agregarCategoria(categoria));
	}
	
    //@ApiOperation(value = "Metodo para actualizar una Categoria")
	@PutMapping("/actualizarCategoria")
	public ResponseEntity<ResponseDto> updateCategoria(@RequestBody CategoriaDto categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(catServ.updateCategoria(categoria));
	}
	
    //@ApiOperation(value = "Metodo para eliminar una Categoria")
	@DeleteMapping("/eliminarCategoria")
	public ResponseEntity<ResponseDto> deletedCategoria(@PathVariable("id") Integer idCategoria){
		return ResponseEntity.status(HttpStatus.OK).body(catServ.deletedCategoria(idCategoria));
	}
}
