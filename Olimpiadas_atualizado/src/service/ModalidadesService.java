package service;

import dao.ModalidadesDAO;
import model.Modalidades;

public class ModalidadesService {

ModalidadesDAO modalidadesDAO = new ModalidadesDAO();
	
	public void criar(Modalidades modalidades) {
		modalidadesDAO.criar(modalidades);
	}

	public void atualizar(Modalidades modalidades) {
		modalidadesDAO.atualiza(modalidades);
	}

	public void excluir(Modalidades modalidades) {
		modalidadesDAO.excluir(modalidades);
	}

	public void carregar(Modalidades modalidades) {
		modalidadesDAO.carregar(modalidades);
	}
	
	public void listaModalidades(int id)
	{
		modalidadesDAO.listaModalidades(id);
	}
}
