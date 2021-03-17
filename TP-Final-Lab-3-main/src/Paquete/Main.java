package Paquete;

import Genericas.Inventario;
import Intrerfaces.IOperacionesBasicas;

import java.util.Scanner;

import Clases.Agenda;
import Clases.Cliente;
import Clases.Producto;
import Clases.Turno;

public class Main
{

	public static void main(String[] args) throws InterruptedException
	{
		
		Inventario<Producto> producto = new Inventario<Producto>();
		for(int aux = 0; aux < 15; aux++)
		{
			producto.agregar(new Producto());
		}
		String elemento = producto.exportarJSON();
		//System.out.println(elemento);
		System.out.println(producto.exportarJSON());
		//System.out.println(producto.importarJson(elemento));
		//producto.escribir();
		
		Cliente numero1 = new Cliente();
		
		
		
		
		
		Agenda agenda = new Agenda();
		
		for(int aux = 0; aux < 10; aux++)
		{
			agenda.agregar(new Cliente());
		}
		
		//agenda.buscarClientePorDni("").agregar(new Turno());
		//agenda.agregarTurno("", new Turno());
		
		//System.out.println(agenda.listar());
		//System.out.println(agenda.buscarTurnoAgenda(""));
		
		Scanner sn = new Scanner(System.in);
        int opMenu = 0, z = 0; //Variables para controlar el menú.
        int numAux = 0;

        while(z == 0) {
            System.out.println("Bienvenido, por favor, ingrese una de las opciones: \n");
            System.out.println("1- \n2- \n3- \n4- \n5- \n6- \n7- \n0- Salir. . .");
            opMenu = sn.nextInt();
            switch(opMenu) {
            case 1:
            		agenda.agregarTurnoEspecifico(2020, 9, 27, 15, 30, "");
                break;

            case 2:
            		System.out.println(numero1.toString());
                break;

            case 3:
	        		Turno turnito = new Turno();
	        		turnito.setFechaEspecifica(2020, 7, 5, 18, 0);
	        		numero1.agregar(turnito);
                break;

            case 4:
            	System.out.println(agenda.listar());

                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;

            case 0:
                z++;
                System.out.println("Hasta la vista, baby");
            default:
                System.out.println("Por favor, ingrese una opcion correcta. . .\n\n");
            }
        }
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
	

}
