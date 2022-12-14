import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Notificacao {
    public Notificacao() throws IOException {
        String uri = new URIpadrao().URI()+Cadastro.criptografia(String.valueOf(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()))) +"\\notificação.txt";
        FileWriter file = new FileWriter(uri,false);
        File file2 = new File(uri);
        BufferedWriter gravar = new BufferedWriter(file);
        Scanner scan = new Scanner(file2);
        while (scan.hasNextLine())
        {
            String not = scan.nextLine();
            if (!not.equals("sem notificações"))
            {
                JOptionPane.showMessageDialog(null, not.replace("|","\n"));
            }
        }
        gravar.write("sem notificações");
        gravar.flush();
        gravar.close();
    }



    public static void main(String[] args) {
        try {
            new Notificacao();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
