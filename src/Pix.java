import java.io.*;
import java.util.Scanner;

public class Pix {

    public static StringBuilder IdPaths = new StringBuilder(new SetPaths().
            GetPaths(new URIpadrao().URICacheIdUser()));
    public static StringBuilder URI = new StringBuilder(new URIpadrao().URI()+
            IdPaths +"\\dadosPix.txt");
    public static StringBuilder URI2 = new StringBuilder(new URIpadrao().URI()+
            IdPaths +"\\resumoOperacoes.txt");
    public static File dadosPix = new File(String.valueOf(URI));
    public static File resumoOperacoes = new File(String.valueOf(URI2));
    public static Scanner scan, scan2, scan3, scan4;
    public static String usuario, valor, userEnvio;
    public static StringBuilder cadastro = new StringBuilder(new URIpadrao().URI()+
            IdPaths +"\\CadastroCliente.txt");
    public static File dadosCadastro = new File(String.valueOf(cadastro));
    public static File padraoPix = new File("C:\\EscapeBank\\Pattern\\padraoPix.txt");

    public static void main(String[] args) throws IOException {
        scan = new Scanner(System.in);
        System.out.println("Seu usuario");
        userEnvio = String.valueOf(Cadastro.criptografia(scan.nextLine()));
        System.out.println("Usuario:");
        usuario = String.valueOf(Cadastro.criptografia(scan.nextLine()));
        dadosPix(userEnvio, usuario);
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
    public static void dadosPix(String userSend, String userReceive) throws IOException {
        String nickSend, nickReceive;
        nickSend = userSend;
        nickReceive = userReceive;
        BufferedWriter wr2 = new BufferedWriter(new FileWriter(resumoOperacoes, true));
        scan3 = new Scanner(new File(String.valueOf(padraoPix)));
        while (scan3.hasNext()){
            wr2.write(scan3.next() + "\t");
        }
        wr2.close();
        dadosCadastro(nickSend);
        dadosCadastro(nickReceive);
    }
    public static void dadosCadastro(String userName) throws IOException {
        String nome = null, cpf = null;
        scan4 = new Scanner(userName);
        while (scan4.hasNextLine()){
            String nome2 = scan4.nextLine();
            if (nome2.contains("Nome: ")){
                nome = nome2.substring(nome2.indexOf(':')+2);
            }
            if (nome2.contains("CPF: ")){
                cpf = nome2.substring(nome2.indexOf(':')+2);
            }
        }
        escreveDadosPix(nome, cpf);
    }
    public static void escreveDadosPix(String nome, String cpf) throws IOException {
        BufferedWriter wr3 = new BufferedWriter(new FileWriter(resumoOperacoes, true));
        scan3 = new Scanner(new File(String.valueOf(padraoPix)));
        while (scan3.hasNext()){
            String dados = scan3.next();
            if (dados.contains("cccccccccccccccccccccccccccccc")){
                dados.replace("cccccccccccccccccccccccccccccc", nome);
            }
            if (dados.contains("dddddddddddddd")){
                dados.replace("dddddddddddddd", cpf);
            }
        }
    }
}
