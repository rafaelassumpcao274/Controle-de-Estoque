package com.relatorioempresa;


public class Produto {

	private String nome;
	private float precoUnitario;
	private int unidade;
	private int quantidade;

	public Produto(String nome,float precoUnitario,int unidade,int quantidade) {
		this.setNome(nome);
		this.setPrecoUnitario(precoUnitario);
		this.setQuantidade(quantidade);
		this.setUnidade(unidade);	
	
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getUnidade() {
		return unidade;
	}
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
