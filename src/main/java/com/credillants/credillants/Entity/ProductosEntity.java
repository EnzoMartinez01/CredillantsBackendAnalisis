package com.credillants.credillants.Entity;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String nombreProducto;
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoriaEntity categoria;
    private Integer cantidadProducto;
    private Date duracionProducto;
    private Double precioProducto;
    private Boolean estadoProducto;
}
