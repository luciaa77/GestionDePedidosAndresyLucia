package com.my_shop.myShop;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private LocalDate fechaRegistro;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private InfoFiscal infoFiscal;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Compra> compras = new ArrayList<>();

    // GETTERS & SETTERS

    public Integer getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public InfoFiscal getInfoFiscal() { return infoFiscal; }
    public void setInfoFiscal(InfoFiscal infoFiscal) {
        this.infoFiscal = infoFiscal;
        infoFiscal.setPersona(this);
    }

    public List<Compra> getCompras() { return compras; }
}
