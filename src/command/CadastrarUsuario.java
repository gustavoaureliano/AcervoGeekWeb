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

public class CadastrarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setUsuario(usuario);
		user.setSenha(senha);
		
		UsuarioService userService = new UsuarioService();
		int idUsuario = userService.cadastro(user);
		user.setIdUsuario(idUsuario);
		
		user = userService.buscar(user);
		
		ColecaoService colecaoService = new ColecaoService();
		
		ArrayList<Colecao> colecoes = colecaoService.buscarColecao(user);
		
		HttpSession session = request.getSession();
		session.setAttribute("usuario", user);
		session.setAttribute("colecoes", colecoes);
		
		RequestDispatcher view = request.getRequestDispatcher("colecoes.jsp");
		view.forward(request, response);

	}

}
