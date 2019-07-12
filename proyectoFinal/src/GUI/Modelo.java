/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;

import javax.rmi.CORBA.Tie;
import javax.swing.JOptionPane;

import LOGIC.ProcesoQuantum;
import LOGIC.Cola;
import LOGIC.ColaBloqueados;
import LOGIC.Semaforo;
import LOGIC.ProcesoPrioridad;
import LOGIC.multycola;
import LOGIC.ProcesoRafaga;
import LOGIC.Procesador;
import LOGIC.Proceso;


public class Modelo {
	Cola PRI;
	Cola SJF;
	Cola RR;
	Cola cT;
	multycola MULTY;
	Procesador CPU;
	ColaBloqueados CB;
	Semaforo sem;
	public int envPRI;
	public int envJSF;
	int timerDeEjecucionRR;
	public int timerDeEjecucionProcesado;
	int quantumRR;
	ArrayList<Integer> gantt;

	public void crearColas() {
		PRI = new Cola();
		SJF = new Cola();
		RR = new Cola();
		RR.setPrioridad(1);
		SJF.setPrioridad(2);
		PRI.setPrioridad(3);
		gantt = new ArrayList();
	}

	public void crearMultyCola() {
		MULTY = new multycola();
	}

	public void añadirElementoMultiCola(Cola c) {
		MULTY.añadirElemento(c);
	}

	public void inicializador() {
		crearProcesador();
		crearColas();
		crearMultyCola();
		crearColaBloqueados();
		crearSemaforo();
		crearColTerminados();
		sem.SetEstado(true);
		envPRI = 10;
		envJSF = 20;
	}

