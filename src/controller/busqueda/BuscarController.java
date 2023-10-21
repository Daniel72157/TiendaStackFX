/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.busqueda;

import static controller.PaginaprincipalController.pilaP;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import model.objSTACK;
import model.producto;

/**
 *
 * @author danie
 */
public class BuscarController implements Initializable {
    
    public static objSTACK pilaB = new objSTACK();
    
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
    
    public static ObservableList<producto> busqueda = FXCollections.observableArrayList();
    
    @FXML
    private Button btnBack;
    
    @FXML
    private void actionEvent(ActionEvent e){
        Object evt = e.getSource();
        if(evt.equals(btnBack)){
            busqueda.removeAll(busqueda);
            objSTACK.aux = null;
            loadStage("/visualizer/Paginaprincipal.fxml", e);
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller.registro.RegistrarprodController.pila = pilaP;
        idProducto.setCellValueFactory(new PropertyValueFactory<producto, String>("idProducto"));
        nomProducto.setCellValueFactory(new PropertyValueFactory<producto, String>("nomProducto"));
        FechaLote.setCellValueFactory(new PropertyValueFactory<producto, String>("FechaLote"));
        FechaVence.setCellValueFactory(new PropertyValueFactory<producto, String>("FechaVence"));
        precioU.setCellValueFactory(new PropertyValueFactory<producto, Float>("precioU"));
        tbList.setItems(busqueda);
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
            Logger.getLogger(BuscarController.class.getName()).log(Level.SEVERE,null, ex);
        }
        
    }
    
}
