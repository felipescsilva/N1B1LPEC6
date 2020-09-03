//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
//import java.util.Collections;
import java.util.Scanner;


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
		} catch(Exception e) {
			System.out.println("Impossível criar arquivo!");
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
			getFileLogin("C:\\Users\\felipe.silva\\Desktop\\login.txt");
			User usuario = new User();
			
			System.out.println(System.getProperty("user.dir"));
			
		
			System.out.println("--------  SISTEMA DE LOGIN ----------");
			
			Scanner login = new Scanner(System.in);
			System.out.print("Login: ");
			usuario.setUser(login.next());
			
			Scanner senha = new Scanner(System.in);
			System.out.print("Senha: ");
			usuario.setPassword(senha.next());			
			
			
			
			for(String c : lineFile) {
				   
				  
				if(c.split(";")[0].equals(usuario.getUser()) && c.split(";")[1].equals(usuario.getPassword()))
					System.out.println("Usuario logado");
				}
		
			
		}
		
		

}


