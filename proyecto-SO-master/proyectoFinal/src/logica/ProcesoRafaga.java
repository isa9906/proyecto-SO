/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author DARKKOH
 */
public class ProcesoRafaga extends Proceso {

    public ProcesoRafaga(int id, int llegada, int rafaga) {
        super(id, llegada, rafaga);
    }

    @Override
    public int compareTo(Proceso p) {
        if (rafaga > p.rafaga) {
            return 1;
        } else if (rafaga < p.rafaga) {
            return -1;
        } else {
            return 0;
        }
    }
}
