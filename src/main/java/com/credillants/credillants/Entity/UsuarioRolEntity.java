package com.credillants.credillants.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Table(name = "userrol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRolEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuariorol;
	@ManyToOne(fetch = FetchType.EAGER)
	private UsuariosEntity usuariorol;
	@ManyToOne(fetch = FetchType.EAGER)
	private RolEntity rolusuario;
}
