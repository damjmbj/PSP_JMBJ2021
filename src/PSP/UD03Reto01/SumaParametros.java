package PSP.UD03Reto01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SumaParametros {

	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		//Se pone la URL
		String host = "https://psp2021site.000webhostapp.com/";
		//
		String php = "suma_parametros.php";
		int numA, numB;
		
		numA = solicitarNumero("Introduce un número: ");
		numB = solicitarNumero("Introduce un número: ");
		String calculoPhp = "?PARAM_A="+numA+"&PARAM_B="+numB;
		

		try {
			URL url = new URL(host+php+calculoPhp);
			URLConnection urlCon = url.openConnection();
			urlCon.connect();
			
			InputStream input = urlCon.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String inputLine;
			
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	private static int solicitarNumero(String msg) {
		int numero;
		System.out.print(msg);
		numero = Integer.parseInt(teclado.nextLine());
		return numero;
	}
	
}