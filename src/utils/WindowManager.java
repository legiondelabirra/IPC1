/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import academia.inicio.InicioController;
import academia.alumnos.VentanaAlumnoController;
import academia.cursos.CursosController;
import academia.matriculas.MatriculasController;
import academia.nuevoCurso.NuevoCursoController;
import academia.anyadirAlumno.AnyadirAlumnoNuevoController;
import academia.listarAlumnoCurso.ListaAlumnoCursoController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;
import modelo.Curso;

/**
 *
 * @author Pau Castelló
 */
public class WindowManager {

    public static InicioController createMainMenu() {
        InicioController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/academia/inicio/Inicio.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<InicioController>getController();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Menu Principal");
            stage.setOnCloseRequest((WindowEvent event) -> {
                new Thread(() -> Database.getInstance().salvar()).start();
            });
            stage.setScene(scene);
            //stage.setMaxHeight(600);
            //stage.setMaxWidth(600);
            stage.setMinHeight(600);
            stage.setMinWidth(400);
            
            stage.widthProperty().addListener((obs, oldVal, newVal) -> {
                System.out.println("Width: " + newVal);
                System.out.println("Height: " + stage.getHeight());
                System.out.println("------------------------------");
            });
            stage.heightProperty().addListener((obs, oldVal, newVal) -> {
                System.out.println("Width: " + stage.getWidth());
                System.out.println("Height: " + newVal);
                System.out.println("------------------------------");
            });
            
            //stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static VentanaAlumnoController createAlumnoWindow() {
        VentanaAlumnoController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/academia/alumnos/VentanaAlumno.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<VentanaAlumnoController>getController();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Ventana Alumno");
            stage.setScene(scene);
            stage.setMinHeight(600);
            stage.setMinWidth(400);
            // stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static CursosController createCursosWindow() {
        CursosController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/academia/cursos/cursos.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<CursosController>getController();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Ventana Cursos");
            stage.setScene(scene);
            stage.setMinHeight(600);
            stage.setMinWidth(400);
            // stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static MatriculasController createMatriculaWindow() {
        MatriculasController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/academia/matriculas/matriculas.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<MatriculasController>getController();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Ventana Matriculas");
            stage.setScene(scene);
            stage.setMinHeight(600);
            stage.setMinWidth(400);
            // stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static NuevoCursoController createNuevoCursoController(CursosController cursos) {
        NuevoCursoController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/academia/nuevoCurso/nuevoCurso.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<NuevoCursoController>getController();
            con.init(cursos);
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Nuevo Curso");
            stage.setScene(scene);
            stage.setMinHeight(600);
            stage.setMinWidth(400);
            //stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static AnyadirAlumnoNuevoController createAlumnoNuevoWindow(VentanaAlumnoController ventanaAlumno) {
        AnyadirAlumnoNuevoController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/academia/anyadirAlumno/anyadirAlumnoNuevo.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<AnyadirAlumnoNuevoController>getController();
            con.init(ventanaAlumno);
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Ventana Alumno Nuevo");
            stage.setScene(scene);
            stage.setMinHeight(600);
            stage.setMinWidth(400);
            // stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
     public static ListaAlumnoCursoController createListaAlumnoCursoWindow(Curso c) {
        ListaAlumnoCursoController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/academia/listarAlumnoCurso/listaAlumnoCurso.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<ListaAlumnoCursoController>getController();
            con.init(c);
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Ventana Lista Alumnos By Curso");
            stage.setScene(scene);
            stage.setMinHeight(601);
            stage.setMinWidth(608);
            // stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
