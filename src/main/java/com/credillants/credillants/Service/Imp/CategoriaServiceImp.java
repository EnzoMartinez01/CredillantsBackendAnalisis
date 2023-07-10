package com.credillants.credillants.Service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credillants.Dto.CategoriaDto;
import com.credillants.Dto.ResponseDto;
import com.credillants.credillants.Entity.CategoriaEntity;
import com.credillants.credillants.Repository.CategoriaRepository;
import com.credillants.credillants.Service.CategoriaService;
import com.credillants.credillants.Util.Constante;
import com.credillants.credillants.Util.Util;

@Service
public class CategoriaServiceImp implements CategoriaService{
	
	@Autowired
	private CategoriaRepository catRep;
	
	@Override
	public ResponseDto getCategoriasAll() {
		try {
			List<CategoriaEntity> listCategoriaEntity = catRep.findAll();
			if(listCategoriaEntity.isEmpty()) {
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			List<CategoriaDto> list = new ArrayList<CategoriaDto>();
			for (CategoriaEntity categoriaEntity : listCategoriaEntity) {
				list.add(CategoriaDto.builder()
						.idCategoria(categoriaEntity.getIdCategoria())
						.nombreCategoria(categoriaEntity.getNombreCategoria())
						.build());
			}
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
		}catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}
	
	@Override
	public ResponseDto agregarCategoria(CategoriaDto categoria) {
		try {
			CategoriaEntity categoriaEntity = CategoriaEntity.builder()
					.nombreCategoria(categoria.getNombreCategoria())
					.build();
			catRep.save(categoriaEntity);
			categoria.setIdCategoria(categoriaEntity.getIdCategoria());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, categoria);
		} catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}
	
	@Override
	public ResponseDto updateCategoria(CategoriaDto categoria) {
		try {
			CategoriaEntity categoriaEntity = catRep.findById(categoria.getIdCategoria()).orElse(null);
			if(null == categoriaEntity) {
	            return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			categoriaEntity.setNombreCategoria(categoria.getNombreCategoria());
			catRep.save(categoriaEntity);
	        return Util.getResponse(true, Constante.OPERATION_SUCCESS, categoria);
		} catch (Exception e) {
	        return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}
	
	@Override
	public ResponseDto deletedCategoria(Integer idCategoria) {
		try {
			CategoriaEntity categoriaEntity = catRep.findById(idCategoria).orElse(null);
			if(null == categoriaEntity) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			catRep.delete(categoriaEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
		} catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}
}
