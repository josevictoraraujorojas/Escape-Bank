import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ContaOutroBanco {
    /*    abertura de conta - baseada em salário atual - possibilidade de cheque especial com porcentagem salário;
        cadastrar conta aleatoria - ele informar um nome e senha ficticio - abrir um valor random;
        deletar conta - onde e como fazer.*/
    public static Scanner scan = new Scanner(System.in);
    //    public static StringBuilder IdPaths = new StringBuilder(new SetPaths().GetPaths("C:\\EscapeBank\\native.txt"));
    public static StringBuilder URI = new StringBuilder("H:\\Meu Drive\\ScapeBank\\Login\\97114105971109710910111510710511697\\ContaCorrente.txt");
    public static File contaCorrente = new File(java.lang.String.valueOf(URI));
    static Random random = new Random();
    public static BufferedWriter wr;
    public static Random rd = new Random();
    static {
        try {
            wr = new BufferedWriter(new FileWriter(contaCorrente, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        contaOutroBanco();
    }
    public static void contaOutroBanco() throws IOException {
        java.lang.String nomeBanco, numBanco, numAgencia, numConta, saldoConta;
        System.out.println("Entre nome do banco: ");
        nomeBanco = scan.nextLine();
        System.out.println("Entre numero do banco: ");
        numBanco = scan.nextLine();
        System.out.println("Entre numero de agencia: ");
        numAgencia = scan.nextLine();
        System.out.println("Entre numero de conta: ");
        numConta = scan.nextLine();
        saldoConta = String.valueOf(random.nextDouble(0.00,1500.00));
        //saldoConta = colocar pra cortar dois depois do ponto
        escreveArquivo("Banco: ", numBanco);
        escreveArquivo("Agência: ", numAgencia);
        escreveArquivo("Conta: ", numConta);
        escreveArquivo("Saldo: ", saldoConta.substring(0,saldoConta.indexOf('.')+3));
        wr.close();

        String usuario = "97114105971109710910111510710511697";
        String[] vetor = Pix.criaVetor();
        Pix.dadosCadastroReceptor(usuario, vetor);
        Pix.preencheDados(vetor, "gggggggggggggggggggggggg", nomeBanco);
        String loginEnvio = Pix.dadosLogin(usuario);
        Pix.preencheDados(vetor, "iiiiiiiiiiiiiiii", loginEnvio);
        Pix.preencheDados(vetor, "eeeeeeeeeeeeeeee", "AG:." + numAgencia + "//.CC:" + numConta);
        Pix.preencheDados(vetor, "bbbb", "portabilidade");
        Pix.preencheDados(vetor, "ffffffff", "Corrente");
        Pix.preencheDados(vetor, "hhhhhhhhhhhhhhhhhhhh", "OutroBanco");
        String numeroOp = String.valueOf(rd.nextInt(0,100));
        Pix.preencheDados(vetor, "jjjj", loginEnvio.substring(0,3) + numeroOp);
        Pix.preencheDados(vetor, "aaaaaaaa", "R$" + saldoConta.substring(0,saldoConta.indexOf('.')+3));
        Pix.escrevePix(usuario, vetor);
        Comprovante.chamarComprovante(usuario, numeroOp);
    }
    public static void escreveArquivo(java.lang.String x, java.lang.String y) throws IOException {
        wr.write(x + y);
        wr.newLine();
    }
}