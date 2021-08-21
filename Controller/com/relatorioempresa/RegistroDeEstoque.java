package com.relatorioempresa;

import java.util.ArrayList;

public class RegistroDeEstoque {
	private static ArrayList<Estoque> esto = new ArrayList<Estoque>();

	
	public RegistroDeEstoque() {
	}

	public boolean create(String id,int operacao,int qtdEstoque) {
		try {
			
			Estoque tempEstoque = new Estoque(id.toLowerCase(), operacao,qtdEstoque);
			this.esto.add(tempEstoque);
			return true;			
		}catch (Exception e) {
			return false;
		}
		
		
	};

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


}
