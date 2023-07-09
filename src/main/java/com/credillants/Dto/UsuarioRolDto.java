package com.credillants.Dto;

import com.credillants.credillants.Entity.RolEntity;
import com.credillants.credillants.Entity.UsuariosEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRolDto {
	private Integer idusuariorol;
	private UsuariosEntity usuariorol;
	private RolEntity rolusuario;
}
