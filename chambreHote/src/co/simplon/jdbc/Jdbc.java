package co.simplon.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	private final static String BDPATH = "jdbc:mysql://localhost:3306/mydb";
	private final static String DBUSER = "root";
	private final static String DBPASSWORD = "root";
	
private static Connection connection;
	
	public void connexion() throws ClassNotFoundException, SQLException{
		
		// Load the database driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// Create the jdbc connection
		connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD);
		System.out.println("Connexion OK");

}
	public void insertData(String nom, String prenom, String email, String telephone, String arrivee, String depart, int nuitee, String nbrePersonne, String myradio) throws SQLException
	{
		Statement statement = null;

		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO `chotebdd` (`nom`, `prenom`, `email`, `telephone`, `arrivee`, `depart`,`nbre_de_jours`, `nbrePersonne`,`Type_de_sejour` ) VALUES ('" + nom + "', '" + prenom + "', '" + email + "', '" + telephone + "'"
					+ ", '" + arrivee + "', '" + depart + "', '" + nuitee + "', '" + nbrePersonne + "', '" + myradio + "')";
			statement.executeUpdate(sql);
		}
		catch(SQLException e){
			System.out.println("An error occured trying to insert the new data !");
		}
		finally{	 
			statement.close();
		}
	
		System.out.println();
	}
	
	public void showData() throws SQLException
	{
		Statement statement = null;
		ResultSet rs = null;

		try {
			// Create the statement
			statement = connection.createStatement();
			String sql = "SELECT * FROM chotebdd";
			
			// Execute the query
			rs = statement.executeQuery(sql);
		
			// Loop on the results extracted from the database
			System.out.println("Liste actuelle des réservations :");
			while (rs.next()) {
				System.out.println("  - " + rs.getString("id_reservation") + " : " + rs.getString("nom") + " " +  rs.getString("prenom"));
			}
		}
		catch(SQLException e){
			System.out.println("An error occured trying to read the data !");
		}
		finally{	 
			statement.close();
		}
		
		System.out.println();
	}
}
