package Examen3EV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			File f = new File("C:\\Users\\Diego\\Documents\\GS\\Programacion\\HablanosDelDon.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String letra = "l";
			int nLinea = 0; 
			String linea;
			while((linea = br.readLine()) != null) {
				nLinea++;
				linea = linea.replaceAll(",", "").replaceAll("¿", "").replaceAll("\\?", "").replaceAll("\\.", "");
				String[] separador = linea.split(" ");
				for (int i = 0; i <= separador.length - 1; i++) {
					String letraPrincipio = String.valueOf(separador[i].charAt(0));
					String letraFinal = String.valueOf(separador[i].charAt(separador[i].length() - 1));
					if (letra.equalsIgnoreCase(letraPrincipio) || letra.equalsIgnoreCase(letraFinal)) {
						System.out.println("Letra: " + letra + " | Palabra: " + separador[i] + " | Linea: " + nLinea);
					}
				}
				System.out.println("--------------");
			}
		}catch(Exception e) {
			System.out.println(e.fillInStackTrace());
		}
	}
}