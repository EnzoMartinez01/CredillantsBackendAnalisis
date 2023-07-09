package com.credillants.credillants.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credillants.credillants.Entity.RolEntity;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer>{

}
