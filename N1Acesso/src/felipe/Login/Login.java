package felipe.Login;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.PrintWriter;


public class Login {
	
	static ArrayList<String> lineFile = new ArrayList<String>();
	
	public static boolean getFileLogin(String pathFile) {
		
		File caminho = new File (pathFile);  //Informar caminho do arquivo
		if(caminho.exists()) {  
			try {
				FileReader filereader = new FileReader(caminho); 
				BufferedReader bufferedReader = new BufferedReader(filereader);
				
				String line = "";				
								
		        while ( ( line = bufferedReader.readLine() ) != null) {
		        lineFile.add(line);		                     
		    }
		        
		        filereader.close();
		        bufferedReader.close();
		        return true;
		               			
			
			}catch(Exception erro) {
				return false;
			}
		}
		
		File newArquivo = new File(System.getProperty("user.dir"), "login.txt"); 
		
		try {
			newArquivo.createNewFile();
			FileWriter fileWriter = new FileWriter(newArquivo, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			cadastroUser(printWriter);
			getFileLogin(System.getProperty("user.dir") + "\\login.txt");
			
		} catch(Exception e) {
			System.out.println("Impossível criar arquivo!");
		}
		return false;
	}
	
	public static void cadastroUser(PrintWriter printWriter) {
		System.out.println("\n");
		System.out.println("***  CADASTRO DE NOVO USUARIO ***");
		
		User usuario = new User();
		String login, senha, confSenha;
				
		Scanner ler = new Scanner(System.in);
		System.out.print("Informe um Login: ");
		login = ler.next();
				
		ler = new Scanner(System.in);
		System.out.print("Informe uma Senha: ");
		senha = ler.next();
				
		ler = new Scanner(System.in);
		System.out.print("Confirme a Senha: ");
		confSenha = ler.next();
		
		if(!(senha.equals(confSenha))) {
			System.out.println("Senhas incompatíveis");
			System.out.println();
			cadastroUser(printWriter);
		}
		
		usuario.setUser(login);
		usuario.setPassword(senha);
		
		try {
			printWriter.println(usuario.getUser() + ";" + usuario.getPassword());

            //o método flush libera a escrita no arquivo
            printWriter.flush();

            //No final precisamos fechar o arquivo
            printWriter.close();
            
            System.out.println("Usuário cadastrado com sucesso!");
            

        } catch (Exception e) {
            
        }
	}
	
	public static void menuLogin() {
		System.out.println("--------  SISTEMA DE LOGIN ----------");
		System.out.println("Digite: ");
		System.out.println("0: LOGIN");
		System.out.println("1: CADASTRO");
		
		Scanner ler = new Scanner(System.in);
		String option;
		option = ler.next();
		
		
		
		boolean checkLogin = false;
		if(option.equals("0")) {
			while(!checkLogin) {
				checkLogin = login();
			}
		} else if (option.equals("1")) {
			File newArquivo = new File(System.getProperty("user.dir"), "login.txt"); 
			
			try {
				newArquivo.createNewFile();
				FileWriter fileWriter = new FileWriter(newArquivo, true);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				cadastroUser(printWriter);
				menuLogin();
				
			} catch(Exception e) {
				System.out.println("Impossível criar arquivo!");
			};
		} else {
			System.out.println("Opção inválida!");
			menuLogin();
		}
	}
	
	public static boolean login() {
		getFileLogin(System.getProperty("user.dir") + "\\login.txt");
		User usuario = new User();
		
		System.out.println("\n");
		System.out.println("--------  EFETUAR LOGIN ----------");
			
		Scanner login = new Scanner(System.in);
		System.out.print("Login: ");
		usuario.setUser(login.next());
		
		Scanner senha = new Scanner(System.in);
		System.out.print("Senha: ");
		usuario.setPassword(senha.next());			
		
		
		for(String c : lineFile) {				   
			  
			if(c.split(";")[0].equals(usuario.getUser()) && c.split(";")[1].equals(usuario.getPassword())) {
				System.out.println("Usuario logado");
				System.out.println("\n");
				return true;
			}
				
		}
		
		System.out.println("Login ou senha incorretos. Tente novamente!");
		System.out.println("\n");
		return false;
	}
				

}


