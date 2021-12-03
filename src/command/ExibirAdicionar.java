package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colecao;
import model.Item;
import model.Usuario;
import service.ColecaoService;
import service.ItemService;

public class ExibirAdicionar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		String sId = request.getParameter("id");
		String sIdUsuario = request.getParameter("idUsuario");
		String sIdColecao = request.getParameter("idColecao");
		
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
		
		int idColecao = -1;
		
		try {
			idColecao = Integer.parseInt(sIdColecao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Usuario user = new Usuario();
		user.setIdUsuario(idUsuario);

		HttpSession session = request.getSession();
		session.setAttribute("usuario", user);

		Colecao colecao = new Colecao();
		colecao.setIdColecao(idColecao);
		ColecaoService colecaoService = new ColecaoService();
		colecao = colecaoService.buscar(colecao);
		session.setAttribute("colecao", colecao);
		
		Item item = new Item();
		item.setIdItem(id);
		ItemService itemService = new ItemService();
		item = itemService.buscar(item);
		session.setAttribute("item", item);
		
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("addItem.jsp");

	}

}
