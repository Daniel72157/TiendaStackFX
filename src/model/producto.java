/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author danie
 */
public class producto {
    
    String idProducto, nomProducto, FechaLote, FechaVence;
    float precioU;

    public producto() {
        idProducto=nomProducto=FechaLote=FechaVence="";
        precioU=-1;
    }
    
    public producto(String idProducto, String nomProducto, String FechaLote, String FechaVence, float precioU){
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.FechaLote = FechaLote;
        this.FechaVence = FechaVence;
        this.precioU = precioU;
        
    }
    
}
