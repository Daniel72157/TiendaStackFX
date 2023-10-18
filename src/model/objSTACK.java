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
    Stack <producto> pilaP;
    Stack <producto> pilaInv;

    public objSTACK() {
        pilaP = new Stack();
    }
    
    public void setPushProducto(producto P){
        int id = pilaP.indexOf(P.idProducto);
        int nom = pilaP.indexOf(P.nomProducto);
        if(id == -1 && nom == -1){
            pilaP.push(P);
            JOptionPane.showMessageDialog(null,
                    "Producto registrado!");
        }else if(id != -1){
            JOptionPane.showMessageDialog(null,
                    "El ID del producto ya se encuentra registrado");
        }else if(nom != -1){
            JOptionPane.showMessageDialog(null,
                    "El nombre del producto ya se encuentra registrado");
        }
    }
    public void setPopProducto(){
        if(!pilaP.empty()){
            int ult = pilaP.size(), i = 0;
            while (i<pilaP.size()){
                pilaInv.push(pilaP.get(ult));
                pilaP.pop();
                ult = ult -1;
            }
            pilaInv.pop();
            int ultInv = pilaInv.size(), j = 0;
            while (j<pilaInv.size()){
                pilaP.push(pilaInv.get(ultInv));
                pilaInv.pop();
                ultInv = ultInv -1;
            }
            
        }else{
            JOptionPane.showMessageDialog(null,
                    "La pila no tiene elementos");
        }
    }
     
    producto getInfoProductoid (String id){
        producto aux = new producto();
        int i = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            if(aux.idProducto.equals(i))
                return aux;
            i++;
        }
        aux = null;
        return aux;
    }
    producto getInfoProductonom (String nom){
        producto aux = new producto();
        int i = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            if(aux.nomProducto.equals(i))
                return aux;
            i++;
        }
        aux = null;
        return aux;
    }
    objSTACK getInfoProductofechaL (String fechaL){
        producto aux = new producto();
        objSTACK caux = new objSTACK();
        int i = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            if(aux.FechaLote.equals(i)){
                caux.pilaP.add(aux);
            }
        }
        aux = null;
        return caux;
    }
    objSTACK getInfoProductofechaV (String fechaV){
        producto aux = new producto();
        objSTACK caux = new objSTACK();
        int i = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            if(aux.FechaVence.equals(i))
                caux.pilaP.add(aux);
            i++;
        }
        aux = null;
        return caux;
    }
    objSTACK getInfoProductoprecio (float precio){
        producto aux = new producto();
        objSTACK caux = new objSTACK();
        int i = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            if(aux.precioU == precio)
                caux.pilaP.add(aux);
            i++;
        }
        aux = null;
        return caux;
    }
    
    public float promPrecio(){
        producto aux = new producto();
        int i = 0;
        float sum = 0, prom = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            sum = aux.precioU + sum;
        }
        prom = sum / pilaP.size();
        return prom;
    }
    objSTACK getMenorProm (float prom){
        prom = promPrecio();
        producto aux = new producto();
        objSTACK caux = new objSTACK();
        int i = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            if(aux.precioU < prom){
                caux.pilaP.add(aux);
            }
        }
        aux = null;
        return caux;
    }
    objSTACK getMayorProm (float prom){
        prom = promPrecio();
        producto aux = new producto();
        objSTACK caux = new objSTACK();
        int i = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            if(aux.precioU > prom){
                caux.pilaP.add(aux);
            }
        }
        aux = null;
        return caux;
    }
    producto getMayorPrecio (producto Mprecio){
        Mprecio = new producto();
        producto aux = new producto();
        int i = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            if(aux.precioU > Mprecio.precioU){
                Mprecio = aux;
            }
        }
        aux = null;
        return Mprecio;
    }
    producto getMenorPrecio (producto mPrecio){
        mPrecio = new producto();
        producto aux = new producto();
        int i = 0;
        while(i<pilaP.size()){
            aux = (producto) pilaP.get(i);
            if(aux.precioU < mPrecio.precioU){
                mPrecio = aux;
            }
        }
        aux = null;
        return mPrecio;
    }
}
