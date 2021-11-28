package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import model.Colecao;
import model.Usuario;

public class colecaoDao {
	
	public void incluir(Colecao colecao) {
		
		String sqlInsert = "insert into colecao (idUsuario, nome, descricao, imagem) values(?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setInt(1, colecao.getIdUsuario());
			stm.setString(2, colecao.getNome());
			stm.setString(3, colecao.getDescricao());
			stm.setObject(4, colecao.getImagem());
			
			stm.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void excluir(Colecao colecao) {
		String procedure = "{call usp_excluirColecao(?)}";
		try (
				Connection conn = ConnectionFactory.conectar(); 
				CallableStatement stm = (CallableStatement) conn.prepareCall(procedure);) {
			stm.setInt(1, colecao.getIdColecao());
			
			stm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizarColecao(Colecao colecao) {
		String procedure = "{call usp_atualizarColecao(?, ?, ?, ?)}";
		try(
				Connection conn = ConnectionFactory.conectar(); 
				CallableStatement stm = (CallableStatement) conn.prepareCall(procedure);
			){
			stm.setString(1, colecao.getNome());
			stm.setString(2, colecao.getDescricao());
			stm.setObject(3, colecao.getImagem());
			stm.setInt(4, colecao.getIdColecao());
			
			stm.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Colecao buscar(Colecao colecao) {
		String sqlSelect = "SELECT * FROM colecao WHERE colecao.idColecao = ?";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, colecao.getIdColecao());
			try (ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					colecao.setIdColecao(rs.getInt(1));
					colecao.setIdUsuario(rs.getInt(2));
					colecao.setNome(rs.getString(3));
					colecao.setDescricao(rs.getString(4));
					colecao.setImagem(rs.getBinaryStream(5));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return colecao;
	}
	
	
	public ArrayList<Colecao> buscarColecao(Usuario usuario) {
		String sqlSelect = "SELECT * from colecao where idUsuario = ?";
		ArrayList<Colecao> lista = new ArrayList<>();
		
		try(
				Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, usuario.getIdUsuario());
			try (ResultSet rs = stm.executeQuery()) {
				while(rs.next()) {
					Colecao colecao = new Colecao();
					colecao.setIdColecao(rs.getInt("idColecao"));
					colecao.setIdUsuario(rs.getInt("idUsuario"));
					colecao.setNome(rs.getString("nome"));
					colecao.setDescricao(rs.getString("descricao"));
					colecao.setImagem(rs.getBinaryStream("imagem"));
					
					lista.add(colecao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public ArrayList<Colecao> buscarColecao(Usuario usuario, String chave) {
        String sqlSelect = "select * from colecao where idUsuario = ? and upper(nome) like ?";
        ArrayList<Colecao> lista = new ArrayList<Colecao>();

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getIdUsuario());
            stm.setString(2, "%" + chave.toUpperCase() + "%");
            try(ResultSet rs = stm.executeQuery();){
	            while (rs.next()) {
	            	Colecao colecao = new Colecao();
	            	colecao.setIdColecao(rs.getInt(1));
	                colecao.setIdUsuario(rs.getInt(2));
	                colecao.setNome(rs.getString(3));
	                colecao.setDescricao(rs.getString(4));
	                colecao.setImagem(rs.getBinaryStream(5));
	                
	                lista.add(colecao);
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
