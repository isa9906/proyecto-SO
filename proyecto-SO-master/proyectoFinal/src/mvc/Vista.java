/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARCE
 */
public class Vista {

    protected JFrame ventana;
    protected JPanel p1Panel, p2Panel, p3Panel, p4Panel, p5Panel, p6Panel,
            p7Panel, p8Panel, p9Panel, pgantt;
    protected JButton b1Boton, b2Boton, b3Boton, b4Boton;
    public JTable t1Tabla, t2Tabla, t3Tabla, t4Tabla, t5Tabla, t6Tabla, t7, tablaGantt;
    protected DefaultTableModel m1Modelo, m2Modelo;
    private JScrollPane scrollPane, scrollPane2, scrollPane3;
    protected JLabel l1Label, l2Label, l3Label, l4Label, l5Label,l6Label;
    protected JComboBox c1Combo;
    public String[][] contenido;
    public String[][] contenido2;
    public String[] contenedorx;

    public String[][] contenedorxy;

    public String[] columnasRR = {"ProcesoID", "Llegada", "Rafaga", "Quantum", "Comienzo", "Final"};
    public String[] columnasTerm = {"ProcesoID", "Llegada", "Rafaga", "Espera", "Final"};
    public String[] columnasSJF = {"ProcesoID", "Llegada", "Rafaga", "Comienzo", "Final"};
    public String[] columnasPRI = {"ProcesoID", "Llegada", "Rafaga", "Prioridad", "Comienzo", "Final"};
    public String[] columnasBlock = {"ColaPrioridad", "ProcesoID", "Llegada",
        "Rafaga", "Prioridad", "Quantum"};
    public String[] columnas2 = {"ProcesoID", "Proceso", "Rafaga", "Tllegada",
        "Tfinal", "Tretorno", "Tespera"};
    final String boton1 = "Crear Proceso";
    final String boton2 = "Ejecutar";
    final String boton3 = "Bloquear";
    final String boton4 = "Desbloquear";
    final String[] algortimos = {"Rafaga mas Corta", "Round Robin", "Prioridad"};

    public Vista() {
        PanelPrincipal();
        PanelRoundRobin();
        PanelRoundJSF();
        panelTerminados();
        panelGantt();
        PanelPRI();
        PanelTerceario();
        panelBloqueo();
        PanelTablas();
        PanelProceso();
        VentanaPrincipal();

    }

    private void PanelPrincipal() {
        p1Panel = new JPanel();
        b1Boton = new JButton(boton1);
        p1Panel.setLayout(new GridBagLayout());
        p1Panel.setBackground(Color.GREEN);
        c1Combo = new JComboBox(algortimos);

        p1Panel.add(b1Boton);
        p1Panel.add(c1Combo);
    }

    private void PanelRoundRobin() {
        p2Panel = new JPanel();
        l1Label = new JLabel("Cola de procesos Round Robin");
        p2Panel.setLayout(new GridLayout(2, 1));
        p2Panel.setLayout(new BoxLayout(p2Panel, BoxLayout.Y_AXIS));
        p2Panel.add(l1Label);
        t1Tabla = new JTable();
        t1Tabla.setPreferredScrollableViewportSize(new Dimension(100, 100));
        scrollPane = new JScrollPane(this.t1Tabla);
        // t1Tabla.setVisible(false);
        p2Panel.add(this.scrollPane);
    }

    private void PanelRoundJSF() {
        p6Panel = new JPanel();
        l4Label = new JLabel("Cola de procesos Rafaga mas Corta");
        p6Panel.setLayout(new GridLayout(2, 1));
        p6Panel.setLayout(new BoxLayout(p6Panel, BoxLayout.Y_AXIS));
        p6Panel.add(l4Label);
        t3Tabla = new JTable();
        t3Tabla.setPreferredScrollableViewportSize(new Dimension(100, 100));
        scrollPane = new JScrollPane(this.t3Tabla);
        // t1Tabla.setVisible(false);
        p6Panel.add(this.scrollPane);
    }

