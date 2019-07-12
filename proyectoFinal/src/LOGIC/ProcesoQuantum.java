/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

/**
 *
 * @author DARKKOH
 */
public class ProcesoQuantum extends Proceso{

public    ProcesoQuantum(int id, int llegada, int rafaga) {
        super(id, llegada, rafaga);
    }
 @Override
    public int compareTo(Proceso p) {
         if(quantum>p.quantum){  
             p.contador=p.contador+1;
        return 1;  
    }else if(quantum<p.quantum){  
        return -1;  
    }else{  
    return 0;  
    }  
    }  
}
