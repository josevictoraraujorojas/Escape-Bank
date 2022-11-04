import java.io.File;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("informe seu login:");
        String login = ler.nextLine();
        File diretorio = new File(String.valueOf(Cadastro.criptografia(login)));
        System.out.println(diretorio.exists());
        String[] pasta = diretorio.list();

        String arquivo = pasta[0];
        System.out.println(arquivo);


    }
}
