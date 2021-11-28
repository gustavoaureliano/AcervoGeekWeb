package service;

import java.util.ArrayList;

import dao.itemDao;
import model.Colecao;
import model.Item;

public class ItemService {
	
	itemDao itemd = new itemDao();
	
	public void incluir(Item item) {
		itemd.incluir(item);
	}
	
	public void excluir(Item item) {
		itemd.excluir(item);
	}
	
	
	public void atualizarItem(Item item) {
		itemd.atualizarItem(item);
	}
	
	
	public Item buscar(Item item) {
		return itemd.buscar(item);
	}
	
	
	public ArrayList<Item> buscarItem(Colecao colecao) {
		return itemd.buscarItem(colecao);
	}
	
	
	public ArrayList<Item> buscarItem(Colecao colecao, String chave) {
        return itemd.buscarItem(colecao, chave);
    }
	
}
