package Personas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//metodo para ver los mecanicos
public class Mecanico {
	static Scanner sc = new Scanner(System.in);

	public void verMecanico() {
		try {

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller", "root", "rosario9");
			String sql = "SELECT \n" + "mecanico_id,\n" + "nombre,\n" + "apellidos,\n" + "dni\n"

					+ "FROM taller.mecanico;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println("");
			System.out.println("*****************************************************************************");
			System.out.println("*                             MECANICOS                                     *");
			System.out.println("*****************************************************************************");
			System.out.println("ID" + "       " + "Nombre" + "       " + " Apellidos" + "              " + " DNI");
			while (rs.next()) {
				int id = rs.getInt("mecanico_id");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String dni = rs.getString("dni");

				System.out.print(id + "        " + nombre + "          " + apellidos + "                    " + dni);
				System.out.println("");

			} // while

		} catch (Exception e) {

			System.out.println("Hemos tenido un problema");
			e.printStackTrace();
		}

	}

//metodo para crear un nuevo mecanico
	public void nuevoMecanico() {
		try {

			System.out.println("Ingrese el nuevo ID del Mecanico");
			int id = sc.nextInt();
			System.out.println("Ingrese el DNI del Mecanico");
			String dni = sc.next();
			System.out.println("ingrese el nombre del Mecanico");
			String nombre = sc.next();
			System.out.println("Ingrese los apellidos del Mecanico");
			String apellidos = sc.next();
			System.out.println("Numero de Telefono");
			String telefono = sc.next();

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller", "root", "rosario9");
			String sql = "INSERT INTO `taller`.`mecanico` (`mecanico_id`, `dni`, `nombre`, `apellidos`, `numero_telefono`) VALUES (?, ?, ?, ?, ?);\n"
					+ "";
			PreparedStatement pst = conexion.prepareStatement(sql);

			pst.setInt(1, id);
			pst.setString(2, dni);
			pst.setString(3, nombre);
			pst.setString(4, apellidos);
			pst.setString(5, telefono);
			int affectedRows = pst.executeUpdate();

			System.out.println("DATOS CREADOS CORRECTAMENTE" + affectedRows);

		} catch (Exception e) {

			System.out.println("Hemos tenido un problema");
			e.printStackTrace();
		}

	}

//metodo para modificar un mecanico
	public void modificarMecanico() throws SQLException {
		boolean salir = false;

		do {
			try {
				System.out.println("");
				System.out.println("------------------------------------------------------------------------------");

				System.out.println("Introduce el ID del mecanico que desea modificar");
				int id = sc.nextInt();
				System.out.println("DNI del mecanico");
				String dni = sc.next();
				System.out.println("Nombre del Mecanico");
				String nombre = sc.next();
				System.out.println("Apellidos del Mecanico");
				String apellidos = sc.next();
				System.out.println("Numero de telefono del Mecanico");
				String telefono = sc.next();

				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller", "root",
						"rosario9");
				String sql = "UPDATE `taller`.`mecanico` SET `dni` = ?, `nombre` = ?, `apellidos` = ?,`numero_telefono` = ? WHERE (`mecanico_id` = ?);";
				PreparedStatement pst = conexion.prepareStatement(sql);

				pst.setString(1, dni);
				pst.setString(2, nombre);
				pst.setString(3, apellidos);
				pst.setString(4, telefono);
				pst.setInt(5, id);

				int filasCambiadas = pst.executeUpdate();

				if (filasCambiadas == 1) {
					salir = true;
					System.out.println("MECANICO MODIFICADO CON EXITO");

				} else {
					salir = false;
					System.out.println("Error, no hay Mecanicos con ese ID " + id);
				}

			} catch (Exception e) {

				System.out.println("Hemos tenido un problema");
				e.printStackTrace();
			}

		} while (salir == false);
	}

//eliminar los mecanicos
	public void eliminarMecanico() {
		boolean salir = false;

		do {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller", "root",
						"rosario9");

				String sql = "DELETE FROM `taller`.`mecanico` WHERE (`mecanico_id` = ?);";
				System.out.println("");
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("INGRESE EL ID DEL MECANICO QUE DESEE ELIMINAR");
				int eliminar = sc.nextInt();

				PreparedStatement pst = conexion.prepareStatement(sql);

				pst.setInt(1, eliminar);

				int filasCambiadas = pst.executeUpdate();

				if (filasCambiadas == 1) {
					salir = true;
					System.out.println("MECANICO CON ID" + "  s" + eliminar + "ELIMINADO CORRECTAMENTE");
				} else {
					salir = false;
					System.out.println("ERROR, VOLVER A INTENTARLO");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (salir == false);

	}
}
