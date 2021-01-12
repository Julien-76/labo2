package be.technifutur.java2020.services;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.technifutur.java2020.dto.Album;
import be.technifutur.java2020.dto.Band;
import be.technifutur.java2020.dto.Label;
import be.technifutur.java2020.mapper.Mapper;

public class AlbumService {

	
	 private Mapper mapper;

	    public AlbumService() {
	        this.mapper = new Mapper();
	    }
	
	
	

    public List<Album> selectAll(Connection c) throws SQLException{
		List<Album> output = new ArrayList<>();

        Statement statement = c.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT \"Albums\".\"Name\", \"Bands\".\"Name\", \"Bands\".\"Nationality\", \"Bands\".\"Creation\",\"Bands\".\"Style\",\"Labels\".\"Name\", \"Labels\".\"Nationality\", \"Labels\".\"Creation\", \"Bands\".\"Members\", \"Bands\".\"Albums\", \"Labels\".\"Name\", \"Labels\".\"Nationality\", \"Labels\".\"Creation\", \"Albums\".\"Release_Date\", \"Albums\".\"Style\"\r\n"
        		+ "FROM \"Albums\", \"Labels\", \"Bands\"\r\n"
        		+ "WHERE \"Albums\".\"Band\" = \"Bands\".\"Name\" AND \"Bands\".\"Label\" = \"Labels\".\"Name\""); 
        
        while (resultSet.next()) {
            Album alb = mapper.toDtoAlbum(resultSet);
            output.add(alb);
        }

        return output;
	}
	
    public Album selectByName(Connection c, String name) throws SQLException {
		String requete = "SELECT \"Albums\".\"Name\", \"Bands\".\"Name\", \"Bands\".\"Nationality\", \"Bands\".\"Creation\",\"Bands\".\"Style\",\"Labels\".\"Name\", \"Labels\".\"Nationality\", \"Labels\".\"Creation\", \"Bands\".\"Members\", \"Bands\".\"Albums\", \"Labels\".\"Name\", \"Labels\".\"Nationality\", \"Labels\".\"Creation\", \"Albums\".\"Release_Date\", \"Albums\".\"Style\"\r\n"
        		+ "FROM \"Albums\", \"Labels\", \"Bands\"\r\n"
        		+ "WHERE \"Albums\".\"Name\" = ?"; 
        Album l = null;
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            l = Mapper.toDtoAlbum(resultSet);
        }
        
        return l;
    }

	public void insert(Connection c, Album v) throws SQLException {
		
		String requete = "INSERT INTO \"Albums\" VALUES (?, ?, ?, ?::Date, ?::\"Style\")";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, v.getName());
        preparedStatement.setString(2, v.getBand().getName());
        preparedStatement.setString(3, v.getLabel().getName());
        preparedStatement.setString(4, v.getRelease_Date().toString());
        preparedStatement.setString(5, v.getStyle());

        preparedStatement.executeUpdate();
	}

	public void update(Connection c, Album v, Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

	public void delete(Connection c, String key) throws SQLException {
    	
    	String requete = "DELETE FROM \"Albums\" WHERE \"Name\" = ?";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, key);
        preparedStatement.executeUpdate();
    }

	public void update(Connection c, Album v, String key) throws SQLException {
	/*	String requete = "UPDATE public.Albums SET \"Name\" = ?, \"Band\" = ?, \"Label\" = ?, \"Release_Date\" = ?, \"Style\" =?::style WHERE \"Name\" = ?";
		PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, key);
        preparedStatement.setString(2, v.getBand().toString());
        preparedStatement.setString(3, v.getLabel().toString());
        preparedStatement.setDate(4, (Date) v.getRelease_Date());
        preparedStatement.setString(5, v.getStyle().toString());

        preparedStatement.executeUpdate();*/
	}


	
}