	public void retroalimentacion(Controlador ct) {
		timerDeEjecucionProcesado++;
		if (MULTY.mostrarPrimerElemento() != null) {
			sem.SetEstado(false);
			if (MULTY.mostrarPrimerElemento().mostrarPrimerElemento() != null) {

				System.out.println("ejecutando");
				if (MULTY.mostrarPrimerElemento().mostrarPrimerElemento().rafaga > 0) {
					if(MULTY.mostrarPrimerElemento().mostrarPrimerElemento().comienzo ==0){
						MULTY.mostrarPrimerElemento().mostrarPrimerElemento().comienzo = timerDeEjecucionProcesado-1;
					}
					gantt.add(MULTY.mostrarPrimerElemento().mostrarPrimerElemento().Id);
					ct.cargarTablaGantt(gantt);
                                        if (MULTY.mostrarPrimerElemento().prioridad == 1) {
						timerDeEjecucionRR++;
						try {
							if (timerDeEjecucionRR
									% MULTY.mostrarPrimerElemento()
											.mostrarPrimerElemento().quantum != 0) {
								CPU.Ejecutar(MULTY.mostrarPrimerElemento()
										.mostrarPrimerElemento());
								/*
								 * JOptionPane.showMessageDialog(null,"Proceso"+
								 * MULTY
								 * .mostrarPrimerElemento().mostrarPrimerElemento
								 * ().Id+"\n"+
								 * "RafagaRestante"+MULTY.mostrarPrimerElemento
								 * ().mostrarPrimerElemento().rafaga);
								 */
								System.out.println(MULTY
										.mostrarPrimerElemento()
										.mostrarPrimerElemento().Id
										+ "ID");
								System.out.println(MULTY
										.mostrarPrimerElemento()
										.mostrarPrimerElemento().rafaga
										+ "Rafaga");
								System.out.println(MULTY
										.mostrarPrimerElemento()
										.mostrarPrimerElemento().llegada
										+ "llegada");
							} else {
								System.out.println("Quinto");
								CPU.Ejecutar(MULTY.mostrarPrimerElemento()
										.mostrarPrimerElemento());
								/*
								 * JOptionPane.showMessageDialog(null,"Proceso"+
								 * MULTY
								 * .mostrarPrimerElemento().mostrarPrimerElemento
								 * ().Id+"\n"+
								 * "RafagaRestante"+MULTY.mostrarPrimerElemento
								 * ().mostrarPrimerElemento().rafaga);
								 */
								System.out.println(MULTY
										.mostrarPrimerElemento()
										.mostrarPrimerElemento().Id
										+ "ID");
								System.out.println(MULTY
										.mostrarPrimerElemento()
										.mostrarPrimerElemento().rafaga
										+ "Rafaga");
								System.out.println(MULTY
										.mostrarPrimerElemento()
										.mostrarPrimerElemento().llegada
										+ "llegada");
								if (RR.TamañoCola() > 1
										&& MULTY.mostrarPrimerElemento()
												.mostrarPrimerElemento().rafaga > 0) {
									int id = MULTY.mostrarPrimerElemento()
											.mostrarPrimerElemento().Id;
									int llegada = MULTY.mostrarPrimerElemento()
											.mostrarPrimerElemento().llegada;
									int rafaga = MULTY.mostrarPrimerElemento()
											.mostrarPrimerElemento().rafaga;
									int quantum = MULTY.mostrarPrimerElemento()
											.mostrarPrimerElemento().quantum;
                                                                        int contador = MULTY.mostrarPrimerElemento()
											.mostrarPrimerElemento().contador;
									MULTY.mostrarPrimerElemento()
											.removerPrimerElemento();
									MULTY.mostrarPrimerElemento()
											.añadirElemento(
													crearProcesoRR(id, llegada,
															rafaga, quantum,contador+1));
									System.out.println("Se movio al final");
									sem.SetEstado(true);
								}
							}
						} catch (java.lang.ArithmeticException zero) {
							System.out
									.println("Quantum capturado con valor cero");
						}
					} else {
						CPU.Ejecutar(MULTY.mostrarPrimerElemento()
								.mostrarPrimerElemento());
						/*
						 * JOptionPane.showMessageDialog(null,"Proceso"+
						 * MULTY.mostrarPrimerElemento
						 * ().mostrarPrimerElemento().Id+"\n"+
						 * "RafagaRestante"+MULTY
						 * .mostrarPrimerElemento().mostrarPrimerElemento
						 * ().rafaga);
						 */
						System.out.println(MULTY.mostrarPrimerElemento()
								.mostrarPrimerElemento().Id + "ID");
						System.out.println(MULTY.mostrarPrimerElemento()
								.mostrarPrimerElemento().rafaga + "Rafaga");
						System.out.println(MULTY.mostrarPrimerElemento()
								.mostrarPrimerElemento().llegada + "llegada");
                                                //MULTY.mostrarPrimerElemento().mostrarPrimerElemento().tfinal-=1;
                                                //MULTY.mostrarPrimerElemento().mostrarPrimerElemento().comienzo=MULTY.mostrarPrimerElemento().mostrarPrimerElemento().tfinal- MULTY.mostrarPrimerElemento().mostrarPrimerElemento().llegada-MULTY.mostrarPrimerElemento().mostrarPrimerElemento().rafagaOrg;
					}
				} else {/*
						 * JOptionPane.showMessageDialog(null,"Proceso"+
						 * MULTY.mostrarPrimerElemento
						 * ().mostrarPrimerElemento().Id+"\n"+
						 * "RafagaRestante"+MULTY
						 * .mostrarPrimerElemento().mostrarPrimerElemento
						 * ().rafaga);
						 */
					//////////////////////////////////////////////aca
                                    
                                       
					MULTY.mostrarPrimerElemento().mostrarPrimerElemento().tfinal = timerDeEjecucionProcesado-1;
                                         if(MULTY.mostrarPrimerElemento().getPrioridad()>=2){
                                            MULTY.mostrarPrimerElemento().mostrarPrimerElemento().tfinal--;
                                        }
                                         
                                        MULTY.mostrarPrimerElemento().mostrarPrimerElemento().comienzo = MULTY.mostrarPrimerElemento().mostrarPrimerElemento().tfinal-MULTY.mostrarPrimerElemento().mostrarPrimerElemento().rafagaOrg-MULTY.mostrarPrimerElemento().mostrarPrimerElemento().llegada-(MULTY.mostrarPrimerElemento().mostrarPrimerElemento().quantum*MULTY.mostrarPrimerElemento().mostrarPrimerElemento().contador);
                                        if( MULTY.mostrarPrimerElemento().mostrarPrimerElemento().comienzo<0){
                                            MULTY.mostrarPrimerElemento().mostrarPrimerElemento().comienzo=0;
                                        }
                                        if(MULTY.mostrarPrimerElemento().mostrarPrimerElemento().contador>=1){
                                            MULTY.mostrarPrimerElemento().mostrarPrimerElemento().tfinal=MULTY.mostrarPrimerElemento().mostrarPrimerElemento().tfinal-1;
                                            MULTY.mostrarPrimerElemento().mostrarPrimerElemento().rafagaOrg = MULTY.mostrarPrimerElemento().mostrarPrimerElemento().quantum*MULTY.mostrarPrimerElemento().mostrarPrimerElemento().contador+MULTY.mostrarPrimerElemento().mostrarPrimerElemento().rafagaOrg;
                                             MULTY.mostrarPrimerElemento().mostrarPrimerElemento().comienzo-=1;
                                        }
					cT.añadirElemento(MULTY.mostrarPrimerElemento().mostrarPrimerElemento());
					MULTY.mostrarPrimerElemento().removerPrimerElemento();
					
					
					System.out.println("Eliminado");
					sem.SetEstado(true);
				}

			} else {
				
				MULTY.removerPrimerElemento();
				System.out.println("cola vacia");
				
				sem.SetEstado(true);
			}
			envejecer();
		} else {
			System.out.println("Sin colas");
			sem.SetEstado(true);
		}
	}

