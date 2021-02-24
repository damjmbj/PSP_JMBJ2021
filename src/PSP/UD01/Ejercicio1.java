package PSP.UD01;

import java.io.IOException;
/**
 * 
 * @author JMBJ
 * 12 NOVIEMBRE 2020
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {


		Runtime runTime = Runtime.getRuntime();
		String executablePath = "firefox";
		
		
		try {
			runTime.exec(executablePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
