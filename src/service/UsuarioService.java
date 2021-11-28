package service;

import java.util.ArrayList;

import dao.usuarioDao;
import model.Usuario;

public class UsuarioService {
	
	usuarioDao usuariod = new usuarioDao();
	
	public int cadastro(Usuario usuario) {
		return usuariod.cadastro(usuario);
	}
	
	
	public void excluir(Usuario usuario) {
		usuariod.excluir(usuario);
	}
	
	
	public void atualizarUsuario(Usuario usuario) {
		usuariod.atualizarUsuario(usuario);
	}
	
	
	public Usuario buscar(Usuario usuario) {
		return usuariod.buscar(usuario);
	}
	
	public Usuario buscarLogin(Usuario usuario) {
		return usuariod.buscarLogin(usuario);
	}
	
	public ArrayList<Usuario> buscarUsuarios() {
		return usuariod.buscarUsuarios();
	}
	
	
	public ArrayList<Usuario> buscarUsuarios(String chave) {
        return usuariod.buscarUsuarios(chave); 
    }
	
	public boolean loginUsuario(Usuario usuario) {
		return usuariod.loginUsuario(usuario);
	}
}
