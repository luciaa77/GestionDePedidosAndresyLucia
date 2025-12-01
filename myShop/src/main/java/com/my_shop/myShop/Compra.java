package com.my_shop.myShop;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime fecha;

    @Column(name = "importe_total", nullable = false)
    private double importeTotal;

    // N:1 con Persona
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escritor")
    private Persona persona;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LineaCompra> lineas = new ArrayList<>();

    public Compra() {}

    public int getId() { return id; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public double getImporteTotal() { return importeTotal; }
    public void setImporteTotal(double importeTotal) { this.importeTotal = importeTotal; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public List<LineaCompra> getLineas() { return lineas; }
    public void setLineas(List<LineaCompra> lineas) { this.lineas = lineas; }
}
