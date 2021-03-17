package Clases;

import org.json.JSONException;
import org.json.JSONObject;

public class Producto 
{
	private String tipo;
	private String funcion;
	private String tipoDePiel;
	private String paraPieles;
	private String efecto;
	private float precio;
	
	public Producto()
	{
		this.tipo = "";
		this.funcion = "";		
		this.tipoDePiel = "";
		this.paraPieles = "";
		this.efecto = "";
		this.precio = 0;
	}
	
	public Producto(String tipo, String funcion, String tipoDePiel, String paraPieles, String efecto, float precio)
	{
		super();
		this.tipo = tipo;
		this.funcion = funcion;
		this.tipoDePiel = tipoDePiel;
		this.paraPieles = paraPieles;
		this.efecto = efecto;
		this.precio = precio;
	}
	
	public Producto(String tipo)
	{
		this.tipo = tipo;
		this.funcion = "";		
		this.tipoDePiel = "";
		this.paraPieles = "";
		this.efecto = "";
		this.precio = 0;
	}

	public String getEfecto()
	{
		return efecto;
	}
	public String getFuncion()
	{
		return funcion;
	}
	public String getParaPieles()
	{
		return paraPieles;
	}
	public float getPrecio()
	{
		return precio;
	}
	public String getTipo()
	{
		return tipo;
	}
	public String getTipoDePiel()
	{
		return tipoDePiel;
	}
	
	public void setEfecto(String efecto)
	{
		this.efecto = efecto;
	}
	public void setFuncion(String funcion)
	{
		this.funcion = funcion;
	}
	public void setParaPieles(String paraPieles)
	{
		this.paraPieles = paraPieles;
	}
	public void setPrecio(float precio)
	{
		this.precio = precio;
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public void setTipoDePiel(String tipoDePiel)
	{
		this.tipoDePiel = tipoDePiel;
	}
	
	public JSONObject toJSON() throws JSONException
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tipo", getTipo());
		jsonObject.put("funcion", getFuncion());
		jsonObject.put("tipoDePiel", getTipoDePiel());
		jsonObject.put("paraPieles", getParaPieles());
		jsonObject.put("efecto", getEfecto());
		jsonObject.put("precio", getPrecio());
		return jsonObject;
	}
	/**
	 * Excepciones que hay en JSON: Solo hay una sola que es JSONException. En JSONObject se puede lanzar al pasarle un null al .put, 
	 * tambien por pasarle una clave incorrecta, que no exista dentro de la clase o que no sea del mismo tipo. 
	 * En JSONArray se puede lanzar al acceder a un indice que no es valido o cuando accedemos a una posicion que nos da null
	 * Tambien al crear los objectos del tipos JSON, si a un JSONObject le pasamos al constructor un String que es del tipo de JSONArray, nos tira una exception
	 * y viceversa tambien
	 */

	@Override
	public String toString()
	{
		return "Efecto" + getEfecto() + "Funcion" + getFuncion() + "ParaPieles"	+ getParaPieles() + "Precio" + getPrecio() + "Tipo" + getTipo() + "TipoDePiel"	+ getTipoDePiel() + "\n";
	}
	

}
