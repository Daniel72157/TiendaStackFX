/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.registro;

import controller.PaginaprincipalController;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import model.objSTACK;
import model.producto;
/**
 *
 * @author danie
 */
public class RegistrarprodController implements Initializable {
    
    public static objSTACK pila = new objSTACK();
    static Calendar calendario = new GregorianCalendar();
    public static int dia = calendario.get(Calendar.DATE);
    public static int mes = calendario.get(Calendar.MONTH);
    public static int año = calendario.get(Calendar.YEAR);
    public static int diav, mesv;
    public String fecha;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private TextField txtLote, txtVence, txtId, txtNom, txtPrecio;
    
    @FXML
    private Button btnRegistrar;
    
    
    @FXML
    private void actionEvent (ActionEvent e){
  
        Object evt = e.getSource();
        
        if(evt.equals(btnRegistrar)){
            String id = txtId.getText();
            String nom = txtNom.getText();
            String FechaL = txtLote.getText();
            String FechaV = txtVence.getText();
            float precio = Float.parseFloat(txtPrecio.getText());
            producto prod = new producto(id, nom, FechaL, FechaV, precio);
            pila.setPushProducto(prod);
            loadStage("/visualizer/Paginaprincipal.fxml", e);
            
        }
        if(evt.equals(btnBack)){
            loadStage("/visualizer/Paginaprincipal.fxml", e);
        }
        
    }
    
    @FXML
    private void keyEvent (KeyEvent e){
        
        Object evt = e.getSource();
        
        if(evt.equals(txtId) || evt.equals(txtPrecio)){
            if (!Character.isDigit(e.getCharacter().charAt(0))){
                e.consume();
            }
        }else if (evt.equals(txtNom)){
            if (!Character.isLetter(e.getCharacter().charAt(0))){
                e.consume();
            }
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calendario.add(Calendar.DATE, 31);
        diav = calendario.get(Calendar.DATE);
        mesv = calendario.get(Calendar.MONTH);
        calendario.add(Calendar.DATE, -31);
        controller.PaginaprincipalController.pilaP = pila;
        
        txtLote.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
        txtVence.setText(String.valueOf(diav)+ "/" + String.valueOf(mesv+1)+ "/" + String.valueOf(año));
    }
    public void modFecha(){
        calendario.add(Calendar.DATE, 1);
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
    }
    public void modFecha10(){
        calendario.add(Calendar.DATE, 10);
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
    }
    public void modFecham1(){
        calendario.add(Calendar.DATE, -1);
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
    }
    public void modFecham10(){
        calendario.add(Calendar.DATE, -10);
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
    }
    private void loadStage(String url, Event event){
        
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            Window window = oldScene.getWindow();
            Stage stage = (Stage) window;
            stage.hide();
            
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            
            newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(PaginaprincipalController.class.getName()).log(Level.SEVERE,null, ex);
        }
        
    }
    
}
