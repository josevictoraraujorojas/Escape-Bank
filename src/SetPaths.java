import javax.swing.*;
import java.io.*;

public class SetPaths
{
    public void SavePaths(StringBuilder salvar, String URI, boolean concat)
    {
        try
        {
            BufferedWriter gravar;
            gravar = new BufferedWriter(new FileWriter(URI,concat));
            gravar.write(String.valueOf(salvar));
            gravar.flush();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"não foi possível gravar");
            throw new RuntimeException(e);
        }
    }
    public StringBuilder GetPaths(String URI)
    {
        StringBuilder ItemSalvo;
        try
        {
            BufferedReader ler = new BufferedReader(new FileReader(URI));
            ItemSalvo = new StringBuilder(ler.readLine());
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"nao foi possível ler!");
            throw new RuntimeException(e);
        }
        return new StringBuilder(ItemSalvo);
    }
}
