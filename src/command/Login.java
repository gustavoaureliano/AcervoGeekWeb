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

public class Login implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario();
		user.setUsuario(usuario);
		user.setSenha(senha);
		
		UsuarioService userService = new UsuarioService();
		boolean status = userService.loginUsuario(user);
		
		if(status) {
			user = userService.buscarLogin(user);
			
			String rd = "controller.do?command=Listar&opcao=colecao&idUsuario=" + user.getIdUsuario();
			
			RequestDispatcher view = request.getRequestDispatcher(rd);
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}

	}

}
