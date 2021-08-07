package com.relatorioempresa;

import java.util.Scanner;

public class Principal {
	
	public void telaPrincipal() {
		CadastroDeProdutos cad = new CadastroDeProdutos();
		Movimentacao movi = new Movimentacao();
		PrecoProdutos pp = new PrecoProdutos();
		Relatorio relat = new Relatorio();
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
			resposta = scan.nextInt();
			
			switch(resposta) {	
			case 1:
				cad.principal();
				break;
			case 2:
				movi.pricipal();
				break;
			case 3:
				pp.pricipal();
				break;
			case 4:
				relat.pricipal();
				break;
			}
			
		}while(resposta != 0);
		System.out.println("Saindo");
	}
	
}
