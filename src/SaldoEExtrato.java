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
    public static String usuario, userEnvio;

    public static File userNome = new File("C:\\EscapeBankCache\\username.txt");
    static Scanner scan;

    static { try { scan = new Scanner(userNome); } catch (FileNotFoundException e) {
        throw new RuntimeException(e); } }
    public static void main(String[] args) throws IOException {
        String userLeitura = scan.nextLine();
        userEnvio = String.valueOf(Cadastro.criptografia(userLeitura));
        Scanner scan2 = new Scanner(acessarResumo(userEnvio));
        do{
            String extrato = scan2.nextLine();
            Extrato(extrato);
            escreveExtrato(userEnvio, Extrato(extrato));
        } while (scan2.hasNextLine());
        calculaExtrato(userEnvio);

    }
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
    public static void calculaExtrato(String usuario) throws IOException {
        Scanner scan2 = new Scanner(acessarExtrato(usuario));
        String nome4;
        Scanner scan3 = new Scanner(nome2);
        String nome3 = scan3.nextLine();
/*        int vetorDiminui[] = new int[25], vetorSoma[] = new int[25];
        for (int i = 0; i < 23; i++) {
            nome4 = scan2.nextLine();
            if (scan2.hasNextLine()){
                for (int j = 0; j < 1; j++) {
                    if (ler[1].contains(nome3)){
                        vetorSoma[i] = ler[3].substring(ler[3].indexOf('$')+1);
                        vetorDiminui[i] = "0";
                    } else {
                        vetorSoma[i] = "0";
                        vetorDiminui[i] = ler[3].substring(ler[3].indexOf('$')+1);
                    }
                }
            }
        }
        System.out.print(Arrays.toString(vetorSoma));
        System.out.println(Arrays.toString(vetorDiminui));
        int soma = 0;
        for (int i = 0; i < vetorSoma.length; i++) {
            soma = (Integer.parseInt(vetorSoma[i]) + Integer.parseInt(vetorSoma[i+1]));
            i++;
        }
        System.out.println(soma);*/
    }
/*    public static int quantidadeLinhas(){
        Scanner scan2 = new Scanner(acessarExtrato(usuario));
        String nome4;
    }*/
}
