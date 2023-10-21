/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class objSTACK {
    private Stack<producto> pila;
    
    public objSTACK() {
        this.pila = new Stack<>();
    }
    
    public void setPushProducto (producto p){
        if(getInfoProductoId(p.idProducto) != null){
            JOptionPane.showMessageDialog(null, "El ID del producto ya se encuentra registrado");
        }else if(getInfoProductoNom(p.nomProducto) != null){
            JOptionPane.showMessageDialog(null, "El Nombre del producto ya se encuentra registrado");
        }else{
            pila.push(p);
            controller.PaginaprincipalController.Productos.add(p);
            JOptionPane.showMessageDialog(null, "Producto registrado exitosamente!");
        }
        
    }
    public void setRemoveProducto(){
        pila.remove(0);
        controller.PaginaprincipalController.Productos.remove(0);
        JOptionPane.showMessageDialog(null, "Un producto a expirado!");
    }
    
    public producto getInfoProductoId (String id){
        producto aux = new producto();
        int i = 0;
        while(i<pila.size()){
            aux = (producto) pila.get(i);
            if(aux.idProducto.equals(id))
                return aux;
            i++;
        }
        aux = null;
        return aux;
    }
    public producto getInfoProductoNom (String Nom){
        producto aux = new producto();
        int i = 0;
        while(i<pila.size()){
            aux = (producto) pila.get(i);
            if(aux.nomProducto.equals(Nom))
                return aux;
            i++;
        }
        aux = null;
        return aux;
    }
    public producto getInfoProductoFechaL (String FechaL){
        producto aux = new producto();
        int i = 0;
        while(i<pila.size()){
            aux = (producto) pila.get(i);
            if(aux.FechaLote.equals(FechaL))
                return aux;
            i++;
        }
        aux = null;
        return aux;
    }
    public producto getInfoProductoFechaV (String FechaV){
        producto aux = new producto();
        int i = 0;
        while(i<pila.size()){
            aux = (producto) pila.get(i);
            if(aux.FechaVence.equals(FechaV))
                return aux;
            i++;
        }
        aux = null;
        return aux;
    }
    public producto getInfoProductoPrecio (float Precio){
        producto aux = new producto();
        int i = 0;
        while(i<pila.size()){
            aux = (producto) pila.get(i);
            if(aux.precioU == Precio)
                return aux;
            i++;
        }
        aux = null;
        return aux;
    }
    public float promPrecio(){
        float sum = 0;
        float prom = 0;
        for (producto lista : pila){
            sum = lista.getPrecioU() + sum;
        }
        prom = sum / pila.size();
        return prom;
    }
    public void getMenProm (){
        float prom = promPrecio();
        for (producto lista : pila){
            if(lista.precioU < prom){
                controller.busqueda.BuscarController.busqueda.add(lista);
            }
        }
    }
    public void getMayProm (){
        float prom = promPrecio();
        for (producto lista : pila){
            if(lista.precioU > prom){
                controller.busqueda.BuscarController.busqueda.add(lista);
            }
        }
    }
}
