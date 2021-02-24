package PSP.UD01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio5 {

	public static void main(String[] args) {

		Runtime runTime = Runtime.getRuntime();
		String cmd = "DIR";
		Process p = null;
		try {
			p = runTime.exec(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int status;
		BufferedReader br = null;
		try {
			status = p.waitFor();
			System.out.println("El comando " + cmd + " ha resultado " + status);	
			System.out.println("La salida ha sido: ");
			
			InputStream errStream = p.getErrorStream();
			br = new BufferedReader(new InputStreamReader(errStream));
			
			String linea = "";
			while ((linea = br.readLine()) !=null){
				System.out.println(linea);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
