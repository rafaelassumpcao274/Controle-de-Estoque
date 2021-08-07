package com.relatorioempresa;

import java.util.ArrayList;

public class RegistroDeProdutos {
	protected  static  ArrayList<Produto> produtos = new ArrayList<Produto>();


	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public void create(String nome,float unitario,int unidade,int estoque) {
		Produto prod = new Produto();
		prod.setNome(nome);
		prod.setPrecoUnitario(unitario);
		prod.setUnidade(unidade);
		prod.setQuantidade(estoque);
		produtos.add(prod);

	}
	
	public Produto findOne(String nome) {
		for(Produto i: produtos) {
			if(i.getNome().equals(nome)) {
				return i;
			}
		}
		return null;		
	}
	public ArrayList<Produto> findAll(){
		return produtos;
	}
	public boolean update(String nome,float unitario,int unidade,int estoque)  {
		Produto procurado = findOne(nome);
		if(procurado != null) {

			procurado.setPrecoUnitario(unitario);
			procurado.setUnidade(unidade);
			procurado.setQuantidade(estoque);
			return true;
			
		}
		return false;
	}
	public boolean delete(String nome)  {
		Produto procurado = findOne(nome);
		if(procurado != null) {			 
			produtos.remove(produtos.indexOf(procurado));
			return true;
			
		}
		return false;
	}
}
