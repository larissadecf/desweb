package service;

import dao.PaisDAO;
import model.Pais;

public class PaisService {
	PaisDAO paisDAO = new PaisDAO();
	
	public void criar(Pais pais) {
		paisDAO.criar(pais);
	}

	public void atualizar(Pais pais) {
		paisDAO.atualiza(pais);
	}

	public void excluir(Pais pais) {
		paisDAO.excluir(pais);
	}

	public void carregar(Pais pais) {
		paisDAO.carregar(pais);
	}

	public void paisPopuloso(Pais pais) {
		paisDAO.paisPopuloso(pais);
	}

	public void menorArea(Pais pais) {
		paisDAO.menorArea(pais);
	}
	public void listaPais(int id) {
		paisDAO.listaPais(id);
	}
}
