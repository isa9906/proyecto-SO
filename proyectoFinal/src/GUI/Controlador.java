/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LOGIC.Proceso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Controlador implements ActionListener{
   public Modelo m;
   public Vista v;
   int quantum;
   int cont;

   
    public Controlador(Modelo m, Vista v) {
        this.m = m;
        this.v = v;
        m.inicializador();
         hi=new hilos(v,m,this);
            Thread hiloCanvas=new Thread(hi);
            hi.crearHilos(hiloCanvas);
        actionListener(this);
        quantum= Integer.valueOf(JOptionPane.showInputDialog("Quantum"));
        cont=0;
    }
    

        int procesid=1;
        String algoritmo;
        hilos hi;
        
      
    
        public void cargarTablaTerminados(int cantidadColumnas) {
            Object[] ar=m.cT.colaAarray();
            ArrayList<Proceso> mpr=new ArrayList<>();
            for(int i=0;i<ar.length;i++){
            mpr.add((Proceso) ar[i]);
            }
            ArrayList<Integer> datos= new ArrayList<>();
           
            for(int i=0;i<mpr.size();i++){
            	
            datos.add(mpr.get(i).Id);
            datos.add(mpr.get(i).llegada);
            datos.add(mpr.get(i).rafagaOrg);
            datos.add(mpr.get(i).comienzo);
            datos.add(mpr.get(i).tfinal);
            
            
            }
            
            this.v.t7.setVisible(true);
            this.v.contenido = new String[(datos.size()) / cantidadColumnas][cantidadColumnas];
            //System.out.println(this.m.getNodosEnCola().size()/cantidadColumnas+" Nodos en cola");
            for (int i = 0; i < (datos.size()) / cantidadColumnas; i++) {
                for (int j = 0; j < cantidadColumnas; j++) {
                    this.v.contenido[i][j] = Integer.toString(datos.get(i * cantidadColumnas + j)) ;
                }
            }
            this.v.t7.setModel(
                    new DefaultTableModel(this.v.contenido, this.v.columnasTerm));
         
        }
        public void cargarTablaGantt(ArrayList<Integer> lista) {
        
	        v.contenedorx = new String[lista.size()];

	  
	        v.contenedorxy = new String[procesid][lista.size()];
	        for(int n = 0; n< lista.size(); n ++){
	        	v.contenedorx[n]= String.valueOf(n+1);
	        
	        }
	   
	        for(int i = 0; i< lista.size(); i ++){
	        	
	        	for (int j = 0; j < procesid; j++) {
	        		
	        		if(lista.get(i).equals(j)){
	        			 this.v.contenedorxy[j][i] = "XXX" ;
	        			
	        		}
                  //  this.v.contenido[i][j] = Integer.toString(datos.get(i * cantidadColumnas + j)) ;
                }
	        }
	        this.v.tablaGantt.setModel(new DefaultTableModel(v.contenedorxy,v.contenedorx));;
        }

         public void cargarTablaRR(int cantidadColumnas) {
             Object[] ar=m.RR.colaAarray();
             ArrayList<Proceso> mpr=new ArrayList<>();
             for(int i=0;i<ar.length;i++){
             mpr.add((Proceso) ar[i]);
             }
             ArrayList<Integer> datos= new ArrayList<>();
             for(int i=0;i<mpr.size();i++){
             datos.add(mpr.get(i).Id);
             datos.add(mpr.get(i).llegada);
             datos.add(mpr.get(i).rafaga);
             datos.add(mpr.get(i).quantum);
             }
             
        this.v.t1Tabla.setVisible(true);
        this.v.contenido = new String[(datos.size()) / cantidadColumnas][cantidadColumnas];
        //System.out.println(this.m.getNodosEnCola().size()/cantidadColumnas+" Nodos en cola");
        for (int i = 0; i < (datos.size()) / cantidadColumnas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                this.v.contenido[i][j] = Integer.toString(datos.get(i * cantidadColumnas + j)) ;
            }
        }
        this.v.t1Tabla.setModel(
                new DefaultTableModel(this.v.contenido, this.v.columnasRR));
    }
            public void cargarTablaSJF(int cantidadColumnas) {
             Object[] ar=m.SJF.colaAarray();
             ArrayList<Proceso> mpr=new ArrayList<>();
             for(int i=0;i<ar.length;i++){
             mpr.add((Proceso) ar[i]);
             }
             ArrayList<Integer> datos= new ArrayList<>();
             for(int i=0;i<mpr.size();i++){
             datos.add(mpr.get(i).Id);
             datos.add(mpr.get(i).llegada);
             datos.add(mpr.get(i).rafaga);
             }
             
        this.v.t3Tabla.setVisible(true);
        this.v.contenido = new String[(datos.size()) / cantidadColumnas][cantidadColumnas];
        //System.out.println(this.m.getNodosEnCola().size()/cantidadColumnas+" Nodos en cola");
        for (int i = 0; i < (datos.size()) / cantidadColumnas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                this.v.contenido[i][j] = Integer.toString(datos.get(i * cantidadColumnas + j)) ;
            }
        }
        try{
        this.v.t3Tabla.setModel(
                new DefaultTableModel(this.v.contenido, this.v.columnasSJF));}
        catch(ArrayIndexOutOfBoundsException arr){
            System.out.println("Desincronizacion");}
    }
   
