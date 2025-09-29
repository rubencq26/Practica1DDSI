/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Aplicacion;

import org.hibernate.SessionFactory;
import config.HibernateUtil;

/**
 *
 * @author Ruben
 */
public class practica0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
// Se obtiene la SessionFactory definida en HibernateUtil
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            System.out.println("Conexión Correcta con Hibernate");
        } catch (ExceptionInInitializerError e) {
            Throwable cause = e.getCause();
            System.out.println("Error en la conexión. Revise el fichero .cfg.xml: " + cause.getMessage());
        }
    }

}
