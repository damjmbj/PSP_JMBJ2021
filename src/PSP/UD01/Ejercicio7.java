package PSP.UD01;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author JMBJ
 *
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		Process p = null;
		List<String> comandos = new ArrayList<String>();
		//En windows...
		String comando = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		String parametro = "https://github.com/damjmbj/PSP_JMBJ";
		
		try {
			comandos.add(comando);
			comandos.add(parametro);
			ProcessBuilder pb = new ProcessBuilder(comandos);
			p = pb.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
