package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import model.Item;

public class itemDao {
	
	public void incluir(Item item) {
		
		String sqlInsert = "insert into item (idCategoria, nome, descricao, imagem, idItem) values(?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setInt(1, item.getIdCategoria());
			stm.setString(2, item.getNome());
			stm.setString(3, item.getDescricao());
			stm.setObject(4, item.getImagem());
			stm.setInt(5, item.getIdItem());
			
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
		
		try(Connection conn = ConnectionFactory.conectar(); CallableStatement stm = (CallableStatement) conn.prepareCall("{call usp_atualizarItem(?, ?, ?, ?, ?)}")){
			stm.setInt(1, item.getIdCategoria());
			stm.setString(2, item.getNome());
			stm.setString(3, item.getDescricao());
			stm.setObject(4, item.getImagem());
			stm.setInt(5, item.getIdItem());
			
			stm.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Item buscar(Item item) {
		String sqlSelect = "SELECT * FROM item WHERE item.idItem = ?";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, item.getIdColecao());
			try (ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					item.setIdItem(rs.getInt("idItem"));
					item.setIdColecao(rs.getInt("idColecao"));
					item.setIdCategoria(rs.getInt("idCategoria"));
					item.setNome(rs.getString("nome"));
					item.setDescricao(rs.getString("descricao"));
					item.setImagem(rs.getBinaryStream("imagem"));
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
	
	
	public ArrayList<Item> buscarItem() {
		String sqlSelect = "SELECT * from item";
		ArrayList<Item> lista = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();){
			while(rs.next()) {
				Item item = new Item();
				
				item.setIdItem(rs.getInt("idItem"));
				item.setIdColecao(rs.getInt("idColecao"));
				item.setIdCategoria(rs.getInt("idCategoria"));
				item.setNome(rs.getString("nome"));
				item.setDescricao(rs.getString("descricao"));
				item.setImagem(rs.getBinaryStream("imagem"));
				
				lista.add(item);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public ArrayList<Item> buscarItem(String chave) {
        String sqlSelect = "select * from item where upper(nome) like ?";
        ArrayList<Item> lista = new ArrayList<Item>();

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setString(1, "%" + chave.toUpperCase() + "%");
            try(ResultSet rs = stm.executeQuery();){
            while (rs.next()) {
            	Item item = new Item();
				item.setIdItem(rs.getInt(1));
				item.setIdColecao(rs.getInt(2));
				item.setIdCategoria(rs.getInt(3));
				item.setNome(rs.getString(4));
				item.setDescricao(rs.getString(5));
				item.setImagem(rs.getBinaryStream(6));
                
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
