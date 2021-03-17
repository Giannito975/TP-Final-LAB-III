package Paquete;

import java.util.Calendar;

public class Producto implements Runnable
{
	private Calendar fecha;
	
	public Producto()
	{
		this.fecha = Calendar.getInstance();
	}
	
	@Override
	public void run()
	{
		System.out.println("");
		System.out.println(fecha.getTime());
	}
	

}
