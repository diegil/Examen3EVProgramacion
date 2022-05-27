package Examen3EV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Al construir un programa java alrededor de esta clase, se lee un archivo de texto y en funcion de la letra
 * dada como parametro, el programa revisa el texto en busca de las palabras que empiezan o terminan por
 * esa letra y muestra la propia palabra y el numero de la linea en la que se encuentra
 */

public class Ejercicio1 {
	
	/**
	 * Pre: ---
	 * Post: Busca el archivo y lo recorre comprobando palabra por palabra si empieza o acaba con la letra 
	 * dada como parametro, si es el caso, escribe la letra, la palabra y el numero de la linea donde
	 * se encuentra, y depues guarda esos datos en la base de datos
	 */

	public static void main(String[] args) {
		try {
			SQLConnection db = new SQLConnection();
			File f = new File("C:\\Users\\Diego\\Documents\\GS\\Programacion\\HablanosDelDon.txt");   //Busca el archivo en la ruta
			FileReader fr = new FileReader(f);		//Crea el FileReader necesario para el BufferedReader 
			BufferedReader br = new BufferedReader(fr);		//Crea el BufferedReader (uso esto en vez del Scanner porque el scanner
															//dejaba de leer lineas a mitad del archivo)
			String letra = "t";
			int nLinea = 0; 
			String linea;
			while((linea = br.readLine()) != null) {   //Comprueba si hay linea siguiente igualandola a null
				nLinea++;
				linea = linea.replaceAll(",", "").replaceAll("¿", "").replaceAll("\\?", "").replaceAll("\\.", "");  //Reemplaza todos
																													//los signos de puntuacion
				String[] separador = linea.split(" ");	//Separa cada linea en palabras
				for (int i = 0; i <= separador.length - 1; i++) {
					String letraPrincipio = String.valueOf(separador[i].charAt(0));
					String letraFinal = String.valueOf(separador[i].charAt(separador[i].length() - 1));
					if (letra.equalsIgnoreCase(letraPrincipio) || letra.equalsIgnoreCase(letraFinal)) {
						System.out.println("Letra: " + letra + " | Palabra: " + separador[i] + " | Linea: " + nLinea);
						//db.addPalabra(letra, separador[i], nLinea);		//A�ade la palabra a la base de datos
					}
				}
				System.out.println("--------------");
			}
		}catch(Exception e) {
			System.out.println(e.fillInStackTrace());
		}
	}
}