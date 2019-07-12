/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JOptionPane;

/**
 *
 * @author DARKKOH
 */
public class Cola implements Comparable<Cola> {
public    int prioridad;


    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
   
	Queue cola= new PriorityQueue();
   
   
    public void añadirElemento(Proceso p){
    cola.offer(p);
    }
    public Proceso mostrarPrimerElemento(){
    return (Proceso) cola.peek();
    }
    public void removerPrimerElemento(){
 
    cola.poll();
    }
    public int TamañoCola(){
    return cola.size();
    }

    @Override
    public int compareTo(Cola c) {
                 if(prioridad>c.prioridad){  
        return 1;  
    }else if(prioridad<c.prioridad){  
        return -1;  
    }else{  
    return 0;  
    }
    }
    public Object[] colaAarray(){
        return cola.toArray();
    }
}
