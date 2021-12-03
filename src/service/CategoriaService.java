package service;

import java.util.ArrayList;

import dao.categoriaDao;
import model.Categoria;
import model.Colecao;

public class CategoriaService {
	
	categoriaDao categoriad = new categoriaDao();
	
	public void incluir(Categoria categoria) {
		 categoriad.incluir(categoria);
	}
	
	
	public void excluir(Categoria categoria) {
		categoriad.excluir(categoria);
	}
	
	
	public void atualizarCategoria(Categoria categoria) {
		categoriad.atualizarCategoria(categoria);
	}
	
	
	public Categoria buscar(Categoria categoria) {
		return categoriad.buscar(categoria);
	}
	
	
	public ArrayList<Categoria> buscarCategoria(Colecao colecao) {
		return categoriad.buscarCategoria(colecao);
	}
	
	
	public ArrayList<Categoria> buscarCategoria(Colecao colecao, String chave) {
        return categoriad.buscarCategoria(colecao, chave);
    }
	
}
