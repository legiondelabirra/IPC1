/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import academia.InicioController;
import academia.VentanaAlumnoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

/**
 *
 * @author Pau Castelló
 */
public class WindowManager {
    
    public static InicioController createMainMenu(){
        InicioController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/academia/Inicio.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<InicioController>getController();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Menu Principal");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static VentanaAlumnoController createAlumnoWindow(){
        VentanaAlumnoController con = null;
        try {
            FXMLLoader myLoader = new FXMLLoader(Object.class.getResource("/academia/VentanaAlumno.fxml"));
            Parent root = (Parent) myLoader.load();
            con = myLoader.<VentanaAlumnoController>getController();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Ventana Alumno");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
