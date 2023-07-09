package com.credillants.credillants.Service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.credillants.Dto.ResponseDto;
import com.credillants.credillants.Entity.UsuarioRolEntity;
import com.credillants.credillants.Entity.UsuariosEntity;


@Service
public interface UsuariosService {
	public ResponseDto obtenerUsuariosAll();
	public UsuariosEntity crearUsuario(UsuariosEntity usuariosJson, Set<UsuarioRolEntity> usuarioRolController) throws Exception;
}
