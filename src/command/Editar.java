package command;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Categoria;
import model.Colecao;
import model.Item;
import model.Usuario;
import service.CategoriaService;
import service.ColecaoService;
import service.ItemService;
import service.UsuarioService;

public class Editar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		String nome = request.getParameter("nome");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String descricao = request.getParameter("descricao");
		Part filePart = request.getPart("imagem");
		String sId = request.getParameter("id");
		String sIdCategoria = request.getParameter("categoria");
		String sIdUsuario = request.getParameter("idUsuario");
		
		int id = -1;
		
		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int idCategoria = -1;
		
		try {
			idCategoria = Integer.parseInt(sIdCategoria);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int idUsuario = -1;
		
		try {
			idUsuario = Integer.parseInt(sIdUsuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		switch (opcao) {
		case "colecao":
			Colecao colecao = new Colecao();
			colecao.setIdColecao(id);
			ColecaoService colecaoService = new ColecaoService();
			colecao = colecaoService.buscar(colecao);
			colecao.setNome(nome);
			colecao.setDescricao(descricao);
			
			if (filePart.getSize() > 0) {
				colecao.setImagem(filePart.getInputStream());
			}

			colecaoService.atualizarColecao(colecao);
			break;
		case "item":
			Item item = new Item();
			item.setIdCategoria(id);
			ItemService itemService = new ItemService();
			item = itemService.buscar(item);
			item.setNome(nome);
			item.setDescricao(descricao);
			item.setImagem(filePart.getInputStream());
			item.setIdCategoria(idCategoria);
			itemService.atualizarItem(item);
			break;
		case "usuario":
			Usuario user = new Usuario();
			user.setIdUsuario(idUsuario);
			UsuarioService userService = new UsuarioService();
			user = userService.buscar(user);
			user.setNome(nome);
			user.setUsuario(usuario);
			
			if(senha.length() > 0) {
				user.setSenha(senha);				
			}
			
			if (filePart.getSize() > 0) {
				user.setFoto(filePart.getInputStream());
			}
			
			userService.atualizarUsuario(user);
			break;
		case "categoria":
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(idCategoria);
			CategoriaService categoriaService = new CategoriaService();
			categoria = categoriaService.buscar(categoria);
			categoria.setNome(nome);
			categoriaService.atualizarCategoria(categoria);
			break;
		default:
			break;
		}
		
		System.out.println("idUsuario: " + idUsuario);
		
		Usuario user = new Usuario();
		user.setIdUsuario(idUsuario);
		
		String rd = "controller.do?command=Listar&opcao=colecoes&idUsuario=" + user.getIdUsuario();
		
		RequestDispatcher view = request.getRequestDispatcher(rd);
		view.forward(request, response);

	}

}