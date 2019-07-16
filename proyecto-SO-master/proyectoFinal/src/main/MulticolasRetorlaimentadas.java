/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import mvc.Controlador;
import mvc.Modelo;
import mvc.Vista;

public class MulticolasRetorlaimentadas {

    /**
     * @param args the command line arguments
     */
    protected Vista v;
    protected Modelo m;
    protected Controlador c;

    public void ejecucion() {
        this.v = new Vista();
        this.m = new Modelo();
        this.c = new Controlador(m, v);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        MulticolasRetorlaimentadas mcr = new MulticolasRetorlaimentadas();
        mcr.ejecucion();
        /*Cola fifo= new Cola();
         fifo.añadirElemento(pro);
         fifo.añadirElemento(pro1);
         System.out.println(fifo.mostrarPrimerElemento().Id);
         fifo.removerPrimerElemento();
         System.out.println(fifo.mostrarPrimerElemento().Id);*/
    }
}
