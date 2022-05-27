package Examen3EV;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el numero que quieres multiplicar: ");
		int n = sc.nextInt();
		tablaMultiplicar(n, 0);
	}
	
	public static void tablaMultiplicar(int n, int multiplicador) {
		if (multiplicador <= 100) {
			System.out.println(n * multiplicador);
			tablaMultiplicar(n, multiplicador + 2);
		}
	}
}