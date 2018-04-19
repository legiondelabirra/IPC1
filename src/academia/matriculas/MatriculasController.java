/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.matriculas;

import accesoaBD.AccesoaBD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Alumno;
import modelo.Curso;
import modelo.Matricula;

/**
 * FXML Controller class
 *
 * @author yo
 */
public class MatriculasController implements Initializable {
    private ObservableList<Alumno> alumnosObservable;
    private ObservableList<Curso> cursosObservable;
    private AccesoaBD acceso;
    private ObservableList<Matricula> matriculasObservable;
    @FXML
    private TableView<Alumno> tablaAlumnos;
    @FXML
    private TableColumn<Alumno, String> dniMatricula;
    @FXML
    private TableColumn<Alumno, String> nombreMatricula;
    @FXML
    private TableView<Curso> tablaCursos;
    @FXML
    private TableColumn<Curso, String> tituloMatricula;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          acceso = new AccesoaBD();
          cursosObservable = FXCollections.observableList(acceso.getCursos());
          alumnosObservable = FXCollections.observableList(acceso.getAlumnos());
           dniMatricula.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("dni"));
           nombreMatricula.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("nombre"));
           tablaAlumnos.setItems(alumnosObservable);
           tituloMatricula.setCellValueFactory(
                new PropertyValueFactory<Curso, String>("titulodelcurso"));
           tablaCursos.setItems(cursosObservable);
        // TODO
    }    

    @FXML
    private void borrarMatricula(ActionEvent event) {
    }

    @FXML
    private void matricular(ActionEvent event) {
    }
    
}