import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Notificacao extends Thread{
    static boolean confirmacao;
    public static void GravarNotificao(String usuario, String valor) throws IOException
    {
        String uri = new URIpadrao().URI()+Cadastro.criptografia(usuario) +"\\notificação.txt";
        FileWriter file = new FileWriter(uri,true);
        BufferedWriter gravar = new BufferedWriter(file);
        gravar.write("\nvocê recebeu uma tranferencia|no valor de: R$"+valor+"|de "+ new SetPaths().GetPaths(new URIpadrao().URICacheUserName()) );
        gravar.flush();
        gravar.close();
    }
    public void run() {
        while (confirmacao){

            try {
                System.out.println("procurando");
                String uri = new URIpadrao().URI()+Cadastro.criptografia(String.valueOf(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()))) +"\\notificação.txt";
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
    public static void AltorizarNotificacao(Boolean autorizacao)
    {confirmacao = autorizacao;
    }

}
