package Examen3EV;

/**
 * Al construir un programa java alrededor de esta clase, se crea una lista simple enlazada
 */

public class SimpleLinkedList {
	private Node first;
	private int size;
	
	public SimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public SimpleLinkedList(Node first) {
		this.first = first;
		this.size = 1;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Pre: ---
	 * Post: Añade un nodo nuevo a la lista
	 */
	
	public boolean add(Node node) {
		try {
			if (size == 0) {
				first = node;
			}else {
				Node p = first;
				for (int i = 1; i <= size - 1; i++) {
					p = p.getNext();
				}
				p.setNext(node);
			}
			size++;
			return true;
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Añade un nodo nuevo en la posicion indicada
	 */
	
	public boolean add(int position, Node node) {
		try {
			if (position == 0) {
				node.setNext(first);
				first = node;
				size++;
				return true;
			}else if (position == size) {
				return add(node);
			}else {
				Node p = first;
				for (int i = 1; i <= position - 1; i++) {
					p = p.getNext();
				}
				node.setNext(p.getNext());
				p.setNext(node);
				size++;
				return true;
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Elimina el nodo de la posicion indicada
	 */
	
	public boolean delete(int index) {
		try {
			if (index == 0) {
				first = first.getNext();
				size--;
				return true;
			}else if (index == size - 1) {
				Node p = first;
				for (int i = 1; i <= index - 1; i++) {
					p = p.getNext();	
				}
				p.setNext(null);
				size--;
				return true;
			}else {
				Node p = first;
				for (int i = 1; i <= index - 1; i++) {
					p = p.getNext();
				}
				p.setNext(p.getNext().getNext());
				size--;
				return true;
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Devuelve el nodo de la posicion indicada
	 */
	
	public Node get(int index) {
		try {
			if (size == 0 || index > size || index < 0) {
				return null;
			}else {
				Node p = first;
				for (int i = 0; i <= index - 1; i++) {
					p = p.getNext();
				}
				return p;
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Eliminar el nodo mayor de la lista
	 */
	
	public boolean eliminarMayor() {
		try {
			if (size == 0) {
				return false;
			}else {
				Node p = first;
				int index = 0;
				int max = p.getContent();
				for (int i = 0; i <= size - 1; i++) {
					if (max < p.getContent()) {
						max = p.getContent();
						index = i;
					}
					p = p.getNext();
				}
				delete(index);
				return true;
			}
		}catch(Exception e) {
			System.out.println(e.fillInStackTrace());
			return false;
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Muestra el contenido de todos los nodos de la lista
	 */
	
	public void show() {
		Node p = first;
		for (int i = 0; i <= size - 1; i++) {
			System.out.println("[" + i + "] -> " + p.getContent());
			p = p.getNext();
		}
	}
}