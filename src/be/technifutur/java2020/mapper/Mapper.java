package be.technifutur.java2020.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.technifutur.java2020.dto.Album;
import be.technifutur.java2020.dto.Band;
import be.technifutur.java2020.dto.Label;
import be.technifutur.java2020.dto.Member;
import be.technifutur.java2020.dto.Role;
import be.technifutur.java2020.dto.Style;

public class Mapper {
	
	public static Album toDtoAlbum(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString(1);
		Band band = new Band(resultSet.getString(2), resultSet.getString(3),
							resultSet.getInt(4), Style.valueOf(resultSet.getString(5)),
							new Label(resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8)),
									resultSet.getInt(9),
									resultSet.getInt(10));
		Label label = new Label(resultSet.getString(11), resultSet.getString(12), resultSet.getInt(13));
		Date release_Date = resultSet.getDate(14);
		Style style = Style.valueOf(resultSet.getString(15));
		
		return new Album (name, band, label, release_Date, style);
	}
	
	public static Band toDtoBand(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString(1);
		String nationality = resultSet.getString(2);
		int creation = resultSet.getInt(3);
		Style style = Style.valueOf(resultSet.getString(4));
		Label label = new Label(resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
		int members = resultSet.getInt(8);
		int albums = resultSet.getInt(9);
	
		return new Band (name, nationality, creation, style, label, members, albums);
	}
	
	public static Label toDtoLabel(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("Name");
		String nationality = resultSet.getString("Nationality");
		int creation = resultSet.getInt("Creation");
		
		return new Label (name, nationality, creation);
	}
	
	public static Member toDtoMember(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString(1);
		String first_Name = resultSet.getString(2);
		Role role = Role.valueOf(resultSet.getString(3));
		Date birthdate = resultSet.getDate(4);
		String origin = resultSet.getString(5);
		int id_Member = resultSet.getInt(6);
		Role second_Role = Role.valueOf(resultSet.getString(7));
		
		return new Member (name, first_Name, role, birthdate, origin, id_Member, second_Role);
	}
		
}
