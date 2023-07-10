package com.credillants.credillants.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "productoCategoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCategoriaEntity {
	@Id
	@Column(name="cod_producto")
	private Integer idProducto;
	@Column(name="cod_categoria")
	private Integer idCategoria;
}
