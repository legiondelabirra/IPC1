/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import accesoaBD.AccesoaBD;
import java.util.List;
import modelo.Alumno;

/**
 *
 * @author Pau Castelló
 */
public class Database {
    
    private static Database instance = new Database();
    
    private AccesoaBD acceso;
    
    private Database(){
        acceso = new AccesoaBD();
    }

    public static Database getInstance() {
        return instance;
    }
    
    public List<Alumno> getAllAlumnos(){
        return acceso.getAlumnos();
    }
    
}
