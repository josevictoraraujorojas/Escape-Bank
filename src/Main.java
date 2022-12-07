import java.io.IOException;

public class Main {

    static boolean confirmacao = false;
    public static void main(String[] args) throws IOException
    {
        if (!confirmacao)
        {
            new LoginScreen();
        }else if (Senha.CriarSenha(String.valueOf(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()))))
        {
            new HomeScreen();
        }else
        {
            confirmacao = false;
            String[] argsx = new String[0];
            main(argsx);
        }

    }
    public static void VerificarLogin(Boolean altorizacao)
    {confirmacao = altorizacao;
    }
}
