package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Categoria;
import service.CategoriaService;

public class AdicionarCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagina = request.getParameter("pagina");
		String nome = request.getParameter("nome");
		String sId = request.getParameter("id");
		String sIdUsuario = request.getParameter("idUsuario");
		
		int id = -1;
		
		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Categoria categoria = new Categoria();
		categoria.setIdColecao(id);
		categoria.setNome(nome);
		CategoriaService catService = new CategoriaService();
		catService.incluir(categoria);
		
		String rd = pagina;
		
		RequestDispatcher view = request.getRequestDispatcher(rd);
		view.forward(request, response);
		
	}

}
