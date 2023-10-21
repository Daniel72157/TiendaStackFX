/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.registro.RegistrarprodController;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import model.producto;
import model.objSTACK;

/**
 *
 * @author danie
 */
public class PaginaprincipalController implements Initializable {
    
    static public objSTACK pilaP = new objSTACK();
    RegistrarprodController registro = new RegistrarprodController();
    public int dia, mes, año;
    public static String fecha;
     
    @FXML
    private TableView<producto> tbList;
    
    @FXML
    private TableColumn<producto, String> idProducto;
    
    @FXML
    private TableColumn<producto, String> nomProducto;
    
    @FXML
    private TableColumn<producto, String> FechaLote;
    
    @FXML
    private TableColumn<producto, String> FechaVence;
    
    @FXML
    private TableColumn<producto, Float> precioU;
    
    public static ObservableList<producto> Productos = FXCollections.observableArrayList();
    
    @FXML
    private Button btnRegistrar, btnClose, btnProm, btnMenProm, btnMayProm, btnModFecha
            , btnFecha10, btnMayPrecio, btnMenPrecio, btnId, btnNom, btnPrecio, btnFechaL, btnFechaV;   
    
   
    @FXML
    private void actionEvent (ActionEvent e){
        
        Object evt = e.getSource();
        
        if(evt.equals(btnRegistrar)){
            loadStage("/visualizer/Registrarprod.fxml", e);
        }
        if(evt.equals(btnClose)){
            System.exit(0);
        }
        if(evt.equals(btnProm)){
            JOptionPane.showMessageDialog(null, "El precio promedio de los productos es:\n"
                                                + pilaP.promPrecio());
        }
        if(evt.equals(btnMenProm)){
            pilaP.getMenProm();
            loadStage("/visualizer/Buscar.fxml", e);
        }
        if(evt.equals(btnMayProm)){
            pilaP.getMayProm();
            loadStage("/visualizer/Buscar.fxml", e);
        }
        if(evt.equals(btnMayPrecio)){
            pilaP.getMayPrecio();
            loadStage("/visualizer/Buscar.fxml", e);
        }
        if(evt.equals(btnMenPrecio)){
            pilaP.getMenPrecio();
            loadStage("/visualizer/Buscar.fxml", e);
        }
        if(evt.equals(btnId)){
            String id = JOptionPane.showInputDialog("Ingrese el ID del producto que desea buscar:");
            pilaP.listarID(id);
            if(objSTACK.aux != null){
                loadStage("/visualizer/Buscar.fxml", e);
            }
        }
        if(evt.equals(btnNom)){
            String Nom = JOptionPane.showInputDialog("Ingrese el nombre del producto que desea buscar:");
            pilaP.listarNom(Nom);
            if(objSTACK.aux != null){
                loadStage("/visualizer/Buscar.fxml", e);
            }
        }
        if(evt.equals(btnFechaL)){
            String FechaL = JOptionPane.showInputDialog("Ingrese la Fecha lote del producto que desea buscar:");
            pilaP.listarFechaL(FechaL);
            if(objSTACK.aux != null){
                loadStage("/visualizer/Buscar.fxml", e);
            }
        }
        if(evt.equals(btnFechaV)){
            String FechaV = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento del producto que desea buscar:");
            pilaP.listarFechaV(FechaV);
            if(objSTACK.aux != null){
                loadStage("/visualizer/Buscar.fxml", e);
            }
        }
        if(evt.equals(btnPrecio)){
            float Precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto que desea buscar:"));
            pilaP.listarPrecio(Precio);
            if(objSTACK.aux != null){
                loadStage("/visualizer/Buscar.fxml", e);
            }
        }
        if(evt.equals(btnModFecha)){
            registro.modFecha();
            dia = controller.registro.RegistrarprodController.dia;
            mes = controller.registro.RegistrarprodController.mes;
            año = controller.registro.RegistrarprodController.año;
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            JOptionPane.showMessageDialog(null, "Fecha actualizada:\n" +
                                        String.valueOf(dia) + "/" +  String.valueOf(mes+1) + "/" + String.valueOf(año));
            pilaP.setRemoveProducto();
        }
        if(evt.equals(btnFecha10)){
            registro.modFecha10();
            dia = controller.registro.RegistrarprodController.dia;
            mes = controller.registro.RegistrarprodController.mes;
            año = controller.registro.RegistrarprodController.año;
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            JOptionPane.showMessageDialog(null, "Fecha actualizada:\n" +
                                        String.valueOf(dia) + "/" +  String.valueOf(mes+1) + "/" + String.valueOf(año));
            pilaP.setRemoveProducto();
        }
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller.registro.RegistrarprodController.pila = pilaP;
        dia = controller.registro.RegistrarprodController.dia;
        mes = controller.registro.RegistrarprodController.mes;
        año = controller.registro.RegistrarprodController.año;
        fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
        idProducto.setCellValueFactory(new PropertyValueFactory<producto, String>("idProducto"));
        nomProducto.setCellValueFactory(new PropertyValueFactory<producto, String>("nomProducto"));
        FechaLote.setCellValueFactory(new PropertyValueFactory<producto, String>("FechaLote"));
        FechaVence.setCellValueFactory(new PropertyValueFactory<producto, String>("FechaVence"));
        precioU.setCellValueFactory(new PropertyValueFactory<producto, Float>("precioU"));
        tbList.setItems(Productos);
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
