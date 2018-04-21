package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Modalidades;

public class ModalidadesDAO<ListaModalidades> {
	public void criar(Modalidades modalidades) {
		String sqlInsert = "INSERT INTO modalidade(id, nome, ouro, prata, bronze) VALUES (?,?,?,?,? )";
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
		String sqlUpdate = "UPDATE modalidade SET id=?, nome=?, ouro=?, prata=?, bronze=?, WHERE id=?";
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
		String sqlDelete = "DELETE FROM modalidade WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, modalidades.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregar(Modalidades modalidades) {
		String sqlSelect = "SELECT nome, ouro, prata, bronze,id FROM modalidade WHERE modalidade.id = ?";
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList listaModalidades(int id)
	{
		ArrayList listaModalidades  = new ArrayList();
		String sqlSelect = "SELECT nome, ouro, prata, bronze FROM modalidade WHERE modalidade.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setInt(1,id);
		try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
				listaModalidades.add(rs.getString("nome"));
				listaModalidades.add(rs.getInt("ouro"));
				listaModalidades.add(rs.getInt("prata"));
				listaModalidades.add(rs.getInt("bronze"));

			}else {
				listaModalidades.add(null);
				listaModalidades.add(null);
				listaModalidades.add(null);
				listaModalidades.add(null);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
			// TODO: handle exception
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaModalidades;
		
	}

}