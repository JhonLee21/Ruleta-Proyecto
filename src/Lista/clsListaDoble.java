/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;
import negocio.nodoLD;
/**
 *
 * @author pc
 */
public class clsListaDoble {
    private nodoLD pListaD;
    public clsListaDoble(){
        this.pListaD = null;
    }
    
    public void setpListaD(nodoLD pListaD){
        this.pListaD = pListaD;
    }
    
    public nodoLD getpListaD(){
        return this.pListaD;
    }
    
    public void insertarIzq(int dato){
        nodoLD nn = new nodoLD(dato);
        if(this.pListaD == null){
            this.pListaD = nn;
        }else{
            if(this.pListaD.getRefIzq() == null){
                nn.setRefDer(this.pListaD);
                this.pListaD.setRefIzq(nn);
            }else{
                (this.pListaD.getRefIzq()).setRefDer(nn);
                nn.setRefIzq(this.pListaD.getRefIzq());
                nn.setRefDer(this.pListaD);
                this.pListaD.setRefIzq(nn);
            }
        }
    }
    
    public boolean moverDer(){
        if(this.pListaD.getRefDer() != null){
            this.pListaD = this.pListaD.getRefDer();
            return true;
        }else{
            return false;
        }
    }
    
    public boolean moverIzq(){
        if(this.pListaD.getRefIzq() != null){
            this.pListaD = this.pListaD.getRefIzq();
            return true;
        }else{
            return false;
        }
    }
    
    public void irPrimero(){
        while(moverIzq()){
            ;
        }
    }
    
    public void irUltimo(){
        while(moverDer()){
            ;
        }
    }
}
