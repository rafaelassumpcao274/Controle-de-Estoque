package com.relatorioempresa;

import java.util.Scanner;

public class Relatorio {
	
	RegistroDeProdutos regiProd = new RegistroDeProdutos();
	RegistroDeEstoque regiEstoq = new RegistroDeEstoque();
	RegistroDePrecos regiPreco = new RegistroDePrecos();
	
	Scanner scan = new Scanner(System.in);
	private String opc;
	
	
	
	public void pricipal(){	
		int resposta;
		if(regiProd.findOne("Sabao") == null) {
			regiProd.create("Sabao", 10.5F, 5, 10);
			regiEstoq.create("Sabao", 0, 10);
			regiProd.create("Teclado", 20.0F, 1, 50);
			regiEstoq.create("Teclado", 0, 50);
			regiProd.create("Monitor", 150.5F, 1, 50);
			regiEstoq.create("Monitor", 0, 50);
			regiProd.create("Mouse", 50.0F, 1, 50);
			regiEstoq.create("Mouse", 0, 50);
		}

		do {
			System.out.println("####   Relatorio ####");
			System.out.println("####   Escolha a opcao ####");
			System.out.println("1 - Produtos");
			System.out.println("2 - Estoque");
			System.out.println("0 - Retornar");
			System.out.print("Opção :");
			resposta = scan.nextInt();
			
			switch(resposta) {	
			case 1:				
				do {
					produtos();
					System.out.println("Deseja repetir operação:(S/N)");
					opc = scan.next();
				}while(opc.equals("N") & opc.equals("n"));
				
				break;
			case 2:
				estoque();				
				break;
			}
			
		}while(resposta != 0);
	}
	public void estoque() {
		int resposta;
		do {
			
			System.out.println("####   Escolha a opcao ####");
			System.out.println("1 - Entrada");
			System.out.println("2 - Saida");
			System.out.println("3 - Ambos");
			System.out.println("0 - Retornar");
			System.out.print("Opção :");
			resposta = scan.nextInt();
			
			switch(resposta) {	
			case 1:				
				do {
					tabela(0);
					System.out.println("Deseja repetir operação:(S/N)");
					opc = scan.next();
				}while(opc.equals("N") & opc.equals("n"));
				break;
			case 2:
				do {
					tabela(1);
					System.out.println("Deseja repetir operação:(S/N)");
					opc = scan.next();
				}while(opc.equals("N") & opc.equals("n"));
				break;
			case 3:
				do {
					tabela(2);
					System.out.println("Deseja repetir operação:(S/N)");
					opc = scan.next();
				}while(opc.equals("N") & opc.equals("n"));				
				break;
			}
			
		}while(resposta != 0);
	}
	public void produtos() {
		System.out.println("------------------------");
		System.out.print("| ");
		System.out.print("Nome");
		System.out.print("| ");
		System.out.print("Preco unitario");
		System.out.print("| ");
		System.out.print("Unidade");
		System.out.print("| ");
		System.out.print("Quantidade");
		System.out.print("| ");
		System.out.println();
		System.out.print("------------------------");
		for(Produto i : regiProd.findAll()) {
			System.out.println("------------------------");
			System.out.print("| ");
			System.out.print(i.getNome());
			System.out.print("| ");
			System.out.print(i.getPrecoUnitario());
			System.out.print("| ");
			System.out.print(i.getUnidade());
			System.out.print("| ");
			System.out.print(i.getQuantidade());
			System.out.print("| ");
			System.out.println();
			System.out.print("------------------------");
			
		}
		System.out.println();
	}
	public void tabela(int opcao) {
		if(regiEstoq.findAll(opcao) != null) {
			for(Estoque i : regiEstoq.findAll(opcao))
			{
				System.out.println("------------------------");
				System.out.print("| ");
				System.out.print(i.getIdProd());
				System.out.print("| ");
				if(i.getOperacao() < 1) {
					System.out.print("Entrada");
				}else {
					System.out.print("Saida");
				}
				
				System.out.print("| ");
				System.out.print(i.getUnidade());
				System.out.print("| ");
				System.out.println();
				System.out.print("------------------------");
				
			}
			System.out.println();
		}else {
			System.out.println("Nenhum registro de ");
			System.out.print((opcao < 1 )? "Entrada":"Saida");
		}
	}
		
	 
}
