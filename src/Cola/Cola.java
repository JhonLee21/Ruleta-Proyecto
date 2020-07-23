/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;
import negocio.nodo;
/**
 *
 * @author pc
 */
public class Cola {
    private nodo refPri, refUlt;
    public Cola(){
        this.refPri = null;
        this.refUlt = null;
    }

    public nodo getRefPri() {
        return refPri;
    }

    public void setRefPri(nodo refPri) {
        this.refPri = refPri;
    }
   
    public nodo getRefUlt() {
        return refUlt;
    }

    public void setRefUlt(nodo refUlt) {
        this.refUlt = refUlt;
    }
    
    public boolean estaVacia(){
        if(this.refPri == null ){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean estaVacia2(){
        return this.refPri == null ? true : false;
    }
    
    public void insertar(int dato, String detalle){
        nodo naux = new nodo(dato,detalle);
        if(estaVacia()){
            this.refPri = naux;
            this.refUlt = naux;
        }else{
            this.refUlt.setRefNodo(naux);
            this.refUlt = naux;
        }
    }
    
    public void eliminar(){
        if(!estaVacia()){
            this.refPri = this.refPri.getRefNodo();
        }
    }
}
