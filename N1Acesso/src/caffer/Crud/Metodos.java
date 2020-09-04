package caffer.Crud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Metodos {
	public static void escreverArquivoTexto(String nomeArquivo, String texto){
		File arquivo = new File(nomeArquivo);
		try {
			FileWriter fw = new FileWriter(arquivo);
			BufferedWriter bw = new BufferedWriter( fw );
			bw.write(texto);
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String lerArquivoTexto(String nomeArquivo) {
		String texto = "";
		File arquivo = new File(nomeArquivo);
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader( fr );
			while (br.ready()) {
				texto += br.readLine() + "\n";
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return texto;
	}
	
	public static String[] stringParaVetor(String arquivo) {
		String[] vetor = arquivo.split("\n");
		
		return vetor;
	}
	
	public static boolean verificaSeCodigoExiste (String arquivo, int codigo) {
		if (!arquivo.isEmpty()) {
			String[] listaDeRoupa = Metodos.stringParaVetor(arquivo);
			for (int i = 0; i < listaDeRoupa.length; i++) {
				int codigoVerificar = Integer.parseInt(listaDeRoupa[i].split("/")[0]);
				if (codigoVerificar == codigo)
					return true;
			}
		}
		return false;
	}
	
	public static int proximoId (String arquivo) {
		int maximoId = 0;
		String[] listaDeRoupa = Metodos.stringParaVetor(arquivo);
		for (int i = 0; i < listaDeRoupa.length; i++) {
			int codigoVerificar = Integer.parseInt(listaDeRoupa[i].split("/")[0]);
			if (codigoVerificar > maximoId)
				maximoId = codigoVerificar;
		}
		return maximoId + 1;
	}
}
