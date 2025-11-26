package com.my_shop.myShop;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetalleCompraId implements Serializable {

    private Integer compraId;
    private Integer articuloId;

    public DetalleCompraId() {}

    public DetalleCompraId(Integer compraId, Integer articuloId) {
        this.compraId = compraId;
        this.articuloId = articuloId;
    }

    public Integer getCompraId() { return compraId; }
    public void setCompraId(Integer compraId) { this.compraId = compraId; }

    public Integer getArticuloId() { return articuloId; }
    public void setArticuloId(Integer articuloId) { this.articuloId = articuloId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleCompraId)) return false;
        DetalleCompraId that = (DetalleCompraId) o;
        return Objects.equals(compraId, that.compraId) &&
               Objects.equals(articuloId, that.articuloId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compraId, articuloId);
    }
}
