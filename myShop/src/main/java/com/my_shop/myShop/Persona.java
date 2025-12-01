package com.my_shop.myShop;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "nifcif", length = 10)
    private String nifcif;

    @Column(nullable = false)
    private String nombre;

    private String telefono;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    // Relación 1:1 con info_fiscal
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private InfoFiscal infoFiscal;

    public Persona() {}

    // GETTERS Y SETTERS
    public String getNifcif() { return nifcif; }
    public void setNifcif(String nifcif) { this.nifcif = nifcif; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public InfoFiscal getInfoFiscal() { return infoFiscal; }
    public void setInfoFiscal(InfoFiscal infoFiscal) {
        this.infoFiscal = infoFiscal;
    }
}
