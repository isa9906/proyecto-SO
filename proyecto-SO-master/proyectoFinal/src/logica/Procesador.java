/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author DARKKOH
 */
public class Procesador {

    public void Ejecutar(Proceso p) {
        if (p.rafaga > 0) {
            p.rafaga = p.rafaga - 1;

        }
    }

}
