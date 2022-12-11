import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Pix {
    public static StringBuilder IdPaths = new StringBuilder(new SetPaths().
            GetPaths(new URIpadrao().URICacheIdUser()));
    public static StringBuilder URI = new StringBuilder(new URIpadrao().URI()+
            IdPaths +"\\dadosPix.txt");
    public static File dadosPix = new File(String.valueOf(URI));
    public static Scanner scan, scan2, scan4;
    public static String usuario, userEnvio, valorPix;
    public static Random rd = new Random();
    public static File padraoPix = new File("H:\\Meu Drive\\ScapeBank\\Pattern\\padraoPix.txt");
    static String uri ="H:\\Meu Drive\\ScapeBank\\Login\\";
    public static void main(String[] args) throws IOException {
        scan = new Scanner(System.in);
        userEnvio = String.valueOf(Cadastro.criptografia(new URIpadrao().URICacheIdUser()));
        do {
            System.out.println("Usuario:");
            usuario = String.valueOf(Cadastro.criptografia(scan.nextLine()));
            if (!verificaUsuario(usuario)){
                System.out.print("Usuário não encontrado. Tente novamente.");
            }
        } while (!verificaUsuario(usuario));
        System.out.println("Valor: ");
        valorPix = scan.nextLine();
        String vetor[] = criaVetor(userEnvio);
        dadosCadastro(userEnvio, vetor);
        dadosCadastroReceptor(usuario, vetor);
        String loginEnvio = dadosLogin(userEnvio);
        preencheDados(vetor, "iiiiiiiiiiiiiiii", loginEnvio);
        String loginUser = dadosLogin(usuario);
        preencheDados(vetor, "eeeeeeeeeeeeeeee", loginUser);
        preencheDados(vetor, "bbbb", "pix");
        preencheDados(vetor, "ffffffff", "Corrente");
        preencheDados(vetor, "hhhhhhhhhhhhhhhhhhhh", "ScapeBank");
        String numeroOp = String.valueOf(rd.nextInt(0,100));
        preencheDados(vetor, "jjjj", loginEnvio.substring(0,3) + numeroOp);
        preencheDados(vetor, "aaaaaaaa", "R$" + valorPix);
        escrevePix(userEnvio, vetor);
        escrevePix(usuario, vetor);
    }
    public static boolean verificaUsuario(String usuario) throws FileNotFoundException {
        File URI = new File((new File(uri) + "\\" + usuario));
        if (URI.exists())
            return true;
        return false;
    }
/*    public static void escrevePix(String usuario) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(dadosPix, true));
        valor = scan.nextLine();
        wr.write(usuario);
        wr.newLine();
        wr.write(valor);
        wr.close();
    }*/
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
    public static StringBuilder acessarLogin(String x){
        StringBuilder login = new StringBuilder(new URIpadrao().URI()+
                x +"\\LoginESenha.txt");
        return login;
    }
    public static void escrevePix(String usuario, String vetor[]) throws IOException {
        String nick;
        nick = String.valueOf(acessarResumo(usuario));
        BufferedWriter wr2 = new BufferedWriter(new FileWriter(nick, true));
        String dados[] = vetor;
        for (int i = 0; i < dados.length; i++) {
            wr2.write(dados[i] + "\t");
        }
        wr2.newLine();
        wr2.close();
    }
    public static void dadosCadastroReceptor(String userName, String[] vetor) throws IOException {
        String nome = null, cpf = null, nick, nome2, nome3;
        nick = String.valueOf(acessarCadastro(userName));
        File dadosCadastro = new File(String.valueOf(nick));
        scan4 = new Scanner(dadosCadastro);
        while (scan4.hasNextLine()){
            nome2 = scan4.nextLine();
            if (nome2.contains("Nome: ")){
                nome3 = nome2.substring(nome2.indexOf(':')+2);
                nome = nome3.replace(' ', '.');
            }
            if (nome2.contains("CPF: ")){
                cpf = nome2.substring(nome2.indexOf(':')+2);
            }
        }
        preencheDados(vetor, "cccccccccccccccccccccccccccccc", nome);
        preencheDados(vetor, "dddddddddddddd", cpf);
    }
    public static void dadosCadastro(String userName, String[] vetor) throws IOException {
        String nome = null, nick, nome2, nome3;
        nick = String.valueOf(acessarCadastro(userName));
        File dadosCadastro = new File(String.valueOf(nick));
        scan4 = new Scanner(dadosCadastro);
        while (scan4.hasNextLine()){
            nome2 = scan4.nextLine();
            if (nome2.contains("Nome: ")){
                nome3 = nome2.substring(nome2.indexOf(':')+2);
                nome = nome3.replace(' ', '.');
            }
        }
        preencheDados(vetor, "gggggggggggggggggggggggg", nome);
    }
    public static String[] criaVetor(String arquivo) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader(padraoPix));
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
    }
    public static String dadosLogin(String username) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader(String.valueOf(acessarLogin(username))));
        String login = rd.readLine();
        return login;
    }
}
