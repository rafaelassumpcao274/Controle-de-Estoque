package com.relatorioempresa;

import java.util.Scanner;

public class PrecoProdutos {
	
	RegistroDePrecos regiPreco = new RegistroDePrecos();
	Scanner scan = new Scanner(System.in);
	private int resposta;
	
	public PrecoProdutos() {
		this.pricipal();
	}


	public void pricipal(){		
		do {
			System.out.println("####   Escolha a opcao ####");
			System.out.println("1 - Todos");
			System.out.println("2 - Produto especifico");
			System.out.println("0 - Retornar");
			System.out.print("Opção :");

			while(!scan.hasNextInt()) {
				System.out.println("####   Escolha a opcao ####");
				System.out.println("1 - Todos");
				System.out.println("2 - Produto especifico");
				System.out.println("0 - Retornar");
				System.out.print("Opção :");
				scan.next();
			};
			resposta = scan.nextInt();
			
			switch(resposta) {	
			case 1:
				aumentarTodos();
				break;
			case 2:
				aumentarUm();
				break;
			}
			
		}while(resposta != 0);
	}
	
	



	public void aumentarTodos() {
		int percentual = 0;
		System.out.println("Digite o percentual:");
		while(!scan.hasNextInt()) {
			System.out.println("Digite o percentual:");
			scan.next();
		}
		percentual = scan.nextInt();
		regiPreco.updateAll(percentual);
	}
	public void  aumentarUm() {
		String nome;
		int percentual;
		System.out.println("Digite nome do Produto:");
		nome = scan.next();
		System.out.println("Digite o percentual:");
		while(!scan.hasNextInt()) {
			System.out.println("Digite o percentual:");
			scan.next();
		}
		percentual = scan.nextInt();
		regiPreco.update(nome, percentual);
	}
}
