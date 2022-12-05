import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Cartao {
    public static void main(String[] args) throws FileNotFoundException {
        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        id = String.valueOf(Cadastro.criptografia(id));
        String caminho = new URIpadrao().URI() + id + "\\CadastroCliente.txt";
        System.out.println(nome(caminho));
        System.out.println(numeroDaConta());
        System.out.println(validadeCartao());


    }
    public static String nome(String caminho) throws FileNotFoundException {
        String nome = "";
        Scanner lerArquivo = new Scanner(new File(caminho));
        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();
            if (linha.contains("Nome")) {
                nome = linha.substring(linha.indexOf(":") + 2);
            }
        }
        return nome;
    }
    public static StringBuilder numeroDaConta(){
        StringBuilder numeroDaConta = new StringBuilder();
        Random aleatorio = new Random();
        numeroDaConta.append(aleatorio.nextInt(100,1000)).append(" ").append("011 ");
        numeroDaConta.append(aleatorio.nextInt(10000000,100000000)).append("-").append(aleatorio.nextInt(0,10));
        return numeroDaConta;

    }
    public static StringBuilder validadeCartao(){
        StringBuilder validade = new StringBuilder();
        Random aleatorio = new Random();
        validade.append(aleatorio.nextInt(0,9)).append("/").append("26");

        return validade;
    }
}
