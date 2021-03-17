package Paquete;

import java.util.Calendar;

public class Turno implements Comparable<Turno>
{
	public static int noExiste = -1;
	public static int igual = 0;
	public static int menor = 1;
	public static int mayor = 2;
	
	private boolean urgente;
	private Calendar fecha;
	
	public Turno()
	{
		this.urgente = false;
		this.fecha = Calendar.getInstance();
	}
	
	public Turno(boolean urgente)
	{
		this.urgente = urgente;
		this.fecha = Calendar.getInstance();
	}
	
	public Calendar getFecha()
	{
		return fecha;
	}
	
	public boolean isUrgente()
	{
		return urgente;
	}
	
	public void setUrgente(boolean urgente)
	{
		this.urgente = urgente;
	}
	
	public void setFecha(Calendar fecha)
	{
		this.fecha = fecha;
	}
	
	@Override
	public String toString()
	{
		return "Fecha del Turno: " + getFecha() + "\nEs urgente: " + isUrgente();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj != null)
		{
			if(obj instanceof Calendar)
			{
				Calendar aux = ((Turno)obj).getFecha();
				if((this.fecha = aux) != null)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Turno obj)
	{
		if(obj != null)
		{
			if(this.fecha.after(obj.getFecha()))
			{
				return mayor;
			}
			if(this.fecha.before(obj.getFecha()))
			{
				return menor;
			}
			if(this.fecha.equals(obj.getFecha()))
			{
				return igual;
			}
		}
		return noExiste;
	}
	
	
	


	
}
