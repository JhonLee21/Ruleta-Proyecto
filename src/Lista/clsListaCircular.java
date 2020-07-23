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
public class clsListaCircular {

    private nodoLD PLC;
    private int cantidad;

    public clsListaCircular() {
        this.PLC = null;
        this.cantidad = 0;

    }

    public nodoLD getPLC() {
        return PLC;
    }

    public void setPLC(nodoLD PLC) {
        this.PLC = PLC;
    }

    public void insertarDerecha(int dato, String objeto) {
        nodoLD nn = new nodoLD(dato, objeto);
        if (this.PLC == null) {
            this.PLC = nn;
            this.PLC.setRefDer(this.PLC);
            this.PLC.setRefIzq(this.PLC);
            this.cantidad++;
        } else {
            (this.PLC.getRefDer()).setRefIzq(nn);
            nn.setRefDer(this.PLC.getRefDer());
            this.PLC.setRefDer(nn);
            nn.setRefIzq(this.PLC);
            this.cantidad++;
        }
    }

    public boolean estaVacia() {
        if (this.PLC == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esUnSoloNodo() {
        if (this.PLC == this.PLC.getRefDer() && this.PLC == this.PLC.getRefIzq()) {
            return true;
        } else {
            return false;
        }
    }

    public int cantidadNodos() {
        return this.cantidad;
    }

    public void eliminarDerecha() {
        if (!estaVacia()) {
            if (esUnSoloNodo()) {
                this.PLC = null;
                cantidad = 0;
            } else {
                ((this.PLC.getRefDer()).getRefDer()).setRefIzq(this.PLC);
                this.PLC.setRefDer((this.PLC.getRefDer()).getRefDer());
                this.cantidad--;
            }
        }
    }

    public void eliminarBusqueda(int dato) {
        int i = 1;
        if (!estaVacia()) {
            if (esUnSoloNodo()) {
                if (this.PLC.getDato() == dato) {
                    this.PLC = null;
                    this.cantidad = 0;
                }
            } else {
                nodoLD aux = this.PLC;
                while (i < this.cantidad) {
                    if (aux.getDato() == dato) {
                        aux.getRefIzq().setRefDer(aux.getRefDer());
                        aux.getRefDer().setRefIzq(aux.getRefIzq());
                        this.cantidad--;
                        break;
                    } else {
                        i++;
                        aux = aux.getRefDer();
                    }

                }

            }
        }

    }
}
