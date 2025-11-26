package com.my_shop.myShop;

import jakarta.persistence.*;

@Entity
@Table(name = "info_fiscal")
public class InfoFiscal {

    @Id
    @Column(name = "persona_id")
    private Integer id;

    private String nifCif;
    private String calle;
    private String ciudad;
    private String codigoPostal;
    private String telefono;

    @OneToOne
    @MapsId
    @JoinColumn(name = "persona_id")
    private Persona persona;

    // GETTERS & SETTERS

    public Integer getId() { return id; }

    public String getNifCif() { return nifCif; }
    public void setNifCif(String nifCif) { this.nifCif = nifCif; }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }
}
