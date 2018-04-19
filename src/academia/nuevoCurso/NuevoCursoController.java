/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.nuevoCurso;

import academia.alumnos.VentanaAlumnoController;
import academia.cursos.CursosController;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modelo.Curso;
import modelo.Dias;
import modelo.LocalTimeAdapter;
import utils.Database;

/**
 * FXML Controller class
 *
 * @author Pau Castelló
 */
public class NuevoCursoController implements Initializable {

    @FXML
    private Button alta;
    @FXML
    private Button cancelar;
    @FXML
    private TextField titulo;
    @FXML
    private TextField profesor;
    @FXML
    private TextField maxAlumnos;
    @FXML
    private DatePicker fechaIni;
    @FXML
    private DatePicker fechaFin;
    @FXML
    private TextField hora;
    @FXML
    private TextField aula;
    @FXML
    private CheckBox checkLunes;
    @FXML
    private CheckBox checkMartes;
    @FXML
    private CheckBox checkMiercoles;
    @FXML
    private CheckBox checkJueves;
    @FXML
    private CheckBox checkViernes;
    @FXML
    private CheckBox checkSabado;
    @FXML
    private CheckBox checkDomingo;
    
    private CursosController cursosController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void init(CursosController cursos){
        this.cursosController = cursos;
    }
    
    @FXML
    private void altaCurso(ActionEvent event){
        LocalTime t = LocalTime.of(Integer.parseInt(hora.getText().split(":")[0]), Integer.parseInt(hora.getText().split(":")[1]));
        ArrayList<Dias> dias = new ArrayList();
        if(checkLunes.isSelected()){
            dias.add(Dias.Lunes);
        }
        if(checkMartes.isSelected()){
            dias.add(Dias.Martes);
        }
        if(checkMiercoles.isSelected()){
            dias.add(Dias.Miercoles);
        }
        if(checkJueves.isSelected()){
            dias.add(Dias.Jueves);
        }
        if(checkViernes.isSelected()){
            dias.add(Dias.Viernes);
        }
        if(checkSabado.isSelected()){
            dias.add(Dias.Sabado);
        }
        if(checkDomingo.isSelected()){
            dias.add(Dias.Domingo);
        }
        Curso c = new Curso(titulo.getText(), profesor.getText(), Integer.parseInt(maxAlumnos.getText()), fechaIni.getValue(), fechaFin.getValue(), t, dias, aula.getText());
        Database.getInstance().addCurso(c);
        cursosController.refresh();
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Curso añadido Correctamente", ButtonType.OK);
            a.show();
        closeWindow();
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }
     private void closeWindow(){
        Node a = hora.getParent();
        a.getScene().getWindow().hide();
    }
}
