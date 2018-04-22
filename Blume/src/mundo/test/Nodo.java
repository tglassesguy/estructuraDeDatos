package mundo.test;

import java.io.Serializable;

public class Nodo<T> implements Serializable {
	
	private static final long serialVersionUID = -5399605122490343339L;
	
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
