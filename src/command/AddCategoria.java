package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Categoria;
import model.Colecao;
import model.Usuario;
import service.CategoriaService;
import service.ColecaoService;

public class AddCategoria implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcao = request.getParameter("opcao");
		String nome = request.getParameter("nome");
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
		
		Categoria categoria = new Categoria();
		categoria.setIdColecao(idColecao);
		categoria.setNome(nome);
		CategoriaService catService = new CategoriaService();
		catService.incluir(categoria);
		
		Usuario user = new Usuario();
		user.setIdUsuario(idUsuario);
		
		ColecaoService colecaoService = new ColecaoService();
		Colecao colecao = new Colecao();
		colecao.setIdColecao(idColecao);
		colecao = colecaoService.buscar(colecao);
		
		HttpSession session = request.getSession();
		session.setAttribute("colecao", colecao);

    	ArrayList<Categoria> categorias = catService.buscarCategoria(colecao);
    	session.setAttribute("categorias", categorias);
		session.setAttribute("categoriaSelecionada", categoria);
		
		String rd = "";
		
		switch (opcao) {
		case "item":
			rd = "controller.do?command=Listar&opcao=item&idUsuario=" + user.getIdUsuario() + "&idColecao=" + idColecao;
			break;
		case "addItem":
			//HttpSession session = request.getSession();
			//session.setAttribute("id", id);
			rd = "addItem.jsp";
			System.out.println(rd);
			break;
		case "editItem":
			rd = "controller.do?command=ExibirEditar&opcao=item&id=" + id + "&idColecao=" + idColecao + "&idUsuario=" + idUsuario;
			break;
		default:
			break;
		}

		RequestDispatcher view = request.getRequestDispatcher(rd);
		view.forward(request, response);

	}

}
