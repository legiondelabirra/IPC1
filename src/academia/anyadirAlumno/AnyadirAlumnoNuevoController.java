/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.anyadirAlumno;

import academia.alumnos.VentanaAlumnoController;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import modelo.Alumno;
import utils.Database;

/**
 * FXML Controller class
 *
 * @author Pau Castelló
 */
public class AnyadirAlumnoNuevoController implements Initializable {

    @FXML
    private DatePicker fechaAltaNuevo;
    @FXML
    private TextField dniNuevo;
    @FXML
    private TextField nombreNuevo;
    @FXML
    private TextField edadnuevo;
    @FXML
    private TextField direccionNuevo;
    @FXML
    private Button anyadirFotoNuevo;
    @FXML
    private ImageView foto;

    private VentanaAlumnoController ventanaAlumno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void init(VentanaAlumnoController ventanaAlumno) {
        this.ventanaAlumno = ventanaAlumno;
    }

    @FXML
    private void aceptar(ActionEvent event) {
        if(fechaAltaNuevo.getValue() == null || dniNuevo.getText() == null || nombreNuevo.getText() == null 
                    || edadnuevo.getText() == null || direccionNuevo.getText() == null || foto.getImage() == null){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Es necesario que todos los campos esten rellenados correctamente", ButtonType.OK);
            a.show();
            
        }else {
        LocalDate s = fechaAltaNuevo.getValue();

        Alumno alumno = new Alumno(dniNuevo.getText(), nombreNuevo.getText(), Integer.parseInt(edadnuevo.getText()), direccionNuevo.getText(),
                s, foto.getImage());

        Database.getInstance().addAlumno(alumno);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Alumno añadido correctamente", ButtonType.OK);
        a.show();
        closeWindow();
        ventanaAlumno.refresh();
        }
    }

    @FXML
    private void anyadirFoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            foto.setImage(image);
        } catch (IOException ex) {
            // Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void closeWindow(){
        Node a = nombreNuevo.getParent();
        a.getScene().getWindow().hide();
    }

    @FXML
    private void onEdad(KeyEvent event) {
        if(!"0123456789".contains(event.getCharacter())){
            event.consume();
        }
    }

}
