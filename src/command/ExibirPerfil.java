package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.colecaoDao;
import model.Categoria;
import model.Colecao;
import model.Item;
import model.Usuario;
import service.ColecaoService;
import service.UsuarioService;

public class ExibirPerfil implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sIdUsuario = request.getParameter("idUsuario");
		String sIdColecao = request.getParameter("idColecao");
		String pagina = request.getParameter("pagina");
		
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
		
		HttpSession session = request.getSession();
		session.setAttribute("usuario", user);
		session.setAttribute("pagina", pagina);
		
		if (pagina == "item") {
			Colecao colecao = new Colecao();
			colecao.setIdColecao(idColecao);
			ColecaoService colecaoService = new ColecaoService();
			colecao = colecaoService.buscar(colecao);
			session.setAttribute("colecao", colecao);
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher("perfil.jsp");
		view.forward(request, response);

	}

}
