/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.alumnos;

import academia.Academia;
import accesoaBD.AccesoaBD;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Alumno;
import modelo.Matricula;
import utils.Database;
import utils.WindowManager;
import static utils.WindowManager.createAlumnoNuevoWindow;

/**
 * FXML Controller class
 *
 * @author Pau Castelló
 */
public class VentanaAlumnoController implements Initializable {

    @FXML
    private TableView<Alumno> listaAlumnos;
    @FXML
    private TableColumn<Alumno, String> dni;
    @FXML
    private TableColumn<Alumno, String> nombre;
    @FXML
    private TableColumn<Alumno, Integer> edad;
    @FXML
    private Button anyadirAlumno;
    @FXML
    private Button borrar;
    
    ObservableList<Alumno> alumnosObservable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
        
        // TODO
    }

    @FXML
    private void borrarAlumno(ActionEvent event) {
        Alumno hector = listaAlumnos.getSelectionModel().getSelectedItem();
        if (!Database.getInstance().alumnoHasMatricula(hector)) {
            Database.getInstance().removeAlumno(hector);
            refresh();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Alumno Borrado Correctamente", ButtonType.OK);
            a.show();
        }else{
            // alert
        }
        
    }

    public void refresh() {
        // acceder a la colección de alumnos para visualizarlos por ejemplo
        alumnosObservable = FXCollections.observableList(Database.getInstance().getAllAlumnos());
        // si está vinculado con un TableView
        dni.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("dni"));
        nombre.setCellValueFactory(
                new PropertyValueFactory<Alumno, String>("nombre"));

        edad.setCellValueFactory(
                new PropertyValueFactory<Alumno, Integer>("edad"));

        listaAlumnos.setItems(alumnosObservable);
    }

    @FXML
    private void anyadirAlumnoNuevo(ActionEvent event) {
        WindowManager.createAlumnoNuevoWindow(this);
    }

}
