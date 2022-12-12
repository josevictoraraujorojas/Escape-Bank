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

    public static void main(String[] args) throws IOException {
        String usuario = "97114105971109710910111510710511697";
        Scanner scan = new Scanner(acessarResumo(usuario));
        do{
            String extrato = scan.nextLine();
            Extrato(extrato);
            escreveExtrato(usuario, Extrato(extrato));
        }while (scan.hasNextLine());
/*        Scanner scan2 = new Scanner(acessarExtrato(usuario));
        Scanner scan3 = new Scanner(nome2);
        String nome3 = scan3.nextLine();
        String vetorDiminui[] = new String[100], vetorSoma[] = new String[100];
        while (scan2.hasNextLine()){
            for (int i = 0; i < 100; i++) {
                String extrato = scan2.nextLine();
                String ler[] = criaVetor(extrato);
                if (ler[3].contains(nome3)){
                    vetorSoma[i] = ler[1].substring(ler[1].indexOf('$')+1);
                } else {
                    vetorDiminui[i] = ler[1].substring(ler[1].indexOf('$')+1);
                }
            }
        }
        System.out.print(Arrays.toString(vetorSoma));
        System.out.println(Arrays.toString(vetorDiminui));*/
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
}
