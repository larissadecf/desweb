package model;

import java.util.ArrayList;

public class Olimpiadas {
	private int ano;
	private String tipo;
	ArrayList<Pais> pais;
	ArrayList<Modalidades> modalidade;

	public Olimpiadas() {

	}

	public Olimpiadas(int ano, String tipo, ArrayList<Pais> pais, ArrayList<Modalidades> modalidade) {
		setPais(pais);
		setModalidade(modalidade);
		setAno(ano);
		setTipo(tipo);
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Pais> getPais() {
		return pais;
	}

	public void setPais(ArrayList<Pais> pais) {
		this.pais = pais;
	}

	public ArrayList<Modalidades> getModalidade() {
		return modalidade;
	}

	public void setModalidade(ArrayList<Modalidades> modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public String toString() {
		return "Olimpiadas [ano=" + ano + ", tipo=" + tipo + ", pais=" + pais + ", modalidade=" + modalidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((modalidade == null) ? 0 : modalidade.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Olimpiadas other = (Olimpiadas) obj;
		if (ano != other.ano)
			return false;
		if (modalidade == null) {
			if (other.modalidade != null)
				return false;
		} else if (!modalidade.equals(other.modalidade))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
