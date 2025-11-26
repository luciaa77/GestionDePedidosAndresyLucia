package com.my_shop.myShop;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoCompra estado;

    private String calleEnvio;
    private String ciudadEnvio;
    private String cpEnvio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaCompra> lineas = new ArrayList<>();

  
    public Long getId() { return id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public EstadoCompra getEstado() { return estado; }
    public void setEstado(EstadoCompra estado) { this.estado = estado; }

    public String getCalleEnvio() { return calleEnvio; }
    public void setCalleEnvio(String calleEnvio) { this.calleEnvio = calleEnvio; }

    public String getCiudadEnvio() { return ciudadEnvio; }
    public void setCiudadEnvio(String ciudadEnvio) { this.ciudadEnvio = ciudadEnvio; }

    public String getCpEnvio() { return cpEnvio; }
    public void setCpEnvio(String cpEnvio) { this.cpEnvio = cpEnvio; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public List<LineaCompra> getLineas() { return lineas; }
    public void setLineas(List<LineaCompra> lineas) { this.lineas = lineas; }
}
