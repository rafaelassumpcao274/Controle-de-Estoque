package com.relatorioempresa;

import java.util.ArrayList;

public class RegistroDeEstoque extends RegistroDeProdutos{
	private static ArrayList<Estoque> esto = new ArrayList<Estoque>();
	private Produto prod = new Produto();
	
	public boolean create(String id,int operacao,int qtdEstoque) {
		Estoque tempEstoque = new Estoque();
		if(this.getProd() != null) {
			tempEstoque.setIdProd(id);
			tempEstoque.setOperacao(operacao);
			tempEstoque.setUnidade(qtdEstoque);
			esto.add(tempEstoque);
			super.update(prod.getNome(),prod.getPrecoUnitario(), prod.getUnidade(), qtdEstoque);
			return true;
		}
		return false;
	};
	public Produto findProduto(String nome) {
		
		this.setProd(super.findOne(nome));
		return this.getProd();
	}
	public ArrayList<Estoque> findAll(int opcao) {
		ArrayList<Estoque> temp  = new ArrayList<Estoque>();
		if(opcao >1) {
			return esto;
		}
		for(Estoque i : esto)
		{
			if(i.getOperacao() == opcao) {
				temp.add(i);
			}
		}
		return temp;
	}
	public Produto getProd() {
		return prod;
	}
	public void setProd(Produto prod) {
		this.prod = prod;
	}
	

}
