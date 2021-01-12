package be.technifutur.java2020.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.technifutur.java2020.dto.Album;
import be.technifutur.java2020.dto.Label;
import be.technifutur.java2020.mapper.Mapper;

public class LabelService {

	 private Mapper mapper;

	    public LabelService() {
	        this.mapper = new Mapper();
	    }
	
	    public List<Label> selectAll(Connection c) throws SQLException{
			List<Label> output = new ArrayList<>();

	        Statement statement = c.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Labels\""); 
	      
	        while (resultSet.next()) {
	            Label alb = mapper.toDtoLabel(resultSet);
	            output.add(alb);
	        }

	        return output;
		}
	    
	    public Label selectByName(Connection c, String name) throws SQLException {
			String requete = "SELECT * FROM \"Labels\" WHERE \"Name\" = ?";
	        Label l = null;
	        PreparedStatement preparedStatement = c.prepareStatement(requete);
	        preparedStatement.setString(1, name);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            l = Mapper.toDtoLabel(resultSet);
	        }

	        return l;
		}
	    
	    public void insert(Connection c, Label v) throws SQLException {
			String requete = "INSERT INTO \"Labels\" VALUES (?, ?, ?)";
	        PreparedStatement preparedStatement = c.prepareStatement(requete);
	        preparedStatement.setString(1, v.getName());
	        preparedStatement.setString(2, v.getNationality());
	        preparedStatement.setInt(3, v.getCreation());

	        preparedStatement.executeUpdate();
		}
	    
	    public void delete(Connection c, String key) throws SQLException {
	    	
	    	String requete = "DELETE FROM \"Labels\" WHERE \"Name\" = ?";
	        PreparedStatement preparedStatement = c.prepareStatement(requete);
	        preparedStatement.setString(1, key);
	        preparedStatement.executeUpdate();
	    }
	    
	    public void update(Connection c, Label v, String key) throws SQLException {
			String requete = "UPDATE public.Labels SET \"Name\" = ?, \"Nationality\" = ?, \"Creation\" = ? WHERE \"Name\" = ?";
			PreparedStatement preparedStatement = c.prepareStatement(requete);
	        preparedStatement.setString(1, key);
	        preparedStatement.setString(2, v.getNationality());
	        preparedStatement.setInt(3, v.getCreation());

	        preparedStatement.executeUpdate();
		}
	
	
}
