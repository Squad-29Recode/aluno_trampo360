package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDAO;
import modelos.Curso;

@WebServlet(urlPatterns = { "/curso", "/curso-create", "/curso-edit", "/curso-update", "/curso-delete" })
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CursoDAO cdao = new CursoDAO();
	Curso curso = new Curso();
       
   
    public CursoServlet() {
        super();
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/curso":
			
			read(request, response);
			
			break;
		case "/curso-create":
			create(request, response);
			break;
			
		case "/curso-edit":
			edit(request, response);
			break;
			
		case "/curso-update":
			update(request, response);
			break;
			
		case "/curso-delete":
			delete(request, response);
			
			break;
			
		      default:
		    	  response.sendRedirect ("index.html");
		    	  break;
		}
		    	  }

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Curso> lista = cdao.read();

		request.setAttribute("listaCurso", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/curso/index.jsp");
		rd.forward(request, response);

	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		curso.setCurso(request.getParameter("curso"));
		curso.setData_Curso(request.getParameter("data_Curso"));

		cdao.create(curso);
		response.sendRedirect("curso");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_Curso = Integer.parseInt(request.getParameter("id"));
		
		curso = cdao.readById(id_Curso);
		
		request.setAttribute("curso", curso);

		RequestDispatcher rd = request.getRequestDispatcher("./views/curso/update.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		curso.setId(Integer.parseInt(request.getParameter("id")));
		curso.setCurso(request.getParameter("curso"));
		curso.setData_Curso(request.getParameter("data_Curso"));
		
		cdao.update(curso);
		response.sendRedirect("curso");
	}

	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id_Curso = Integer.parseInt(request.getParameter("id"));
		cdao.delete(id_Curso);
		response.sendRedirect("curso");
	}

}
