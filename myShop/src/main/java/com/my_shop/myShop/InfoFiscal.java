package com.my_shop.myShop;

import jakarta.persistence.*;

@Entity
@Table(name = "info_fiscal")
public class InfoFiscal {

    @Id
    @Column(name = "nifcif", length = 10)
    private String nifcif;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String direccion;

    private String ciudad;
    private String provincia;
    private String cp;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nifcif")
    private Persona persona;

    public InfoFiscal() {}

    // GETTERS Y SETTERS
    public String getNifcif() { return nifcif; }
    public void setNifcif(String nifcif) { this.nifcif = nifcif; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getCp() { return cp; }
    public void setCp(String cp) { this.cp = cp; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }
}
