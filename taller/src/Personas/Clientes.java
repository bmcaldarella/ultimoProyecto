package Personas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// metodo para ver los clientes
public class Clientes {
	static Scanner sc = new Scanner(System.in);

	public void verclientes() {

		try {

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller", "root", "rosario9");
			String sql = "SELECT cliente_id,\n" + "nombre,\n" + "apellidos,\n" + "numero_cliente,\n" + "coche_id\n"
					+ "\n" + " FROM taller.clientes;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("");
			System.out.println("*****************************************************************************");
			System.out.println("*                             CLIENTES                                      *");
			System.out.println("*****************************************************************************");
			System.out.println("ID" + "       " + "Nombre" + "       " + " Apellidos" + "              " + " NumCliente"
					+ "   " + "  Coche ID ");

			while (rs.next()) {
				int id = rs.getInt("cliente_id");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String numero = rs.getString("numero_cliente");
				int coche = rs.getInt("coche_id");

				System.out.print(id + "        " + nombre + "             " + apellidos + "                 " + numero
						+ "           " + coche);
				System.out.println("");

			} // while

		} catch (Exception e) {

			System.out.println("Hemos tenido un problema");
			e.printStackTrace();
		}

	}

//metodo para crear los clientes
	public void nuevoCliente() {
		try {

			System.out.println("Ingrese el nuevo ID del Cliente");
			int id = sc.nextInt();

			System.out.println("ingrese el nombre del Cliente");
			String nombre = sc.next();
			System.out.println("Ingrese los apellidos del cliente");
			String apellidos = sc.next();
			System.out.println("Numero de Telefono");
			String telefono = sc.next();
			System.out.println("Ingrese el id de su coche");
			int idCoche = sc.nextInt();

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller", "root", "rosario9");
			String sql = "INSERT INTO `taller`.`clientes` (`cliente_id`, `nombre`, `apellidos`, `numero_cliente`, `coche_id`) VALUES (?,?,?,?,?);\n"
					+ "";
			PreparedStatement pst = conexion.prepareStatement(sql);

			pst.setInt(1, id);
			pst.setString(2, nombre);
			pst.setString(3, apellidos);
			pst.setString(4, telefono);
			pst.setInt(5, idCoche);
			int affectedRows = pst.executeUpdate();

			System.out.println("DATOS CREADOS CORRECTAMENTE");

		} catch (Exception e) {

			System.out.println("Hemos tenido un problema");
			e.printStackTrace();
		}

	}

	// metodo para modificar los clientes
	public void modificarCliente() throws SQLException {
		boolean salir = false;

		do {
			try {
				System.out.println("");
				System.out.println("------------------------------------------------------------------------------");

				System.out.println("Introduce el ID del Cliente que desea modificar");
				int id = sc.nextInt();

				System.out.println("Nombre del Cliente");
				String nombre = sc.next();
				System.out.println("Apellidos del Cliente");
				String apellidos = sc.next();
				System.out.println("Numero de telefono del Cliente");
				String telefono = sc.next();
				System.out.println("Introduce el ID del coche ");
				int cocheId = sc.nextInt();

				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller", "root",
						"rosario9");
				String sql = "UPDATE `clientes` SET `nombre` = ?, `apellidos` = ?,`numero_cliente` = ? ,`coche_id` = ? WHERE (`cliente_id` = ?);";
				PreparedStatement pst = conexion.prepareStatement(sql);

				pst.setString(1, nombre);
				pst.setString(2, apellidos);
				pst.setString(3, telefono);
				pst.setInt(4, cocheId);
				pst.setInt(5, id);

				int filasCambiadas = pst.executeUpdate();

				if (filasCambiadas == 1) {
					salir = true;
					System.out.println("CLIENTE MODIFICADO CON EXITO");

				} else {
					salir = false;
					System.out.println("Error, no hay Clientes  con ese ID " + id);
				}

			} catch (Exception e) {

				System.out.println("Hemos tenido un problema");
				e.printStackTrace();
			}

		} while (salir == false);
	}

}
