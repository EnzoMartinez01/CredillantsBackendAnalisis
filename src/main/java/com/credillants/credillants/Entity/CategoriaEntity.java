package com.credillants.credillants.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	private String nombreCategoria;
	//@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	//@JsonIgnore
	//@Builder.Default
	//private Set<ProductosEntity> productos = new LinkedHashSet<>();
}
