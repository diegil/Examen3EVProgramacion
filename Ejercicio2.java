package Examen3EV;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Al construir un programa java alrededor de esta clase, se lee un archivo csv y te muestra los divorcios que ha habido con separacion previa
 * en 2019, los que habido sin separacion previa en 2018 y la provincia con mas divorcios entre 2013 y 2019
 */

public class Ejercicio2 {
	
	/**
	 * Pre: ---
	 * Post: Busca el archivo y lo recorre comprobando si el año es 2019 y ha habido separacion previa para guardarlo
	 * en una variable, 
	 */

	public static void main(String[] args) {
		try {
			File f = new File("C:\\Users\\Diego\\Documents\\GS\\Programacion\\Divorcios.csv");   //Busca el archivo en la ruta
			Scanner scf = new Scanner(f);	
			int divorciosSeparacion = 0;
			int divorciosSinSeparacion = 0;
			ArrayList<Localidad> localidades = new ArrayList<Localidad>();
			scf.nextLine();
			while(scf.hasNextLine()) {
				String linea = scf.nextLine();
				String[] separador = linea.split(";");
				int contadorPuntos = 0;
				for (int i = 0 ; i <= separador[3].length() - 1; i++) {
					contadorPuntos++;
				}
				if (contadorPuntos > 1) {										//Cuenta la cantidad de puntos en el ultimo campo,
					separador[3] = separador[3].replaceAll("\\.", "0");			//si este es mayor que uno cambia los dos puntos por 0
				}else {															//si es uno cambia el punto por ""
					separador[3] = separador[3].replaceAll("\\.", "");
				}
				int divorcios = Integer.parseInt(separador[3]);
				Localidad localidad = new Localidad(separador[0], divorcios);
				if (localidades.size() == 0) {
					localidades.add(localidad);
				}
				int contador = 0;
				//Comprueba si la localidad esta en la lista, si no esta la añade, pero si esta suma los divorcios
				for (int i = 0; i <= localidades.size() - 1; i++) {
					if (!localidades.get(i).getNombre().equalsIgnoreCase(localidad.getNombre())) {
						contador++;
					}
					if (contador == localidades.size()) {								
						localidades.add(localidad);
					}else if (contador == localidades.size() - 1){
						localidades.get(i).setnDivorcios(localidades.get(i).getnDivorcios() + divorcios);
					}
				}
				if (separador[1].equalsIgnoreCase("si") && separador[2].equals("2019")) {
					divorciosSeparacion += divorcios;
				}else if (separador[2].equals("2018")){
					divorciosSinSeparacion += divorcios;
				}	
			}
			Collections.sort(localidades);
			System.out.println("Divorcios con separacion previa en 2019: " + divorciosSeparacion);
			System.out.println("Divorcios sin separacion previa en 2018: " + divorciosSinSeparacion);
			for (int i = 0 ; i <= localidades.size() - 1; i++) {
				System.out.println(localidades.get(i).getnDivorcios());
			}
			System.out.println("La localidad con mas divorcios entre 2013 y 2019 es: " + localidades.get(0).getNombre());
		}catch(Exception e) {
			System.out.println(e.fillInStackTrace());
		}
		
	}
}