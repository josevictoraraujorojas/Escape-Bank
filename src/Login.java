
import javax.swing.*;
import java.io.*;


public class Login {

    public int VerificaLogin(String login, String senha) throws IOException {

        String id = String.valueOf(Cadastro.criptografia(login));
        String URI = new URIpadrao().URI();
        String caminho = URI+id;

        File diretorio = new File(caminho);

        String[] pasta = diretorio.list();
        if (pasta == null)
        {
            JOptionPane.showMessageDialog(null,"usuario nao encontrado");
            return 2;
        }
        String arquivo = "LoginESenha.txt";

        BufferedReader le = new BufferedReader(new FileReader(caminho+"\\"+arquivo));
        String line;
        boolean verificaLogin=false;
        boolean verificaSenha=false;
        while ((line = le.readLine())!=null)
        {
            if (line.equals(login))
            {
                verificaLogin=true;
            }
            else if (line.equals(String.valueOf(Cadastro.criptografia(senha))))
            {
                verificaSenha=true;
            }
        }
        if (verificaLogin && verificaSenha)
        {
            JOptionPane.showMessageDialog(null,"<html><font color=#FF00FF face=arial><i><b> usuario encontrado");
            return 1;
        } else
        {
            JOptionPane.showMessageDialog(null,"senha incorreta");
            return 3;
        }
    }
}