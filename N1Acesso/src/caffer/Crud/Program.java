package caffer.Crud;


import java.util.Scanner;

import caffer.Roupa.Cor;
import caffer.Roupa.Roupa;
import caffer.Roupa.Tamanho;
import felipe.Login.Login;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login.menuLogin();
		interfaceUser();
	}
	
	public static void interfaceUser() {
		while(true) {
			Crud crud = new Crud();
			System.out.println("--------  CONTROLE DE ESTOQUE ----------");
			System.out.println("Digite: ");
			System.out.println("0: Adicionar ao estoque");
			System.out.println("1: Remover do estoque");
			System.out.println("2: Atualizar no estoque");
			System.out.println("3: Ver o estoque");	
			System.out.println("Outro: Sair");
			
			
			Scanner ler = new Scanner(System.in);
			int option = ler.nextInt();
			System.out.println("\n");
			
			switch(option)
			{
				case 0:
				try {
					Roupa roupa = lerDados();
					crud.inserir(roupa);
					System.out.println("O código do produto é: " + roupa.getCodigoItem());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("Algum valor foi informado de maneira incorreta!");
					System.out.println(e1.toString());
				}					
					break;
					
				case 1:
					System.out.println("Informe o código do produto: ");				
				try {
					crud.remover(ler.nextInt());
					System.out.println("Produto removido com sucesso!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("Algum valor foi informado de maneira incorreta!");
					System.out.println(e1.toString());
				}
					break;
					
				case 2:				
					boolean voltar = false;
					boolean correto = true;
					Roupa roupa = new Roupa();
					do {
						try {
							Scanner scannerRoupa = new Scanner(System.in);
							System.out.println("Informe o código do produto a atualizar: ");
							int opcaoRoupa = scannerRoupa.nextInt();
							roupa = crud.ler(opcaoRoupa);
							correto = true;
						}
						catch (Exception e) {
							System.out.println("Código informado inválido");
							correto = false;
						}
					} while (!correto);
					int opcaoAtualizar = 0;
					do {
						exibirDados(roupa);
						opcaoAtualizar = listaOpcoesAtualizacao(roupa);
						if (opcaoAtualizar == 11)
							voltar = true;
					} while (!voltar);
					break;
					
				case 3:
					System.out.println("Informe o código do produto: ");	
				try {
					exibirDados(crud.ler(ler.nextInt()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("Algum valor foi informado de maneira incorreta!");
					System.out.println(e1.toString());
				}
					break;
				default:
					ler.close();
					System.exit(0);
					break;
			}
		}
	}
	public static Roupa lerDados()
	{		
		String dataEntrega;
		String localDaCompra;
		String tipo;
		String marca;
		String caracteristicas;
		Tamanho tamanho; 
		Cor cor;
		double valorEtiqueta;
		double valorPago;		
		double valorSugerido;
		
		Scanner ler = new Scanner(System.in);
				
		System.out.println("Informe a data de entrega <dd-mm-aaaa>:  ");
		dataEntrega = ler.nextLine();
		
		System.out.println("Informe o local de compra");
		localDaCompra = ler.nextLine();
		
		System.out.println("Informe o tipo do produto: ");
		tipo = ler.nextLine();
		
		System.out.println("Informe a marca do produto: ");
		marca = ler.nextLine();
		
		System.out.println("Informe as características: ");
		caracteristicas = ler.nextLine();
		
		tamanho = lerTamanho();	
		
		cor = lerCor();		
		
		System.out.println("Informe o valor de etiqueta: ");
		valorEtiqueta = ler.nextDouble();
		System.out.println("Informe o valor pago: ");
		valorPago = ler.nextDouble();
		System.out.println("Informe o valor sugerido: ");
		valorSugerido = ler.nextDouble();
		
		//ler.close();
		
		Roupa roupa = new Roupa(dataEntrega, localDaCompra, tipo, marca, caracteristicas, tamanho, cor, valorEtiqueta, valorPago, valorSugerido);
		return roupa;
	}

	public static Tamanho lerTamanho()
	{
		while(true) {
			System.out.println("Informe o tamanho <P/M/G>: ");
			Scanner ler = new Scanner(System.in);
			String tamanho = ler.nextLine();
			//ler.close();			
			if(tamanho.equals("G") || tamanho.equals("g")) {
				return Tamanho.G;
			}
			else if(tamanho.equals("M") || tamanho.equals("m")) {
				return Tamanho.M;
			}
			else if(tamanho.equals("P") || tamanho.equals("p")) {
				return Tamanho.P;
			}
			else {
				System.out.println("Tamanho inválido!");
			}
			
		}
	}
	
	public static int listaOpcoesAtualizacao(Roupa roupa) {
		boolean correto = true;
		Crud crud = new Crud();
		int opcao = 0;
		do {
			try {
				System.out.println("1. Data de entrega");
				System.out.println("2. Local de compra");
				System.out.println("3. Tipo");
				System.out.println("4. Marca");
				System.out.println("5. Características");
				System.out.println("6. Tamanho");
				System.out.println("7. Cor");
				System.out.println("8. Valor de etiqueta na compra");
				System.out.println("9. Valor pago na compra");
				System.out.println("10. Preço sugerido");
				System.out.println("Outro. Sair");
				System.out.println("\n");
				Scanner ler = new Scanner(System.in);
				Scanner ler2 = new Scanner(System.in);
				System.out.println("Qual dessas opções deseja atualizar? ");
				opcao = ler.nextInt();
				correto = true;
				
				switch (opcao) {
					case 1:
						System.out.println("Informe a data de entrega <dd-mm-aaaa>:  ");
						roupa.setDataEntrega(ler2.nextLine());
						crud.atualizar(roupa);
						break;
					case 2:
						System.out.println("Informe o local de compra");
						roupa.setLocalDaCompra(ler2.nextLine());
						crud.atualizar(roupa);
						break;
					case 3:
						System.out.println("Informe o tipo do produto: ");
						roupa.setTipo(ler2.nextLine());
						crud.atualizar(roupa);
						break;
					case 4:
						System.out.println("Informe a marca do produto: ");
						String marca = ler2.nextLine();
						roupa.setMarca(marca);
						crud.atualizar(roupa);
						break;
					case 5:
						System.out.println("Informe as características: ");
						roupa.setCaracteristicas(ler2.nextLine());
						crud.atualizar(roupa);
						break;
					case 6:
						roupa.setTamanho(lerTamanho());	
						crud.atualizar(roupa);
						break;
					case 7:
						roupa.setCor(lerCor());	
						crud.atualizar(roupa);
						break;
					case 8:
						System.out.println("Informe o valor de etiqueta: ");
						roupa.setValorEtiqueta(ler2.nextDouble());
						crud.atualizar(roupa);
						break;
					case 9:
						System.out.println("Informe o valor pago: ");
						roupa.setValorPago(ler2.nextDouble());
						crud.atualizar(roupa);
						break;
					case 10:
						System.out.println("Informe o valor sugerido: ");
						roupa.setValorSugerido(ler2.nextDouble());
						crud.atualizar(roupa);
						break;
					default:
						opcao = 11;
						break;
				}
			}
			catch (Exception e) {
				System.out.println("Valor informado incorreto, digite um outro número para sair, ou digite umas das opções abaixo!");
				correto = false;
			}
		} while (!correto);
		return opcao;
	}
	
	public static Cor lerCor() {
		while(true) {
			System.out.println("Informe a cor <branco, preto, azul, vermelho, verde>: ");
			Scanner ler = new Scanner(System.in);
			String cor = ler.next();			
			//ler.close();
			cor = cor.toUpperCase();
			if(cor.equals("BRANCO")) {
				return Cor.BRANCO;
			}
			else if(cor.equals("PRETO")) {
				return Cor.PRETO;
			}
			else if(cor.equals("AZUL")) {
				return Cor.AZUL;
			}
			else if(cor.equals("VERMELHO")) {
				return Cor.VERMELHO;
			}
			else if(cor.equals("VERDE")) {
				return Cor.VERDE;
			}
			else {
				System.out.println("Cor inválida!");
			}
		}
		
	}
	
	public static void exibirDados(Roupa roupa) {
		System.out.println("Data de entrega: " + roupa.getDataEntrega());
		System.out.println("Local de compra: " + roupa.getLocalDaCompra());
		System.out.println("Tipo: " + roupa.getTipo());
		System.out.println("Marca: " + roupa.getMarca());
		System.out.println("Características: " + roupa.getCaracteristicas());
		System.out.println("Tamanho: " + roupa.getTamanho());
		System.out.println("Cor: " + roupa.getCor());
		System.out.println("Valor de etiqueta na compra: " + roupa.getValorEtiqueta());
		System.out.println("Valor pago na compra: " + roupa.getValorPago());
		System.out.println("Preço sugerido: " + roupa.getValorSugerido());
		System.out.println("\n");
	}
}
