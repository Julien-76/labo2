package be.technifutur.java2020.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technifutur.java2020.ConnexionPSQL;
import be.technifutur.java2020.dto.Band;
import be.technifutur.java2020.dto.Label;
import be.technifutur.java2020.services.AlbumService;
import be.technifutur.java2020.services.BandService;
import be.technifutur.java2020.services.LabelService;



@WebServlet(name = "ServletLabel", urlPatterns = {"/labels", "/labels/delete/*", "/labels/create/*", "/labels/update/*"}, loadOnStartup = 7)
public class ServletLabel extends HttpServlet {
	
       
	private final String HOST = "/Labo2";
    
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			String pathInfo = request.getRequestURI();
		
		
		LabelService labelService = new LabelService();
		
		String choice = !pathInfo.equals(HOST + "/labels") ? pathInfo.split("/")[3] : "labels";
		
		int id;
		String name = "";
		
		switch (choice) {
			
			case "labels" :
				request.setAttribute("messages", null);
				try {
					request.setAttribute("labels", labelService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/labels.jsp").forward(request, response);
				}
				break;
			case "delete" :
				request.setAttribute("messages", null);
				
				
				try {
					request.setAttribute("label", labelService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/deleteLabel.jsp").forward(request, response);
				}
				break;
			case "create" :
				request.setAttribute("messages", null);
				
				try {
					request.setAttribute("labels", labelService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/insertLabel.jsp").forward(request, response);
				}
				break;
			case "update" :
				request.setAttribute("messages", null);
				
				id = Integer.parseInt(pathInfo.split("/")[4]);
				
				try {
					request.setAttribute("moteurs", labelService.selectAll(ConnexionPSQL.getInstance()));
					
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
		
		String pathInfo = request.getRequestURI();	
			
		String choice = !pathInfo.equals(HOST + "/labels") ? pathInfo.split("/")[3] : "labels";
		
		switch (choice) {
		case "create" :
			
			String name = request.getParameter("name");
			String nationality = request.getParameter("nationality");
			int creation = Integer.parseInt(request.getParameter("creation"));
			try {
				Label label = new Label(name, nationality, creation);
				labelService.insert(ConnexionPSQL.getInstance(), label);	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				response.sendRedirect(HOST + "/labels");
			}
			break;
		
		case "delete" :
			
			String labelName = request.getParameter("labelToDelete");
			try {
				Label labelToDelete = labelService.selectByName(ConnexionPSQL.getInstance(), labelName);
				labelService.delete(ConnexionPSQL.getInstance(), labelName);	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				response.sendRedirect(HOST + "/labels");
			}
			break;
		
		}

	}
}