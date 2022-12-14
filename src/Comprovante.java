import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Comprovante {
    static Color cor1 = new PaletaDeCores().cor1();
    public static File rostoComprovante = new File("H:\\Meu Drive\\ScapeBank\\Pattern\\RostoComprovante.txt");
    public static Scanner rosto; //só pra ler o comprovante padrão, na pasta Pattern ficam arquivos padrão
    public static File arquivoProvisorio(String usuario) throws IOException { //aqui ele cria um arquivo provisório
        StringBuilder URI2 = new StringBuilder(new URIpadrao().URI()+ //ele lê no resumo de operações, salva em
                usuario +"\\provisorio.txt"); //um vetor e do vetor ele imprime no padrão que o comprovante lê
        File provisorio = new File(String.valueOf(URI2)); //neste arquivo provisório.
        return provisorio;
    }
    static {
        try {
            rosto = new Scanner(rostoComprovante); //scanner lendo o padrão.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static File acessarResumo(String usuario) throws IOException { //seu método tem que escrever no resumo de operações
        StringBuilder URI2 = new StringBuilder(new URIpadrao().URI()+ //pode ver o código no Pix -> escrevePix
                usuario +"\\resumoOperacoes.txt"); // e escrever no padrão que rola no preenche dados
        File resumoOperacoes = new File(String.valueOf(URI2));
        return resumoOperacoes;
    }
/*    public static void criarResumo() throws IOException {
        String cripto = String.valueOf(Cadastro.criptografia(Pix.nomeUsuario()));
        String uri = "H:\\Meu Drive\\ScapeBank\\Login\\" + cripto + "\\resumoOperacoes.txt";
        File a = new File(uri);
        a.createNewFile();
    }*/
/*    public static void criarProvisorio() throws IOException {
        String cripto = String.valueOf(Cadastro.criptografia(Pix.nomeUsuario()));
        String uri = "H:\\Meu Drive\\ScapeBank\\Login\\" + cripto + "\\provisorio.txt";
        File a = new File(uri);
        a.createNewFile();
    }*/
    public static void escreverInicial(String usuario) throws IOException {
        File resumoOperacoes = acessarResumo(usuario);
        FileWriter escreve = new FileWriter(resumoOperacoes);
        escreve.write(".\t.\t.\t.\tjjjj\t.\tR$:0,00\t.\tbbbb\t.\t.\t." +
                "\tcccccccccccccccccccccccccccccc\tdddddddddddddd\teeeeeeeeeeeeeeee\tffffffff\t.\t.\t." +
                "\tgggggggggggggggggggggggg\thhhhhhhhhhhhhhhhhhhh\tiiiiiiiiiiiiiiii\t.\t.\t.\t.\t.");
        escreve.write("\n");
        escreve.close();
    }
    public static void escreveProvisorio(String usuario, String vetor[]) throws IOException {
        String nick;
        nick = String.valueOf(arquivoProvisorio(usuario));
        BufferedWriter wr2 = new BufferedWriter(new FileWriter(nick, false));
        String dados[] = vetor;
        for (int i = 0; i < dados.length; i++) { //aqui ele escreve o vetor que leu no resumo de operações
            wr2.write(dados[i] + "\t"); //no padrão que o print consegue ler e imprimir
        }
        wr2.newLine();
        wr2.close();
    }
    public static void chamarComprovante(String usuario, String operacao) throws IOException { //mudar o nome pra um chamarComprovante
        String vetor[] = criaVetor(usuario,operacao);
        escreveProvisorio(usuario, vetor);
        readPrintFile(usuario);
    }
/*    public static void main(String[] args) throws IOException {
        chamarComprovante("97114105971109710910111510710511697", "ari41");
    }*/
    public static Scanner scan;
    public static String[] criaVetor(String usuario, String operacao) throws IOException {
        String nick;
        nick = String.valueOf(acessarResumo(usuario));
        File dadosResumo = new File(String.valueOf(nick)); //aqui ele lê o resumo de operações e chama a
        scan = new Scanner(dadosResumo); //operação criada lá e escreve em um vetor que será escrito no
        String vetor[] = new String[30]; //provisório depois para ser lido mais facilmente
        while (scan.hasNextLine()){
            usuario = scan.nextLine();
            if (usuario.contains(operacao)){
                for (int i = 0; i < usuario.length(); i++) {
                    vetor = usuario.split("\t");
                }
            }
        }
        System.out.println(Arrays.toString(vetor));
        return vetor;
    }
    public static void readPrintFile(String usuario) throws IOException {  //aqui ele lê o provisório e imprime o comprovante
        UIManager.getDefaults().put("OptionPane.background",cor1);
        UIManager.put ("Panel.background", cor1);
        StringBuilder impressao = new StringBuilder();
        Scanner scan = new Scanner(arquivoProvisorio(usuario));
        rosto = new Scanner(rostoComprovante);
        String pix;
        while (rosto.hasNextLine()) {
            pix = scan.next();
            impressao = impressao.append("<html><font color=#FF00FF face=arial><i><b>" +
                    rosto.nextLine().replace('.', ' ') +
                    pix.replace('.', ' ').replace(':',' ') + "\n");
        }
    JOptionPane.showMessageDialog(null, impressao, "Comprovante", JOptionPane.PLAIN_MESSAGE);
    }
}
