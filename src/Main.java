import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main extends  Thread{
    static boolean confirmacao = false;
    public static void main(String[] args) throws IOException
    {Thread th = new Notificacao();

        if (!confirmacao)
        {
            Notificacao.AltorizarNotificacao(false);
            new LoginScreen();


        }else {
            new HomeScreen();
            Notificacao.AltorizarNotificacao(true);
            th.start();
        }

    }
    public static void VerificarLogin(Boolean autorizacao)
    {confirmacao = autorizacao;
    }

}
