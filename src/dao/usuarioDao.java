package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import model.Usuario;

public class usuarioDao {
	
	
	public int cadastro(Usuario usuario) {
		String sqlInsert = "{call usp_cadastrarUsuario(?, ?, ?, ?)}";
		try(
				Connection conn = ConnectionFactory.conectar(); 
				CallableStatement stm = (CallableStatement) conn.prepareCall(sqlInsert)
						){
			stm.setString(1, usuario.getUsuario());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getSenha());
			stm.setObject(4, usuario.getFoto());
			
			stm.execute();
			
			String sqlQuery = "select last_insert_id()";
			try(
					PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();
				) {
				if(rs.next()) {
					usuario.setIdUsuario(rs.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return usuario.getIdUsuario();
	}
	
	
	public void excluir(Usuario usuario) {
		String sqlDelete = "DELETE FROM usuario where idUsuario = ?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, usuario.getIdUsuario());
			
			stm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizarUsuario(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario set usuario = ?, nome = ?, senha = ?, foto = ? where idUsuario = ?";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getUsuario());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getSenha());
			stm.setObject(4, usuario.getFoto());
			
			stm.setInt(5, usuario.getIdUsuario());
			
			stm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public Usuario buscar(Usuario usuario) {
		String sqlSelect = "SELECT * FROM usuario WHERE usuario.idUsuario = ?";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, usuario.getIdUsuario());
			try (ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					usuario.setIdUsuario(rs.getInt(1));
					usuario.setUsuario(rs.getString(2));
					usuario.setNome(rs.getString(3));
					usuario.setSenha(rs.getString(4));
					usuario.setFoto(rs.getBinaryStream(5));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return usuario;
	}
	
	public Usuario buscarLogin(Usuario usuario) {
		String sqlSelect = "SELECT * FROM usuario WHERE usuario.usuario = ?";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, usuario.getUsuario());
			try (ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					usuario.setIdUsuario(rs.getInt(1));
					usuario.setUsuario(rs.getString(2));
					usuario.setNome(rs.getString(3));
					usuario.setSenha(rs.getString(4));
					usuario.setFoto(rs.getBinaryStream(5));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return usuario;
	}
	
	
	public ArrayList<Usuario> buscarUsuarios() {
		String sqlSelect = "SELECT * from usuario";
		ArrayList<Usuario> lista = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();){
			while(rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setFoto(rs.getBinaryStream("foto"));
				lista.add(usuario);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public ArrayList<Usuario> buscarUsuarios(String chave) {
        String sqlSelect = "select * from usuario where upper(nome) like ?";
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        try (Connection conn = ConnectionFactory.conectar();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setString(1, "%" + chave.toUpperCase() + "%");
            try(ResultSet rs = stm.executeQuery();){
            while (rs.next()) {
            	Usuario usuario = new Usuario();
            	usuario.setIdUsuario(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setNome(rs.getString(3));
                usuario.setSenha(rs.getString(4));
                usuario.setFoto(rs.getBinaryStream(5));
                
                lista.add(usuario);
            }
            }catch (SQLException e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }
	
	public boolean loginUsuario(Usuario usuario) {
		
		boolean status = false;
		
		try (Connection conn = ConnectionFactory.conectar();
				CallableStatement stm = (CallableStatement) conn.prepareCall("{call usp_login(?, ?)}");){
			stm.setString(1, usuario.getUsuario());
			stm.setString(2 , usuario.getSenha());;
			
			try (ResultSet rs = stm.executeQuery();){
				if (rs.next()) {
					if(rs.getInt(1) == 1) {
						status = true;
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
		
		return status;
	}
	
}
