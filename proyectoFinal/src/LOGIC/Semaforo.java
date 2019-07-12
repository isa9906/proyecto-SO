/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

/**
 *
 * @author DARKKOH
 */
public class Semaforo {
   public boolean Estado;
    public boolean Habilitado(){
    return Estado;
    }
    public void SetEstado(boolean est){
    Estado=est;
    }
}
