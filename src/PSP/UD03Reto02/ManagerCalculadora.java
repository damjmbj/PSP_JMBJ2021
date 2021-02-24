package PSP.UD03Reto02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class ManagerCalculadora {

	private static Scanner teclado = new Scanner(System.in);
	private static String protocolo = "https://psp2021site.000webhostapp.com/";
	private static String urlEndPoint = "registrarAplicacion.php";
	private static Integer apiKey;
	private static boolean estaRegistrada=false;

	public static void main(String[] args) {

		String calculo;
		String urlphp;

		try {
			URL url = new URL(protocolo + urlEndPoint);
			URLConnection urlCon = url.openConnection();
			urlCon.connect();

			InputStream input = urlCon.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				
				System.out.println(Integer.parseInt(inputLine));
				apiKey = Integer.parseInt(inputLine);
				estaRegistrada=true;
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (apiKey < 0 || !estaRegistrada) {
			System.out.println("Hubo un error a la hora de recoger apiKey : " + apiKey);
		} else {
			TipoOperacion tOperacion = validandoTipo();
			
			int param_A = 0;
			int param_B = 0;
			switch (tOperacion) {
			case SUMA:
				param_A=solicitarEntero("Ingrese el primer parametro a "+tOperacion);
				param_B =solicitarEntero("Ingrese el segundo parametro a "+tOperacion);

				try {

					urlphp = "realizaOperacion.php";
					calculo = "?API_KEY=" + apiKey + "&TIPO_OPERACION=" + tOperacion + "&SUMANDO_A=" +param_A + "&SUMANDO_B="+param_B;
					URL url = new URL(protocolo + urlphp + calculo);
					System.out.println(tOperacion);
					System.out.println(url.toString());
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

				break;

			case RESTA:
				param_A=solicitarEntero("Ingrese el primer parametro a "+tOperacion);
				param_B =solicitarEntero("Ingrese el segundo parametro a "+tOperacion);
				
				try {

					urlphp = "realizaOperacion.php";
					calculo = "?API_KEY=" + apiKey + "&TIPO_OPERACION=" + tOperacion + "&MINUENDO=" +param_A + "&SUSTRAENDO="+param_B;
					URL url = new URL(protocolo + urlphp + calculo);
					System.out.println(tOperacion);
					System.out.println(url.toString());
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
				break;
			case MULTIPLICACION:
				param_A=solicitarEntero("Ingrese el primer parametro a "+tOperacion);
				param_B =solicitarEntero("Ingrese el segundo parametro a "+tOperacion);
				try {

					urlphp = "realizaOperacion.php";
					calculo = "?API_KEY=" + apiKey + "&TIPO_OPERACION=" + tOperacion + "&OPERADOR_1=" +param_A + "&OPERADOR_2="+param_B;
					URL url = new URL(protocolo + urlphp + calculo);
					System.out.println(tOperacion);
					System.out.println(url.toString());
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
				break;
			}

		}

	}

	private static int solicitarEntero(String string) {
		int entero;
		
		System.out.println(string);
		entero = Integer.parseInt(teclado.nextLine());
		return entero;
	}

	public static TipoOperacion validandoTipo() {
		TipoOperacion tOperacion = null;
		String tipoOpercacion;
		boolean tValido = false;
		do {
			tipoOpercacion = solicitarCadena("Ingresa el tipo de operacion |SUMA|RESTA|MULTIPLICACION|");
			tipoOpercacion = tipoOpercacion.toUpperCase();

			switch (tipoOpercacion) {
			case "SUMA":
				tValido = true;
				break;

			case "RESTA":
				tValido = true;
				break;
			case "MULTIPLICACION":
				tValido = true;
				break;
			}
		} while (!tValido);

		if (tValido) {

			tOperacion=tOperacion.valueOf(tipoOpercacion);
		}

		return tOperacion;
	}

	private static String solicitarCadena(String string) {
		String cadena;
		System.out.println(string);
		cadena = teclado.nextLine();
		return cadena;
	}

}
