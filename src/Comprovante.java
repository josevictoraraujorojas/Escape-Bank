import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Comprovante {
    static Color cor1 = new LigthMode().cor1();
    public static File rostoComprovante = new File("C:\\EscapeBank\\Pattern\\RostoComprovante.txt");
    public static File dadosPix = new File("C:\\Users\\arian\\OneDrive\\Sistemas Informacao" +
            "\\2.1. LTPII\\LTPII\\src\\Projeto\\dadosPix.txt");
    public static Scanner rosto, pix;

    static {
        try {
            rosto = new Scanner(rostoComprovante);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            pix = new Scanner(dadosPix);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        readPrintFile();
    }

    public static void readPrintFile() throws IOException {
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
