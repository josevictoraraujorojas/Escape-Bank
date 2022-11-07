import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Cadastro {public static void main(String[] args) throws IOException {

    Scanner ler = new Scanner(System.in);

    System.out.println("Informe seu login:");
    String login = ler.nextLine();
    System.out.println("informe a sua senha:");
    String senha = ler.nextLine();

    String URI = "C:\\Users\\2022101202010252.IFGOIANO\\OneDrive\\";
    StringBuilder id = new StringBuilder(String.valueOf(criptografia(login)));
    StringBuilder caminho = new StringBuilder(URI+id);


    do {
        if (validacaoDeUsuario(login) ||verificaLoginDuplicada(String.valueOf(caminho)))
        {
            System.out.println("login invalido");
            System.out.println("Informe seu login:");
            login = ler.nextLine();
            id.delete(0,id.length());
            id.append(String.valueOf(criptografia(login)));
            caminho.delete(0,caminho.length());
            caminho.append(URI).append(id);
        }

        else if (validaDeSenhaRegex(senha) ||senha.equals(login)|| verificaSequencia(senha)){
            System.out.println("Senha invalida");
            System.out.println("Informe sua senha:");
            senha = ler.nextLine();
        }

    }while (senha.equals(login)|| validacaoDeUsuario(senha) || validaDeSenhaRegex(senha) ||verificaLoginDuplicada(login)|| verificaSequencia(senha));


            File diretorio = new File(String.valueOf(caminho));

    diretorio.mkdir();
    File arquivo = new File(diretorio,"LoginESenha.txt");
    arquivo.createNewFile();
    BufferedWriter armazena = new BufferedWriter(new FileWriter(arquivo, true));

    armazenaLoginESenha(armazena,login,senha);
}

    public static boolean validacaoDeUsuario(String login){
        for (char letra:login.toCharArray()) {
            if (!Character.isLetterOrDigit(letra)&&letra!='_')
            {
                return true;
            } else if (Character.isDigit(login.charAt(0)))
            {
                return true;
            }else if (!(login.length()>=8&&login.length()<=16))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean verificaSequencia(String senha){
        boolean retonar=true;
        for (int i = 0; i < senha.length(); i++) {
            if (i< senha.length()-2&& Character.isDigit(senha.charAt(i))){
                int p1,p2;
                p1=senha.charAt(i)-senha.charAt(i+1);
                p2=senha.charAt(i+1)-senha.charAt(i+2);
                if ((p1== 1 && p2 == 1) || (p1 == -1 && p2 == -1)){
                    retonar = false;
                }

            }
        }return !retonar;
    }


    public static boolean validaDeSenhaRegex(String senha){
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$");
        Matcher matcher = pattern.matcher(senha);
        return !matcher.find();
    }

    public static Boolean verificaLoginDuplicada(String caminho) {
        File verificaDuplicado = new File(caminho);
        return verificaDuplicado.exists();
    }

    public static void armazenaLoginESenha( BufferedWriter armazena,String login, String senha){
        try {
            armazena.write(login);
            armazena.newLine();
            armazena.write(String.valueOf(criptografia(senha)));
            armazena.newLine();
            armazena.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static StringBuilder criptografia(String senha){
        StringBuilder codificacao = new StringBuilder();
        for (int i = 0; i < senha.length() ; i++) {
            codificacao.append(senha.codePointAt(i));
        }

        return codificacao;
    }
}
