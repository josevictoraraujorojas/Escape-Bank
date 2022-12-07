import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Comprovante {
    static Color cor1 = new PaletaDeCores().cor1();
    public static File rostoComprovante = new File("H:\\Meu Drive\\ScapeBank\\Pattern\\RostoComprovante.txt");
    public static Scanner rosto;
    public static Scanner pix;
    public static File arquivoProvisorio(String x){
        StringBuilder URI2 = new StringBuilder(new URIpadrao().URI()+
                x +"\\provisorio.txt");
        File provisorio = new File(String.valueOf(URI2));
        return provisorio;
    }
    static {
        try {
            rosto = new Scanner(rostoComprovante);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static {
        try {
            pix = new Scanner(arquivoProvisorio("97114105971109710910111510710511697"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static File acessarResumo(String x){
        StringBuilder URI2 = new StringBuilder(new URIpadrao().URI()+
                x +"\\resumoOperacoes.txt");
        File resumoOperacoes = new File(String.valueOf(URI2));
        return resumoOperacoes;
    }
    public static void escreveProvisorio(String y, String vetor[]) throws IOException {
        String nick;
        nick = String.valueOf(arquivoProvisorio(y));
        BufferedWriter wr2 = new BufferedWriter(new FileWriter(nick, true));
        String dados[] = vetor;
        for (int i = 0; i < dados.length; i++) {
            wr2.write(dados[i] + "\t");
        }
        wr2.newLine();
        wr2.close();
    }
    public static void main(String[] args) throws IOException {
        String vetor[] = criaVetor("97114105971109710910111510710511697","ari46");
        escreveProvisorio("97114105971109710910111510710511697", vetor);
        readPrintFile();
    }
    public static Scanner scan;
    public static String[] criaVetor(String usuario, String operacao) throws IOException {
        String nick;
        nick = String.valueOf(acessarResumo(usuario));
        File dadosResumo = new File(String.valueOf(nick));
        scan = new Scanner(dadosResumo);
        String vetor[] = new String[30];
        while (scan.hasNextLine()){
            usuario = scan.nextLine();
            if (usuario.contains(operacao)){
                for (int i = 0; i < usuario.length(); i++) {
                    vetor = usuario.split("\t");
                }
            }

        }
        return vetor;
    }
    public static void readPrintFile(){
        UIManager.getDefaults().put("OptionPane.background",cor1);
        UIManager.put ("Panel.background", cor1);
        StringBuilder impressao = new StringBuilder();
        while (rosto.hasNextLine()) {
            impressao = impressao.append("<html><font color=#FF00FF face=arial><i><b>" +
                    rosto.nextLine().replace('.', ' ') +
                    pix.next().replace('.', ' ') + "\n");
        }

    JOptionPane.showMessageDialog(null, impressao, "Comprovante", JOptionPane.PLAIN_MESSAGE);
    }
}
