package mundo.test;

public class Nodo {
	
	Object cabeza;
	Object siguiente;
	
	public Nodo()
	{
		siguiente = null;
	}

	public Object getCabeza() {
		return cabeza;
	}

	public void setCabeza(Object cabeza) {
		this.cabeza = cabeza;
	}

	public Object getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Object siguiente) {
		this.siguiente = siguiente;
	}
	
	

	
}
