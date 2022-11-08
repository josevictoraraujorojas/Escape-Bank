import javax.management.StringValueExp;
import java.io.*;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        System.out.println("informe seu login:");
        String login = ler.nextLine();
        System.out.println("informe sua senha:");
        String senha = ler.nextLine();

        String id = String.valueOf(Cadastro.criptografia(login));
        String URI = "C:\\OneDrive\\EscapebankFiles\\logins\\";
        String caminho = URI+id;

        File diretorio = new File(caminho);

        String[] pasta = diretorio.list();
        assert pasta != null;
        String arquivo = pasta[0];

        BufferedReader le = new BufferedReader(new FileReader(caminho+"\\"+arquivo));
        String line;
        boolean verificaLogin=false;
        boolean verificaSenha=false;
        while ((line = le.readLine())!=null){
            if (line.equals(login)){
                verificaLogin=true;
            }
            else if (line.equals(String.valueOf(Cadastro.criptografia(senha)))){
                verificaSenha=true;
            }
        }
        if (verificaLogin && verificaSenha){
            System.out.println("login valido");
        }

    }
}
