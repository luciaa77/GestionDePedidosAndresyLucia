package com.my_shop.myShop;

import jakarta.persistence.*;
import java.time.LocalDate;

public class Pruebas {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_eshopPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            // ===============================
            // 1. CREAR PERSONA
            // ===============================
            Persona p = new Persona();
            p.setNombre("Alejandro Fernández");
            p.setEmail("alejandro@example.com");
            p.setFechaRegistro(LocalDate.now());

            InfoFiscal info = new InfoFiscal();
            info.setNifCif("12345678A");
            info.setCalle("Calle Madrid 21");
            info.setCiudad("Madrid");
            info.setCodigoPostal("28001");
            info.setTelefono("666123123");

            // relación persona <-> info
            info.setPersona(p);
            p.setInfoFiscal(info);

            em.persist(p);


            // ===============================
            // 2. CREAR ARTÍCULOS
            // ===============================
            Articulo a1 = new Articulo();
            a1.setNombre("Teclado Mecánico K1");
            a1.setDescripcion("Teclado mecánico RGB");
            a1.setPrecio(89.99);
            a1.setStock(100);

            Articulo a2 = new Articulo();
            a2.setNombre("Ratón Gaming Ultra");
            a2.setDescripcion("Ratón 16000 DPI");
            a2.setPrecio(49.99);
            a2.setStock(200);

            em.persist(a1);
            em.persist(a2);


            // ===============================
            // 3. CREAR COMPRA
            // ===============================
            Compra compra = new Compra();
            compra.setFecha(LocalDate.now());
            compra.setDireccionEnvio("Avenida Europa 5, Madrid");
            compra.setEstado(EstadoCompra.PENDIENTE);
            compra.setPersona(p);

            em.persist(compra);

            // aseguramos que los IDs estén generados
            em.flush();


            // ===============================
            // 4. CREAR DETALLES
            // ===============================

            // detalle 1
            DetalleCompraId id1 = new DetalleCompraId(compra.getId(), a1.getId());

            DetalleCompra d1 = new DetalleCompra();
            d1.setId(id1);
            d1.setCompra(compra);
            d1.setArticulo(a1);
            d1.setUnidades(2);
            d1.setPrecioUnitario(89.99);

            // detalle 2
            DetalleCompraId id2 = new DetalleCompraId(compra.getId(), a2.getId());

            DetalleCompra d2 = new DetalleCompra();
            d2.setId(id2);
            d2.setCompra(compra);
            d2.setArticulo(a2);
            d2.setUnidades(1);
            d2.setPrecioUnitario(49.99);

            em.persist(d1);
            em.persist(d2);


            em.getTransaction().commit();

            System.out.println("=== DATOS INSERTADOS CORRECTAMENTE ===");


        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
            emf.close();
        }
    }
}
