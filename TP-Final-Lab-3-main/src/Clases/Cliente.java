package Clases;

import java.util.ArrayList;
import java.util.Collections;

import Intrerfaces.IOperacionesBasicas;

public class Cliente extends Persona implements IOperacionesBasicas<Turno>
{
	private String tipoTratamiento;
	private ArrayList<Turno> turno;
	
	public Cliente()
	{
		super();
		this.tipoTratamiento = "";
		this.turno = new ArrayList<Turno>();
	}
	
	public Cliente(String nombre, String apellido, String fechaNacimiento, char sexo, String domicilio, String correoElectronico, String dni, String nroTelefono, String tratamiento)
	{
		super(nombre, apellido, fechaNacimiento, sexo, domicilio, correoElectronico, dni, nroTelefono);
		this.tipoTratamiento = tratamiento;
		this.turno = new ArrayList<Turno>();
	}
	
	/**
	 * Agregar al ArrayList de Turnos, un turno especificando la fecha en la que se va a registrar dicho turno
	 * 
	 * @param anio
	 * @param mes
	 * @param dia
	 * @param hora
	 * @param minuto
	 */
	public void agregarTurno(int anio, int mes, int dia, int hora, int minuto)
	{
		Turno turnito = new Turno();
		agregar(turnito);
		int aux = this.turno.size();
		aux = aux - 1;
		turno.get(aux).setFechaEspecifica(anio, mes, dia, hora, minuto);
	}
	
	public Turno getTurno(Turno elemento)	//	Retorna un NullPointerException
	{
		if(buscar(elemento))
		{
			int numero = this.turno.indexOf(elemento);
			return this.turno.get(numero);
		}
		return null;
	}
	
	public ArrayList<Turno> getTurno()
	{
		return this.turno;
	}
	
/**
 * 	Se busca un turno que tenga la misma hora que se le pasa por parametro
 * @param un numero dentro de la franja horaria
 * @return retorna el turno adecuado
 */
	public Turno getTurnoUnico(int hora)
	{
		if(!this.turno.isEmpty())
		{
			for(int aux = 0; aux < this.turno.size(); aux++)
			{
				if(this.turno.get(aux).getHora() == hora)
				{
					return this.turno.get(aux);
				}
			}
		}
		return null;
	}
	
	public String getTipoTratamiento()
	{
		return tipoTratamiento;
	}
	
	public void setTipoTratamiento(String tipoTratamiento)
	{
		this.tipoTratamiento = tipoTratamiento;
	}

	@Override
	public String listar()
	{
		StringBuilder sb = new StringBuilder();
		for(Turno aux : turno)
		{
			sb.append(aux.toString());
		}
		String retorno = sb.toString();
		return retorno;				
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "Tipo de Tratamiento: " + getTipoTratamiento() + listar() + "\n-------------------------------------";
	}
	
	@Override
	/**
	 * 	Agrega un turno ordenado de manera descendente al ArrayList de Turnos
	 */
    public void agregar(Turno elemento) // Lanza un ClassCastException / UnsupportedOperationException // IllegalArgumentException
    {
        this.turno.add(elemento);
        try 
        {
            Collections.sort(turno);
        } 
        catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException e) 
        {
            System.out.println(e.getMessage());
            try 
            {
                Collections.reverse(turno);
            } 
            catch (UnsupportedOperationException x) 
            {
                System.out.println(x.getMessage());
            }
        }
    }

	@Override
	public boolean eliminar(Turno elemento)
	{
		if(!this.turno.isEmpty())
		{
			if(this.turno.contains(elemento))
			{
				this.turno.remove(elemento);
				return true;
			}
		}
		return false;
	}

	@Override
	public void modificar(Turno elemento)
	{
		if(elemento != null)
		{
			if(this.turno.contains(elemento))
			{
				int aux = this.turno.indexOf(elemento);
				this.turno.add(aux, elemento);
			}
		}
	}

	@Override
	public boolean buscar(Turno elemento)
	{
		if(elemento != null)
		{
			if(this.turno.contains(elemento))
			{
				return true;
			}
		}
		return false;
	}
	
	public String getDni()
	{
		return super.getDni();
	}
	
	
}
