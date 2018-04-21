package service;

import dao.OlimpiadasDAO;
import model.Olimpiadas;

public class OlimpiadasService {
OlimpiadasDAO dao = new OlimpiadasDAO();
	
	public void criar(Olimpiadas olimpiadas) {
		dao.criar(olimpiadas);
	}

	public void atualizar(Olimpiadas olimpiadas) {
		dao.atualiza(olimpiadas);
	}

	public void excluir(Olimpiadas olimpiadas) {
		dao.excluir(olimpiadas);
	}

	public Olimpiadas carregar(int ano) {
		return dao.carregar(ano);
		
	}

	

	
}