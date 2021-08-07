package com.relatorioempresa;

import java.util.ArrayList;

public class RegistroDePrecos extends RegistroDeProdutos {
	private static ArrayList<Precos> precos = new ArrayList<Precos>();
	
	public void  create(String descricao,float valor,int percentual) {
		Precos preco = new Precos();
		preco.setDescricaoProduto(descricao);
		preco.setNovoValor(valor);
		preco.setPercentual(percentual);
		precos.add(preco);
	}
	public ArrayList<Precos> findPrecos(){
		return precos;
		
	}
	public void updateAll(int percentual) {
		try {
			for(Produto prod : super.produtos) {
				prod.setPrecoUnitario((prod.getPrecoUnitario()*100)/percentual);
			}
			create("Todos",0,percentual);
		}catch (Exception e) {
			System.out.println("Erro "+e);
		}

	}
	public void update (String nome,int percentual) {
		Produto i = super.findOne(nome);
		if(i != null) {
			i.setPrecoUnitario((i.getPrecoUnitario()*100)/percentual);
			create(nome,i.getPrecoUnitario(),percentual);
		}else {
			System.out.println("Produto nao encontrado");
		}
	}
	
	
	
	
	public ArrayList<Precos> findUm(String nome){
		ArrayList<Precos> produto = new ArrayList<Precos>();
		for(Precos i : precos) {
			if(i.getDescricaoProduto().equals(nome)) {
				produto.add(i);
			}
		}
		return produto;
	}
}
