package be.technifutur.java2020.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;

import be.technifutur.java2020.ConnexionPSQL;
import be.technifutur.java2020.dto.Album;
import be.technifutur.java2020.dto.Band;
import be.technifutur.java2020.dto.Label;
import be.technifutur.java2020.dto.Style;
import be.technifutur.java2020.services.AlbumService;
import be.technifutur.java2020.services.BandService;
import be.technifutur.java2020.services.LabelService;



@WebServlet(name = "ServletAlbum", urlPatterns = {"/albums", "/albums/create", "/albums/delete", "/albums/update"}, loadOnStartup = 7)
public class ServletAlbum extends HttpServlet {
	
       
	private final String HOST = "/Labo2";
    
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			String pathInfo = request.getRequestURI();
		
		AlbumService albumService = new AlbumService();
		BandService bandService = new BandService();
		LabelService labelService = new LabelService();
		
		String choice = !pathInfo.equals(HOST + "/albums") ? pathInfo.split("/")[3] : "albums";		//Vérifie l'adresse fournie pour rediriger correctement avec le choice
		
		int id;
		String name = "";
		
		switch (choice) {
			
			case "albums" :
				request.setAttribute("messages", null);
				try {
					request.setAttribute("albums", albumService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/albums.jsp").forward(request, response);
				}
				break;
			case "delete" :
				request.setAttribute("messages", null);
				
				try {
					request.setAttribute("albums", albumService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/deleteAlbum.jsp").forward(request, response);
				}
				break;
			case "create" :
				request.setAttribute("messages", null);
				
				try {
					request.setAttribute("band", bandService.selectAll(ConnexionPSQL.getInstance()));
					request.setAttribute("label", labelService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/insertAlbum.jsp").forward(request, response);
				}
				break;
			case "update" :
				request.setAttribute("messages", null);
				
				id = Integer.parseInt(pathInfo.split("/")[4]);
				
				try {
					request.setAttribute("moteurs", albumService.selectAll(ConnexionPSQL.getInstance()));
					
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
		AlbumService albumService = new AlbumService();
		
		String pathInfo = request.getRequestURI();	
			
		String choice = !pathInfo.equals(HOST + "/bands") ? pathInfo.split("/")[3] : "bands";
		
		switch (choice) {
		case "create" :
			String name = request.getParameter("name");
			String bandName = request.getParameter("band");
			String labelname = request.getParameter("label");
			Style style = Style.valueOf(request.getParameter("style"));
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateRelease = request.getParameter("date");
			
			Date release_Date = null;
			try {
				release_Date = df.parse(dateRelease);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			LocalDate release_Date2 = release_Date.toInstant().atZone(ZoneId.of("Europe/Paris")).toLocalDate();
			java.sql.Date sqlDate = java.sql.Date.valueOf(release_Date2);
			try {
				Label label = labelService.selectByName(ConnexionPSQL.getInstance(), labelname);
				Band band = bandService.selectByName(ConnexionPSQL.getInstance(), bandName);
				Album album = new Album(name, band, label, sqlDate, style);
				albumService.insert(ConnexionPSQL.getInstance(), album);	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				response.sendRedirect(HOST + "/albums");
			}
			break;
			
		case "delete" :
			String albumName = request.getParameter("albumToDelete");
			try {
				Album albumToDelete = albumService.selectByName(ConnexionPSQL.getInstance(), albumName);
				albumService.delete(ConnexionPSQL.getInstance(), albumName);	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				response.sendRedirect(HOST + "/albums");
			}
			break;
		}
		
	
	
	}

}

