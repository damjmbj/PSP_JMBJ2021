package PSP.UD01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author JMBJ
 *
 */
public class Ejercicio9 {

	public static void main(String[] args) {
		String ls="ls";
		String src= " src";


		List<String> lCommand = new ArrayList<String>();
		lCommand.add(ls);
		lCommand.add(src);
		
		ProcessBuilder pb = new ProcessBuilder(lCommand);
				
		int status;
		try {
			pb.redirectError(new File("error_ejer9.txt"));
			pb.redirectOutput(new File("log_ejer9.txt"));

			//pasamos el processbuilder a proccess para poder hacer un waitFor()
			Process process = pb.start();
			status = process.waitFor();
			
			
			if (status == 0) {
				System.out.println("a ido todo OK.");
			}else {
				System.out.println("A FALLADO ");
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		

	}

}
