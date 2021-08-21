package com.relatorioempresa;

import java.util.Scanner;

public class Principal {
	public Principal() {
		this.telaPrincipal();
	}
	public void telaPrincipal() {		
		
		Scanner scan = new Scanner(System.in);
		int resposta;
		

		do {
			System.out.println("####   Escolha a opcao ####");
			System.out.println("1 - Cadastro de produtos");
			System.out.println("2 - Movimentacao");
			System.out.println("3 - Reajuste de preco");
			System.out.println("4 - Relatorio");
			System.out.println("0 - Finalizar");
			System.out.print("Opção :");
			while(!scan.hasNextInt()){
				System.out.println("####   Escolha a opcao ####");
				System.out.println("1 - Cadastro de produtos");
				System.out.println("2 - Movimentacao");
				System.out.println("3 - Reajuste de preco");
				System.out.println("4 - Relatorio");
				System.out.println("0 - Finalizar");
				System.out.print("Opção :");
				scan.next();
			}; 
			resposta = scan.nextInt();
			
			switch(resposta) {	
			case 1:
				CadastroDeProdutos cad = new CadastroDeProdutos();
				break;
			case 2:
				Movimentacao movi = new Movimentacao();
				break;
			case 3:
				PrecoProdutos pp = new PrecoProdutos();
				break;
			case 4:
				Relatorio relat = new Relatorio();
				break;
			}
			
		}while(resposta != 0);
		System.out.println("Saindo");
	}
	
}
