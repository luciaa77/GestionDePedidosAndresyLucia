package com.my_shop.myShop;

import jakarta.persistence.*;

@Entity
@Table(name = "info_fiscal")
public class InfoFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nifCif;
    private String calle;
    private String ciudad;
    private String cp;
    private String telefono;

    @OneToOne
    @JoinColumn(name = "persona_id", unique = true)
    private Persona persona;

    // GETTERS & SETTERS
    public Long getId() { return id; }

    public String getNifCif() { return nifCif; }
    public void setNifCif(String nifCif) { this.nifCif = nifCif; }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getCp() { return cp; }
    public void setCp(String cp) { this.cp = cp; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }
}
