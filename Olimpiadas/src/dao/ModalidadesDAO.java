package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Modalidades;

public class ModalidadesDAO {
	public void criar(Modalidades modalidades) {
		String sqlInsert = "INSERT INTO modalidades(id, nome, ouro, prata, bronze) VALUES (?,?,?,?,? )";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, modalidades.getId());
			stm.setString(2, modalidades.getNome());
			stm.setInt(3, modalidades.getOuro());
			stm.setInt(4, modalidades.getPrata());
			stm.setInt(5, modalidades.getBronze());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualiza(Modalidades modalidades) {
		String sqlUpdate = "UPDATE modalidades SET id=?, nome=?, ouro=?, prata=?, bronze=?, WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, modalidades.getId());
			stm.setString(2, modalidades.getNome());
			stm.setInt(3, modalidades.getOuro());
			stm.setInt(4, modalidades.getPrata());
			stm.setInt(5, modalidades.getBronze());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Modalidades modalidades) {
		String sqlDelete = "DELETE FROM modalidades WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, modalidades.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregar(Modalidades modalidades) {
		String sqlSelect = "SELECT nome, ouro, prata, bronze,id FROM modalidades WHERE modalidades.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, modalidades.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					modalidades.setNome(rs.getString("nome"));
					modalidades.setOuro(rs.getInt("ouro"));
					modalidades.setPrata(rs.getInt("prata"));
					modalidades.setBronze(rs.getInt("bronze"));

				} else {
					modalidades.setId(-1);
					modalidades.setNome(null);
					modalidades.setOuro(0);
					modalidades.setPrata(0);
					modalidades.setBronze(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

	}

}
