/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author pc
 */
public class nodoLD {

    private int dato;
    private nodoLD refDer, refIzq;
    private String color;
    private String objeto;

    public nodoLD(int dato, String obj) {
        this.dato = dato;
        this.color = "";
        this.objeto = obj;
        this.refDer = null;
        this.refIzq = null;
    }

    public String getObjeto() {
        return this.objeto;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDato() {
        return dato;
    }
    public nodoLD(int dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodoLD getRefDer() {
        return refDer;
    }

    public void setRefDer(nodoLD refDer) {
        this.refDer = refDer;
    }

    public nodoLD getRefIzq() {
        return refIzq;
    }

    public void setRefIzq(nodoLD refIzq) {
        this.refIzq = refIzq;
    }

}
