package PSP.UD01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {

	public static void main(String[] args) {



		Runtime runTime = Runtime.getRuntime();
		String cmd = "ls -l";
		Process p = null;

		Process out;
		try {
			out = runTime.exec(cmd);

			BufferedReader br = new BufferedReader(new InputStreamReader(out.getInputStream()));
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt" ));
			
			String linea;
			
			while((linea = br.readLine()) != null){
				bw.write(linea);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
