import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SaldoEExtrato {
    public static File acessarResumo(String usuario){
        StringBuilder URI2 = new StringBuilder(new URIpadrao().URI()+
                usuario +"\\resumoOperacoes.txt");
        File resumoOperacoes = new File(String.valueOf(URI2));
        return resumoOperacoes;
    }
    public static File nome2 = new File(new URIpadrao().URICacheUserName());
    public static File nome = new File(new URIpadrao().URICacheIdUser());
    public static String userEnvio;
    public static File userNome = new File("C:\\EscapeBankCache\\username.txt");
    static Scanner scan;
    static { try { scan = new Scanner(userNome); } catch (FileNotFoundException e) {
        throw new RuntimeException(e); } }
    static String userLeitura = scan.nextLine();

    public static double retornarExtrato() throws IOException {
        userEnvio = String.valueOf(Cadastro.criptografia(userLeitura));
        Scanner scan2 = new Scanner(acessarResumo(userEnvio));
        do{
            String extrato = scan2.nextLine();
            Extrato(extrato);
            escreveExtrato(userEnvio, Extrato(extrato));
        } while (scan2.hasNextLine());
        double extratoFinal = calculaExtrato(userEnvio);
        String valor = String.valueOf(extratoFinal);
        valor = valor.substring(0, valor.indexOf('.')+2);
        extratoFinal = Double.parseDouble(valor);
        FileWriter escreve = new FileWriter(acessarExtrato(userEnvio));
        escreve.write("");
        escreve.close();
        return extratoFinal;
    }

/*    public static void main(String[] args) throws IOException {
        System.out.println(retornarExtrato());
    }*/
    public static String[] criaVetor(String extrato) throws IOException {
        String vetor[] = extrato.split("\t");
        return vetor;
    }
    public static String[] Extrato(String extrato) throws IOException {
        String vetor[] = criaVetor(extrato);
        String vetorExtrato[] = new String[4];
        for (int i = 0; i < vetor.length; i++) {
            String s = vetor[i];
            if (s == vetor[4])
                vetorExtrato[0] = s; //numero da Operação
            if (s == vetor[6])
                vetorExtrato[3] = s; //valor da Operação
            if (s == vetor[8])
                vetorExtrato[2] = s; //nome da Operação
            if (s == vetor[21])
                vetorExtrato[1] = s; //nome de quem enviou
        }
        return vetorExtrato;
    }
    public static File acessarExtrato(String usuario){
        StringBuilder URI2 = new StringBuilder(new URIpadrao().URI()+
                usuario +"\\extrato.txt");
        File extrato = new File(String.valueOf(URI2));
        return extrato;
    }
    public static void escreveExtrato(String usuario, String vetor[]) throws IOException {
        String nick;
        nick = String.valueOf(acessarExtrato(usuario));
        BufferedWriter wr2 = new BufferedWriter(new FileWriter(nick, true));
        String vetor1[] = vetor;
        for (int j = 0; j < vetor1.length; j++) {
            wr2.write(vetor1[j] + "\t");
        }
        wr2.newLine();
        wr2.close();
    }
    public static double calculaExtrato(String usuario) throws IOException {
        Scanner scan2 = new Scanner(acessarExtrato(usuario));
        String nome4;
        double soma = 0;

        while (scan2.hasNextLine()) {
            nome4 = scan2.nextLine();
            nome4 = nome4.replace(':', ' ').replace(',','.');
            nome4 = nome4.substring(nome4.indexOf('$') + 1);
            nome4 = nome4.substring(0, nome4.indexOf('.') + 3);
            if (nome4.contains(" ")) {
                nome4 = nome4.substring(1, nome4.length());
            }
            double valores = Double.parseDouble(nome4);
            soma += valores;
        }
        return soma;
    }
}