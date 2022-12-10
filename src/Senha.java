import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Senha {
    static Color cor1 = new PaletaDeCores().cor1();


    public static boolean CriarSenha() throws IOException
    {

        String user = String.valueOf(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        String cripto = String.valueOf(Cadastro.criptografia(user));
        String uri = new URIpadrao().URI()+cripto+"\\senhadeoperação.txt";
        new URIpadrao().ExistsURI(uri,new URIpadrao().URI()+cripto,"\\senhadeoperação.txt");
        File URI = new File(uri);
        UIManager.getDefaults().put("OptionPane.background",cor1);
        UIManager.put ("Panel.background", cor1);


        while (true)
        {
            BufferedReader ler = new BufferedReader(new FileReader(URI));
            String senha = ler.readLine();
            if (senha == null)
            {
                BufferedWriter gravar = new BufferedWriter(new FileWriter(URI));
                String password = JOptionPane.showInputDialog(null, "<html><font color=#FF00FF face=arial><i><b>digite uma senha para seu cartão<br>essa senha será usada para todas as transacoes<br>sua senha deve ter 4 digitos");
                if (password == null){
                    return false;
                }
                if (CadastroCliente.confereRegex("^[0-9]{4}$",password))
                {
                    gravar.write(password);
                    gravar.flush();
                    gravar.close();
                    JOptionPane.showMessageDialog(null,"<html><font color=#FF00FF face=arial><i><b>sua senha foi salva com sucesso");

                }
                else JOptionPane.showMessageDialog(null,"<html><font color=#FF00FF face=arial><i><b>senha não aceita tente denovo");
            }
            else return true;
        }
    }
    public static boolean SolicitarSenha() throws IOException
    {

        String user = String.valueOf(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        String cripto = String.valueOf(Cadastro.criptografia(user));
        String uri = new URIpadrao().URI()+cripto+"\\senhadeoperação.txt";
        File URI = new File(uri);
        UIManager.getDefaults().put("OptionPane.background",cor1);
        UIManager.put ("Panel.background", cor1);

        BufferedReader ler = new BufferedReader(new FileReader(URI));
        String senha = ler.readLine();
        String password = JOptionPane.showInputDialog(null, "<html><font color=#FF00FF face=arial><i><b>digite sua senha de 4 digitos");
        if (senha.equals(password))
        {
            return true;
        }
        else JOptionPane.showMessageDialog(null,"<html><font color=#FF00FF face=arial><i><b>senha incorreta");
        return false;
    }
}
