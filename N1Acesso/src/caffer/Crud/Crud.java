package caffer.Crud;

import caffer.Roupa.Cor;
import caffer.Roupa.Roupa;
import caffer.Roupa.Tamanho;

public class Crud {
	public void inserir(Roupa roupa) throws Exception {
		String texto = Metodos.lerArquivoTexto("dados.txt");
		if (!Metodos.verificaSeCodigoExiste(texto, roupa.getCodigoItem())) {
			texto += roupa.getCodigoItem() + "/"+ 
					roupa.getDataEntrega() + "/"+
					roupa.getLocalDaCompra() + "/"+
					roupa.getTipo() + "/" + 
					roupa.getMarca() + "/" + 
					roupa.getCaracteristicas() + "/" +
					roupa.getTamanho().getDescricao() + "/" +
					roupa.getCor().getDescricao() + "/" +
					roupa.getValorEtiqueta() + "/" + 
					roupa.getValorPago() + "/" + 
					roupa.getValorParaMargemDe100Porc() + "/" +
					roupa.getValorSugerido() + "\n";
			Metodos.escreverArquivoTexto("Dados.txt", texto);
		}
		else {
			throw new Exception();
		}
	}
	
	public void remover (int codigoItem) throws Exception {
		String texto = Metodos.lerArquivoTexto("dados.txt");
		if (Metodos.verificaSeCodigoExiste(texto, codigoItem)) {
			String novoTexto = "";
			String[] listaDeRoupa = Metodos.stringParaVetor(texto);
			for (int i = 0; i < listaDeRoupa.length; i++) {
				int codigoVerificar = Integer.parseInt(listaDeRoupa[i].split("/")[0]);
				if (codigoVerificar != codigoItem)
					novoTexto += listaDeRoupa[i] + "\n";
			}
			Metodos.escreverArquivoTexto("Dados.txt", novoTexto);
		}
		else {
			throw new Exception();
		}
	}
	
	public void atualizar (Roupa roupa) throws Exception {
		String texto = Metodos.lerArquivoTexto("dados.txt");
		if (Metodos.verificaSeCodigoExiste(texto, roupa.getCodigoItem())) {
			String novoTexto = "";
			String[] listaDeRoupa = Metodos.stringParaVetor(texto);
			for (int i = 0; i < listaDeRoupa.length; i++) {
				int codigoVerificar = Integer.parseInt(listaDeRoupa[i].split("|")[0]);
				if (codigoVerificar == roupa.getCodigoItem()) {
					String atualizar = roupa.getCodigoItem() + "/"+ 
							roupa.getDataEntrega() + "/"+
							roupa.getLocalDaCompra() + "/"+
							roupa.getTipo() + "/" + 
							roupa.getMarca() + "/" + 
							roupa.getCaracteristicas() + "/" +
							roupa.getTamanho().getDescricao() + "/" +
							roupa.getCor().getDescricao() + "/" +
							roupa.getValorEtiqueta() + "/" + 
							roupa.getValorPago() + "/" + 
							roupa.getValorParaMargemDe100Porc() + "/" +
							roupa.getValorSugerido();
					listaDeRoupa[i] = atualizar;
				}
				novoTexto += listaDeRoupa[i] + "\n";
			}
			Metodos.escreverArquivoTexto("Dados.txt", novoTexto);
		}
		else {
			throw new Exception();
		}
	}
	
	public Roupa ler (int codigoItem) throws Exception {
		String texto = Metodos.lerArquivoTexto("dados.txt");
		if (Metodos.verificaSeCodigoExiste(texto, codigoItem)) {
			Roupa roupa = new Roupa();
			String[] listaDeRoupa = Metodos.stringParaVetor(texto);
			for (int i = 0; i < listaDeRoupa.length; i++) {
				int codigoVerificar = Integer.parseInt(listaDeRoupa[i].split("/")[0]);
				if (codigoVerificar == codigoItem) {
					roupa.setCodigoItem(Integer.parseInt(listaDeRoupa[i].split("/")[0]));
					String data = listaDeRoupa[i].split("/")[1];
					int dia = Integer.parseInt(data.split("-")[2]);
					int mes = Integer.parseInt(data.split("-")[1]);
					int ano = Integer.parseInt(data.split("-")[0]);
					roupa.setDataEntrega(dia + "-" + mes + "-" + ano);
					roupa.setLocalDaCompra(listaDeRoupa[i].split("/")[2]);
					roupa.setTipo(listaDeRoupa[i].split("/")[3]);
					roupa.setMarca(listaDeRoupa[i].split("/")[4]);
					roupa.setCaracteristicas(listaDeRoupa[i].split("/")[5]);
					switch (listaDeRoupa[i].split("/")[6]){
						case "p":
							roupa.setTamanho(Tamanho.P);
							break;
						case "m":
							roupa.setTamanho(Tamanho.M);
							break;
						case "g":
							roupa.setTamanho(Tamanho.G);
							break;
					}
					switch (listaDeRoupa[i].split("/")[7]){
						case "branco":
							roupa.setCor(Cor.BRANCO);
							break;
						case "preto":
							roupa.setCor(Cor.PRETO);
							break;
						case "azul":
							roupa.setCor(Cor.AZUL);
							break;
						case "vermelho":
							roupa.setCor(Cor.VERMELHO);
							break;
						case "verde":
							roupa.setCor(Cor.VERDE);
							break;
					}
					roupa.setValorEtiqueta(Double.parseDouble(listaDeRoupa[i].split("/")[8]));
					roupa.setValorPago(Double.parseDouble(listaDeRoupa[i].split("/")[9]));
					roupa.setValorSugerido(Double.parseDouble(listaDeRoupa[i].split("/")[11]));
				}
			}
			return roupa;
		}
		else
			throw new Exception();
	}
	
}
