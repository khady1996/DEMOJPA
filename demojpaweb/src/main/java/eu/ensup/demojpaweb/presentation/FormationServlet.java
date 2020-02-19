package eu.ensup.demojpaweb.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.demojpaweb.domaine.Formation;
import eu.ensup.demojpaweb.service.FormationService;

/**
 * Servlet implementation class FormationServlet
 */
@WebServlet("/Creation")
public class FormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FormationService service = new FormationService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("creerFormation.jsp");
		String theme = request.getParameter("theme");
		Formation formation = new Formation(theme);
		HttpSession masession = request.getSession();
		masession.setAttribute("creation", service.creerFormation(formation));
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
