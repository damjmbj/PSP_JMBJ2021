package PSP.UD01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * @author JMBJ
 *
 */
public class Ejercicio6 {

	private static final String FICHERO_TXT = "errorComando.txt";

	public static void main(String[] args) {

		Runtime rt = Runtime.getRuntime();
		Process p = null;
		String cmd = "CMD /C DIRRR";
		int status;
		String linea;
		
		try {
			p = rt.exec(cmd);
			status = p.waitFor();
			InputStream error = p.getErrorStream();	
			//Metemos en un flujo de lectura el error
			BufferedReader br = new BufferedReader(new InputStreamReader(error));
			//Utilizamos un flujo de escritura para escribir en el fichero
			BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_TXT));
			
			//Escribe línea línea en el fichero.
			linea = br.readLine();
			while (linea != null) {
				bw.write(linea);
				linea = br.readLine();
			}
			//Cerramos los flujos
			bw.close();
			br.close();
			
		} catch (IOException e){
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}