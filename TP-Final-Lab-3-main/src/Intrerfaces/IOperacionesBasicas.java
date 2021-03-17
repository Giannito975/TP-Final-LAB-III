package Intrerfaces;

public interface IOperacionesBasicas <E>
{
	void agregar(E elemento);
	boolean eliminar(E elemento);
	void modificar(E elemento);
	String listar();
	boolean buscar(E elemento);
}
