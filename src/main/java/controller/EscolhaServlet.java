package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EscolhaDAO;
import dao.AlunoDAO;
import dao.CursoDAO;
import modelos.Escolha;
import modelos.Aluno;
import modelos.Curso;


@WebServlet(urlPatterns = { "/escolha", "/escolha-getCreate", "/escolha-create", "/escolha-edit", "/escolha-update", "/escolha-delete" })
public class EscolhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EscolhaDAO edao = new EscolhaDAO();
	AlunoDAO adao = new AlunoDAO();
	CursoDAO cdao = new CursoDAO();
	Escolha escolha = new Escolha();

    public EscolhaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/escolha":
			read(request, response);
			break;
		case "/escolha-getCreate":
			getCreate(request, response);
			break;
		case "/escolha-create":
			create(request, response);
			break;
		case "/escolha-edit":
			edit(request, response);
			break;
		case "/escolha-update":
			update(request, response);
			break;
		case "/escolha-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Escolha> escolha = edao.read();

		request.setAttribute("listaEscolha", escolha);

		RequestDispatcher rd = request.getRequestDispatcher("./views/escolha/index.jsp");
		rd.forward(request, response);

	}
	
	protected void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Aluno> listaAluno = adao.read();
		request.setAttribute("listaCurso", listaAluno);
		
		List<Curso> listaCurso = cdao.read();
		request.setAttribute("listaCurso", listaCurso);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/escolha/create.jsp");
		rd.forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aluno aluno = adao.readById(Integer.parseInt(request.getParameter("id_Aluno")));
		Curso curso = cdao.readById(Integer.parseInt(request.getParameter("id_Curso")));
	
		String data_Escolha = request.getParameter("data_Escolha");
		String nome = request.getParameter("nome");

		
		escolha = new Escolha(0, nome, data_Escolha, aluno, curso, 0, 0);
		
		edao.create(escolha);
		response.sendRedirect("escolha");
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		escolha = edao.readById(id);
		
		request.setAttribute("escolha", escolha);
		
		List<Aluno> listaAluno = adao.read();
		request.setAttribute("listaAluno", listaAluno);
		
		List<Curso> listaCurso = cdao.read();
		request.setAttribute("listaCurso", listaCurso);

		RequestDispatcher rd = request.getRequestDispatcher("./views/escolha/update.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		escolha.setId(Integer.parseInt(request.getParameter("id")));
		escolha.setNome(request.getParameter("nome"));
		escolha.setData_Escolha(request.getParameter("data"));
		escolha.setAluno(adao.readById(Integer.parseInt(request.getParameter("aluno"))));
		escolha.setCurso(cdao.readById(Integer.parseInt(request.getParameter("curso"))));

		edao.update(escolha);
		response.sendRedirect("escolha");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		edao.delete(id);
		response.sendRedirect("escolha");
	}

}