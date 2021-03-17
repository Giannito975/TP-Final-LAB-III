package Clases;

import java.util.Calendar;

public class Turno implements Comparable<Turno>
{
	public static final int noExiste = -1;
	public static final int igual = 0;
	public static final int menor = 1;
	public static final int mayor = 2;
	public static final int segundo = 0;
	
	private boolean urgente;
	private Calendar fecha;
	private boolean estado;
	
	public Turno()
	{
		this.urgente = false;
		this.fecha = Calendar.getInstance();
		this.estado = true;
	}
	
	public Calendar getFecha()
	{
		return this.fecha;
	}
	
	public boolean isUrgente()
	{
		return this.urgente;
	}
	
	public boolean isEstado()
	{
		return this.estado;
	}
	
	public void setUrgente()
	{
		if(this.urgente == true)
		{
			this.urgente = false;
		}
		else
		{
			this.urgente = true;
		}
	}
	
	public void setEstado()
	{
		if(this.estado == true)
		{
			this.estado = false;
		}
		else
		{
			this.estado = true;
		}
	}

	public void setFecha(Calendar fecha)
	{
		this.fecha = fecha;
	}
	
	/**
	 * 	Establece una fecha especifica
	 * @param anio
	 * @param mes
	 * @param dia
	 * @param hora
	 * @param minuto
	 */
	public void setFechaEspecifica(int anio, int mes, int dia, int hora, int minuto)
	{
		this.fecha.set(anio, mes, dia, hora, minuto, segundo);
	}
	
	public int getDia()
	{
		return this.fecha.get(Calendar.DATE);
	}
	
	public int getHora()
	{
		return this.fecha.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getMinuto()
	{
		return this.fecha.get(Calendar.MINUTE);
	}
	
	public int getMes()
	{
		return this.fecha.get(Calendar.MONTH);
	}
	
	public int getAnio()
	{
		return this.fecha.get(Calendar.YEAR);
	}
	
	@Override
	public String toString()
	{
		return "\nFecha del Turno: " + getDia() + "/" + getMes() + "/" + getAnio() + " " + getHora() + ":" + getMinuto() + ":" + 00 + "\nEs urgente: " + isUrgente();
	}

	@Override
	public boolean equals(Object obj)	//	Le paso por parametro un objeto del tipo Calendar
	{
		if(obj != null)
		{
			if(obj instanceof Calendar)
			{
				Calendar aux = ((Turno)obj).getFecha();
				if(this.fecha == aux)
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
