package be.technifutur.java2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import be.technifutur.java2020.dto.Album;
import be.technifutur.java2020.services.AlbumService;

public class TestConnection {

	public static void main(String[] args) {
		
		
		System.out.println("On va y arriver");
		String DBUrl = "jdbc:postgresql://localhost/Labo2";
		
		try (Connection connection = DriverManager.getConnection(DBUrl, "postgres", "19410719")) {
            System.out.println("Connexion réussie bordel de merde ! !");
            afficheMembers(connection);
        } catch (SQLException e) {
            arret(e.getMessage());
        }

	}
	
	private static void arret(String message) {
        System.err.println(message);
        System.exit(99);
    }

	
	public static void afficheAlbums(Connection connection) throws SQLException {
     
        Statement statement = connection.createStatement();
       
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Albums\"");

        while (resultSet.next()) {
            System.out.println("\"" + resultSet.getString("Name") + "\" du groupe \"" + resultSet.getString("Band") + "\" sous le label " + 
            		resultSet.getString("Label") + " sorti le " + resultSet.getDate("Release_Date") +
            		". Style : " + resultSet.getString("Style"));
        }
    }
	
public static void insertAlbum(Connection connection) throws SQLException {
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("INSERT INTO \"Albums\" VALUES ('Phantom Antichrist', 'Kreator', 'Nuclear Blast', '2012-06-01', 'Thrash')");
	    
			System.out.println("L'album a bien été ajouté");
	}
	
	public static void insertLabel(Connection connection) throws SQLException {
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("INSERT INTO \"Labels\" VALUES ('Columbia Records', 'USA', '1987')");
	    
			System.out.println("Le Label a bien été ajouté");
	}
	
	public static void insertBand(Connection connection) throws SQLException {
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("INSERT INTO \"Bands\" VALUES ('Kreator', 'Germany', '1982', 'Thrash', 'Columbia Records', '4', '14')");
	    
			System.out.println("Le groupe a bien été ajouté");
	}
	
	public static void insertMember(Connection connection) throws SQLException {
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("INSERT INTO \"Members\" VALUES ('Lamarche', 'Thierry', 'Bass', '1969-02-18', 'Belgium', '38')");
	    
			System.out.println("Le membre a bien été ajouté");
	}
	
	public static void deleteLabel(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("DELETE FROM \"Labels\" WHERE \"Name\" = ''");
	}
	
	public static void deleteAlbum(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("DELETE FROM \"Albums\" WHERE \"Name\" = 'Phantom Antichrist'");
	}
	
	public static void deleteBand(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("DELETE FROM \"bands\" WHERE \"Name\" = ''");
	}
	
	public static void deleteMember(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("DELETE FROM \"Members\" WHERE \"ID_Member-\" = ''");
	}
	
	public static void capasse(Connection c) throws SQLException {
		AlbumService albumService = new AlbumService();
		List<Album> maliste = albumService.selectAll(c);
		System.out.println(maliste.get(1));
	}
	
	public static void afficheMembers(Connection c) throws SQLException{
		Statement statement = c.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Members\"");
		
		while (resultSet.next()) {
            System.out.println("\"" + resultSet.getString("Name") + " " + resultSet.getString("First_Name") + "\" joue de la " + 
            		resultSet.getString("Role") + " et son annif c'est le " + resultSet.getDate("Birthdate") +
            		". Il vient de " + resultSet.getString("Origin"));
		}
	}
}
