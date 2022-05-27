package Examen3EV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Al construir un programa java alrededor de esta clase java se conecta con la base de datos de las palabras y
 * todos los datos de las mismas
 */

public class SQLConnection {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	final private String host = "localhost:3306/palabras";
	final private String user = "usr_adm";
	final private String passwd = "admin";
	
	/**
	 * Pre: ---
	 * Post: Añade las palabras a la base de datos
	 */
	
	public void addPalabra(String letra, String palabra, int linea) {
		try {
			int contador = 1; //Variable que guardara la cantidad de datos de la tabla (id)
			Class.forName("com.mysql.jdbc.Driver");  //Importa el driver JDBC
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "?"
												+ "user=" + user + "&password=" + passwd); //Se conecta a la base de datos
			preparedStatement = connect.prepareStatement("insert into palabra(id, letra, palabra, linea) "  //
														 + "values (?, ?, ?, ?)");                    //Ejecuta la consulta
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from palabra");      // Crea otra consulta para saber cuantos datos hay
			while (resultSet.next()) {
				contador++;
			}
			preparedStatement.setInt(1, contador);
			preparedStatement.setString(2, letra);   //Introduce los datos de la palabra
			preparedStatement.setString(3, palabra);
			preparedStatement.setInt(4, linea);
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
