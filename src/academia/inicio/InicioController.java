/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.inicio;

import accesoaBD.AccesoaBD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import modelo.Curso;
import utils.WindowManager;

/**
 *
 * @author Pau Castelló
 */
public class InicioController implements Initializable {
    
  
    @FXML
    private Button alumno;
    @FXML
    private Button curso;
    @FXML
    private Button matricula;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AccesoaBD datos = new AccesoaBD();
        //ObservableList<Curso> miscursos;
      //  miscursos = FXCollections.observableList(datos.getCursos());
        //System.out.println(miscursos.toString());
      //  alumno.onMouseClickedProperty().

        
    }    
    

    @FXML
    private void onAlumnoClicked(ActionEvent event) {
        WindowManager.createAlumnoWindow();
    }

    @FXML
    private void onCursoClicked(ActionEvent event) {
        WindowManager.createCursosWindow();
    }

    @FXML
    private void onMatriculaClicked(ActionEvent event) {
        WindowManager.createMatriculaWindow();
    }
}