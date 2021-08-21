package com.relatorioempresa;

public class Estoque {
	private int  operacao,unidade;
	private String idProd ;
	
	public Estoque(String idProd,int operacao,int unidade) {
		this.setIdProd(idProd);
		this.setOperacao(operacao);
		this.setUnidade(unidade);
		
	}
	public int getOperacao() {
		return operacao;
	}
	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}
	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public int getUnidade() {
		return unidade;
	}
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
}
