package com.relatorioempresa;

public class Precos {

	private String descricaoProduto;
	private float novoValor;
	private int percentual;
	
	public Precos(String descricaoProduto,float novoValor,int percentual) {
		this.setDescricaoProduto(descricaoProduto);
		this.setNovoValor(novoValor);
		this.setPercentual(percentual);
	}
	
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public float getNovoValor() {
		return novoValor;
	}
	public void setNovoValor(float novoValor) {
		this.novoValor = novoValor;
	}
	public int getPercentual() {
		return percentual;
	}
	public void setPercentual(int percentual) {
		this.percentual = percentual;
	}
}
