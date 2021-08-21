package com.relatorioempresa;

import java.util.ArrayList;

public class RegistroDePrecos extends RegistroDeProdutos {
	private static ArrayList<Precos> precos = new ArrayList<Precos>();
	

	
	public RegistroDePrecos() {
		super();
	}
	public void  create(String descricao,float valor,int percentual) {
		Precos preco = new Precos(descricao,valor,percentual);
		precos.add(preco);
	}
	public ArrayList<Precos> findPrecos(){
		return precos;
		
	}
	public void updateAll(int percentual) {
		try {
			float  porcent = percentual/100F;
			float updateP;
			for(Produto prod : super.produtos) {
				updateP = prod.getPrecoUnitario();
				prod.setPrecoUnitario(Math.round((porcent +1)* updateP));
			}
			create("Todos",0,percentual);
		}catch (Exception e) {
			System.out.println("Erro "+e);
		}

	}
	public void update (String nome,int percentual) {
		Produto i = super.findOne(nome);
		float porcentagem,updateP;
		porcentagem = percentual/100F;
		if(i != null) {
			updateP = i.getPrecoUnitario();
			i.setPrecoUnitario(Math.round((porcentagem+1)*updateP));
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
