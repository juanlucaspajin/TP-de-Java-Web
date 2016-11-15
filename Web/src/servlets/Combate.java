package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Personaje;
import logic.CtrlCombate;
import utils.ApplicationException;

/**
 * Servlet implementation class Combate
 */
@WebServlet("/Combate")
public class Combate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int turno=1;
    private CtrlCombate controlador;
    private Personaje per1, per2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Combate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Personaje p1 = (Personaje)request.getSession().getAttribute("P1");
		Personaje p2 = (Personaje)request.getSession().getAttribute("P1");
		controlador = new CtrlCombate();
		controlador.seteaPer(p1, p2);
		if(request.getParameter("atacar")!= null){
			try {
				if(controlador.ataque(Integer.parseInt(request.getParameter("energiaUsar")), turno))
				{
					request.getSession().setAttribute("vida1", String.valueOf(controlador.getVidaP1()));
					request.getSession().setAttribute("vida2", String.valueOf(controlador.getVidaP2()));
					request.getSession().setAttribute("energia1", String.valueOf(controlador.getEnergiaP1()));
					request.getSession().setAttribute("energia2", String.valueOf(controlador.getEnergiaP2()));
					request.getSession().setAttribute("nombreTurno", controlador.getPerTurno());
					PrintWriter out = response.getWriter(); 
					out.println("<script type=\"text/javascript\">alert('Has ganado');</script>");
					response.sendRedirect("Index.html");
				}else{
					request.getSession().setAttribute("vida1", String.valueOf(controlador.getVidaP1()));
					request.getSession().setAttribute("vida2", String.valueOf(controlador.getVidaP2()));
					request.getSession().setAttribute("energia1", String.valueOf(controlador.getEnergiaP1()));
					request.getSession().setAttribute("energia2", String.valueOf(controlador.getEnergiaP2()));
					request.getSession().setAttribute("nombreTurno", controlador.getPerTurno());
					this.cambiaTurno();
				}
			} catch (NumberFormatException e) {
				PrintWriter out = response.getWriter(); 
				out.println("<script type=\"text/javascript\">alert('Error en la energia');</script>");
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher("WEB-INF/Combate.jsp").forward(request, response);
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
	}

	private void cambiaTurno() {
		if (turno == 1) 
		{
			turno = 2;
		}
		else 
		{
			turno = 1;
		}
		
	}





}
