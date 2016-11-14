package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.ControladorABMCPersonaje;
import utils.ApplicationException;
import entidades.*;

/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorABMCPersonaje ctrl = new ControladorABMCPersonaje();
		Personaje p1= new Personaje();
		p1.setId(Integer.parseInt(request.getParameter("Personaje1")));
		Personaje p2= new Personaje();
		p2.setId(Integer.parseInt(request.getParameter("Personaje2")));
		try {
			p1=ctrl.busca(p1);
			p2=ctrl.busca(p2);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.getWriter().append("P1: ").append(p1.getNombre()+" "+p1.getApellido());
		//response.getWriter().append("P2: ").append(p2.getNombre()+" "+p2.getApellido());
		request.getSession().setAttribute("P1", p1);
		request.getSession().setAttribute("P2", p2);
		//response.sendRedirect("WEB-INF/war.jsp");
		request.getRequestDispatcher("WEB-INF/Combate.jsp").forward(request, response);
		response.sendRedirect("/Combate.jsp");
	}

}
