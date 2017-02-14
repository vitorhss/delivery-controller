package br.com.delivery.management.domain;

public class Rota implements Comparable<Rota> {
	private String rota;

	private Double valorCusto;

	public Rota(String rota, Double valorCusto) {
		super();
		this.rota = rota;
		this.valorCusto = valorCusto;
	}

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

	public Double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rota == null) ? 0 : rota.hashCode());
		result = prime * result + ((valorCusto == null) ? 0 : valorCusto.hashCode());
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
		Rota other = (Rota) obj;
		if (rota == null) {
			if (other.rota != null)
				return false;
		} else if (!rota.equals(other.rota))
			return false;
		if (valorCusto == null) {
			if (other.valorCusto != null)
				return false;
		} else if (!valorCusto.equals(other.valorCusto))
			return false;
		return true;
	}

	@Override
	public int compareTo(Rota o) {
		return valorCusto.compareTo(o.valorCusto);
	}

}
