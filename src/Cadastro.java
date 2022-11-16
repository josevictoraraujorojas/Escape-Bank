import java.awt.Color;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Cadastro {
    public Cadastro(String login, String senha) throws IOException {
        UIManager.getDefaults().put("OptionPane.background", new Color(6422686));
        UIManager.put("Panel.background", new Color(6422686));
        new Scanner(System.in);
        String URI = "C:\\Users\\arian\\OneDrive - Instituto Federal de Educação, Ciência e Tecnologia Goiano\\ScapeBank\\";
        StringBuilder id = new StringBuilder(String.valueOf(criptografia(login)));
        StringBuilder caminho = new StringBuilder(URI + id);

        while(validacaoDeUsuario(login) && !verificaLoginDuplicada(String.valueOf(caminho)) && !senha.equals(login)&& !verificaSequencia(senha)&& !validaDeSenhaRegex(senha)){
            if (validaDeSenhaRegex(senha) || senha.equals(login) || verificaSequencia(senha)) {
                JOptionPane.showMessageDialog(null, "<html><font color=#FF00FF face=arial><i><b> senha incorreta atente-se aos requisitos");
            }

            if (!senha.equals(login) && validacaoDeUsuario(senha) && !validaDeSenhaRegex(senha) && !verificaLoginDuplicada(login) && !verificaSequencia(senha)) {
                File diretorio = new File(String.valueOf(caminho));
                diretorio.mkdir();
                File arquivo = new File(diretorio, "LoginESenha.txt");
                arquivo.createNewFile();
                BufferedWriter armazena = new BufferedWriter(new FileWriter(arquivo, true));
                armazenaLoginESenha(armazena, login, senha);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "<html><font color=#FF00FF face=arial><i><b> login incorreto", "erro", JOptionPane.ERROR_MESSAGE);
        id.delete(0, id.length());
        id.append(String.valueOf(criptografia(login)));
        caminho.delete(0, caminho.length());
        caminho.append(URI).append(id);
    }

    public static boolean validacaoDeUsuario(String login) {
        char[] var1 = login.toCharArray();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            char letra = var1[var3];
            if (!Character.isLetterOrDigit(letra) && letra != '_') {
                return false;
            }

            if (Character.isDigit(login.charAt(0))) {
                return false;
            }

            if (login.length() < 8 || login.length() > 16) {
                return false;
            }
        }

        return true;
    }

    public static boolean verificaSequencia(String senha) {
        boolean retonar = true;

        for(int i = 0; i < senha.length(); ++i) {
            if (i < senha.length() - 2 && Character.isDigit(senha.charAt(i))) {
                int p1 = senha.charAt(i) - senha.charAt(i + 1);
                int p2 = senha.charAt(i + 1) - senha.charAt(i + 2);
                if (p1 == 1 && p2 == 1 || p1 == -1 && p2 == -1) {
                    retonar = false;
                }
            }
        }

        return !retonar;
    }

    public static boolean validaDeSenhaRegex(String senha) {
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$");
        Matcher matcher = pattern.matcher(senha);
        return !matcher.find();
    }

    public static Boolean verificaLoginDuplicada(String caminho) {
        File verificaDuplicado = new File(caminho);
        return verificaDuplicado.exists();
    }

    public static void armazenaLoginESenha(BufferedWriter armazena, String login, String senha) {
        try {
            Boolean b = true;
            armazena.write(login);
            armazena.newLine();
            armazena.write(String.valueOf(criptografia(senha)));
            armazena.newLine();
            armazena.close();
            JOptionPane.showMessageDialog(null, "<html><font color=#FF00FF face=arial><i><b> usuario cadastrado com sucesso!!");
            TelaDeCadastro.fechartela(b);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public static StringBuilder criptografia(String senha) {
        StringBuilder codificacao = new StringBuilder();

        for(int i = 0; i < senha.length(); ++i) {
            codificacao.append(senha.codePointAt(i));
        }

        return codificacao;
    }
}
