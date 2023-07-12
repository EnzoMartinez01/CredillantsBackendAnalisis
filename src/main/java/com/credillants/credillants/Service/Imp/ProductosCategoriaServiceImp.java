package com.credillants.credillants.Service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credillants.Dto.ProductoCategoriaDto;
import com.credillants.Dto.ResponseDto;
import com.credillants.credillants.Entity.CategoriaEntity;
import com.credillants.credillants.Entity.ProductoCategoriaEntity;
import com.credillants.credillants.Entity.ProductosEntity;
import com.credillants.credillants.Repository.CategoriaRepository;
import com.credillants.credillants.Repository.ProductoRepository;
import com.credillants.credillants.Repository.ProductosCategoriaRepository;
import com.credillants.credillants.Service.ProductosCategoriasService;
import com.credillants.credillants.Util.Constante;
import com.credillants.credillants.Util.Util;

@Service
public class ProductosCategoriaServiceImp implements ProductosCategoriasService{
	@Autowired
	private ProductosCategoriaRepository productosCategoriaRepository;
	
	@Autowired
	private CategoriaRepository catRep;
	
	@Autowired ProductoRepository productoRepository;
	
	@Override
	public ResponseDto getAllProductosCategoria() {
		try {
			List<ProductoCategoriaEntity> listProductoCategoriaEntity = productosCategoriaRepository.findAll();
			List<ProductoCategoriaDto> listProductoCategoriaDto = new ArrayList<ProductoCategoriaDto>();
			
			for(int i = 0; i < listProductoCategoriaEntity.size(); i++) {
				ProductosEntity productosEntity = productoRepository.findById(listProductoCategoriaEntity.get(i).getIdProducto()).orElse(null);
				
				CategoriaEntity categoriaEntity = catRep.findById(listProductoCategoriaEntity.get(i).getIdCategoria()).orElse(null);
				
				listProductoCategoriaDto.add(ProductoCategoriaDto.builder()
						.idCategoria(categoriaEntity.getIdCategoria())
						.nombreCategoria(categoriaEntity.getNombreCategoria())
						.idProducto(productosEntity.getIdProducto())
						.nombreProducto(productosEntity.getNombreProducto())
						.precioProducto(productosEntity.getPrecioProducto())
						.build());
			}
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, listProductoCategoriaDto); 
		} catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}
	
	@Override
	public ResponseDto getProductoCurso(Integer idCategoria) {
		try {
			ProductoCategoriaEntity productoCategoriaEntity = productosCategoriaRepository.findByIdCategoria(idCategoria);
			if(productoCategoriaEntity == null) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, productoCategoriaEntity);
			}
			ProductosEntity productosEntity = productoRepository.findById(productoCategoriaEntity.getIdProducto()).orElse(null);
			CategoriaEntity categoriaEntity = catRep.findById(productoCategoriaEntity.getIdCategoria()).orElse(null);
			
			ProductoCategoriaDto productoCategoriaDto = ProductoCategoriaDto.builder()
					.idCategoria(categoriaEntity.getIdCategoria())
					.nombreCategoria(categoriaEntity.getNombreCategoria())
					.idProducto(productosEntity.getIdProducto())
					.nombreProducto(productosEntity.getNombreProducto())
					.build();
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, productoCategoriaDto);
		} catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}
	
	@Override
	public ResponseDto createProductoCategoria(ProductoCategoriaDto productoCategoriaDto) {
		try {
			ProductoCategoriaEntity productoCategoriaEntity = ProductoCategoriaEntity.builder()
					.idCategoria(productoCategoriaDto.getIdCategoria())
					.idProducto(productoCategoriaDto.getIdProducto())
					.build();
			
			productosCategoriaRepository.save(productoCategoriaEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
		} catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}
	
	@Override
	public ResponseDto updateProductoCategoria(ProductoCategoriaDto productoCategoriaDto) {
		try {
			ProductoCategoriaEntity productoCategoriaEntity = productosCategoriaRepository.findById(productoCategoriaDto.getIdProducto()).orElse(null);
			if(null == productoCategoriaEntity) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			productoCategoriaEntity.setIdCategoria(productoCategoriaDto.getIdCategoria());
			productoCategoriaEntity.setIdProducto(productoCategoriaDto.getIdProducto());
			productosCategoriaRepository.save(productoCategoriaEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, productoCategoriaDto);
		} catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);		
		}
	}
	
	@Override
	public ResponseDto deleteProductoCategoria(Integer idCategoria) {
		try {
			ProductoCategoriaEntity productoCategoriaEntity = productosCategoriaRepository.findById(idCategoria).orElse(null);
			productosCategoriaRepository.delete(productoCategoriaEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
		} catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}
}
