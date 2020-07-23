/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentación;

import Cola.Cola;
import Lista.clsListaSimple;

/**
 *
 * @author pc
 */
public class clsPrincipal {
    public static void main(String[] args) {
        clsListaSimple obj = new clsListaSimple();
        obj.insertarOrdenado(10, "Pedro");
        obj.insertarOrdenado(70, "Juan");
        obj.insertarOrdenado(50, "Jose");
        obj.insertarOrdenado(100, "Mario");
        obj.insertarOrdenado(80, "Ana");
        obj.insertarOrdenado(10, "pedro");
    }
}
