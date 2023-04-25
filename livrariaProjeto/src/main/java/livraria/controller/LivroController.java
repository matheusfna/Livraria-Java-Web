package livraria.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livraria.dao.LivroDAO;
import livraria.model.Livro;



/**
 * Servlet implementation class LivroController
 */
@WebServlet("/LivroController")
public class LivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LivroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		
		LivroDAO livroDAO = null;
		Livro livro = null;
		
		int id;
		String titulo, isbn, autor, editora;
		
		try {
			
			livroDAO = new LivroDAO();
			RequestDispatcher rd  = null;
			
			if (cmd.equalsIgnoreCase("listar")) {
				List<Livro> livrosLista = livroDAO.listar();				
				
				
				
				request.setAttribute("livrosLista", livrosLista);
				
				
				rd = request.getRequestDispatcher("/mostrar-livro.jsp");		
				
			} else if (cmd.equalsIgnoreCase("mostrar")) {
				titulo = request.getParameter("titulo");
				
				System.out.println("titulo: " +titulo);
				
				livro = new Livro();
				
				livro.setTitulo(titulo);
				
				Livro livro2 = livroDAO.pesquisar(livro);
				
				System.out.println("Livro: " +livro2.toString());
				
				request.setAttribute("livro", livro2);
				
				rd = request.getRequestDispatcher("/detalhes-livro.jsp");
				
			} else if(cmd.equalsIgnoreCase("excluir")) {
				String resposta = request.getParameter("id");				
				id = Integer.parseInt(resposta);
				
				livro = new Livro();
				livro.setId(id);
				
				livroDAO.excluir(livro);
				
				rd = request.getRequestDispatcher("/controller?cmd=listar");
				
			} else if(cmd.equalsIgnoreCase("salvar")) {
				titulo = request.getParameter("titulo");
				isbn = request.getParameter("isbn");
				autor = request.getParameter("autor");
				editora = request.getParameter("editora");
				
				livro = new Livro(0, titulo, isbn,  autor,  editora);
				
				livroDAO.inserir(livro);
				
				rd = request.getRequestDispatcher("/controller?cmd=listar");
				
			}
			
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
			
		}
		
	}

}
