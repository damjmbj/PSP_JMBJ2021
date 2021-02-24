package PSP.CODIFICACION;

/**
 * 
 * @author JMBJ
 *
 */

public class Codificador {

	private static final int DESPLAZAMIENTO_CESAR = 3;
	private static final char A_MAY= 'A';
	private static final char Z_MAY= 'Z';
	private static final char A_MIN= 'a';
	private static final char Z_MIN= 'z';
	

	public static String codifica(String texto) {
		
		StringBuilder cifrado = new StringBuilder();
		
		int code = DESPLAZAMIENTO_CESAR % 26;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) != ' ') {
				if (texto.charAt(i) >= A_MIN && texto.charAt(i) <= Z_MIN) {
					if ((texto.charAt(i) + code) > Z_MIN) {
						cifrado.append((char) (texto.charAt(i) + code - 26));
					} else {
						cifrado.append((char) (texto.charAt(i) + code));
					}
				} else if (texto.charAt(i) >= A_MAY && texto.charAt(i) <= Z_MAY) {
					if ((texto.charAt(i) + code) > Z_MAY) {
						cifrado.append((char) (texto.charAt(i) + code - 26));
					} else {
						cifrado.append((char) (texto.charAt(i) + code));
					}
				}
			} else {
				cifrado.append((char) texto.charAt(i));
			}
		}
		return cifrado.toString();
	}

	public static String decodifica(String texto) {
		
		StringBuilder cifrado = new StringBuilder();
		
		int code = DESPLAZAMIENTO_CESAR % 26;
		
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) != ' ') {
				if (texto.charAt(i) >= A_MIN && texto.charAt(i) <= Z_MIN) {
					if ((texto.charAt(i) - code) < A_MIN ) {
						cifrado.append((char) (texto.charAt(i) - code + 26));
					} else {
						cifrado.append((char) (texto.charAt(i) - code));
					}
				} else if (texto.charAt(i) >= A_MAY && texto.charAt(i) <= Z_MAY) {
					if ((texto.charAt(i) - code) < A_MAY) {
						cifrado.append((char) (texto.charAt(i) - code + 26));
					} else {
						cifrado.append((char) (texto.charAt(i) - code));
					}
				}
			} else {
				cifrado.append((char) texto.charAt(i));
			}
		}
		return cifrado.toString();
	}
}
