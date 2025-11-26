package com.my_shop.myShop;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private double precioCatalogo;
    private int stock;

    @OneToMany(mappedBy = "articulo", fetch = FetchType.LAZY)
    private List<LineaCompra> lineas = new ArrayList<>();

    // GETTERS & SETTERS
    public Long getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecioCatalogo() { return precioCatalogo; }
    public void setPrecioCatalogo(double precioCatalogo) { this.precioCatalogo = precioCatalogo; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public List<LineaCompra> getLineas() { return lineas; }
    public void setLineas(List<LineaCompra> lineas) { this.lineas = lineas; }
}
