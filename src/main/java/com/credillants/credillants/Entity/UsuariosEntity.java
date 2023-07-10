package com.credillants.credillants.Entity;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosEntity implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nombreUsuario;
	private String username;
	@Column(name = "passworduser")
	private String password;
	private Integer edadUsuario;
	private String correoUsuario;
	private Integer telefonoUsuario;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuariorol")
	@JsonIgnore
	@Builder.Default
	private Set<UsuarioRolEntity> usuariorolentity = new HashSet<>();
	
	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autorizacion = new HashSet<>();
        this.usuariorolentity.forEach(usuarioRolEntity -> {
            autorizacion.add(new Authority(usuarioRolEntity.getRolusuario().getNombreRol()));
        });
        return autorizacion;
    }

}
