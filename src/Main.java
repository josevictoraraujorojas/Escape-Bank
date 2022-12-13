import java.io.IOException;

public class Main {


    static boolean confirmacao = false;
    public static void main(String[] args) throws IOException
    {
        if (!confirmacao)
        {
            new LoginScreen();
        }else {

            new HomeScreen();
        }

    }
    public static void VerificarLogin(Boolean autorizacao)
    {confirmacao = autorizacao;
    }
}