public void cargarTablaPRI(int cantidadColumnas) {
             Object[] ar=m.PRI.colaAarray();
             ArrayList<Proceso> mpr=new ArrayList<>();
             for(int i=0;i<ar.length;i++){
             mpr.add((Proceso) ar[i]);
             }
             ArrayList<Integer> datos= new ArrayList<>();
             for(int i=0;i<mpr.size();i++){
             datos.add(mpr.get(i).Id);
             datos.add(mpr.get(i).llegada);
             datos.add(mpr.get(i).rafaga);
             datos.add(mpr.get(i).prioridad);
             }
             
        this.v.t4Tabla.setVisible(true);
        this.v.contenido = new String[(datos.size()) / cantidadColumnas][cantidadColumnas];
        //System.out.println(this.m.getNodosEnCola().size()/cantidadColumnas+" Nodos en cola");
        for (int i = 0; i < (datos.size()) / cantidadColumnas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                this.v.contenido[i][j] = Integer.toString(datos.get(i * cantidadColumnas + j)) ;
            }
        }
        try{
        this.v.t4Tabla.setModel(
                new DefaultTableModel(this.v.contenido, this.v.columnasPRI));
        }
        catch(ArrayIndexOutOfBoundsException arr){
            System.out.println("Desincronizacion");}
    }
public void cargarTablaBloqueo(int cantidadColumnas) {
             Object[] ar=m.CB.colaAarray();
             ArrayList<Proceso> mpr=new ArrayList<>();
             for(int i=0;i<ar.length;i++){
             mpr.add((Proceso) ar[i]);
             }
             
             ArrayList<Integer> datos= new ArrayList<>();
             for(int i=0;i<mpr.size();i++){
             datos.add(m.CB.prioridadCola.get(i));
             datos.add(mpr.get(i).Id);
             datos.add(mpr.get(i).llegada);
             datos.add(mpr.get(i).rafaga);
             datos.add(mpr.get(i).prioridad);
             datos.add(mpr.get(i).quantum);
             }
        this.v.t2Tabla.setVisible(true);
        this.v.contenido = new String[(datos.size()) / cantidadColumnas][cantidadColumnas];
        //System.out.println(this.m.getNodosEnCola().size()/cantidadColumnas+" Nodos en cola");
        for (int i = 0; i < (datos.size()) / cantidadColumnas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                this.v.contenido[i][j] = Integer.toString(datos.get(i * cantidadColumnas + j)) ;
            }
        }
        try{
        this.v.t2Tabla.setModel(
                new DefaultTableModel(this.v.contenido, this.v.columnasBlock));
        }
        catch(ArrayIndexOutOfBoundsException arr){
            System.out.println("Desincronizacion");}
    }
          
    @Override
    public void actionPerformed(ActionEvent e) {
        // eventos del combo
        if (e.getSource().equals(v.c1Combo)){
            algoritmo=(String) v.c1Combo.getSelectedItem();
        }
        
        if (e.getActionCommand().equals(v.boton1)) {
            
           int  Id= procesid++;
           int  llegada= cont;
           int  rafaga= 0;
           int contador=0;
           m.quantumRR=quantum;
           int prioridad=0;
            if ("RR".equals(algoritmo)){
                
                rafaga=Integer.parseInt(JOptionPane.showInputDialog("Rafaga"));
              
       m.añadirElementoColaRR(m.crearProcesoRR(Id, llegada, rafaga, quantum,contador));
                 JOptionPane.showMessageDialog(null, algoritmo);      
            }
            if ("SJF".equals(algoritmo)){
               rafaga= Integer.parseInt(JOptionPane.showInputDialog("Rafaga"));
          
       m.añadirElementoColaSJF(m.crearProcesoSJF(Id, llegada, rafaga));
                JOptionPane.showMessageDialog(null, algoritmo);
            }
            if ("PRI".equals(algoritmo)){
               rafaga= Integer.parseInt(JOptionPane.showInputDialog("Rafaga"));
          
               prioridad=Integer.parseInt(JOptionPane.showInputDialog("Prioridad"));
       m.añadirElementoColaPRI(m.crearProcesoPRI(Id, llegada, rafaga, prioridad));
                JOptionPane.showMessageDialog(null,algoritmo);
            }
            
            cargarTablaRR(4);
            cargarTablaSJF(3);
            cargarTablaPRI(4);
            cargarTablaBloqueo(6);
            cargarTablaTerminados(5);
            cont++;
        }
        
        if (e.getActionCommand().equals(v.boton2)){
       //ejecucion manual
         /*   m.retroalimentacion();
            hi.refrescarTablas();
            if(m.sem.Estado==true){
            v.l3Label.setText("Libre");}
            else{v.l3Label.setText("Ocupado");}
        cont++;*/
            
            //ejecucion con hilos
        try{    
            hi.iniciarHiloProcesamiento();}
        catch (ArrayIndexOutOfBoundsException err){
        
        JOptionPane.showMessageDialog(hi, "Desincronizacion");}
           
        }
        if (e.getActionCommand().equals(v.boton3)) {
            try{
        m.BloquearProceso();
        hi.refrescarTablas();
        }
        catch (ArrayIndexOutOfBoundsException err){
        
        JOptionPane.showMessageDialog(null, "Desincronizacion");}
           
        }
        
        if (e.getActionCommand().equals(v.boton4)) {   
            try{
        m.desbloquearProceso();
        hi.refrescarTablas();
        }
        catch (ArrayIndexOutOfBoundsException err){
        
        JOptionPane.showMessageDialog(null, "Desincronizacion");}
            
        }
        

    }
    

    private void actionListener(Controlador e) {
        this.v.b1Boton.addActionListener(e);
        this.v.b2Boton.addActionListener(e);
        this.v.b3Boton.addActionListener(e);
        this.v.b4Boton.addActionListener(e);
        this.v.c1Combo.addActionListener(e);
    }
}
