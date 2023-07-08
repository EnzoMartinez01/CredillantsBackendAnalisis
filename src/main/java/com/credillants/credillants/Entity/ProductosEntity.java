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
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private Double precioProducto;
    private Boolean estadoProducto;
}
