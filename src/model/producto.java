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
    
    String idProducto;
    String nomProducto;
    String FechaLote;
    String FechaVence;
    float precioU;
    
    public producto() {
        idProducto = "";
        nomProducto = "";
        FechaLote = "";
        FechaVence = "";
        precioU = -1;
    }
    
    public producto(String idProducto, String nomProducto, String FechaLote, String FechaVence, float precioU){
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.FechaLote = FechaLote;
        this.FechaVence = FechaVence;
        this.precioU = precioU;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getFechaLote() {
        return FechaLote;
    }

    public void setFechaLote(String FechaLote) {
        this.FechaLote = FechaLote;
    }

    public String getFechaVence() {
        return FechaVence;
    }

    public void setFechaVence(String FechaVence) {
        this.FechaVence = FechaVence;
    }

    public float getPrecioU() {
        return precioU;
    }

    public void setPrecioU(float precioU) {
        this.precioU = precioU;
    }
    
}
