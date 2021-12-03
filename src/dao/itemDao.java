package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import model.Categoria;
import model.Colecao;
import model.Item;

public class itemDao {
	
	public void incluir(Item item) {
		
		String sqlInsert = "insert into item (idColecao, idCategoria, nome, descricao, imagem) values(?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setInt(1, item.getIdColecao());
			if (item.getIdCategoria() > 0) {
				stm.setInt(2, item.getIdCategoria());				
			} else {
				stm.setNull(2, 0);
			}
			stm.setString(3, item.getNome());
			stm.setString(4, item.getDescricao());
			stm.setObject(5, item.getImagem());
			
			stm.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void excluir(Item item) {
		String sqlDelete = "DELETE FROM item where idItem = ?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, item.getIdItem());
			
			stm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizarItem(Item item) {
		String sqlUpdate = "{call usp_atualizarItem(?, ?, ?, ?, ?)}";
		try(Connection conn = ConnectionFactory.conectar(); 
				CallableStatement stm = (CallableStatement) conn.prepareCall(sqlUpdate)
		){
			
			if (item.getIdCategoria() > 0)
				stm.setInt(1, item.getIdCategoria());				
			else
				stm.setNull(1, 0);
			stm.setString(2, item.getNome());
			stm.setString(3, item.getDescricao());
			stm.setObject(4, item.getImagem());
			stm.setInt(5, item.getIdItem());
			
			stm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Item buscar(Item item) {
		String sqlSelect = "SELECT * FROM item WHERE item.idItem = ?";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, item.getIdItem());
			try (ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					item.setIdItem(rs.getInt("idItem"));
					item.setIdColecao(rs.getInt("idColecao"));
					item.setIdCategoria(rs.getInt("idCategoria"));
					item.setNome(rs.getString("nome"));
					item.setDescricao(rs.getString("descricao"));
					
					InputStream imagem = rs.getBinaryStream(6);
					
					if(imagem != null) {
						item.setImagem(rs.getBinaryStream(6));					
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return item;
	}
	
	
	public ArrayList<Item> buscarItem(Colecao colecao, Categoria categoria) {
		String sqlSelect = "";
		if (categoria.getIdCategoria() > 0)
			sqlSelect = "SELECT * from item where idColecao = ? and idCategoria = ?";
		else
        	sqlSelect = "SELECT * from item where idColecao = ?";
		ArrayList<Item> lista = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, colecao.getIdColecao());
			if (categoria.getIdCategoria() > 0)
				stm.setInt(2, categoria.getIdCategoria());
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					Item item = new Item();
					
					item.setIdItem(rs.getInt("idItem"));
					item.setIdColecao(rs.getInt("idColecao"));
					item.setIdCategoria(rs.getInt("idCategoria"));
					item.setNome(rs.getString("nome"));
					item.setDescricao(rs.getString("descricao"));
					
					InputStream imagem = rs.getBinaryStream(6);
					
					if(imagem != null) {
						item.setImagem(rs.getBinaryStream(6));					
					}
					
					lista.add(item);
				}
			} catch (SQLException e) {
                e.printStackTrace();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public ArrayList<Item> buscarItem(Colecao colecao, Categoria categoria, String chave) {
		String sqlSelect = "";
		if (categoria.getIdCategoria() > 0)
			sqlSelect = "select * from item where idColecao = ? and upper(nome) like ? and idCategoria = ?";
		else
        	sqlSelect = "select * from item where idColecao = ? and upper(nome) like ?";
        
        ArrayList<Item> lista = new ArrayList<Item>();

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, colecao.getIdColecao());
			stm.setString(2, "%" + chave.toUpperCase() + "%");
			if (categoria.getIdCategoria() > 0)
				stm.setInt(3, categoria.getIdCategoria());
            try(ResultSet rs = stm.executeQuery();){
            while (rs.next()) {
            	Item item = new Item();
				item.setIdItem(rs.getInt(1));
				item.setIdColecao(rs.getInt(2));
				item.setIdCategoria(rs.getInt(3));
				item.setNome(rs.getString(4));
				item.setDescricao(rs.getString(5));
				
				InputStream imagem = rs.getBinaryStream(6);
				
				if(imagem != null) {
					item.setImagem(rs.getBinaryStream(6));					
				}
                
                lista.add(item);
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
