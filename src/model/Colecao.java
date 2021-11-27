package model;

import java.io.InputStream;
import java.sql.Date;

public class Colecao {
	private int idColecao;
	private int idUsuario;
	private String nome;
	private String descricao;
	private InputStream imagem;
	private Date data_criacao;
	private Date data_alteracao;
	
	
	public int getIdColecao() {
		return idColecao;
	}
	public void setIdColecao(int idColecao) {
		this.idColecao = idColecao;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public Date getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	public Date getData_alteracao() {
		return data_alteracao;
	}
	public void setData_alteracao(Date data_alteracao) {
		this.data_alteracao = data_alteracao;
	}
	
	
}