	public void crearProcesador() {
		CPU = new Procesador();
	}

	public Proceso crearProcesoSJF(int Id, int llegada, int rafaga) {
		Proceso p = new ProcesoRafaga(Id, llegada, rafaga);
		
		return p;
	}

	public Proceso crearProcesoPRI(int Id, int llegada, int rafaga,
			int prioridad) {
		Proceso p = new ProcesoPrioridad(Id, llegada, rafaga);
		p.setPrioridad(prioridad);
		return p;

	}

	public Proceso crearProcesoRR(int Id, int llegada, int rafaga, int quantum,int contador) {
		Proceso p = new ProcesoQuantum(Id, llegada, rafaga);
		p.setQuantum(quantum);
                p.contador=contador;
		return p;
	}

	public void añadirElementoColaSJF(Proceso p) {
		if (SJF.TamañoCola() == 0) {
			añadirElementoMultiCola(SJF);
		}
		SJF.añadirElemento(p);
	}

	public void añadirElementoColaRR(Proceso p) {
		if (RR.TamañoCola() == 0) {
			añadirElementoMultiCola(RR);
		}
		RR.añadirElemento(p);
	}

	public void añadirElementoColaPRI(Proceso p) {
		if (PRI.TamañoCola() == 0) {
			añadirElementoMultiCola(PRI);
		}
		PRI.añadirElemento(p);
	}

	public void crearColaBloqueados() {
		CB = new ColaBloqueados();
	}
	
	public void crearColTerminados() {
		cT = new Cola();
	}

	public void BloquearProceso() {
		try {
			if (MULTY.mostrarPrimerElemento().mostrarPrimerElemento() != null) {
				int id = MULTY.mostrarPrimerElemento().mostrarPrimerElemento().Id;
				int llegada = MULTY.mostrarPrimerElemento()
						.mostrarPrimerElemento().llegada;
				int rafaga = MULTY.mostrarPrimerElemento()
						.mostrarPrimerElemento().rafaga;

				if (MULTY.mostrarPrimerElemento().getPrioridad() == 1) {
					CB.añadirPrioridadProcesoEnCola(1);
					int quantum = MULTY.mostrarPrimerElemento()
							.mostrarPrimerElemento().quantum;
                                        int contador= MULTY.mostrarPrimerElemento()
							.mostrarPrimerElemento().contador;
					MULTY.mostrarPrimerElemento().removerPrimerElemento();
					System.out.println("Se Envio a la cola de bloqueados");
					CB.añadirElemento(crearProcesoRR(id, llegada, rafaga,
							quantum,contador));
				}
				if (MULTY.mostrarPrimerElemento().getPrioridad() == 2) {
					CB.añadirPrioridadProcesoEnCola(2);
					MULTY.mostrarPrimerElemento().removerPrimerElemento();
					System.out.println("Se Envio a la cola de bloqueados");
					CB.añadirElemento(crearProcesoSJF(id, llegada, rafaga));
				}
				if (MULTY.mostrarPrimerElemento().getPrioridad() == 3) {
					CB.añadirPrioridadProcesoEnCola(3);
					int prioridad = MULTY.mostrarPrimerElemento()
							.mostrarPrimerElemento().prioridad;
					MULTY.mostrarPrimerElemento().removerPrimerElemento();
					System.out.println("Se Envio a la cola de bloqueados");
					CB.añadirElemento(crearProcesoPRI(id, llegada, rafaga,
							prioridad));
				}
			} else {
				System.out.println("No hay elementos para bloquear");
			}
		} catch (NullPointerException ext) {
			System.out.println("Sin elementos para bloquear");
		}
	}

