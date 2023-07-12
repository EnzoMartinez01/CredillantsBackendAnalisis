package com.credillants.credillants.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.credillants.Dto.ProductoDto;
import com.credillants.Dto.ResponseDto;
import com.credillants.credillants.Service.ProductoService;

@RestController
@RequestMapping("/Productos")
public class ProductoController {
    @Autowired
    private ProductoService prodServ;

    //@ApiOperation(value = "Metodo para listar Productos")
    @GetMapping("/obtenerProductos")
    public ResponseEntity<ResponseDto> readAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(prodServ.getProductosAll());
    }

    //@ApiOperation(value = "Metodo para listar Producto por ID")
    @GetMapping("/obtenerProducto/{id}")
    public ResponseEntity<ResponseDto> readProduct(@PathVariable("id") Integer idProducto){
    	return ResponseEntity.status(HttpStatus.OK).body(prodServ.getProducto(idProducto));
    }
    
    
    //@ApiOperation(value = "Metodo para Implementar Productos")
    @PostMapping("/implementarProducto")
    public ResponseEntity<ResponseDto> implementarProducto(@RequestBody ProductoDto producto){
    	return ResponseEntity.status(HttpStatus.CREATED).body(prodServ.createProducto(producto));
    }
    
    //@ApiOperation(value = "Metodo para actualizar Producto")
    @PutMapping("/modificarProducto")
    public ResponseEntity<ResponseDto> updateProducto(@RequestBody ProductoDto producto){
    	return ResponseEntity.status(HttpStatus.CREATED).body(prodServ.updateProducto(producto));
    }
    
    //@ApiOperation(value = "Metodo para Inhabilitar Producto")
    @DeleteMapping("/inhabilitarProducto/{id}")
    public ResponseEntity<ResponseDto> inhabilitarProducto(@PathVariable("id") Integer idProducto){
    	return ResponseEntity.status(HttpStatus.OK).body(prodServ.inhabilitarProducto(idProducto));
    }
    
    //@ApiOperation(value = "Metodo para listar Productos Activos")
    @GetMapping("/productosActivos")
    public ResponseEntity<ResponseDto> productosActivos(){
    	return ResponseEntity.status(HttpStatus.OK).body(prodServ.getProductosActivos());
    }
    
    //@ApiOperation(value = "Metodo para listar Productos Inactivos")
    @GetMapping("/productosInactivos")
    public ResponseEntity<ResponseDto> productosInactivos(){
    	return ResponseEntity.status(HttpStatus.OK).body(prodServ.getProductosInactivos());
    }
    
}
