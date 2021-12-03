package model;

import java.io.InputStream;

public class Item {
	private int idItem = 0;
	private int idColecao = 0;
	private int idCategoria = 0;
	private String nome = "";
	private String descricao = "";
	private InputStream imagem = null;
	
	
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public int getIdColecao() {
		return idColecao;
	}
	public void setIdColecao(int idColecao) {
		this.idColecao = idColecao;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public InputStream getImagem() {
		return imagem;
	}
	public void setImagem(InputStream imagem) {
		this.imagem = imagem;
	}
	
	
}
