package Paquete;

public interface operacionesBasicas <E>
{
	void agregar(E elemento);
	boolean eliminar(E elemento);
	void modificar(E elemento);
	String listar();
	E buscar(E elemento);
}
