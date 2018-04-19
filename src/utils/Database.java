/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import accesoaBD.AccesoaBD;
import java.util.List;
import modelo.Alumno;
import modelo.Curso;
import modelo.Matricula;

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
    
    public void addAlumno(Alumno alumno){
        acceso.getAlumnos().add(alumno);
        acceso.salvar();
    }
    
    public void removeAlumno(Alumno alumno){
        acceso.getAlumnos().remove(alumno);
        acceso.salvar();
    }
    public void removeCurso (Curso curso){
        acceso.getCursos().remove(curso);
        acceso.salvar();
    }
    
    public boolean alumnoHasMatricula(Alumno alumno){
        for(Matricula mat : acceso.getMatriculas()){
            if(mat.getAlumno().equals(alumno)){
                return true;
            }
        }
        return false;
    }
     public boolean cursoHasMatricula(Curso curso){
        for(Matricula mat : acceso.getMatriculas()){
            if(mat.getCurso().equals(curso)){
                return true;
            }
        }
        return false;
    }
    
    public List<Curso> getAllCursos(){
        for(Curso s : acceso.getCursos())
            System.out.println(s);
        return acceso.getCursos();
    }
    
    public void addCurso(Curso curso){
        acceso.getCursos().add(curso);
        acceso.salvar();
    }
    
}
