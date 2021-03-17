package Genericas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import Intrerfaces.IOperacionesBasicas;

public class contenedorCliente <E> implements IOperacionesBasicas<E>
{

	private ArrayList <E> cliente;
	
	public contenedorCliente()
	{
		this.cliente = new ArrayList<E>();
	}
	
	@Override
	public void agregar(E elemento)
	{
		this.cliente.add(elemento);		
	}

	@Override
	public boolean eliminar(E elemento)
	{
		if(!cliente.isEmpty())
		{
			if(this.cliente.contains(elemento))
			{
				this.cliente.remove(elemento);
				return true;
			}
		}
		return false;
	}

	@Override
	public void modificar(E elemento)
	{
		
	}

	@Override
	public String listar()
	{
		StringBuilder sb = new StringBuilder();
		for(E aux : cliente)
		{
			sb.append(aux);
		}
		String retorno = sb.toString();
		return retorno;
	}

	@Override
	public boolean buscar(E elemento)	
	{
		for(E aux : cliente)
		{
			if(aux.equals(elemento))
			{
				return true;
			}
		}
		return false;
	}

}
