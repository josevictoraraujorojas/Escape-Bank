import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Cartao {
    public static Random aleatorio = new Random();
    public static void cartao() throws IOException {
        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheIdUser()));
        String caminho = new URIpadrao().URI() + id;
        File arquivo = new File(caminho,"Cartão.txt");
        arquivo.createNewFile();
        BufferedWriter escreve = new BufferedWriter(new FileWriter(arquivo,true));

        escreve.write("numero do cartao:"+numeroDoCartao());
        escreve.newLine();
        escreve.write("nome:"+nome());
        escreve.newLine();
        escreve.write("numero da conta:"+numeroDaConta());
        escreve.newLine();
        escreve.write("validade cartao:"+validadeCartao());
        escreve.newLine();
        escreve.write("codigo de seguranca:"+codigoDeSeguranca());
        escreve.close();
    }
    public static String nome() throws FileNotFoundException {
        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheIdUser()));
        String caminho = new URIpadrao().URI() + id + "\\CadastroCliente.txt";

        String nome = "";
        StringBuilder juntar = new StringBuilder("");
        Scanner lerArquivo = new Scanner(new File(caminho));
        while(true) {
            String linha;
            do {
                if (!lerArquivo.hasNext()) {
                    return nome;
                }

                linha = lerArquivo.nextLine();
            } while(!linha.contains("Nome"));

            nome = linha.substring(linha.indexOf(":") + 2);
            nome = nome.replaceAll(" ", "/ ");
            String a = nome.substring(nome.indexOf("/"));
            String[] Nome = a.split("/");
            nome = nome.substring(0, nome.indexOf("/"));

            int i;
            for(i = 1; i < Nome.length; ++i) {
                if (i == 1) {
                    Nome[i] = Nome[i].substring(1, 2);
                } else if (Nome[i].length() <= 3) {
                    Nome[i] = "";
                } else {
                    Nome[i] = Nome[i].substring(0, 2);
                }
            }

            for(i = 1; i < Nome.length; ++i) {
                Nome[i] = Nome[i].replaceAll(" ", ".");
                juntar = juntar.append(Nome[i]);
            }

            nome = nome + " " + juntar;
            nome = recursao(nome);
            System.out.println(nome);
        }
    }
    public static StringBuilder numeroDaConta(){
        StringBuilder numeroDaConta = new StringBuilder();
        numeroDaConta.append(aleatorio.nextInt(100,1000)).append(" ").append("011 ");
        numeroDaConta.append(aleatorio.nextInt(10000000,100000000)).append("-").append(aleatorio.nextInt(0,10));
        return numeroDaConta;

    }
    public static StringBuilder numeroDoCartao(){
        StringBuilder numeroDoCartao = new StringBuilder();
        numeroDoCartao.append(aleatorio.nextInt(1000,10000)).append("     ");
        numeroDoCartao.append(aleatorio.nextInt(1000,10000)).append("     ");
        numeroDoCartao.append(aleatorio.nextInt(1000,10000)).append("     ");
        numeroDoCartao.append(aleatorio.nextInt(1000,10000));
        return numeroDoCartao;
    }
    public static StringBuilder validadeCartao(){
        StringBuilder validade = new StringBuilder();
        validade.append(aleatorio.nextInt(0,9)+1).append("/").append("26");

        return validade;
    }
    public static StringBuilder codigoDeSeguranca(){
        StringBuilder codigoDeSeguranca = new StringBuilder();
        codigoDeSeguranca.append(aleatorio.nextInt(100,1000));
        return codigoDeSeguranca;
    }
    public static String recursao(String str) {
        if (str.length() <= 13) {
            return str;
        } else {
            StringBuilder a = new StringBuilder(str);
            a.delete(a.indexOf("."), a.indexOf(".") + 2);
            str = String.valueOf(a);
            return recursao(str);
        }
    }


}
