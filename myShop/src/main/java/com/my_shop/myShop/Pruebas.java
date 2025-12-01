package com.my_shop.myShop;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pruebas {
	/**
	 * @author Andrés Muñoz y Lucia Cuadrado
	 * @version 1.0 
	 * @since
	 * Clase main en la cual añadimos el contenido a nuestra base de datos
	 */

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_eshop");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // LIMPIAR TABLAS (para poder ejecutar muchas veces sin errores de PK duplicada)
        em.createQuery("DELETE FROM LineaCompra").executeUpdate();
        em.createQuery("DELETE FROM Compra").executeUpdate();
        em.createQuery("DELETE FROM InfoFiscal").executeUpdate();
        em.createQuery("DELETE FROM Persona").executeUpdate();
        em.createQuery("DELETE FROM Articulo").executeUpdate();

        // Crear persona
        Persona p = new Persona();
        p.setNifcif("12345678A");
        p.setNombre("Paco Gonzalez");
        p.setTelefono("600000000");
        p.setEmail("paco@gmail.com");
        p.setFechaRegistro(LocalDate.now());

        // Crear info fiscal
        InfoFiscal f = new InfoFiscal();
        f.setNifcif("12345678A");   // mismo NIFCIF que la persona
        f.setDni("12345678A");
        f.setDireccion("Calle laguna 13");
        f.setCiudad("Madrid");
        f.setProvincia("Madrid");
        f.setCp("28001");
        f.setPersona(p);

        p.setInfoFiscal(f);

        em.persist(p);  // con el cascade se guarda también InfoFiscal

        // Crear artículo
        Articulo a = new Articulo();
        a.setNombre("Teclado Mecánico");
        a.setPrecioBase(59.99);
        a.setDescripcion("Teclado RGB mecánico");
        em.persist(a);

        // Crear compra
        Compra c = new Compra();
        c.setFecha(LocalDateTime.now());
        c.setImporteTotal(59.99);
        c.setPersona(p);
        em.persist(c);

        // Crear línea
        LineaCompra l = new LineaCompra();
        l.setCompra(c);
        l.setArticulo(a);
        l.setUnidades(1);
        l.setPrecioUnitario(a.getPrecioBase());
        em.persist(l);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Datos insertados correctamente.");
    }
}
