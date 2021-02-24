package PSP.UD01;

/**
 * 
 * @author JMBJ
 *
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		Runtime runTime = Runtime.getRuntime();
		String cmd = "ls --help";
		Process p = null;
		try {
			p = runTime.exec(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int status;
		try {
			status = p.waitFor();
			System.out.println("El comando " + cmd + " ha resultado " + status);			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
