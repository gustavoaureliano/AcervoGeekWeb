package service;

import java.util.ArrayList;

import dao.colecaoDao;
import model.Colecao;

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
	
	
	public ArrayList<Colecao> buscarColecao() {
		return colecaod.buscarColecao();
	}
	
	
	public ArrayList<Colecao> buscarColecao(String chave) {
		return colecaod.buscarColecao(chave);
    }
}
