package be.technifutur.java2020.services;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import be.technifutur.java2020.dto.Album;
import be.technifutur.java2020.dto.Band;

public interface Crudable <DTO, TID>{


    List<DTO> selectAll(Connection c) throws SQLException;

    void insert(Connection c, DTO v) throws SQLException;

    void update(Connection c, DTO v, TID id) throws SQLException;

    void delete(Connection c, TID id) throws SQLException;

	void delete(Connection c, Album l, String key) throws SQLException;
	
	void delete(Connection c, Band l, String key) throws SQLException;


}