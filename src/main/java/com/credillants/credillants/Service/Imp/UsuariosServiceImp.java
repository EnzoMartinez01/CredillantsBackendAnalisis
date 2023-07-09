package com.credillants.credillants.Service.Imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credillants.Dto.ResponseDto;
import com.credillants.Dto.UsuariosDto;
import com.credillants.credillants.Entity.UsuarioRolEntity;
import com.credillants.credillants.Entity.UsuariosEntity;
import com.credillants.credillants.Repository.RolRepository;
import com.credillants.credillants.Repository.UsuariosRepository;
import com.credillants.credillants.Service.UsuariosService;
import com.credillants.credillants.Util.Constante;
import com.credillants.credillants.Util.Util;

@Service
public class UsuariosServiceImp implements UsuariosService {

	@Autowired
	private UsuariosRepository userRep;

	@Autowired
	private RolRepository rolRep;

	@Override
	public ResponseDto obtenerUsuariosAll() {
		try {
			List<UsuariosEntity> listUsuariosEntity = userRep.findAll();
			if (listUsuariosEntity.isEmpty()) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			List<UsuariosDto> list = new ArrayList<UsuariosDto>();
			for (UsuariosEntity usuariosEntity : listUsuariosEntity) {
				list.add(UsuariosDto.builder().idUsuario(usuariosEntity.getIdUsuario())
						.username(usuariosEntity.getUsername()).nombreUsuario(usuariosEntity.getNombreUsuario())
						.edadUsuario(usuariosEntity.getEdadUsuario()).correoUsuario(usuariosEntity.getCorreoUsuario())
						.telefonoUsuario(usuariosEntity.getTelefonoUsuario()).build());
			}
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
		} catch (Exception e) {
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public UsuariosEntity crearUsuario(UsuariosEntity usuariosJson, Set<UsuarioRolEntity> usuarioRolController)
			throws Exception {
		UsuariosEntity userLocal = userRep.findByUsername(usuariosJson.getUsername());
		if (userLocal != null) {
			System.out.println("Usuario ya existe");
		} else {
			for (UsuarioRolEntity usuarioRolEntity : usuarioRolController) {
				rolRep.save(usuarioRolEntity.getRolusuario());
			}
			usuariosJson.getUsuariorolentity().addAll(usuarioRolController);
			userLocal = userRep.save(usuariosJson);
		}
		return userLocal;
	}
}
