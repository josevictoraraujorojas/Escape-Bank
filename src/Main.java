import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main extends  Thread{


    static boolean confirmacao = false;
    public static void main(String[] args) throws IOException
    {Main thread = new Main();
        if (!confirmacao)
        {
            new LoginScreen();
        }else {
            new HomeScreen();
            thread.start();
        }

    }
    public static void VerificarLogin(Boolean autorizacao)
    {confirmacao = autorizacao;
    }
    public void run() {
        while (true){

            try {
                String uri = new URIpadrao().URI()+"103117103117116101115116101"/*Cadastro.criptografia(String.valueOf(new SetPaths().GetPaths(new URIpadrao().URICacheUserName())))*/ +"\\notificação.txt";
                FileWriter file = null;
                file = new FileWriter(uri,false);
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
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
