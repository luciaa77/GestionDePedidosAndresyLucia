package com.my_shop.myShop;

import jakarta.persistence.*;

@Entity
@Table(name = "linea_compra")
public class DetalleCompra {

    @EmbeddedId
    private DetalleCompraId id;

    private Integer unidades;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("compraId")
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articuloId")
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

    // ===========================
    // GETTERS & SETTERS
    // ===========================

    public DetalleCompraId getId() {
        return id;
    }

    public void setId(DetalleCompraId id) {
        this.id = id;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
