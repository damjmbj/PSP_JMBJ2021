package PSP.EJERCICIOFCFS;

/**
 * 
 * @author JMBJ
 *
 */
public class ProcesoImpresion implements Comparable<ProcesoImpresion>{


	public long duracion;
	
	public String nombre;

	public ProcesoImpresion(String nombre, long duracion) {
		
		this.duracion = duracion;
		this.nombre = nombre;
	}

	public long getDuracion() {
		return duracion;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int compareTo(ProcesoImpresion o) {
		long obj1= new Long(getDuracion());
		long obj2= new Long(o.getDuracion());
		
		int compareValue = Long.compare(obj1, obj2);
		
		if (compareValue == 0) {
			compareValue=(int) obj1;
		}else if (compareValue > 0) {
			compareValue = (int) obj2;
		}else {
			compareValue= (int) obj1;
		}
		

		return compareValue;
	}

	
}
