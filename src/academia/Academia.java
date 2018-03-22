/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import accesoaBD.AccesoaBD;
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Alumno;
import utils.Database;
import utils.WindowManager;

/**
 *
 * @author Pau Castelló
 */
public class Academia extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //WindowManager.createAlumnoWindow();
        for (Alumno a : Database.getInstance().getAllAlumnos()) {
            System.out.println(a.getDni());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
