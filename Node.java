package Examen3EV;

/**
 * Al construir un programa java alrededor de esta clase, se crea una un nodo
 */

public class Node {
	private int content;
	private Node next;
	
	public Node (int content, Node next) {
		this.content = content;
		this.next = next;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		if (next != null) {
			return "Node [content=" + content + ", next=" + next.getContent() + "]";
		}else {
			return "Node [content=" + content + ", next=null]";
		}
	}
}