import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Pix {
    public static StringBuilder IdPaths = new StringBuilder(new SetPaths().
            GetPaths(new URIpadrao().URICacheIdUser()));
    public static StringBuilder URI = new StringBuilder(new URIpadrao().URI()+
            IdPaths +"\\dadosPix.txt");
    public static File dadosPix = new File(String.valueOf(URI));
    public static Scanner scan, scan2, scan3, scan4;
    public static String usuario, valor, userEnvio;
    public static File padraoPix = new File("C:\\EscapeBank\\Pattern\\padraoPix.txt");
    public static void main(String[] args) throws IOException {
        scan = new Scanner(System.in);
        System.out.println("Seu usuario");
        userEnvio = String.valueOf(Cadastro.criptografia(scan.nextLine()));
        System.out.println("Usuario:");
        usuario = String.valueOf(Cadastro.criptografia(scan.nextLine()));
        dadosPix(userEnvio);
        dadosPix(usuario);
        dadosCadastro(userEnvio);

/*        if (verificaUsuario(usuario)){
            System.out.println("usuário encontrado");
            escrevePix(usuario);
        }
        else System.out.println("usuário não encontrado. tente novamente.");*/
    }
    public static boolean verificaUsuario(String usuario) throws FileNotFoundException {
        scan2 = new Scanner(new File (new URIpadrao().URIusrdescript()));
        while (scan2.hasNextLine()){
            String user = scan2.nextLine();
            if (usuario.equals(user)){
                return true;
            }
        }
        return false;
    }
    public static void escrevePix(String usuario) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(dadosPix, true));
        valor = scan.nextLine();
        wr.write(usuario);
        wr.newLine();
        wr.write(valor);
        wr.close();
    }
    public static File acessarResumo(String x){
        StringBuilder URI2 = new StringBuilder(new URIpadrao().URI()+
                x +"\\resumoOperacoes.txt");
        File resumoOperacoes = new File(String.valueOf(URI2));
        return resumoOperacoes;
    }
    public static StringBuilder acessarCadastro(String x){
        StringBuilder cadastro = new StringBuilder(new URIpadrao().URI()+
                x +"\\CadastroCliente.txt");
        return cadastro;
    }
    public static void dadosPix(String y) throws IOException {
        String nick;
        nick = String.valueOf(acessarResumo(y));
        BufferedWriter wr2 = new BufferedWriter(new FileWriter(nick, true));
        scan3 = new Scanner(new File(String.valueOf(padraoPix)));
        while (scan3.hasNext()){
            wr2.write(scan3.next() + "\t");
        }
        wr2.close();
    }
    public static void dadosCadastro(String userName) throws IOException {
        String nome = null, cpf = null, nick, nome2, replace;
        nick = String.valueOf(acessarCadastro(userName));
        File dadosCadastro = new File(String.valueOf(nick));
        scan4 = new Scanner(dadosCadastro);
        while (scan4.hasNextLine()){
            nome2 = scan4.nextLine();
            if (nome2.contains("Nome: ")){
                nome = nome2.substring(nome2.indexOf(':')+2);
            }
            if (nome2.contains("CPF: ")){
                cpf = nome2.substring(nome2.indexOf(':')+2);
            }
        }
        String vetor[] = criaVetor(userName);
        preencheDados(vetor, "cccccccccccccccccccccccccccccc", nome);
        preencheDados(vetor, "dddddddddddddd", cpf);
    }
    public static String[] criaVetor(String arquivo) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader(acessarResumo(arquivo)));
        String ler = rd.readLine();
        String vetor[] = ler.split("\t");
        return vetor;
    }
    public static void preencheDados(String[] a, String x, String y) throws IOException {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(x)){
                a[i] = y;
            }
        }
        System.out.print(Arrays.toString(a));
    }

}
