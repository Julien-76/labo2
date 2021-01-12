package be.technifutur.java2020.services;

import java.sql.Connection;
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

public class BandService {

	private Mapper mapper;

    public BandService() {
        this.mapper = new Mapper();
    }

    public List<Band> selectAll(Connection c) throws SQLException{
		List<Band> output = new ArrayList<>();

        Statement statement = c.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT \"Bands\".\"Name\", \"Bands\".\"Nationality\", \"Bands\".\"Creation\",\"Bands\".\"Style\",\"Labels\".\"Name\", \"Labels\".\"Nationality\", \"Labels\".\"Creation\", \"Bands\".\"Members\", \"Bands\".\"Albums\"\r\n"
        		+ "FROM \"Labels\", \"Bands\"\r\n"
        		+ "WHERE \"Bands\".\"Label\" = \"Labels\".\"Name\""); 
        
        while (resultSet.next()) {
            Band alb = mapper.toDtoBand(resultSet);
            output.add(alb);
        }

        return output;
	}
    
    public Band selectByName(Connection c, String name) throws SQLException {
		String requete = "SELECT \"Bands\".\"Name\", \"Bands\".\"Nationality\", \"Bands\".\"Creation\",\"Bands\".\"Style\",\"Labels\".\"Name\", \"Labels\".\"Nationality\", \"Labels\".\"Creation\", \"Bands\".\"Members\", \"Bands\".\"Albums\"\r\n"
        		+ "FROM \"Labels\", \"Bands\"\r\n"
        		+ "WHERE \"Bands\".\"Name\" = ?";
        Band l = null;
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            l = Mapper.toDtoBand(resultSet);
        }

        return l;
	}
    
    public void insert(Connection c, Band v) throws SQLException {
		String requete = "INSERT INTO \"Bands\" VALUES (?, ?, ?, ?::\"Style\", ?, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, v.getName());
        preparedStatement.setString(2, v.getNationality());
        preparedStatement.setInt(3, v.getCreation());
        preparedStatement.setString(4, v.getStyle());
        preparedStatement.setString(5, v.getLabel().getName());
        preparedStatement.setInt(6, v.getMembers());
        preparedStatement.setInt(7, v.getAlbums());

        preparedStatement.executeUpdate();
	}
	
    public void delete(Connection c, String key) throws SQLException {
    	
    	String requete = "DELETE FROM \"Bands\" WHERE \"Name\" = ?";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, key);
        preparedStatement.executeUpdate();
    }
    
    public void update(Connection c, Band v, String key) throws SQLException {
		/*String requete = "UPDATE public.Labels SET \"Name\" = ?, \"Nationality\" = ?, \"Creation\" = ?, \"Style\" = ?::style, \"Label\" = ?, \"Members\" = ?, \"Albums\" = ? WHERE \"Name\" = ?";
		PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, key);
        preparedStatement.setString(2, v.getNationality());
        preparedStatement.setInt(3, v.getCreation());
        preparedStatement.setString(4, v.getStyle().toString());
        preparedStatement.setString(5, v.getLabel().toString());
        preparedStatement.setInt(6, v.getMembers());
        preparedStatement.setInt(7, v.getAlbums());

        preparedStatement.executeUpdate();*/
	}
}
