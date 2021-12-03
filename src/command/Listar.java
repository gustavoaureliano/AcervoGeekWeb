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
		String sIdCategoria = request.getParameter("categoria");
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
		
		int idCategoria = -1;
		
		try {
			idCategoria = Integer.parseInt(sIdCategoria);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ColecaoService colecaoService = new ColecaoService();
		
		
		
		HttpSession session = request.getSession();

		RequestDispatcher view = null;

		Usuario user = new Usuario();
		user.setIdUsuario(idUsuario);
				
		UsuarioService userService = new UsuarioService();
		user = userService.buscar(user);
		
		session.setAttribute("usuario", user);
		
		switch (opcao) {
		case "colecao":
			ArrayList<Colecao> colecoes = null;
			
			if(chave != null && chave.length() > 0) {
				colecoes = colecaoService.buscarColecao(user, chave);
			} else {
				colecoes = colecaoService.buscarColecao(user);
			}
			session.setAttribute("colecoes", colecoes);
			view = request.getRequestDispatcher("colecoes.jsp");
			break;
		case "item":
			Colecao colecao = new Colecao();
			colecao.setIdColecao(idColecao);
			colecao = colecaoService.buscar(colecao);
			
			ItemService itemService = new ItemService();
			ArrayList<Item> itens = null;
			
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(idCategoria);
			
			if(chave != null && chave.length() > 0) {
				itens = itemService.buscarItem(colecao, categoria, chave);
			} else {
				itens = itemService.buscarItem(colecao, categoria);
			}
			CategoriaService catService = new CategoriaService();
        	ArrayList<Categoria> categorias = catService.buscarCategoria(colecao);
        	session.setAttribute("categorias", categorias);
			session.setAttribute("colecao", colecao);
			session.setAttribute("itens", itens);
			session.setAttribute("categoriaSelecionada", categoria);
			view = request.getRequestDispatcher("itens.jsp");
			break;
		default:
			break;
		}
		
		view.forward(request, response);
		
	}

}
