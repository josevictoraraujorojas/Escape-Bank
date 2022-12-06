import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerCartao {
    public static String numeroDoCartao () throws FileNotFoundException {
       return pesquisaArquivo("numero do cartao:");
    }
    public static String nome () throws FileNotFoundException {
       return pesquisaArquivo("nome:");
    }
    public static String numeroDaConta () throws FileNotFoundException {
       return pesquisaArquivo("numero da conta:");
    }
    public static String  validadeCartao () throws FileNotFoundException {
       return pesquisaArquivo("validade cartao:");
    }
    public static String pesquisaArquivo(String pesquisa) throws FileNotFoundException {
        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        id = String.valueOf(Cadastro.criptografia(id));
        String caminho = new URIpadrao().URI() + id + "\\Cartão.txt";
        String numeroCarao = "";
        Scanner lerArquivo = new Scanner(new File(caminho));
        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();
            if (linha.contains(pesquisa)) {
                numeroCarao = linha.substring(linha.indexOf(":") + 1);
            }
        }
        return numeroCarao;
    }
}
