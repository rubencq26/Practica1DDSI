/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Aplicacion;

import Modelo.Socio;
import org.hibernate.SessionFactory;
import config.HibernateUtil;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Ruben
 */
public class practica0 {

    /**
     * @param args the command line arguments
     */
    private static Session sesion;
    private static SessionFactory sesionFactory = conectarDB();

    public static void main(String[] args) {

        if (sesionFactory == null) {
            return;
        }
        listarNombreTelefonoSocios();

    }

    public static SessionFactory conectarDB() {
        try {
// Se obtiene la SessionFactory definida en HibernateUtil
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            System.out.println("Conexion Correcta con Hibernate");
            return sessionFactory;
        } catch (ExceptionInInitializerError e) {
            Throwable cause = e.getCause();
            System.out.println("Error en la conexion. Revise el fichero .cfg.xml: " + cause.getMessage());
            return null;
        }

    }

    public static void listarSociosHQL() {
        sesion = sesionFactory.openSession();
        Transaction tr = null;
        try {
            tr = sesion.beginTransaction();
            Query consulta = sesion.createQuery("FROM Socio", Socio.class);
            List<Socio> socios = consulta.getResultList();
            System.out.println("Numero de Socio | DNI   | Nombre       | FNac   | Telefono  |  Correo      | FEntrada  |  Categoria    | Actividades ");
            for (Socio s : socios) {
                System.out.println(s.toString());

            }
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sesion != null && sesion.isOpen()) {
                sesion.close();
            }
        }

    }

    public static void listarSociosSQL() {
        try {
            sesion = sesionFactory.openSession();
            Transaction tr = null;
            try {
                tr = sesion.beginTransaction();
                Query consulta = sesion.createNativeQuery("SELECT * FROM SOCIO", Socio.class);
                List<Socio> socios = consulta.getResultList();
                System.out.println("Numero de Socio | DNI   | Nombre       | FNac   | Telefono  |  Correo      | FEntrada  |  Categoria    | Actividades ");
                for (Socio s : socios) {
                    System.out.println(s.toString());

                }

            } catch (Exception e) {
                tr.rollback();
                System.out.println("Error: " + e.getMessage());
            } finally {
                if (sesion != null && sesion.isOpen()) {
                    sesion.close();
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarSociosNamed() {
        try {
            sesion = sesionFactory.openSession();
            Transaction tr = null;
            try {
                tr = sesion.beginTransaction();
                Query consulta = sesion.createNamedQuery("Socio.findAll", Socio.class);
                List<Socio> socios = consulta.getResultList();
                System.out.println("Numero de Socio | DNI   | Nombre       | FNac   | Telefono  |  Correo      | FEntrada  |  Categoria    | Actividades ");
                for (Socio s : socios) {
                    System.out.println(s.toString());

                }

            } catch (Exception e) {
                tr.rollback();
                System.out.println("Error: " + e.getMessage());
            } finally {
                if (sesion != null && sesion.isOpen()) {
                    sesion.close();
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarNombreTelefonoSocios() {
        try {
            sesion = sesionFactory.openSession();
            Transaction tr = null;
            try {
                tr = sesion.beginTransaction();
                Query consulta = sesion.createNativeQuery("SELECT s.nombre, s.telefono FROM SOCIO s", Object[].class);
                List<Object[]> socios = consulta.getResultList();
                System.out.println("Nombre  | Telefono ");
                for (Object[] s : socios) {
                    System.out.println(s[0] + " | " + s[1]);
                }

            } catch (Exception e) {
                tr.rollback();
                System.out.println("Error: " + e.getMessage());
            } finally {
                if (sesion != null && sesion.isOpen()) {
                    sesion.close();
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
