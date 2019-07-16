/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.awt.Canvas;
import java.awt.IllegalComponentStateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class hilos extends Canvas implements Runnable {
//hilos para movimientos

    Modelo m;
    Vista v;
    Controlador c;
    Thread hilo1;
    int tiempo = 0;
    
    public hilos(Vista v, Modelo m, Controlador c) {
        this.v = v;
        this.m = m;
        this.c = c;
    }

    public void refrescarTablas() {
        c.cargarTablaRR(4);
        c.cargarTablaSJF(3);
        c.cargarTablaPRI(4);
        c.cargarTablaBloqueo(5);
        c.cargarTablaTerminados(5);
    }

    @Override
    public void run() {
        
        try {
            while (true) {
                
                try {
                    while (m.MULTY.mostrarPrimerElemento() != null) {                        
                        m.retroalimentacion(c);
                        refrescarTablas();
                        if (m.sem.Estado == true) {
                            v.l3Label.setText("Libre");
                        } else {
                            v.l3Label.setText("Ocupado");
                        }
                        c.cont++;
                        hilo1.sleep(1000);
                    }                    
                } catch (IllegalComponentStateException ie) {
                    JOptionPane.showMessageDialog(this, "Sin datos");
                } catch (NullPointerException ne) {
                    JOptionPane.showMessageDialog(this, "Cola vacia");
                }
 //                
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    public void crearHilos(Thread hilo1) {
        this.hilo1 = hilo1;        
    }

    public void iniciarHiloProcesamiento() {
        try {
            hilo1.start();
        } catch (IllegalThreadStateException iex) {
            System.out.println("Ya en ejecucion");
        }
        
    }

    public void continuarHiloProcesamiento() {
        // continua la ejecucion del hilo
        hilo1.resume();
    }
    
    public void parar() {
        //pausa el movimiento
        hilo1.suspend();
        //System.out.println(hilo1.getState()+ "estado detenido");
    }
    
}