    private void PanelPRI() {
        p7Panel = new JPanel();
        l5Label = new JLabel("Cola de procesos Prioridad");
        p7Panel.setLayout(new GridLayout(2, 1));
        p7Panel.setLayout(new BoxLayout(p7Panel, BoxLayout.Y_AXIS));
        p7Panel.add(l5Label);
        t4Tabla = new JTable();
        t4Tabla.setPreferredScrollableViewportSize(new Dimension(100, 100));
        scrollPane = new JScrollPane(this.t4Tabla);
        // t1Tabla.setVisible(false);
        p7Panel.add(this.scrollPane);
    }

	//desde acas e pone hp
    private void PanelTerceario() {
        p3Panel = new JPanel();
        b2Boton = new JButton(this.boton2);
        b3Boton = new JButton(this.boton3);
        b4Boton = new JButton(this.boton4);
        l2Label = new JLabel("Semaforo" + "\n" + " Del Procesador");
        l3Label = new JLabel();
        p3Panel.setLayout(new GridLayout(5, 3));
        // p3Panel.setLayout(new BoxLayout(p3Panel, BoxLayout.X_AXIS));
        p3Panel.add(b2Boton);
	p3Panel.add(b3Boton);
        p3Panel.add(b4Boton);
        p3Panel.add(l2Label);
        p3Panel.add(l3Label);
    }

    private void panelBloqueo() {

        p4Panel = new JPanel();
        l6Label = new JLabel("Cola de Bloqueados");
        p4Panel.setLayout(new BoxLayout(p4Panel, BoxLayout.Y_AXIS));
        t2Tabla = new JTable();
        t2Tabla.setPreferredScrollableViewportSize(new Dimension(100, 100));
        scrollPane2 = new JScrollPane(this.t2Tabla);
        p4Panel.setBackground(Color.GREEN);
        p4Panel.add(l6Label);
	//t2Tabla.setVisible(true);
        p4Panel.add(this.scrollPane2);
    }

    private void PanelProceso() {
        p5Panel = new JPanel();
        p5Panel.setLayout(new GridLayout(6, 5));
        p5Panel.setPreferredSize(new Dimension(1024, 600));
        p5Panel.setBorder(BorderFactory.createEtchedBorder());
        p5Panel.setBackground(Color.GREEN);
        
        p5Panel.add(p1Panel);
        p5Panel.add(p3Panel);
        p5Panel.add(p4Panel);
        p5Panel.add(p8Panel);
        p5Panel.add(p9Panel);
        p5Panel.add(pgantt);
        
        
    }

    private void PanelTablas() {
        p8Panel = new JPanel();
        p8Panel.setLayout(new GridLayout(1, 3));
        p8Panel.setPreferredSize(new Dimension(1024, 600));
        p8Panel.setBorder(BorderFactory.createEtchedBorder());
        p8Panel.setBackground(Color.GREEN);
        p8Panel.add(p2Panel);
        p8Panel.add(p6Panel);
        p8Panel.add(p7Panel);//7

    }

    private void panelTerminados() {

        p9Panel = new JPanel();
        p9Panel.setLayout(new BoxLayout(p9Panel, BoxLayout.Y_AXIS));

        t7 = new JTable();
        t7.setPreferredScrollableViewportSize(new Dimension(100, 100));
        scrollPane2 = new JScrollPane(this.t7);
        p9Panel.setBackground(Color.GREEN);
        
        //t2Tabla.setVisible(true);
        p9Panel.add(this.scrollPane2);
    }

    private void panelGantt() {

        pgantt = new JPanel();
        pgantt.setLayout(new BoxLayout(pgantt, BoxLayout.Y_AXIS));
        //pgantt.setLayout (new BorderLayout());
        

        tablaGantt = new JTable();
        tablaGantt.setPreferredScrollableViewportSize(new Dimension(100, 100));
        
        scrollPane3 = new JScrollPane(this.tablaGantt);
        //t2Tabla.setVisible(true);
        pgantt.add(this.scrollPane3);
        
    }

    private void VentanaPrincipal() {
        ventana = new JFrame();
        //ventana.setResizable(false);
        ventana.setLayout(new GridLayout(1, 2, 0, 2));
        ventana.setPreferredSize(new Dimension(700, 900));
        
        ventana.setLocation(10, 100);
        ventana.add(this.p5Panel);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
