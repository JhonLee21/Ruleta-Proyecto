/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilas;

import negocio.nodo;

/**
 *
 * @author pc
 */
public class Pila {
    private nodo cima;

    public Pila() {
        this.cima = null;
    }
    
    public void insertar(int cod, String detalle){
        nodo nAux = new nodo(cod,detalle);
        if(this.cima == null){
            this.cima = nAux;
        }else{
            nAux.setRefNodo(this.cima);
            this.cima = nAux;
        }
    }
    
    public String sacarDatos(){
        String ss = "Cod: "+this.cima.getCod()+", Detalle: "+this.cima.getDetalle();
        if(!estaVacia()){
            this.cima = this.cima.getRefNodo();
        }
        return ss;
    }
    
    public String Eliminar(){
        String dd = "Cod: "+this.cima.getCod()+", Detalle: "+this.cima.getDetalle();
        if(estaVacia()){
            this.cima = this.cima.getRefNodo();
        }
        return dd;
    }
    
    public boolean estaVacia(){
        if(this.cima == null){
            return true;
        }else{
            return false;
        }
    }
    
    public nodo getCima(){
        return this.cima;
    }
}
