package com.credillants.Dto;

import java.util.HashSet;
import java.util.Set;

import com.credillants.credillants.Entity.UsuarioRolEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolDto {
	private Integer idRol;
	private String nombreRol;
	@Builder.Default
	private Set<UsuarioRolEntity> usuariorolentity = new HashSet<>();
}
