package com.credillants.Dto;

import java.util.HashSet;
import java.util.Set;

import com.credillants.credillants.Entity.UsuarioRolEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDto {
	private Integer idUsuario;
	private String nombreUsuario;
	private String username;
	private String password;
	private Integer edadUsuario;
	private String correoUsuario;
	private Integer telefonoUsuario;
	@JsonIgnore
	@Builder.Default
	private Set<UsuarioRolEntity> usuariorolentity = new HashSet<>();

}
