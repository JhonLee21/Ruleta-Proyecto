/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import negocio.nodo;

/**
 *
 * @author ASUS
 */
public class clsListaSimple {

    private nodo refPri;

    public clsListaSimple() {
        this.refPri = null;
    }

    public nodo getRefPri() {
        return refPri;
    }

    public void setRefPri(nodo refPri) {
        this.refPri = refPri;
    }

    public boolean estaVacia() {
        return this.refPri == null ? true : false;
    }

    // insertar Ordenado
    public void insertarOrdenado(int cod, String detalle) {
        nodo nn = new nodo(cod, detalle);
        if (estaVacia()) {
            this.refPri = nn;
        } else {
            if (cod < this.refPri.getCod()) {
                nn.setRefNodo(this.refPri);
                this.refPri = nn;
            } else {
                nodo p = refPri;
                boolean sw = false;
                while (p.getRefNodo() != null) {
                    if (nn.getCod() < p.getRefNodo().getCod()) {
                        sw = true;
                        nn.setRefNodo(p.getRefNodo());
                        p.setRefNodo(nn);
                        break; //corte del proceso repetitivo
                    } else {
                        p = p.getRefNodo();
                    }
                }
                if (sw == false) {
                    p.setRefNodo(nn);
                }
            }
        }
    }

    public void eliminarNodo() {
        if (!estaVacia()) {
            this.refPri = this.refPri.getRefNodo();
        }
    }

    public void eliminarPorCod(int cod) {
        if (this.refPri.getCod() == cod) {
            this.refPri = this.refPri.getRefNodo();
        } else {
            nodo p = this.refPri;
            while (p.getRefNodo() != null && cod >= p.getRefNodo().getCod()) {
                if (p.getRefNodo().getCod() == cod) {
                    p.setRefNodo(p.getRefNodo().getRefNodo());
                    break;
                } else {
                    p = p.getRefNodo();
                }
            }
        }
    }
//3#

    public int tamanoLista() {
        int cantidad = 0;
        nodo p = this.refPri;
        if (!estaVacia()) {
            while (p.getRefNodo() != null) {
                cantidad++;
                p = p.getRefNodo();
            }
            return cantidad + 1;
        }
        return 0;
    }
//1#

    public double promedio() {
        int cantidad = 0;
        int promedioParcial = 0;
        double promedioTotal = 0;
        nodo p = this.refPri;
        if (!estaVacia()) {
            while (p.getRefNodo() != null) {
                cantidad++;
                promedioParcial = promedioParcial + p.getCod();
                p = p.getRefNodo();
            }
            promedioTotal = ((double) (promedioParcial + p.getCod()) / (cantidad + 1));
        }
        return promedioTotal;
    }
//2#

    public void eliminarUltimo() {
        nodo anterior = null;
        nodo p = this.refPri;
        if (!estaVacia()) {
            if (tamanoLista() == 1) {
                this.refPri = null;
            }
            while (p.getRefNodo() != null) {
                anterior = p.getRefNodo();
                if (anterior.getRefNodo() == null) {
                    p.setRefNodo(null);
                    break;
                }
                p = p.getRefNodo();

            }

        }

    }

    public void eliminarNodoPar() {
        nodo siguiente = null;
        if (!estaVacia()) {
            if (this.refPri.getRefNodo() == null) {
                if (this.refPri.getCod() % 2 == 0) {
                    this.refPri = null;
                    return;
                }
            }
            nodo p = this.refPri;
            while (p.getRefNodo() != null) {

                siguiente = p.getRefNodo();
                if (siguiente.getCod() % 2 == 0) {
                    p.setRefNodo(siguiente.getRefNodo());
                } else {
                    p = p.getRefNodo();
                }
            }
            if (this.refPri.getCod() % 2 == 0) {
                this.refPri = this.refPri.getRefNodo();
            }

        }

    }

    public int cantidadPrimos() {
        int cantidad = 0;
        nodo p = this.refPri;
        if (!estaVacia()) {
            while (p.getRefNodo() != null) {
                if (esPrimo(p.getCod())) {
                    cantidad++;
                }
                p = p.getRefNodo();
            }
            if (esPrimo(p.getCod())) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public boolean esPrimo(int numero) {
        boolean esPrimoActual = true;
        if (numero < 2) {
            esPrimoActual = false;
        } else {
            for (int x = 2; x * x <= numero; x++) {
                if (numero % x == 0) {
                    esPrimoActual = false;
                    break;
                }
            }
        }
        return esPrimoActual;
    }
    

}
