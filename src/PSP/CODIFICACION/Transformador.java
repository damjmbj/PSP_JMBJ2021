package PSP.CODIFICACION;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author JMBJ
 *
 */
public class Transformador {

	private static final String ARCHIVO_TXT = "prueba.txt";
	private static final String ARCHIVO_TXT_CODIFICADO = "pruebaCodificado.txt";
	private static final String ARCHIVO_TXT_DESCODIFICADO = "pruebaDescodificado.txt";

	public static void main(String[] args) {

		File archivo = new File(ARCHIVO_TXT);

		leerYCodificar(archivo);
		System.out.println("Se a leido y codificado CORRECTAMENTE");
		leerYDescodificar(archivo);
		System.out.println("Se a leido y descodificado CORRECTAMENTE");

	}

	private static void leerYCodificar(File archivo) {

		try (BufferedReader br = new BufferedReader(new FileReader(archivo));
				BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_TXT_CODIFICADO))) {

			String texto;

			texto = br.readLine();
			while (texto != null) {
				bw.write(Codificador.codifica(texto) + "\n");

				texto = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al leer el fichero " + e.getMessage());
		}
	}

	private static void leerYDescodificar(File archivo) {
		try (BufferedReader br = new BufferedReader(new FileReader(archivo));
				BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_TXT_DESCODIFICADO))) {

			String texto;

			texto = br.readLine();
			while (texto != null) {
				bw.write(Codificador.decodifica(texto) + "\n");
				texto = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al leer el fichero " + e.getMessage());
		}
	}
}
