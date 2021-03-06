package com.relatorioempresa;

import java.util.Scanner;

public class CadastroDeProdutos {
	RegistroDeProdutos orm = new RegistroDeProdutos();
	RegistroDeEstoque regiEstoq = new RegistroDeEstoque();
	
	Scanner scan = new Scanner(System.in);
	private int resposta,quantidade,unidade;
	private String nome;
	private float preco;

	public CadastroDeProdutos() {
		this.principal();
	}

	public void principal() {
		
		orm.findOne("Sabao");
		String repetir = "";

		do {
			System.out.println("Escolha a opcao");
			System.out.println("1 - Criar");
			System.out.println("2 - Procurar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Deletar");
			System.out.println("0 - Voltar");
			System.out.print("Op??o :");

			while(!scan.hasNextInt()){
				System.out.println("Escolha a opcao");
				System.out.println("1 - Criar");
				System.out.println("2 - Procurar");
				System.out.println("3 - Atualizar");
				System.out.println("4 - Deletar");
				System.out.println("0 - Voltar");
				System.out.print("Op??o :");
				scan.next();
			};
			resposta = scan.nextInt();

			switch(resposta) {
			case 0:
				break;
			case 1:
				do {
					criar();
					System.out.println("Deseja repetir opera?ao: (S/N)");
					repetir = scan.next();						
				}while(repetir.equals("S") || repetir.equals("s"));
				break;
			case 2:				
				do {
					buscar();
					System.out.println("Deseja repetir opera?ao: (S/N)");
					repetir = scan.next();
				}while(repetir.equals("S") || repetir.equals("s"));
				break;
			case 3:
				atualizar();
				do {
					System.out.println("Deseja repetir opera?ao: (S/N)");
					repetir = scan.next();
					if(repetir.equals("S") || repetir.equals("s"))
						atualizar();
				}while(repetir.equals("N") && repetir.equals("n"));
				break;
			case 4:
				do {
					deletar();
					System.out.println("Deseja repetir opera?ao: (S/N)");
					repetir = scan.next();
				}while(repetir.equals("S") || repetir.equals("s"));
				deletar();
			default:
				System.out.println("Digite um numero valido !!!!");
			}
		}while(resposta != 0);
	}

	public void criar() throws  java.util.InputMismatchException {
		
		String resposta = "";
		System.out.print("Digite o nome:");
		nome = scan.next();		
		System.out.println("Digite o Pre?o:");	
		while(!scan.hasNextFloat()){
			System.out.println("Digite o Pre?o:");			
			scan.next();
		};
		preco = scan.nextFloat();
		System.out.println("Digite a Qtd Unitario:");
		while(!scan.hasNextInt()){
			System.out.println("Digite a Qtd Unitario:");
			scan.next();			
		};
		unidade = scan.nextInt();
		if(unidade > 0 ) {
			System.out.println("Digite a quantidade no estoque:");
			while(!scan.hasNextInt()){
				System.out.println("Digite a quantidade no estoque:");
				scan.next();			
			};
			quantidade = scan.nextInt();
			if(quantidade>= 0) {
				if(orm.findOne(nome) != null) {
					System.out.println("Erro produto ja cadastrado !!!!");
				}else {
					do {
						System.out.println("Digite para confirmar cadastro:(S/N)");
						resposta = scan.next();
						if(resposta.equals("S") || resposta.equals("s"))
						{
							orm.create(nome, preco, unidade, quantidade);
							regiEstoq.create(nome, 0, quantidade);
							System.out.println("Produto castrado com sucesso");
							break;
						}
					}while(resposta.equals("N") && resposta.equals("n"));

				}
			}else {
				System.out.println("Erro quantidade menor que zero");
			}

		}else {
			System.out.println("Erro valor menor ou igual a zero !!!!");
		}

		
	}
	private boolean lista(String nome) {
		Produto produto = orm.findOne(nome);
		if(produto!= null) {			
			System.out.println("Nome: "+produto.getNome());
			System.out.println("Preco: "+produto.getPrecoUnitario());
			System.out.println("Unidade: "+ produto.getUnidade());
			System.out.println("Quantidade: "+produto.getQuantidade());
			return true;
		}
		return false;
			
		
	}
	
	public void buscar() {
		System.out.println("Digite o nome:");
		nome = scan.next();
		if(!lista(nome))
			System.out.println("Erro produto n?o encontrado !!!!!");
	}
	public void atualizar() {
		System.out.print("Digite o nome:");
		nome = scan.next();
		if(orm.findOne(nome) != null)
		{
			lista(nome);
			System.out.println("######################");
			System.out.println("Digite o Pre?o:");
			while(!scan.hasNextFloat()) {
				System.out.println("Digite o Pre?o:");			
				scan.next();
			}
			preco = scan.nextFloat();
			System.out.println("Digite a Qtd Unitario:");
			while(!scan.hasNextInt()){
				System.out.println("Digite a Qtd Unitario:");
				scan.next();			
			};
			unidade = scan.nextInt();
			System.out.println("Digite a quantidade no estoque:");
			while(!scan.hasNextInt()){
				System.out.println("Digite a quantidade no estoque:");
				scan.next();			
			};
			quantidade = scan.nextInt();
			if(orm.update(nome, preco, unidade, quantidade)) {
				System.out.println("Atualizado com sucesso");
			}else {
				System.out.println("Erro ao atualizar");
			}
			
			
		}else{
			System.out.println("Erro produto n?o encontrado!!!");
		}

	}
	public void deletar() {
		String resposta = "";
		System.out.println("Digite o nome:");
		nome = scan.next();
		if(lista(nome)) {
			System.out.println("Confirma exclusao do produto: (S/N)");
			resposta = scan.next();
			if(resposta.equals("S") || resposta.equals("s")) {
				if(orm.delete(nome)) {
					System.out.println("Deletado com sucesso !!!");
				}else {
					System.out.println("Erro produto n?o encontrado!!!");
				}
			}
		}else{
			System.out.println("Erro produto n?o encontrado");
		}


	}

}
