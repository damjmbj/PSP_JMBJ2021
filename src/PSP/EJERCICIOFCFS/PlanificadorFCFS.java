package PSP.EJERCICIOFCFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author JMBJ
 *
 */

public class PlanificadorFCFS {
	
	//Variable estatica Queue y delcarar el tipo de queue
		private static Queue<ProcesoImpresion> queue = new LinkedList<ProcesoImpresion>();
		
		
		public static ProcesoImpresion get() {
			//Variable auxiliar de la clase Proceso Impresion.
			//guardamos en el auxiliar el valor que tiene queue.
			ProcesoImpresion aux = queue.poll();
			//variable inicio y fin para la hora.
			long inicio, fin;
			
			//si aux es distinto de null
			if (aux != null) {
				try {
					//guardaamos el tiempo en milisegundo
					inicio = System.currentTimeMillis();
					System.out.println("*****************");
					//Imprimimos el valor de la variable inicio
					System.out.println("Hora de inicio " + inicio);	
					//Suspende el subproceso actual durante la cantidad de tiempo especificada. en la duracion de la clase ProcesoImpresion
					Thread.sleep(aux.duracion);
					fin = System.currentTimeMillis();
					System.out.println(" hora de fin: " + fin);
					System.out.println(" --> Duracion del hilo (" +aux.duracion + " )" + aux.nombre);
					System.out.println("*********** FIN DEL PROCESO");
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("*************** PLANIFICADOR SIN PROCESO:");
			}
			return aux;
			
		}
		
		public static void put (ProcesoImpresion pi) {
			queue.add(pi);
		}
		
		public static void sirve() {
			while (get() != null) {
				
			}
		}

}
