package com.credillants.credillants.Service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credillants.Dto.ProductoDto;
import com.credillants.Dto.ResponseDto;
import com.credillants.credillants.Entity.CategoriaEntity;
import com.credillants.credillants.Entity.ProductosEntity;
import com.credillants.credillants.Repository.ProductoRepository;
import com.credillants.credillants.Service.ProductoService;
import com.credillants.credillants.Util.Constante;
import com.credillants.credillants.Util.Util;

@Service
public class ProductoServiceImp implements ProductoService{
    @Autowired
    private ProductoRepository prodRep;
    
    @Override
    public ResponseDto getProductosAll() {
        try {
            List<ProductosEntity> listProductEntity = prodRep.findAll();
            if(listProductEntity.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<ProductoDto> list = new ArrayList<ProductoDto>();
            for (ProductosEntity productoEntity : listProductEntity) {
                list.add(ProductoDto.builder()
                    .idProducto(productoEntity.getIdProducto())
                    .nombreProducto(productoEntity.getNombreProducto())
                    .categoria(productoEntity.getCategoria())
                    .cantidadProducto(productoEntity.getCantidadProducto())
                    .duracionProducto(productoEntity.getDuracionProducto())
                    .precioProducto(productoEntity.getPrecioProducto())
                    .estadoProducto(productoEntity.getEstadoProducto())
                    .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
        }catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getProducto(Integer idProducto) {
        try {
            ProductosEntity prodEntity = prodRep.findById(idProducto).orElse(null);
            if(null == prodEntity) {
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            ProductoDto productoDto = ProductoDto.builder()
                .idProducto(prodEntity.getIdProducto())
                .nombreProducto(prodEntity.getNombreProducto())
                .categoria(prodEntity.getCategoria())
                .cantidadProducto(prodEntity.getCantidadProducto())
                .duracionProducto(prodEntity.getDuracionProducto())
                .precioProducto(prodEntity.getPrecioProducto())
                .estadoProducto(prodEntity.getEstadoProducto())
                .build();
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, productoDto);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto createProducto(ProductoDto producto) {
        try {
            ProductosEntity productoEntity = ProductosEntity.builder()
                .nombreProducto(producto.getNombreProducto())
                .categoria(producto.getCategoria())
                .cantidadProducto(producto.getCantidadProducto())
                .duracionProducto(producto.getDuracionProducto())
                .precioProducto(producto.getPrecioProducto())
                .estadoProducto(true)
                .build();
            prodRep.save(productoEntity);
            producto.setIdProducto(productoEntity.getIdProducto());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, producto);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateProducto(ProductoDto producto) {
        try {
            ProductosEntity productosEntity = prodRep.findById(producto.getIdProducto()).orElse(null);
            if (null == productosEntity) {
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            productosEntity.setNombreProducto(producto.getNombreProducto());
            productosEntity.setCategoria(producto.getCategoria());
            productosEntity.setCantidadProducto(producto.getCantidadProducto());
            productosEntity.setDuracionProducto(producto.getDuracionProducto());
            productosEntity.setPrecioProducto(producto.getPrecioProducto());
            productosEntity.setEstadoProducto(producto.getEstadoProducto());
            prodRep.save(productosEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, producto);
        } catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto inhabilitarProducto(Integer idProducto){
        try {
            ProductosEntity productosEntity = prodRep.findById(idProducto).orElse(null);
            productosEntity.setEstadoProducto(false);
            prodRep.save(productosEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getProductosActivos(){
        try {
            List<ProductosEntity> obtenerProductosActivos = prodRep.findByEstadoProducto(true);
            if(obtenerProductosActivos.isEmpty()) {
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<ProductoDto> list = new ArrayList<ProductoDto>();
            for (ProductosEntity productosEntity : obtenerProductosActivos) {
                list.add(ProductoDto.builder()
                    .idProducto(productosEntity.getIdProducto())
                    .nombreProducto(productosEntity.getNombreProducto())
                    .categoria(productosEntity.getCategoria())
                    .cantidadProducto(productosEntity.getCantidadProducto())
                    .duracionProducto(productosEntity.getDuracionProducto())
                    .precioProducto(productosEntity.getPrecioProducto())
                    .estadoProducto(productosEntity.getEstadoProducto())
                    .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getProductosInactivos() {
        try {
            List<ProductosEntity> obtenerProductosActivos = prodRep.findByEstadoProducto(false);
            if(obtenerProductosActivos.isEmpty()) {
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<ProductoDto> list = new ArrayList<ProductoDto>();
            for (ProductosEntity productosEntity : obtenerProductosActivos) {
                list.add(ProductoDto.builder()
                    .idProducto(productosEntity.getIdProducto())
                    .nombreProducto(productosEntity.getNombreProducto())
                    .categoria(productosEntity.getCategoria())
                    .cantidadProducto(productosEntity.getCantidadProducto())
                    .duracionProducto(productosEntity.getDuracionProducto())
                    .precioProducto(productosEntity.getPrecioProducto())
                    .estadoProducto(productosEntity.getEstadoProducto())
                    .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }
    
    @Override
    public ResponseDto getProductosdeunaCategoria(CategoriaEntity categoria) {
    	try {
    		List<ProductosEntity> obtenerProductosdeunaCategoria = prodRep.findByCategoria(categoria);
    		if(obtenerProductosdeunaCategoria.isEmpty()) {
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
    		}
    		List<ProductoDto> list = new ArrayList<ProductoDto>();
    		for (ProductosEntity productosEntity : obtenerProductosdeunaCategoria) {
    			list.add(ProductoDto.builder()
    					.idProducto(productosEntity.getIdProducto())
                        .nombreProducto(productosEntity.getNombreProducto())
                        .categoria(productosEntity.getCategoria())
                        .cantidadProducto(productosEntity.getCantidadProducto())
                        .duracionProducto(productosEntity.getDuracionProducto())
                        .precioProducto(productosEntity.getPrecioProducto())
                        .estadoProducto(productosEntity.getEstadoProducto())
                        .build());
    		}
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
    	} catch (Exception e) {
    		return Util.getResponse(false, Constante.OPERATION_FAILED, null);
    	}
    }
}
