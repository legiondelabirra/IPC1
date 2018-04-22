/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.listarAlumnoCurso;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Alumno;
import modelo.Curso;
import modelo.Matricula;
import utils.Database;

/**
 * FXML Controller class
 *
 * @author Pau Castelló
 */
public class ListaAlumnoCursoController implements Initializable {

    @FXML
    private TableView<Alumno> listaAlumnoCurso;

    private Curso curso;

    @FXML
    private TableColumn<Alumno, String> dni;
    @FXML
    private TableColumn<Alumno, String> nombre;
    @FXML
    private TableColumn<?, ?> foto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void init(Curso c) {
        this.curso = c;

        

        dni.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("dni"));
        nombre.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("nombre"));
        refresh();
    }
    
    public void refresh(){
        ObservableList xd = FXCollections.observableList(Database.getInstance().getAlumnosByCurso(curso));
        listaAlumnoCurso.setItems(xd);
    }

    @FXML
    private void desmatricular(ActionEvent event) {

        Alumno desmatricular = listaAlumnoCurso.getSelectionModel().getSelectedItem();
        Database.getInstance().desmatricular(curso, desmatricular);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "El Alumno Se Ha Desmatriculado", ButtonType.OK);
        a.show();
        refresh();
        /*
         if (!Database.getInstance().alumnoHasMatricula(hector)) {
            Database.getInstance().removeAlumno(hector);
            refresh();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Alumno Borrado Correctamente", ButtonType.OK);
            a.show();
        }else{
            Alert a = new Alert(Alert.AlertType.INFORMATION, "El Alumno Esta Matriculado De Algun Curso", ButtonType.OK);
            a.show();
         */

    }

}
