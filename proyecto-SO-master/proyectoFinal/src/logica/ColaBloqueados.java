/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author DARKKOH
 */
public class ColaBloqueados implements Comparable<ColaBloqueados> {

    public ArrayList<Integer> prioridadCola = new ArrayList<>();
    int prioridad;

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
    Queue cola = new PriorityQueue();

    public void añadirElemento(Proceso p) {
        cola.offer(p);
    }

    public Proceso mostrarPrimerElemento() {
        return (Proceso) cola.peek();
    }

    public void removerPrimerElemento() {
        cola.poll();
    }

    public int TamañoCola() {
        return cola.size();
    }

    @Override
    public int compareTo(ColaBloqueados c) {
        if (prioridad > c.prioridad) {
            return 1;
        } else if (prioridad < c.prioridad) {
            return -1;
        } else {
            return 0;
        }
    }

    public void añadirPrioridadProcesoEnCola(int pricola) {
        prioridadCola.add(pricola);
    }

    public void eliminiarPrioridadProcesoEnCola() {
        prioridadCola.remove(0);
    }

    public Object[] colaAarray() {
        return cola.toArray();
    }
}
