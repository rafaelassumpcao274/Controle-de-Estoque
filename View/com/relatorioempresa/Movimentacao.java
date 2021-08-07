package com.relatorioempresa;

import java.util.Scanner;

public class Movimentacao  {
	
	RegistroDeEstoque regi = new RegistroDeEstoque();
	Scanner scan = new Scanner(System.in);
	private int resposta,quantidade,unidade,valor;
	private String nome;
	private float preco;
	public void pricipal(){		
//		for (int i = 0; i < 50; ++i) System.out.println();
		do {
			
			System.out.println("####   Escolha a opcao ####");
			System.out.println("1 - Entrada");
			System.out.println("2 - Saida");
			System.out.println("0 - Retornar");
			System.out.print("Opção :");
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
			produto= regi.findProduto(nome);			
			if(produto != null) {
				preco = produto.getPrecoUnitario();
				unidade =produto.getUnidade();
				quantidade = produto.getQuantidade();
				System.out.println("atual:"+ quantidade);
				System.out.print("Entrada: ");
				valor = scan.nextInt();
				System.out.println("Final:"+ (valor+quantidade));
				System.out.println("Confirma: (S/N)");
				opcao = scan.next();
				if(opcao.equals("S")| opcao.equals("s"))
				{
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
			produto= regi.findProduto(nome);			
			if(produto != null) {
				preco = produto.getPrecoUnitario();
				unidade =produto.getUnidade();
				quantidade = produto.getQuantidade();
				System.out.println("atual:"+ quantidade);
				System.out.print("Saida: ");
				valor = scan.nextInt();
				System.out.println("Final:"+ Math.abs(valor-quantidade));
				System.out.println("Confirma: (S/N)");
				opcao = scan.next();
				if(opcao.equals("S")| opcao.equals("s"))
				{
					regi.create(nome, 1, valor);					
				}					
			}
		}while(opcao.equals("N")|| opcao.equals("n"));
	}
}
