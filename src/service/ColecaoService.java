package service;

import java.util.ArrayList;

import dao.colecaoDao;
import model.Colecao;
import model.Usuario;

public class ColecaoService {
	
	colecaoDao colecaod = new colecaoDao();
	
	public void incluir(Colecao colecao) {
		colecaod.incluir(colecao);
	}
	
	
	public void excluir(Colecao colecao) {
		colecaod.excluir(colecao);
	}
	
	
	public void atualizarColecao(Colecao colecao) {
		colecaod.atualizarColecao(colecao);
	}
	
	
	public Colecao buscar(Colecao colecao) {
		return colecaod.buscar(colecao);
	}
	
	
	public ArrayList<Colecao> buscarColecao(Usuario usuario) {
		return colecaod.buscarColecao(usuario);
	}
	
	
	public ArrayList<Colecao> buscarColecao(Usuario usuario, String chave) {
		return colecaod.buscarColecao(usuario, chave);
    }
}
