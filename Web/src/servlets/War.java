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
@WebServlet("/War")
public class War extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int turno=1;
    private CtrlCombate controlador = new CtrlCombate();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public War() {
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
		Personaje p2 = (Personaje)request.getSession().getAttribute("P2");
		controlador.seteaPer(p1, p2);
		PrintWriter out = response.getWriter(); 
		if(request.getParameter("atacar")!= null){
			try {
				if(controlador.ataque(Integer.parseInt(request.getParameter("energiaUsar")), turno))
				{
					MapearPersonajes(p1, p2);
					request.getSession().setAttribute("P1", p1);
					request.getSession().setAttribute("P2", p2);
//					request.getSession().setAttribute("vida1", String.valueOf(controlador.getVidaP1()));
//					request.getSession().setAttribute("vida2", String.valueOf(controlador.getVidaP2()));
//					request.getSession().setAttribute("energia1", String.valueOf(controlador.getEnergiaP1()));
//					request.getSession().setAttribute("energia2", String.valueOf(controlador.getEnergiaP2()));
					request.getSession().setAttribute("nombreTurno", controlador.getPerTurno()); 
					
					
					
					out.println("<script language='JavaScript'>alert('Hello');</script>" );
					response.sendRedirect("Index.html");
				}else{
//					request.getSession().setAttribute("vida1", String.valueOf(controlador.getVidaP1()));
//					request.getSession().setAttribute("vida2", String.valueOf(controlador.getVidaP2()));
//					request.getSession().setAttribute("energia1", String.valueOf(controlador.getEnergiaP1()));
//					request.getSession().setAttribute("energia2", String.valueOf(controlador.getEnergiaP2()));
					MapearPersonajes(p1, p2);
					request.getSession().setAttribute("P1", p1);
					request.getSession().setAttribute("P2", p2);
					request.getSession().setAttribute("nombreTurno", controlador.getPerTurno());
					
					
					this.cambiaTurno();
				}
			} catch (NumberFormatException e) {
				out.println("<script type=\"text/javascript\">alert('Error en la energia');</script>");
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				out.println("<script type=\"text/javascript\">alert('Error en la energia');</script>");
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
	
	public void MapearPersonajes(Personaje p1, Personaje p2)
	{
		p1.setVida(controlador.getVidaP1());
		p1.setEnergia(controlador.getEnergiaP1());
		p2.setVida(controlador.getVidaP2());
		p2.setEnergia(controlador.getEnergiaP2());
	}





}
