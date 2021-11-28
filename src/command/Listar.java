package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Categoria;
import model.Colecao;
import model.Item;
import model.Usuario;
import service.CategoriaService;
import service.ColecaoService;
import service.ItemService;
import service.UsuarioService;

public class Listar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		String sIdUsuario = request.getParameter("idUsuario");
		String sIdColecao = request.getParameter("idColecao");
		String chave = request.getParameter("chave");
		
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
				
		UsuarioService userService = new UsuarioService();
		user = userService.buscar(user);
		
		ColecaoService colecaoService = new ColecaoService();
		
		HttpSession session = request.getSession();
		session.setAttribute("usuario", user);

		RequestDispatcher view = null;
		
		switch (opcao) {
		case "colecoes":
			ArrayList<Colecao> colecoes = null;
			
			if(chave != null && chave.length() > 0) {
				colecoes = colecaoService.buscarColecao(user, chave);
			} else {
				colecoes = colecaoService.buscarColecao(user);
			}
			session.setAttribute("colecoes", colecoes);
			view = request.getRequestDispatcher("colecoes.jsp");
			break;
		case "itens":
			Colecao colecao = new Colecao();
			colecao.setIdColecao(idColecao);
			colecao = colecaoService.buscar(colecao);
			
			ItemService itemService = new ItemService();
			ArrayList<Item> itens = itemService.buscarItem(colecao);
			
			if(chave != null && chave.length() > 0) {
				itens = itemService.buscarItem(colecao, chave);
			} else {
				itens = itemService.buscarItem(colecao);
			}
			session.setAttribute("colecao", colecao);
			session.setAttribute("itens", itens);
			view = request.getRequestDispatcher("itens.jsp");
			break;
		default:
			break;
		}
		
		view.forward(request, response);
		
	}

}
