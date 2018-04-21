package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Olimpiadas;

public class OlimpiadasDAO {
	public void criar(Olimpiadas olimpiadas) {
		String sqlInsert = "INSERT INTO ano(tipo) VALUES (?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, olimpiadas.getTipo());
			
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

	public void atualiza(Olimpiadas olimpiadas) {
		String sqlUpdate = "UPDATE olimpiadas SET ano=?, tipo=?, id_pais=?, id_modalidades=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, olimpiadas.getAno());
			stm.setString(2, olimpiadas.getTipo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Olimpiadas olimpiadas) {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Olimpiadas carregar(int ano) {
		Olimpiadas olimpiadas = new Olimpiadas();
		olimpiadas.setAno(ano);
		String sqlSelect = "SELECT ano,tipo FROM ano WHERE ano.ano = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, olimpiadas.getAno());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
				
					olimpiadas.setTipo(rs.getString("tipo"));
					
				} else {
					olimpiadas.setAno(-1);
					olimpiadas.setTipo(null);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return olimpiadas;

	}
}