/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import accesoaBD.AccesoaBD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Alumno;
import modelo.Curso;
import modelo.Dias;
import modelo.Matricula;

/**
 *
 * @author Pau Castelló
 */
public class Database {

    private static Database instance = new Database();

    private AccesoaBD acceso;

    List<Matricula> matriculas;
    List<Curso> cursos;
    List<Alumno> alumnos;

    private Database() {
        acceso = new AccesoaBD();
        matriculas = acceso.getMatriculas();
        cursos = acceso.getCursos();
        alumnos = acceso.getAlumnos();
    }

    public static Database getInstance() {
        return instance;
    }

    public List<Alumno> getAllAlumnos() {
        return alumnos;
    }
    public ArrayList getAlumnosByCurso(Curso c){
        if(c == null){
            System.out.println("es null");
            return new ArrayList();
        }
        ArrayList res = new ArrayList();
        for (Matricula mat : matriculas) {
            if (mat.getCurso().getTitulodelcurso().equals(c.getTitulodelcurso())){
                res.add(mat.getAlumno());
            }
        }
        return res;
    }
            
    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void salvar() {
        acceso.salvar();
    }

    public void removeAlumno(Alumno alumno) {
        alumnos.remove(alumno);
    }

    public void removeCurso(Curso curso) {
        cursos.remove(curso);
    }

    public boolean alumnoHasMatricula(Alumno alumno) {
        for (Matricula mat : matriculas) {
            if (mat.getAlumno().getDni().equals(alumno.getDni())) {
                return true;
            }
        }
        return false;
    }
   
    public boolean cursoHasMatricula(Curso curso) {
        for (Matricula mat : matriculas) {
            if (mat.getCurso().getTitulodelcurso().equals(curso.getTitulodelcurso())) {
                return true;
            }
        }
        return false;
    }

    public List<Curso> getAllCursos() {
        return cursos;
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
    }

    public MatriculaResult matricularAlumno(Curso c, Alumno al) {

        if (c.getNumeroMaximodeAlumnos() <= acceso.getMatriculasDeCurso(c).size()) {
            return MatriculaResult.MAX_ALUMNOS;
        }

        boolean matriculadoYa = false;
        List<Curso> cursos = new ArrayList();
        for (Matricula m : matriculas) {
            if (m.getAlumno().getDireccion().equals(al.getDni()) && m.getCurso().getTitulodelcurso().equals(c.getTitulodelcurso())) {
                matriculadoYa = true;
            }
            if (m.getAlumno().getDni().equals(al.getDni())) {
                cursos.add(m.getCurso());
            }

        }
        boolean horariosCoinciden = false;
        for (Curso c1 : cursos) {
            if (!c1.getHora().equals(c.getHora())) {
                for (Dias d : c1.getDiasimparte()) {
                    for (Dias d2 : c.getDiasimparte()) {
                        if (d.equals(d2)) {
                            horariosCoinciden = true;
                        }
                    }
                }
            }

        }

        if (matriculadoYa) {
            return MatriculaResult.YA_MATRICULADO;
        }
        if (horariosCoinciden) {
            return MatriculaResult.COINCIDEN_HORARIOS;
        }

        Matricula m = new Matricula(LocalDate.now(), c, al);
        matriculas.add(m);
        return MatriculaResult.CORRECTO;
    }

    public enum MatriculaResult {
        CORRECTO, MAX_ALUMNOS, YA_MATRICULADO, COINCIDEN_HORARIOS;
    }

    public void desmatricular(Curso c, Alumno a) {
        Matricula mat = null;
        for (Matricula m : matriculas) {
            if (m.getAlumno().getDni().equals(a.getDni()) && m.getCurso().getTitulodelcurso().equals(c.getTitulodelcurso())) {
                mat = m;
                break;
            }
        }
        
        matriculas.remove(mat);
    }
}
