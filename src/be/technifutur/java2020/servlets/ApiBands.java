package be.technifutur.java2020.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import com.google.gson.Gson;

import be.technifutur.java2020.ConnexionPSQL;
import be.technifutur.java2020.Util;
import be.technifutur.java2020.services.BandService;
import be.technifutur.java2020.services.LabelService;

@WebServlet(name = "apibands", urlPatterns = {"/apibands"}, loadOnStartup = 8)
public class ApiBands extends HttpServlet {
	
	//Transformation de données de BDD en données objet Java, puis en JSON
	
	private final String HOST = "/Labo2";
	
	private final BandService bandService = new BandService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * Démo de base pour retourner un JSON
		 */
		/*
		Car testJSON = new Car(99, "Mercedes Classe A", 25500.95, new Moteur(65, Carburant.Essence, 1995));
		String carToString = new Gson().toJson(testJSON);	//Transformation de l'objet en String pour JSON
		
		PrintWriter out = resp.getWriter();					//Permet de gérer la réponse sous forme de flux et d'écrire dans la réponse
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print(carToString);								//Affiche le flux
		out.flush();                                        //Vide le flux
		*/
		
		
		
		String pathInfo = req.getRequestURI();
		
		String choice = !pathInfo.equals(HOST + "/apibands") ? pathInfo.split("/")[3] : "apibands";
		
		String id;
		
		switch (choice) {
			case "apibands" :
				try {
					Util.formatResponse(resp, bandService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default :
				id = String.valueOf(pathInfo.split("/")[3]);
				try {
					Util.formatResponse(resp, bandService.selectByName(ConnexionPSQL.getInstance(), id));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
		}

	}
}