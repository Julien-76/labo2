package be.technifutur.java2020.servlets;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.technifutur.java2020.ConnexionPSQL;
import be.technifutur.java2020.dto.Album;
import be.technifutur.java2020.dto.Band;
import be.technifutur.java2020.dto.Label;
import be.technifutur.java2020.dto.Style;
import be.technifutur.java2020.services.AlbumService;
import be.technifutur.java2020.services.BandService;
import be.technifutur.java2020.services.LabelService;



@WebServlet(name = "ServletBand", urlPatterns = {"/bands", "/bands/create/*", "/bands/delete", "/bands/update/*"}, loadOnStartup = 7)
public class ServletBand extends HttpServlet {
	
       
	private final String HOST = "/Labo2";
    
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			String pathInfo = request.getRequestURI();
		
		
		BandService bandService = new BandService();
		LabelService labelService = new LabelService();
		
		String choice = !pathInfo.equals(HOST + "/bands") ? pathInfo.split("/")[3] : "bands";		
		
		int id;
		String name = "";
		
		switch (choice) {
			
			case "bands" :
				request.setAttribute("messages", null);
				try {
					request.setAttribute("bands", bandService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/bands.jsp").forward(request, response);
				}
				break;
			case "delete" :
				request.setAttribute("messages", null);
				
				
				try {
					request.setAttribute("band", bandService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/deleteBands.jsp").forward(request, response);
				}
				break;
			case "create" :
				request.setAttribute("messages", null);
				
				try {
					request.setAttribute("label", labelService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/insertband.jsp").forward(request, response);
				}
				break;
			case "update" :
				request.setAttribute("messages", null);
				
				id = Integer.parseInt(pathInfo.split("/")[4]);
				
				try {
					request.setAttribute("moteurs", bandService.selectAll(ConnexionPSQL.getInstance()));
					
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/gestionDBUpdate.jsp").forward(request, response);
				}
				break;
			default :
				break;
		}
		
	}

		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		LabelService labelService = new LabelService();
		BandService bandService = new BandService();
		
		String pathInfo = request.getRequestURI();	
			
		String choice = !pathInfo.equals(HOST + "/bands") ? pathInfo.split("/")[3] : "bands";
		
		switch (choice) {
		case "create" :
			
			String name = request.getParameter("name");
			String nationality = request.getParameter("nationality");
			int creation = Integer.parseInt(request.getParameter("creation"));
			Style style = Style.valueOf(request.getParameter("style"));
			String labelname = request.getParameter("label");
			int members = Integer.parseInt(request.getParameter("members"));
			int albums = Integer.parseInt(request.getParameter("albums"));
			
			try {
				Label label = labelService.selectByName(ConnexionPSQL.getInstance(), labelname);
				Band band = new Band(name, nationality, creation, style, label, members, albums);
				bandService.insert(ConnexionPSQL.getInstance(), band);	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				response.sendRedirect(HOST + "/bands");
			}
			break;
		
		case "delete" :
			String bandName = request.getParameter("bandToDelete");
			try {
				Band bandToDelete = bandService.selectByName(ConnexionPSQL.getInstance(), bandName);
				bandService.delete(ConnexionPSQL.getInstance(), bandName);	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				response.sendRedirect(HOST + "/bands");
			}
			break;
		}
		

	
	}

}
