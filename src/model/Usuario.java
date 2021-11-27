package model;

import java.io.InputStream;

public class Usuario {
	private int idUsuario;
	private String usuario;
	private String nome;
	private String senha;
	private InputStream foto;
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public InputStream getFoto() {
		return foto;
	}
	public void setFoto(InputStream foto) {
		this.foto = foto;
	}
	
	
}
