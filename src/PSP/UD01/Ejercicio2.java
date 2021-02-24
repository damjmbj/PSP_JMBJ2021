package PSP.UD01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio2 {
	public static void main(String[] args) {

		Runtime runTime = Runtime.getRuntime();
		String cmd = "ls src";
		Process p = null;

		Process out;
		try {
			out = runTime.exec(cmd);
			BufferedReader bf = new BufferedReader(new InputStreamReader(out.getInputStream()));
			String linea;
			while ((linea = bf.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
