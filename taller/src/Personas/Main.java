package Personas;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	final static int VERMECANICO = 1;
	final static int ANIADIRMECANICO = 2;
	final static int MODIFICARMECANICO = 3;
	final static int ELIMINARMECANICO = 4;
	final static int VERCLIENTES = 5;
	final static int NUEVOCLIENTE = 6;
	final static int MODIFICARCLIENTE = 7;
	final static int VERREPARACIONES = 8;
	final static int SALIR = 0;

	static boolean salir = false;
	public Gestion mecanico = new Gestion();

	public static void main(String[] args) {

		System.out.println("hola");

		Scanner sc = new Scanner(System.in);

		while (!salir) {

			System.out.println("_____________________________________");
			System.out.println("|      BIENVENIDO AL TALLER         |");
			System.out.println("|                                   |");
			System.out.println("|___________________________________|");
			System.out.println("| 1.Ver Mecanicos                   |");
			System.out.println("| 2.Añadir Mecanicos                |");
			System.out.println("| 3.Modificar Mecanico              |");
			System.out.println("| 4.Eliminar Mecanico               |");
			System.out.println("| 5.Ver Clientes                    |");
			System.out.println("| 6.Añadir nuevo Cliente            |");
			System.out.println("| 7.Modificar Cliente               |");
			System.out.println("| 8.Ver Reparaciones                |");
			System.out.println("|___________________________________|");
			System.out.println("| 0. Salir                          |");
			System.out.println("|___________________________________|");
			try {
				int opcion = sc.nextInt();
				
				Clientes cliente = new Clientes();
				Mecanico mecanico = new Mecanico();
			
				
				switch (opcion) {

				case VERMECANICO:

					mecanico.verMecanico();

					break;

				case ANIADIRMECANICO:
					mecanico.nuevoMecanico();

					break;
				case MODIFICARMECANICO:

					mecanico.verMecanico();
					mecanico.modificarMecanico();
					break;

				case ELIMINARMECANICO:

					mecanico.verMecanico();
					mecanico.eliminarMecanico();
					break;
				case VERCLIENTES:

					cliente.verclientes();

					break;
				case NUEVOCLIENTE:

					cliente.nuevoCliente();
					break;
				case MODIFICARCLIENTE:

					cliente.verclientes();
					cliente.modificarCliente();
					break;
				case VERREPARACIONES:
					Gestion reparacion = new Gestion();
					reparacion.reparaciones();
					break;

				case SALIR:
					salir = true;
					System.out.println("FIN DEL PROGRAMA");
					break;

				default:
					System.out.println("ingresar una opcion valida");
				}

			} catch (Exception e) {
				System.out.println("Error, debe ingresar una edad validad");
			}

		}
	}
}
