package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.Colecao;
import model.Item;
import model.Usuario;
import service.CategoriaService;
import service.ColecaoService;
import service.ItemService;
import service.UsuarioService;

public class Excluir implements Command {

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
		
		System.out.println("opcao: " + opcao);
		System.out.println("idUsuario: " + idUsuario);		
		
		Usuario user = new Usuario();
		user.setIdUsuario(idUsuario);
		UsuarioService userService = new UsuarioService();
		userService.buscar(user);

		String rd = "controller.do?command=Listar&idUsuario=" + user.getIdUsuario();
		
		switch (opcao) {
		case "colecao":
			System.out.println("coleção!");
			Colecao colecao = new Colecao();
			colecao.setIdColecao(id);
			ColecaoService colecaoService = new ColecaoService();
			colecaoService.excluir(colecao);
			//rd = "controller.do?command=Listar&opcao=colecoes&idUsuario=" + user.getIdUsuario();
			break;
		case "item":
			Item item = new Item();
			item.setIdItem(id);
			ItemService itemService = new ItemService();
			itemService.excluir(item);
			System.out.println("idUsuario: " + idUsuario);
			System.out.println("idUsuario user: " + user.getIdUsuario());
			rd += "&idColecao=" + idColecao;
			//rd = "controller.do?command=Listar&opcao=itens&idColecao="+idColecao+"&idUsuario=" + user.getIdUsuario();
			break;
		case "usuario":
			userService.excluir(user);
			rd = "login.jsp";
			break;
		case "categoria":
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(id);
			CategoriaService catService = new CategoriaService();
			catService.excluir(categoria);
			rd += "&idColecao=" + idColecao;
			opcao = "item";
			break;
		default:
			break;
		}
		
		rd += "&opcao=" + opcao;

		System.out.println("excluir: " + rd);
		RequestDispatcher view = request.getRequestDispatcher(rd);
		view.forward(request, response);

	}

}
