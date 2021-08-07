package com.relatorioempresa;

import java.util.Scanner;

public class CadastroDeProdutos {
	RegistroDeProdutos orm = new RegistroDeProdutos();
	RegistroDeEstoque regiEstoq = new RegistroDeEstoque();
	
	Scanner scan = new Scanner(System.in);
	private int resposta,quantidade,unidade;
	private String nome;
	private float preco;

	public void principal() {
		
		orm.findOne("Sabao");
		String repetir = "";
//		for (int i = 0; i < 50; ++i) System.out.println();
		do {
			
			System.out.println("Escolha a opcao");
			System.out.println("1 - Criar");
			System.out.println("2 - Procurar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Deletar");
			System.out.println("0 - Voltar");
			System.out.print("Opção :");
			resposta = scan.nextInt();

			switch(resposta) {
			case 0:
				break;
			case 1:
				criar();
				do {
					System.out.println("Deseja repetir operaçao: (S/N)");
					repetir = scan.next();
					if(repetir.equals("S") || repetir.equals("s"))
						criar();
				}while(repetir.equals("N") && repetir.equals("n"));
				break;
			case 2:
				buscar();
				do {
					System.out.println("Deseja repetir operaçao: (S/N)");
					repetir = scan.next();
					if(repetir.equals("S") || repetir.equals("s"))
						buscar();
				}while(repetir.equals("N") && repetir.equals("n"));
				break;
			case 3:
				atualizar();
				do {
					System.out.println("Deseja repetir operaçao: (S/N)");
					repetir = scan.next();
					if(repetir.equals("S") || repetir.equals("s"))
						atualizar();
				}while(repetir.equals("N") && repetir.equals("n"));
				break;
			case 4:
				do {
					System.out.println("Deseja repetir operaçao: (S/N)");
					repetir = scan.next();
					if(repetir.equals("S") || repetir.equals("s"))
						deletar();
				}while(repetir.equals("N") && repetir.equals("n"));
				deletar();
			default:
				System.out.println("Digite um numero valido !!!!");
			}
		}while(resposta != 0);
	}

	public void criar() {
		
		String resposta = "";
		System.out.print("Digite o nome:");
		nome = scan.next();
		System.out.println("Digite o Preço:");
		preco = scan.nextFloat();
		System.out.println("Digite a Qtd Unitario:");
		unidade = scan.nextInt();
		if(unidade > 0 ) {
			System.out.println("Digite a quantidade no estoque:");
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
			System.out.println("Erro produto não encontrado !!!!!");
	}
	public void atualizar() {
		System.out.print("Digite o nome:");
		nome = scan.next();
		if(orm.findOne(nome) != null)
		{
			lista(nome);
			System.out.println("######################");
			System.out.println("Digite o preco:");
			preco = scan.nextFloat();
			System.out.println("Digite Qtd Uni:");
			unidade = scan.nextInt();
			System.out.println("Digite a quantidade no estoque:");
			quantidade = scan.nextInt();
			if(orm.update(nome, preco, unidade, quantidade)) {
				System.out.println("Atualizado com sucesso");
			}else {
				System.out.println("Erro ao atualizar");
			}
			
			
		}else{
			System.out.println("Erro produto não encontrado!!!");
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
					System.out.println("Erro produto não encontrado!!!");
				}
			}
		}else{
			System.out.println("Erro produto não encontrado");
		}


	}

}
