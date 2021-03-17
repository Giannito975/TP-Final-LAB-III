package Genericas;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Intrerfaces.IOperacionesBasicas;
import Clases.Producto;;

public class contenedorInventario <E> implements IOperacionesBasicas<E>
{
	private ArrayList<E> inventario;
	
	public contenedorInventario()
	{
		this.inventario = new ArrayList<E>();
	}
	
	@Override
	public void agregar(E elemento)
	{
		this.inventario.add(elemento);		
	}

	@Override
	public boolean eliminar(E elemento)
	{
		
		return false;
	}

	@Override
	public void modificar(E elemento)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listar()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean buscar(E elemento)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isEmpty()
	{
		if(this.inventario.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	public String exportarJSON()
	{
		JSONArray jsonArrayInventario = new JSONArray();
		try
		{
			for(E aux: inventario)
			{
				JSONObject jsonObjectProducto = ((Producto)aux).toJSON();
				jsonArrayInventario.put(jsonObjectProducto);
			}
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		finally
		{
			return jsonArrayInventario.toString();
		}
	}
	
	public String importarJson(String elemento)
	{
		inventario.clear();
		StringBuilder sb = new StringBuilder();
		try
		{
			JSONArray inventarioImportado = new JSONArray(elemento);
			for(int aux = 0; aux < inventarioImportado.length(); aux++)
			{
				JSONObject jsonObject = inventarioImportado.getJSONObject(aux);
				Producto importado = new Producto(jsonObject.getString("tipo"));
				agregar((E) importado);
			}
			for(E aux : inventario)
			{
				sb.append(aux);
			}
		} 
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		finally
		{
			return sb.toString();
		}
	}
	
	public void escribir()
	{
		String producto = "Producto 'X'";
		DataOutputStream dos = null;
		
		try
		{
			dos = new DataOutputStream(new FileOutputStream("inventario.dat"));
			dos.writeUTF(producto);
			Producto pro = new Producto();
			for(int aux = 0; aux < 20; aux++)
			{
				dos.writeUTF(pro.getEfecto());
				dos.writeUTF(pro.getFuncion());
				dos.writeUTF(pro.getParaPieles());
				dos.writeUTF(pro.getTipo());
				dos.writeUTF(pro.getTipoDePiel());
				dos.writeFloat(pro.getPrecio());				
			}
			dos.close();
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
	
	public void leer()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
