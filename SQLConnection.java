package Examen3EV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Al construir un programa java alrededor de esta clase java se conecta con la base de datos del juego y te permite 
 * añadir nuevas entradas y jugar
 */

public class SQLConnection {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	final private String host = "localhost:3306/stranded";
	final private String user = "usr_adm";
	final private String passwd = "admin";
	
	/**
	 * Pre: ---
	 * Post: Te permite añadir nuevos avatares
	 */
	
	public void addAvatar() {
		try {
			int contador = 1; //Variable que guardara la cantidad de datos de la tabla
			Scanner sc = new Scanner(System.in);  
			Class.forName("com.mysql.jdbc.Driver");  //Importa el driver JDBC
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "?"             //
												+ "user=" + user + "&password=" + passwd); //Se conecta a la base de datos
			System.out.print("Escribe el nombre del avatar > ");
			String nombre = sc.nextLine();
			System.out.print("Escribe la vida del avatar > ");
			int vida = sc.nextInt();
			preparedStatement = connect.prepareStatement("insert into avatares(id, nombre, vida) "  //
														 + "values (?, ?, ?)");                    //Ejecuta la consulta
			statement = connect.createStatement();                          //
			resultSet = statement.executeQuery("select * from avatares");      // Crea otra consulta para saber cuantos datos hay
			while (resultSet.next()) {
				contador++;
			}
			preparedStatement.setInt(1, contador);
			preparedStatement.setString(2, nombre);   //Introduce los datos del Avatar
			preparedStatement.setInt(3, vida);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Escribe los datos guardados en resultSet
	 */

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
		   int id = resultSet.getInt(1);
		   String nombre = resultSet.getString(2);
		   System.out.print("\t- [" + id + "] ");
		   System.out.println(nombre);
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Cierra todas las conexiones abiertas
	 */
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			} if (statement != null) {
				statement.close();
			} if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {}
	}
}
