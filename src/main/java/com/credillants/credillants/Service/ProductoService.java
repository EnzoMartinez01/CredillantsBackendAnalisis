package com.credillants.credillants.Service;

import org.springframework.stereotype.Service;

import com.credillants.Dto.ProductoDto;
import com.credillants.Dto.ResponseDto;

@Service
public interface ProductoService {
    public ResponseDto getProductosAll();
    public ResponseDto getProducto(Integer idProducto);
    public ResponseDto createProducto(ProductoDto producto);
}