	public void desbloquearProceso() {
		if (CB.mostrarPrimerElemento() != null) {
			int id = CB.mostrarPrimerElemento().Id;
			int llegada = CB.mostrarPrimerElemento().llegada;
			int rafaga = CB.mostrarPrimerElemento().rafaga;
                       int contador= CB.mostrarPrimerElemento().contador;
			if (!CB.prioridadCola.isEmpty()) {
				if (CB.prioridadCola.get(0) == 1 && !CB.prioridadCola.isEmpty()) {
					int quantum = CB.mostrarPrimerElemento().quantum;
					CB.removerPrimerElemento();
					CB.eliminiarPrioridadProcesoEnCola();
					añadirElementoColaRR(crearProcesoRR(id, llegada, rafaga,
							quantum,contador));
					System.out.println("Se Envio a la cola de Round Robin");
				}
			}
			if (!CB.prioridadCola.isEmpty()) {
				if (CB.prioridadCola.get(0) == 2 && !CB.prioridadCola.isEmpty()) {
					CB.removerPrimerElemento();
					CB.eliminiarPrioridadProcesoEnCola();
					añadirElementoColaSJF(crearProcesoSJF(id, llegada, rafaga));
					System.out.println("Se Envio a la cola de SJF");
				}
			}
			if (!CB.prioridadCola.isEmpty()) {
				if (CB.prioridadCola.get(0) == 3) {
					int prioridad = CB.mostrarPrimerElemento().prioridad;
					CB.removerPrimerElemento();
					CB.eliminiarPrioridadProcesoEnCola();
					añadirElementoColaPRI(crearProcesoPRI(id, llegada, rafaga,
							prioridad));
					System.out.println("Se Envio a la cola de prioridades");
				}
			}
		} else {
			System.out.println("Nada Para Desbloquear");
		}
	}

	public void crearSemaforo() {
		sem = new Semaforo();
	}

	public void envejecerProcesoPRIaSJF() {

		int id = PRI.mostrarPrimerElemento().Id;
		int llegada = PRI.mostrarPrimerElemento().llegada;
		int rafaga = PRI.mostrarPrimerElemento().rafaga;
		PRI.removerPrimerElemento();
		añadirElementoColaSJF(crearProcesoSJF(id, llegada, rafaga));

	}

	public void envejecerProcesoSJFaRR(int quantum) {

		int id = SJF.mostrarPrimerElemento().Id;
		int llegada = SJF.mostrarPrimerElemento().llegada;
		int rafaga = SJF.mostrarPrimerElemento().rafaga;
                int contador = SJF.mostrarPrimerElemento().contador;
		SJF.removerPrimerElemento();
		añadirElementoColaRR(crearProcesoRR(id, llegada, rafaga, quantum, contador));

	}

	public void envejecer() {

		if (PRI.mostrarPrimerElemento() != null) {
			if (timerDeEjecucionProcesado % envPRI == 0) {
				System.out.println(timerDeEjecucionProcesado);
				System.out.println(envPRI);
				envejecerProcesoPRIaSJF();
				System.out.println("Proceso Ascendio a JSF");
			}
		}

		if (SJF.mostrarPrimerElemento() != null) {
			if (timerDeEjecucionProcesado % envJSF == 0) {
				envejecerProcesoSJFaRR(quantumRR);
				System.out.println("Proceso Ascendio a RR");
			}
		}
	}
}
