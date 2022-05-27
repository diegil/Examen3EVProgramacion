package Examen3EV;

/**
 * Al construir un programa java alrededor de esta clase, se crea una lista simple enlazada, se rellena y se llama a la funcion "eliminarMayor"
 */

public class Ejercicio3 {
	
	/**
	 * Pre: ---
	 * Post: Crea una lista simple enlazada, la rellena y llama al metodo "eliminarMayor" para comprobar
	 */
	
	public static void main(String[] args) {
		SimpleLinkedList l = new SimpleLinkedList();
		Node n0 = new Node(0, null);
		Node n1 = new Node(1, null);
		Node n2 = new Node(10, null);
		Node n3 = new Node(3, null);
		Node n4 = new Node(12, null);
		Node n5 = new Node(5, null);
		l.add(n0);
		l.add(n1);
		l.add(n2);
		l.add(n3);
		l.add(3, n4);
		l.add(n5);
		l.show();
		System.out.println("-----------------");
		l.eliminarMayor();
		l.show();
	}
}