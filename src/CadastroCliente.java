import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Abrir conta, cadastrar conta, deletar conta -> jos�
        - cadastro da pessoa - nome, endere�o, cpf sal�rio atual, ganhos extras; ok
        - abertura de conta - baseada em sal�rio atual - possibilidade de cheque especial com porcentagem sal�rio;
        - cadastrar conta aleatoria - ele informar um nome e senha ficticio - abrir um valor random;
        - deletar conta - onde e como fazer.*/
public class CadastroCliente {
    public static StringBuilder IdPaths = new StringBuilder(new SetPaths().GetPaths("C:\\EscapeBank\\native.txt"));
    public static StringBuilder URI = new StringBuilder(new URIpadrao().URI()+ IdPaths +"\\CadastroCliente.txt");
    public static File cadastroCliente = new File(String.valueOf(URI));
    public static Scanner scan = new Scanner(System.in);
    public static boolean found;

    public static int cadastrarConta(String nome, String cpf, String endereco, String numero, String cep, String cidade, String estado, String salarioAtual, String ganhosExtras) throws IOException {
        if (!confereNome(nome)){
            return 2;
        }
        if (!confereCPF(cpf)){
            return 3;
        }
        if (!confereEndereco(endereco, numero, cep, cidade, estado)){
            return 4;
        }
        if (!confereSalario(salarioAtual)){
            return 5;
        }
        if (!confereGanhosExtras(ganhosExtras)){
            return 6;
        }
        calcularRendaTotal();
        return 1;
    }
    public static boolean confereRegex(String x, String y){
        Pattern pattern = Pattern.compile(x);
        Matcher matcher = pattern.matcher(y);
        found = matcher.find();
        return found;
    }
    public static void escreveArquivo(String x, String y) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        wr.write(x + y);
        wr.newLine();
        wr.close();
    }
    public static boolean confereCPF(String cpf) throws IOException {
        if (confereRegex("^[0-9]{3}.[0-9]{3}.[0-9]{3}[-][0-9]{2}$",cpf)) {
            escreveArquivo("CPF: ", cpf);
        } else{
            JOptionPane.showMessageDialog(null,"Verifique o formato digitado!");
        }
        return true;
    }
        public static boolean confereNome(String nome) throws IOException {
            if (confereRegex("^[A-Za-z\\s]{8,}$", nome)) {
                escreveArquivo("Nome: ", nome);
            } else {
                JOptionPane.showMessageDialog(null,"Você digitou errado! O nome não pode conter números ou caracteres especiais. Tente novamente.");
            }
            return true;
        }
    public static boolean confereEndereco(String endereco, String numero, String cep, String cidade, String estado) throws IOException{
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        wr.write("Endereco: " + endereco);
        if (confereRegex("^[0-9]{0,3}.[0-9]{0,3}$", numero)) {
            wr.write(", n.: " + numero);
        } else {
            JOptionPane.showMessageDialog(null,"numero incorreto");
        }
        if (confereRegex("^[0-9]{2}.[0-9]{3}[-][0-9]{3}$", cep)) {
            wr.write("- CEP: " + cep);
        } else {
            JOptionPane.showMessageDialog(null,"cep incorreto");
        }
        if (confereRegex("^[A-Za-z\\s]{2,20}$", cidade)) {
            wr.write("- cidade: " + cidade);
        } else {
            JOptionPane.showMessageDialog(null,"cidade incorreto");
        }
        if (confereRegex("^[A-Z]{2}$", estado)) {
            wr.write("/ " + estado + ".");
            wr.newLine();
            wr.close();
        } else {
            JOptionPane.showMessageDialog(null,"estado incorreto");
        }
        return true;
    }
    public static boolean confereSalario(String salarioAtual) throws IOException{
        if (confereRegex("^[0-9]{0,3}.[0-9]{0,3}[.][0-9]{2}$", salarioAtual)) {
            escreveArquivo("Salario Atual: R$ ", salarioAtual);
        } else {
            JOptionPane.showMessageDialog(null,"formato de salario não compativel");
        }
        return true;
    }
    public static boolean confereGanhosExtras(String ganhosExtras) throws IOException{
        if (confereRegex("^[0-9]{0,3}.[0-9]{0,3}[.][0-9]{2}$", ganhosExtras)) {
            escreveArquivo("Ganhos Extras: R$ ", ganhosExtras);
        } else {
            JOptionPane.showMessageDialog(null,"formato de ganho extra nao permitido");
        }
        return true;
    }
    public static void calcularRendaTotal() throws IOException {
        scan = new Scanner(cadastroCliente);
        String salario1;
        double salario = 0, rendaExtra = 0, rendaTotal;
        while (scan.hasNextLine()){
            salario1 = scan.nextLine();
            if (salario1.contains("Salario Atual: R$ ")){
                salario = Double.parseDouble(salario1.substring(salario1.indexOf('$')+2));
            }
            if (salario1.contains("Ganhos Extras: R$ ")){
                rendaExtra = Double.parseDouble(salario1.substring(salario1.indexOf('$')+2));
            }
        }
        rendaTotal = salario + rendaExtra;
        escreveArquivo("Renda Total: R$ ", String.valueOf(rendaTotal));
        System.out.println("Renda Total: R$ " + rendaTotal);
    }
}
