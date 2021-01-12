package be.technifutur.java2020.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.technifutur.java2020.ConnexionPSQL;
import be.technifutur.java2020.dto.Album;
import be.technifutur.java2020.dto.Band;
import be.technifutur.java2020.dto.Label;
import be.technifutur.java2020.dto.Member;
import be.technifutur.java2020.dto.Role;
import be.technifutur.java2020.dto.Style;
import be.technifutur.java2020.services.AlbumService;
import be.technifutur.java2020.services.BandService;
import be.technifutur.java2020.services.LabelService;
import be.technifutur.java2020.services.MemberService;




@WebServlet(name = "ServletMember", urlPatterns = {"/members", "/members/create", "/members/delete", "/members/update"}, loadOnStartup = 7)
public class ServletMember extends HttpServlet {
	
       
	private final String HOST = "/Labo2";
    
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			String pathInfo = request.getRequestURI();
		
		
		MemberService memberService = new MemberService();
		
		String choice = !pathInfo.equals(HOST + "/members") ? pathInfo.split("/")[3] : "members";
		
		int id;
		
		
		switch (choice) {
			
			case "members" :
				request.setAttribute("messages", null);
				try {
					request.setAttribute("members", memberService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/members.jsp").forward(request, response);
				}
				break;
			case "delete" :
				request.setAttribute("messages", null);
				
				
				try {
					request.setAttribute("member", memberService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/deleteMember.jsp").forward(request, response);
				}
				break;
			case "create" :
				request.setAttribute("messages", null);
				
				try {
					request.setAttribute("members", memberService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					request.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/insertMember.jsp").forward(request, response);
				}
				break;
			case "update" :
				request.setAttribute("messages", null);
				
				id = Integer.parseInt(pathInfo.split("/")[4]);
				
				try {
					request.setAttribute("moteurs", memberService.selectAll(ConnexionPSQL.getInstance()));
					
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
		
		
		String pathInfo = request.getRequestURI();	
		
		String choice = !pathInfo.equals(HOST + "/members") ? pathInfo.split("/")[3] : "members";
		
		switch (choice) {
		case "create" :
			
			String name = request.getParameter("name");
			String firstName = request.getParameter("first_Name");
			Role role =  Role.valueOf(request.getParameter("role"));
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			String date = request.getParameter("date");
			
			Date release_Date = null;
			try {
				release_Date = df.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			LocalDate release_Date2 = release_Date.toInstant().atZone(ZoneId.of("Europe/Paris")).toLocalDate();
			java.sql.Date birthdate = java.sql.Date.valueOf(release_Date2);
			String origin = request.getParameter("origin");
			int id_member = Integer.parseInt(request.getParameter("id_Member"));
			Role second_Role =  Role.valueOf(request.getParameter("second_Role"));
			try {
				MemberService memberService = new MemberService();
				Member member = new Member(name, firstName, role, birthdate,origin, id_member, second_Role);
				memberService.insert(ConnexionPSQL.getInstance(), member);	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				response.sendRedirect(HOST + "/members");
			}
			break;
		
		case "delete" :
			
			int memberID = Integer.parseInt(request.getParameter("memberToDelete"));
			try {
				MemberService memberService = new MemberService();
				Member member = memberService.selectByID(ConnexionPSQL.getInstance(), memberID);
				memberService.delete(ConnexionPSQL.getInstance(), memberID);	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				response.sendRedirect(HOST + "/members");
			}
			break;
		}
	}

}
