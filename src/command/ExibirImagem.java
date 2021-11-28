package command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colecao;
import model.Item;
import model.Usuario;
import service.ColecaoService;
import service.ItemService;
import service.UsuarioService;

public class ExibirImagem implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		String sId = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(sId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		InputStream fin = null;
		
		switch (opcao) {
		case "colecao":
			System.out.println("IMG COleção");
			Colecao colecao = new Colecao();
			System.out.println("id: " + id);
			colecao.setIdColecao(id);
			ColecaoService colecaoService = new ColecaoService();
			colecao = colecaoService.buscar(colecao);
			fin = colecao.getImagem();
			break;
		case "item":
			System.out.println("IMG Item");
			Item item = new Item();
			System.out.println("id: " + id);
			item.setIdItem(id);
			ItemService itemService = new ItemService();
			item = itemService.buscar(item);
			fin = item.getImagem();
			break;
		case "usuario":
			Usuario user = new Usuario();
			user.setIdUsuario(id);
			UsuarioService userService = new UsuarioService();
			user = userService.buscar(user);
			fin = user.getFoto();
			break;
		default:
			break;
		}
		
		response.setContentType("image/jpeg");
		ServletOutputStream out;
		out = response.getOutputStream();
		
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch =0; ;
		while((ch=bin.read())!=-1)
		{
		bout.write(ch);
		}
		
		bin.close();
		bout.close();
		out.close();
		
	}
}
