package service;

import dao.OlimpiadasDAO;
import model.Olimpiadas;

public class OlimpiadasService {
OlimpiadasDAO olimpiadasDAO = new OlimpiadasDAO();
	
	public void criar(Olimpiadas olimpiadas) {
		olimpiadasDAO.criar(olimpiadas);
	}

	public void atualizar(Olimpiadas olimpiadas) {
		olimpiadasDAO.atualiza(olimpiadas);
	}

	public void excluir(Olimpiadas olimpiadas) {
		olimpiadasDAO.excluir(olimpiadas);
	}

	public void carregar(Olimpiadas olimpiadas) {
		olimpiadasDAO.carregar(olimpiadas);
	}

	
}
