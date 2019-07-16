/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author
 */
public class multycola {

    Queue multicola = new PriorityQueue();

    public void añadirElemento(Cola c) {
        multicola.offer(c);
    }

    public Cola mostrarPrimerElemento() {
        return (Cola) multicola.peek();
    }

    public void removerPrimerElemento() {
        multicola.poll();
    }

    public int TamañoCola() {
        return multicola.size();
    }
}
