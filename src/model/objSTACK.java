/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.PaginaprincipalController;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class objSTACK {
    private Stack<producto> pila;
    public static producto aux = null;
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
    public void setRemoveProducto(){
        String fecha = PaginaprincipalController.fecha;
        producto eliminar = new producto();
        for (producto lista : pila){
            eliminar = getInfoProductoFechaV(fecha);
            while(eliminar != null){
                pila.remove(eliminar);
                controller.PaginaprincipalController.Productos.remove(eliminar);
                eliminar = getInfoProductoFechaV(fecha);
            }
        }
        
    }
    public void listarID(String id){
        for(producto lista : pila){
            if(lista.idProducto.equals(id)){
                controller.busqueda.BuscarController.busqueda.add(lista);
                aux = lista;
            }
        }
    }
    public void listarNom(String nom){
        for(producto lista : pila){
            if(lista.nomProducto.equals(nom)){
                controller.busqueda.BuscarController.busqueda.add(lista);
                aux = lista;
            }
        }
    }
    public void listarFechaL(String fechal){
        for(producto lista : pila){
            if(lista.FechaLote.equals(fechal)){
                controller.busqueda.BuscarController.busqueda.add(lista);
                aux = lista;
            }
        }
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
    public void listarFechaV(String fechav){
        for(producto lista : pila){
            if(lista.FechaVence.equals(fechav)){
                controller.busqueda.BuscarController.busqueda.add(lista);
                aux = lista;
            }
        }
    }
    public void listarPrecio(float precio){
        for(producto lista : pila){
            if(lista.precioU == (precio)){
                controller.busqueda.BuscarController.busqueda.add(lista);
                aux = lista;
            }
        }
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
    public void getMayPrecio(){
        producto mayor = getMay();
        for (producto lista : pila){
            if(lista.precioU > mayor.precioU){
                mayor = lista;
            }
        }
        for (producto lista2 : pila){
            if(lista2.precioU == mayor.precioU){
                controller.busqueda.BuscarController.busqueda.add(lista2);
            }
        }
    }
    public producto getMay(){
        producto mayor = new producto();
        float precio = 0;
        for (producto lista : pila){
            if(lista.precioU > precio){
                mayor = lista;
            }
        }
        return mayor;
    }
    public void getMenPrecio(){
        producto menor = getMay();
        for (producto lista : pila){
            if(lista.precioU < menor.precioU){
                menor = lista;
            }
        }
        for (producto lista2 : pila){
            if(lista2.precioU == menor.precioU){
                controller.busqueda.BuscarController.busqueda.add(lista2);
            }
        }
    }
}
