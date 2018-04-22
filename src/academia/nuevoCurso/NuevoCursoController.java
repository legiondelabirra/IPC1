/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.nuevoCurso;

import academia.cursos.CursosController;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
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
import javafx.scene.input.KeyEvent;
import modelo.Curso;
import modelo.Dias;
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
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void init(CursosController cursos) {
        this.cursosController = cursos;
    }

    @FXML
    private void altaCurso(ActionEvent event) {
        if (fechaFin.getValue() == null || fechaIni.getValue() == null || titulo.getText() == null || profesor.getText() == null
                || maxAlumnos.getText() == null || hora.getText() == null || aula.getText() == null || algunDiaSemana() == false) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Es necesario que todos los campos esten rellenados correctamente", ButtonType.OK);
            a.show();

        } else {

            LocalTime t = LocalTime.of(Integer.parseInt(hora.getText().split(":")[0]), Integer.parseInt(hora.getText().split(":")[1]));
            ArrayList<Dias> dias = new ArrayList();
            if (checkLunes.isSelected()) {
                dias.add(Dias.Lunes);
            }
            if (checkMartes.isSelected()) {
                dias.add(Dias.Martes);
            }
            if (checkMiercoles.isSelected()) {
                dias.add(Dias.Miercoles);
            }
            if (checkJueves.isSelected()) {
                dias.add(Dias.Jueves);
            }
            if (checkViernes.isSelected()) {
                dias.add(Dias.Viernes);
            }
            if (checkSabado.isSelected()) {
                dias.add(Dias.Sabado);
            }
            if (checkDomingo.isSelected()) {
                dias.add(Dias.Domingo);
            }
            if (fechaIni.getValue().compareTo(fechaFin.getValue()) > 0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "FECHA DE INICIO MAYOR QUE FECHA DE FIN", ButtonType.OK);
                a.show();
            } else {
                Curso c = new Curso(titulo.getText(), profesor.getText(), Integer.parseInt(maxAlumnos.getText()), fechaIni.getValue(), fechaFin.getValue(), t, dias, aula.getText());
                Database.getInstance().addCurso(c);
                cursosController.refresh();
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Curso añadido Correctamente", ButtonType.OK);
                a.show();
                closeWindow();
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }

    private void closeWindow() {
        Node a = hora.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void onEdad(KeyEvent event) {
        if (!"0123456789:".contains(event.getCharacter())) {
            event.consume();
        }
    }

    public boolean algunDiaSemana() {
        boolean res = false;
        if (checkLunes.isSelected()) {
            res = true;
        }
        if (checkMartes.isSelected()) {
            res = true;
        }
        if (checkMiercoles.isSelected()) {
            res = true;
        }
        if (checkJueves.isSelected()) {
            res = true;
        }
        if (checkViernes.isSelected()) {
            res = true;
        }
        if (checkSabado.isSelected()) {
            res = true;
        }
        if (checkDomingo.isSelected()) {
            res = true;
        }
        return res;
    }
}
