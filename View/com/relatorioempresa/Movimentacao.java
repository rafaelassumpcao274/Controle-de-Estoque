package com.relatorioempresa;

import java.util.Scanner;

public class Movimentacao  {
	
	RegistroDeEstoque regi = new RegistroDeEstoque();
	RegistroDeProdutos regiProd = new RegistroDeProdutos();
	Scanner scan = new Scanner(System.in);
	private int resposta,quantidade,unidade,valor;
	private String nome;
	private float preco;
	
	public Movimentacao() {
		this.pricipal();
	}



	public void pricipal(){		

		do {
			System.out.println("####   Escolha a opcao ####");
			System.out.println("1 - Entrada");
			System.out.println("2 - Saida");
			System.out.println("0 - Retornar");
			System.out.print("Opção :");

			while(!scan.hasNextInt()){
				System.out.println("####   Escolha a opcao ####");
				System.out.println("1 - Entrada");
				System.out.println("2 - Saida");
				System.out.println("0 - Retornar");
				System.out.print("Opção :");
				scan.next();
			};
			resposta = scan.nextInt();
			
			switch(resposta) {	
			case 1:
				entrada();
				break;
			case 2:
				saida();
				break;
			}
			
		}while(resposta != 0);
	}
	
	public void  entrada()
	{
		Produto produto;
		String opcao = "";
		do {
			System.out.println("Nome Produto:");
			nome = scan.next();
			produto= regiProd.findOne(nome);			
			if(produto != null) {
				preco = produto.getPrecoUnitario();
				unidade =produto.getUnidade();
				quantidade = produto.getQuantidade();
				System.out.println("atual:"+ quantidade);
				System.out.print("Entrada: ");
				while(!scan.hasNextInt()) {
					System.out.print("Entrada: ");
					scan.next();
				}
				valor = scan.nextInt();
				System.out.println("Final:"+ (valor+quantidade));
				System.out.println("Confirma: (S/N)");
				opcao = scan.next();
				if(opcao.equals("S")| opcao.equals("s"))
				{
					regiProd.update(nome, preco, unidade, quantidade+valor);
					regi.create(nome, 0, valor);					
				}					
			}
		}while(opcao.equals("N")|| opcao.equals("n"));

	}
	
	public void saida() {
		Produto produto;
		String opcao = "";
		do {
			System.out.println("Nome Produto:");
			nome = scan.next();
			produto= regiProd.findOne(nome);			
			if(produto != null) {
				preco = produto.getPrecoUnitario();
				unidade =produto.getUnidade();
				quantidade = produto.getQuantidade();
				System.out.println("atual:"+ quantidade);
				System.out.print("Saida: ");
				while(!scan.hasNextInt()) {
					System.out.print("Saida: ");
					scan.next();
				}
				valor = scan.nextInt();
				System.out.println("Final:"+ Math.abs(valor-quantidade));
				System.out.println("Confirma: (S/N)");
				opcao = scan.next();
				if(opcao.equals("S")| opcao.equals("s"))
				{
					regiProd.update(nome, preco, unidade, quantidade-valor);
					regi.create(nome, 1, valor);					
				}					
			}
		}while(opcao.equals("N")|| opcao.equals("n"));
	}
}
