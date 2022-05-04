package Personas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class Gestion {

	static Scanner sc = new Scanner(System.in);

	

	//Metodo ver las reparaciones
	public void reparaciones() throws SQLException {
		
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/taller", "root", "rosario9");
		String sql = "SELECT coche_id,\n"
				+ "mecanico_id,\n"
				+ "fecha_reparacion,\n"
				+ "facturacion\n"
				+ "\n"
				+ "FROM taller.reparacion;";
		PreparedStatement pst = conexion.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		System.out.println("*******************************************************");
		
		System.out.println("*            REPARACIONES DEL TALLER                  *");
		
		System.out.println("*******************************************************");
		
		System.out.println("  Coche" + "   "+ "   Mecanico" +"    "+ "   Fecha reparacion " + "    " +  "   Facturacion");
		
		while (rs.next()) {
			String coche = rs.getString("coche_id");
			int id = rs.getInt("mecanico_id");
			String fecha = rs.getString("fecha_reparacion");
			String facturacion = rs.getString("facturacion");
			

			System.out.print(coche + "        " + id+ "          " + fecha+ "                    " + facturacion);
			System.out.println("");

		} // while

		
	}
}
