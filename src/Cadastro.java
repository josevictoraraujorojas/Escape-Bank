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

    do {
        if (validacaoDeUsuario(login) ||verificaLoginDuplicada(login))
        {
            System.out.println("login invalido");
            System.out.println("Informe seu login:");
            login = ler.nextLine();
        }

        else if (validaDeSenhaRegex(senha) ||senha.equals(login)|| verificaSequencia(senha)){
            System.out.println("Senha invalida");
            System.out.println("Informe sua senha:");
            senha = ler.nextLine();
        }

    }while (senha.equals(login)|| validacaoDeUsuario(senha) || validaDeSenhaRegex(senha) ||verificaLoginDuplicada(login)|| verificaSequencia(senha));

    File diretorio = new File(String.valueOf(criptografia(login)));
    diretorio.mkdir();
    File arquivo = new File(diretorio,"LoginESenha.txt");
    arquivo.createNewFile();
    BufferedWriter armazenaSenha = new BufferedWriter(new FileWriter(arquivo, true));
    BufferedWriter armazenalogin = new BufferedWriter(new FileWriter(arquivo, true));
    armazenaLoginESenha(armazenaSenha,armazenalogin,login,senha);

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

    public static Boolean verificaLoginDuplicada(String login) {
        File verificaDuplicado = new File(String.valueOf(criptografia(login)));
        return verificaDuplicado.exists();
    }

    public static void armazenaLoginESenha(BufferedWriter armazenaSenha, BufferedWriter armazenalogin,String login, String senha){
        try {
            armazenalogin.write(login+"\n");
            armazenaSenha.write(criptografia(senha)+"\n");
            armazenalogin.close();
            armazenaSenha.close();

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
