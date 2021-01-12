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
import be.technifutur.java2020.dto.Member;
import be.technifutur.java2020.mapper.Mapper;

public class MemberService {

	private Mapper mapper;

    public MemberService() {
        this.mapper = new Mapper();
    }

    public List<Member> selectAll(Connection c) throws SQLException{
		List<Member> output = new ArrayList<>();

        Statement statement = c.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT*\r\n"
        		+ "FROM \"Members\"\r\n"
        		+ "ORDER BY \"ID_Member\" ASC"); 
        while (resultSet.next()) {
            Member alb = mapper.toDtoMember(resultSet);
            output.add(alb);
        }
        System.out.println(output.get(2));
        return output;
	}
    
    public Member selectByID(Connection c, int key) throws SQLException {
		String requete = "SELECT * FROM \"Members\" WHERE \"Members\".\"ID_Member\" = ?";
        Member l = null;
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setInt(1, key);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            l = Mapper.toDtoMember(resultSet);
        }

        return l;
	}
    
    public void insert(Connection c, Member v) throws SQLException {
		String requete = "INSERT INTO \"Members\" VALUES (?, ?, ?::\"Role\", ?::Date, ?, ?, ?::\"Role\")";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, v.getName());
        preparedStatement.setString(2, v.getFirst_Name());
        preparedStatement.setString(3, v.getRole().toString());
        preparedStatement.setString(4, v.getBirthdate().toString());
        preparedStatement.setString(5, v.getOrigin());
        preparedStatement.setInt(6, v.getId_Member());
        preparedStatement.setString(7, v.getSecond_Role().toString());

        preparedStatement.executeUpdate();
	}
    
    public void delete(Connection c, int key) throws SQLException {
    	
    	String requete = "DELETE FROM \"Members\" WHERE \"Members\".\"ID_Member\" = ?";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setInt(1, key);
        preparedStatement.executeUpdate();
    }
    
    public void update(Connection c, Member v, int id) throws SQLException {
		String requete = "UPDATE public.Labels SET \"Name\" = ?, \"First_Name\" = ?, \"Role\" = ?::role, \"Birthdate\" = ?, \"Origin\" = ?, \"ID_Member\" = ?, \"2nd_Role\" = ?::Role WHERE \"Name\" = ?";
		PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, v.getName());
        preparedStatement.setString(2, v.getFirst_Name());
        preparedStatement.setString(3, v.getRole().toString());
        preparedStatement.setDate(4, v.getBirthdate());
        preparedStatement.setString(5, v.getOrigin());
        preparedStatement.setInt(6, id);
        preparedStatement.setString(7, v.getSecond_Role().toString());

        preparedStatement.executeUpdate();
	}
    
    
}
