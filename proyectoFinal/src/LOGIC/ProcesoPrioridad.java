/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

/**
 *
 * @author DARKKOH
 */
public class ProcesoPrioridad extends Proceso{

public    ProcesoPrioridad(int id, int llegada, int rafaga) {
        super(id, llegada, rafaga);
    }
 @Override
    public int compareTo(Proceso p) {
         if(prioridad>p.prioridad){  
        return 1;  
    }else if(prioridad<p.prioridad){  
        return -1;  
    }else{  
    return 0;  
    }  
    }
}
