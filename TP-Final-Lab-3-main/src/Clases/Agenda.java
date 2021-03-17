package Clases;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Intrerfaces.IOperacionesBasicas;

public class Agenda implements IOperacionesBasicas<Cliente>, Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cliente> agenda;

	public Agenda()
	{
		this.agenda = new ArrayList<Cliente>();
	}
	
	public void agregarTurno(String dni, Turno nuevoTurno) 
	{
		Cliente clientin = buscarClientePorDni(dni);
		clientin.agregar(nuevoTurno);
	}
	/**
	 * 	Agregar un turno especificando la fecha de manera precisa indicando el anio, mes, dia, hora, minutos
	 * @param anio
	 * @param mes
	 * @param dia
	 * @param hora
	 * @param minuto
	 * @param dni
	 */
	public void agregarTurnoEspecifico(int anio, int mes, int dia, int hora, int minuto, String dni) 
	{
		Cliente clientin = buscarClientePorDni(dni);
		clientin.agregarTurno(anio, mes, dia, hora, minuto);		
	}

	public void eliminarTurno(String dni, int hora)	// Eliminamos un turno desde la agenda
	{
		Cliente clientin = buscarClientePorDni(dni);
		clientin.eliminar(clientin.getTurnoUnico(hora));
	}
	
	public void modificarTurno(String dni, int hora)	//	Modificamos un turno desde la agenda
	{
		Cliente clientin = buscarClientePorDni(dni);
		clientin.modificar(clientin.getTurnoUnico(hora));
	}
	
	@Override
	public void agregar(Cliente elemento)
	{
		if (this.agenda.contains(elemento))
		{
			if (eliminar(elemento))
			{
				this.agenda.add(elemento);
			}
		}
		else
		{
			this.agenda.add(elemento);
		}
	}

	@Override
	public boolean eliminar(Cliente elemento)
	{
		if (!this.agenda.isEmpty())
		{
			if (this.agenda.contains(elemento))
			{
				this.agenda.remove(elemento);
				return true;
			}
		}
		return false;
	}

	@Override
	public void modificar(Cliente elemento)
	{
		if(elemento != null)
		{
			if(this.agenda.contains(elemento))
			{
				int aux = this.agenda.indexOf(elemento);
				this.agenda.add(aux, elemento);
			}
		}
	}

	@Override
	public String listar()
	{
		StringBuilder sb = new StringBuilder();
		for (Cliente aux : agenda)
		{
			sb.append(aux.toString());
		}
		String retorno = sb.toString();
		return retorno;
	}

	@Override
	public boolean buscar(Cliente elemento)
	{
		if (this.agenda.contains(elemento))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj != null)
		{
			if (obj instanceof Cliente)
			{
				for (Cliente aux : agenda)
				{
					if (aux == ((Cliente) obj))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	
	/**
	 * 	Busco un cliente por el dni
	 * @param dni
	 * @return cliente
	 */
	public Cliente buscarClientePorDni(String dni)	//	retorna un NullPointerException
	{
		try {
			if(this.agenda != null)
			{
				for(Cliente aux : agenda)
				{
					int numero = aux.getDni().compareTo(dni);
					if(numero == 0)
					{
						return aux;
					}
				}
			}
		} 
		catch (NullPointerException e) 
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	
	/**
	 *  Primero busco al cliente por el DNI y luego busco el/los turno/s que tenga asociados y los retorno en un String
	 * @param dni
	 * @return listado de/los turnos del cliente
	 */
	public String buscarTurnoAgenda(String dni)
	{
		if(this.agenda != null)
		{
			StringBuilder sb = new StringBuilder();
			Cliente aux = buscarClientePorDni(dni);
			for(Turno turnito : aux.getTurno())
			{
				sb.append(turnito.toString());
			}
			String retorno = sb.toString();
			return retorno;			
		}
		return "Agenda Vacia";
	}
	
	public void escribir()
	{
		String cliente = "cliente: ";
		DataOutputStream dos = null;
		try
		{
			dos = new DataOutputStream(new FileOutputStream("agenda.dat"));
			dos.writeUTF(cliente);
			Cliente clientin = new Cliente();
			for(int aux = 0; aux < 20; aux++)
			{
				dos.writeUTF(clientin.getNombre());
				dos.writeUTF(clientin.getApellido());
				dos.writeUTF(clientin.getDni());
				dos.writeUTF(clientin.getNroTelefono());
				dos.writeUTF(clientin.getDomicilio());
				dos.writeUTF(clientin.getFechaNacimiento());
				dos.writeUTF(clientin.getCorreoElectronico());
				dos.writeUTF(clientin.getTipoTratamiento());
				dos.writeUTF(clientin.listar());
			}				
			dos.close();			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
}
