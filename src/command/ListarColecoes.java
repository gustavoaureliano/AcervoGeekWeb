package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colecao;
import model.Usuario;
import service.ColecaoService;
import service.UsuarioService;

public class ListarColecoes implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcao = request.getParameter("opcao");
		String sId = request.getParameter("idUsuario");
		String chave = request.getParameter("chave");
		
		int id = -1;
		
		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Usuario user = new Usuario();
		user.setIdUsuario(id);
				
		UsuarioService userService = new UsuarioService();
		user = userService.buscar(user);
		
		
		ColecaoService colecaoService = new ColecaoService();
		
		ArrayList<Colecao> colecoes = colecaoService.buscarColecao(user);
		
		if(chave != null && chave.length() > 0) {
			colecoes = colecaoService.buscarColecao(user, chave);
		} else {
			colecoes = colecaoService.buscarColecao(user);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("usuario", user);
		session.setAttribute("colecoes", colecoes);
		
		RequestDispatcher view = request.getRequestDispatcher("colecoes.jsp");
		view.forward(request, response);

	}

}
