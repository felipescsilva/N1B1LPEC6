import felipe.Login.Login;
import felipe.Login.User;
import caffer.Crud.Crud;
import caffer.Roupa.Cor;
import caffer.Roupa.Roupa;
import caffer.Roupa.Tamanho;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login.menuLogin();
		Crud crud = new Crud();
		Roupa roupa = new Roupa("23-12-2020", "Fábrica", "Camisa", "NIKE", "Qualquer caracteristica", Tamanho.G, Cor.BRANCO,
				800.00, 800.00, 800.00);
		try {
			Roupa atualizar = crud.ler(4);
			atualizar.setValorPago(900.00);
			//crud.inserir(roupa);
			crud.atualizar(atualizar);
			//crud.remover(3);
			Roupa ver = crud.ler(4);
			System.out.println(ver.getTamanho());
			System.out.println(ver.getCor());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
