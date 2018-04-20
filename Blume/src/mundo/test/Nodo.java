package mundo.test;

public class Nodo<T> {
	
	T valor;
	Nodo<T> siguiente;
	
	public Nodo()
	{
		siguiente = null;
	}
	
	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
	
}
