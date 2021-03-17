package Paquete;

import java.util.HashSet;
import java.util.Iterator;

public class Cliente extends Persona
{
	private String tipoTratamiento;
	private HashSet<Turno> turno;
	
	public Cliente()
	{
		this.tipoTratamiento = "";
		this.turno = new HashSet<Turno>();
	}
	
	public Cliente(String tratamiento)
	{
		this.tipoTratamiento = tratamiento;
		this.turno = new HashSet<Turno>();
	}
	
	public Cliente(String tratamiento, boolean urgente)
	{
		this.tipoTratamiento = tratamiento;
		this.turno = new HashSet<Turno>();
	}
	
	public String getTipoTratamiento()
	{
		return tipoTratamiento;
	}
	
	public Turno getTurno() // Lanza un Null Pointer Exception
    {
        try {
            Iterator<Turno> it = this.turno.iterator();
            while (it.hasNext()) {
                return it.next();
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

	
	public Turno getTurno(Turno turno) // Lanza un Null Pointer Exception
    {
        try {
            Iterator<Turno> it = this.turno.iterator();
            while (it.hasNext()) {
                if (turno.equals(it.next())) {
                    return it.next();
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
	
	public void setTipoTratamiento(String tipoTratamiento)
	{
		this.tipoTratamiento = tipoTratamiento;
	}
	
	public void agregarTurno(Turno turno)
	{
		this.turno.add(turno);
	}
	
	public String listar()
	{
		StringBuilder sb = new StringBuilder();
		Iterator<Turno> it = this.turno.iterator();
		while(it.hasNext())
		{
			sb.append(it.next());
		}
		String retorno = sb.toString();
		return retorno;				
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "Tipo de Tratamiento: " + getTipoTratamiento() + listar();
	}
}
