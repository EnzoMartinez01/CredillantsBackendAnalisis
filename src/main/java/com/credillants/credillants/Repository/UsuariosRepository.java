package com.credillants.credillants.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credillants.credillants.Entity.UsuariosEntity;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer>{
	public UsuariosEntity findByUsername(String username);
}
