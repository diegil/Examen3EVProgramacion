package Examen3EV;

/**
 * Al construir un programa java alrededor de esta clase, se crea una localidad, que guarda el nombre y numero de divorcios
 */

public class Localidad implements Comparable<Localidad>{
	private String nombre;
	private int nDivorcios;
	
	public Localidad(String nombre, int nDivorcios) {
		this.nombre = nombre;
		this.nDivorcios = nDivorcios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getnDivorcios() {
		return nDivorcios;
	}

	public void setnDivorcios(int nDivorcios) {
		this.nDivorcios = nDivorcios;
	}
	
	/**
	 * Pre: ---
	 * Post: Ordena la lista en funcion del numero de divorcios de menor a mayor
	 */
	
	@Override
	public int compareTo(Localidad l) {
		if (this.nDivorcios > l.getnDivorcios()) {
			return -1;
		}else if (this.nDivorcios < l.getnDivorcios()) {
			return 1;
		}else {
			return 0;
		}
	}
}