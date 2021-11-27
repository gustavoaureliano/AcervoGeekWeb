package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Categoria;

public class categoriaDao {
	
	public void incluir(Categoria categoria) {
		
		String sqlInsert = "insert into categoria (idColecao, nome) values(?, ?)";
		
		try(Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setInt(1, categoria.getIdColecao());
			stm.setString(2, categoria.getNome());
			
			stm.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void excluir(Categoria categoria) {
		String sqlDelete = "DELETE FROM categoria where idCategoria = ?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, categoria.getIdCategoria());
			
			stm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizarCategoria(Categoria categoria) {
		String sqlUpdate = "UPDATE categoria set idColecao = ?, nome = ? where idCategoria = ?";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, categoria.getIdColecao());
			stm.setString(2, categoria.getNome());
			
			stm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public Categoria buscar(Categoria categoria) {
		String sqlSelect = "SELECT * FROM categoria WHERE categoria.idCategoria = ?";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, categoria.getIdCategoria());
			try (ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					categoria.setIdCategoria(rs.getInt(1));
					categoria.setIdColecao(rs.getInt(2));
					categoria.setNome(rs.getString(3));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return categoria;
	}
	
	
	public ArrayList<Categoria> buscarCategoria() {
		String sqlSelect = "SELECT * from categoria";
		ArrayList<Categoria> lista = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();){
			while(rs.next()) {
				Categoria categoria = new Categoria();
				
				categoria.setIdCategoria(rs.getInt("idCategoria"));
				categoria.setIdColecao(rs.getInt("idColecao"));
				categoria.setNome(rs.getString("nome"));
				
				lista.add(categoria);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public ArrayList<Categoria> buscarCategoria(String chave) {
        String sqlSelect = "select * from categoria where upper(nome) like ?";
        ArrayList<Categoria> lista = new ArrayList<Categoria>();

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setString(1, "%" + chave.toUpperCase() + "%");
            try(ResultSet rs = stm.executeQuery();){
            while (rs.next()) {
            	Categoria categoria = new Categoria();
            	categoria.setIdCategoria(rs.getInt(1));
                categoria.setIdColecao(rs.getInt(2));
                categoria.setNome(rs.getString(3));
                
                lista.add(categoria);
            }
            }catch (SQLException e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }
	
}
