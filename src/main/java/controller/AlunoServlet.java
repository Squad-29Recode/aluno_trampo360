package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;
import modelos.Aluno;

@WebServlet(urlPatterns = { "/aluno", "/aluno-create", "/aluno-edit", "/aluno-update", "/aluno-delete" })
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AlunoDAO adao = new AlunoDAO();
	Aluno aluno = new Aluno();
       
   
    public AlunoServlet() {
        super();
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/aluno":
			
			read(request, response);
			
			break;
		case "/aluno-create":
			create(request, response);
			break;
			
		case "/aluno-edit":
			edit(request, response);
			break;
			
		case "/aluno-update":
			update(request, response);
			break;
			
		case "/aluno-delete":
			delete(request, response);
			
			break;
			
		      default:
		    	  response.sendRedirect ("index.html");
		    	  break;
		}
		    	  }

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Aluno> lista = adao.read();

		request.setAttribute("listaAluno", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/aluno/index.jsp");
		rd.forward(request, response);

	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		aluno.setCPF(request.getParameter("CPF"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setNome(request.getParameter("nome"));
		aluno.setSenha(request.getParameter("senha"));

		adao.create(aluno);
		response.sendRedirect("aluno");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_Aluno = Integer.parseInt(request.getParameter("id"));
		
		aluno = adao.readById(id_Aluno);
		
		request.setAttribute("aluno", aluno);

		RequestDispatcher rd = request.getRequestDispatcher("./views/aluno/update.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		aluno.setId(Integer.parseInt(request.getParameter("id")));
		aluno.setCPF(request.getParameter("CPF"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setNome(request.getParameter("nome"));
		aluno.setSenha(request.getParameter("senha"));

		adao.update(aluno);
		response.sendRedirect("aluno");
	}

	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id_Aluno = Integer.parseInt(request.getParameter("id"));
		adao.delete(id_Aluno);
		response.sendRedirect("aluno");
	}

}
