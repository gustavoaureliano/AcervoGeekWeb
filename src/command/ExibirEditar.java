package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Categoria;
import model.Colecao;
import model.Item;
import model.Usuario;
import service.ColecaoService;
import service.ItemService;
import service.UsuarioService;

public class ExibirEditar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		String sId = request.getParameter("id");
		String sIdUsuario = request.getParameter("idUsuario");
		
		int id = -1;
		
		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int idUsuario = -1;
		
		try {
			idUsuario = Integer.parseInt(sIdUsuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Usuario user = new Usuario();
		user.setIdUsuario(idUsuario);

		HttpSession session = request.getSession();
		session.setAttribute("usuario", user);
		
		RequestDispatcher view = null;
		
		switch (opcao) {
		case "colecao":

			System.out.println("idColecao: " + id);
			Colecao colecao = new Colecao();
			colecao.setIdColecao(id);
			ColecaoService colecaoService = new ColecaoService();
			colecao = colecaoService.buscar(colecao);
			session.setAttribute("colecao", colecao);
			view = request.getRequestDispatcher("editColecao.jsp");
			break;
		case "item":
			Item item = new Item();
			item.setIdItem(id);
			ItemService itemService = new ItemService();
			item = itemService.buscar(item);
			session.setAttribute("item", item);
			view = request.getRequestDispatcher("editItem.jsp");
			break;
		case "categoria":
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(id);
			break;
		default:
			break;
		}
		
		
		

		
		view.forward(request, response);

	}

}
