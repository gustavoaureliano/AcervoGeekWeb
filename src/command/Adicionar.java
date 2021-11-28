package command;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Categoria;
import model.Colecao;
import model.Item;
import model.Usuario;
import service.ColecaoService;
import service.ItemService;
import service.UsuarioService;

public class Adicionar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		String nome = request.getParameter("nome");
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
		
		String rd = null;
		

		System.out.println("idUsuario: " + idUsuario);
		
		Usuario user = new Usuario();
		user.setIdUsuario(idUsuario);
		
		switch (opcao) {
		case "colecao":
			Colecao colecao = new Colecao();
			colecao.setIdUsuario(idUsuario);
			colecao.setNome(nome);
			colecao.setDescricao(descricao);
			colecao.setImagem(filePart.getInputStream());
			ColecaoService colecaoService = new ColecaoService();
			colecaoService.incluir(colecao);
			rd = "controller.do?command=Listar&opcao=colecoes&idUsuario=" + user.getIdUsuario();
			break;
		case "item":
			Item item = new Item();
			item.setIdColecao(id);
			
			System.out.print("idCategoria: " + idCategoria);
			if(idCategoria == 0) {
				System.out.print("Cat é 0: " + idCategoria);
			}
			
			item.setNome(nome);
			item.setDescricao(descricao);
			item.setImagem(filePart.getInputStream());
			ItemService itemService = new ItemService();
			itemService.incluir(item);
			rd = "controller.do?command=Listar&opcao=itens&idColecao="+id+"&idUsuario=" + user.getIdUsuario();
			break;
		case "categoria":
			Categoria categoria = new Categoria();
			categoria.setIdColecao(id);
			categoria.setNome(nome);
			break;
		default:
			break;
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(rd);
		view.forward(request, response);

	}

}
