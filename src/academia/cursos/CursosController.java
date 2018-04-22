/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.cursos;

import accesoaBD.AccesoaBD;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import modelo.Alumno;
import modelo.Curso;
import utils.Database;
import utils.WindowManager;

/**
 * FXML Controller class
 *
 * @author Pau Castelló
 */
public class CursosController implements Initializable {

    @FXML
    private TableColumn<Curso, String> titulo;
    @FXML
    private TableColumn<Curso, String> profesor;
    @FXML
    private TableColumn<Curso, String> maximo;
    @FXML
    private TableColumn<Curso, String> aula;
    @FXML
    private TableColumn<Curso, LocalDate> inicio;
    @FXML
    private TableColumn<Curso, LocalDate> fin;
    //@FXML
    //private TableView ArrayList<Dias> listaCursos;
    //@FXML
    //private TableView<Dias> listaCursos;
    @FXML
    private TableView<Curso> listaCursos;
    @FXML
    private Button borrar;
    @FXML
    private Button anyadir;
    ObservableList<Curso> cursosObservable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }
    
    public void refresh(){
        cursosObservable = FXCollections.observableList(Database.getInstance().getAllCursos());
        // si está vinculado con un TableView
        //titulo.setCellValueFactory(acceso.getCursos().add(e));
        titulo.setCellValueFactory(
                new PropertyValueFactory<>("titulodelcurso"));
        profesor.setCellValueFactory(
                new PropertyValueFactory<>("profesorAsignado"));

        maximo.setCellValueFactory(
                new PropertyValueFactory<>("numeroMaximodeAlumnos"));
        aula.setCellValueFactory(
                new PropertyValueFactory<>("aula"));
        inicio.setCellValueFactory(
                new PropertyValueFactory<>("fechainicio"));
        fin.setCellValueFactory(
                new PropertyValueFactory<>("fechafin"));

        String s = cursosObservable.isEmpty() + "";
        
        listaCursos.setItems(cursosObservable);
    }

    @FXML
    private void anyadirCurso(ActionEvent event) {
        WindowManager.createNuevoCursoController(this);
    }

    @FXML
    private void borrarCurso(ActionEvent event) {
        Curso c1 = listaCursos.getSelectionModel().getSelectedItem();
        if (!Database.getInstance().cursoHasMatricula(c1)) {
            Database.getInstance().removeCurso(c1);
            refresh();
             Alert a = new Alert(Alert.AlertType.INFORMATION, "Curso Borrado Correctamente", ButtonType.OK);
            a.show();
        }else{
             Alert a = new Alert(Alert.AlertType.INFORMATION, "Curso Con Alumnos Matriculados", ButtonType.OK);
            a.show();
            // alert
        }
    }
   
}
