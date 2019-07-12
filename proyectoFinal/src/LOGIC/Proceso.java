/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

/**
 *
 * @author DARKKOH
 */
public  class Proceso implements Comparable<Proceso>{
  public  int Id;
  public  int llegada;
  public  int rafaga;
  public  int rafagaOrg;
  public   int prioridad;
  public int quantum;
  public int tfinal;
  public int comienzo;
  public int contador=0;

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getQuantum() {
        return quantum;
    }

            public Proceso(int id, int llegada,int rafaga){
            this.Id=id;
            this.llegada=llegada;
            this.rafaga=rafaga;
            this.rafagaOrg = rafaga;
            }

    @Override
    public int compareTo(Proceso t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
