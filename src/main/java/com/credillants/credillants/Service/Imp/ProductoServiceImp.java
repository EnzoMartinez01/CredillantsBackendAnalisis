package com.credillants.credillants.Service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credillants.Dto.ProductoDto;
import com.credillants.Dto.ResponseDto;
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
                    .descripcionProducto(productoEntity.getDescripcionProducto())
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
                .descripcionProducto(prodEntity.getDescripcionProducto())
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
                .descripcionProducto(producto.getDescripcionProducto())
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
}
