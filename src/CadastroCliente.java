import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Abrir conta, cadastrar conta, deletar conta -> jos�
        - cadastro da pessoa - nome, endere�o, cpf sal�rio atual, ganhos extras; ok
        - abertura de conta - baseada em sal�rio atual - possibilidade de cheque especial com porcentagem sal�rio;
        - cadastrar conta aleatoria - ele informar um nome e senha ficticio - abrir um valor random;
        - deletar conta - onde e como fazer.*/
public class CadastroCliente {
    static StringBuilder fiile = new StringBuilder(new SetPaths().GetPaths("C:\\EscapeBank\\native.txt"));
    public static StringBuilder URI = new StringBuilder("C:\\EscapeBank\\login\\"+ fiile+"\\CadastroCliente.txt");
    public static File cadastroCliente = new File(String.valueOf(URI));
    public static Scanner scan = new Scanner(System.in);

    public static boolean found;
    static Random random = new Random();

    public static void cadastrarConta(String nome,String cpf,String endereco,String numero,String cep,String cidade,String estado,String salarioAtual,String ganhosExtras) throws IOException {
        confereNome(nome);
        confereCPF(cpf);
        confereEndereco(endereco, numero, cep, cidade, estado);
        confereSalario(salarioAtual);
        confereGanhosExtras(ganhosExtras);
        calcularRendaTotal();
        System.out.println("Cadastro finalizado.");
    }

    public static void confereCPF(String cpf) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        do {
            System.out.println("Digite o seu cpf (xxx.xxx.xxx-xx):");
            cpf = scan.nextLine();
            Pattern pattern = Pattern.compile("^[0-9]{3}.[0-9]{3}.[0-9]{3}[-][0-9]{2}$");
            Matcher matcher = pattern.matcher(cpf);
            found = matcher.find();
            if (found) {
                wr.write("CPF: " + cpf);
                wr.newLine();
                wr.close();
            } else {
                System.out.println("Você digitou errado! Tente novamente!");break;            }
        }while (!found);
    }
        public static void confereNome(String nome) throws IOException {
            BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
            do {
                Pattern pattern = Pattern.compile("^[A-Za-z\\s]{8,}$");
                Matcher matcher = pattern.matcher(nome);
                found = matcher.find();
                if (found) {
                    wr.write("Nome: " + nome);
                    wr.newLine();
                    wr.close();
                } else {
                    JOptionPane.showMessageDialog(null,"Você digitou errado! O nome não pode conter números ou caracteres especiais. Tente novamente.");break;
                }
            }while (!found);
        }
    public static void confereEndereco(String endereco, String numero, String cep, String cidade, String estado) throws IOException{
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        do {
            wr.write("Endere�o: " + endereco);
        }while (!found);
        do {
            Pattern pattern = Pattern.compile("^[0-9]{0,3}.[0-9]{0,3}$");
            Matcher matcher = pattern.matcher(numero);
            found = matcher.find();
            if (found) {
                wr.write(", n�.: " + numero);
            } else {
                JOptionPane.showMessageDialog(null,"numero incorreto");break;
            }
        }while (!found);
        do {
            Pattern pattern = Pattern.compile("^[0-9]{2}.[0-9]{3}[-][0-9]{3}$");
            Matcher matcher = pattern.matcher(cep);
            found = matcher.find();
            if (found) {
                wr.write("- CEP: " + cep);
            } else {
                JOptionPane.showMessageDialog(null,"cep incorreto");break;
            }
        }while (!found);
        do {

            Pattern pattern = Pattern.compile("^[A-Za-z\\s]{2,20}$");
            Matcher matcher = pattern.matcher(cidade);
            found = matcher.find();
            if (found) {
                wr.write("- cidade: " + cidade);
            } else {
                JOptionPane.showMessageDialog(null,"cidade incorreto");break;}
            }
        while (!found);
        do {
            Pattern pattern = Pattern.compile("^[A-Z]{2}$");
            Matcher matcher = pattern.matcher(estado);
            found = matcher.find();
            if (found) {
                wr.write("/ " + estado + ".");
                wr.newLine();
                wr.close();
            } else {
                JOptionPane.showMessageDialog(null,"estado incorreto");
                break;
            }
        }while (!found);
    }
    public static void confereSalario(String salarioAtual) throws IOException{
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        do {
            Pattern pattern = Pattern.compile("^[0-9]{0,3}.[0-9]{0,3}[.][0-9]{2}$");
            Matcher matcher = pattern.matcher(salarioAtual);
            found = matcher.find();
            if (found) {
                wr.write("Sal�rio Atual: R$ " + salarioAtual);
                wr.newLine();
                wr.close();
            } else {
                JOptionPane.showMessageDialog(null,"formato de salario não compativel");
                break;
            }
        }while (!found);
    }
    public static void confereGanhosExtras(String ganhosExtras) throws IOException{
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        do {
            Pattern pattern = Pattern.compile("^[0-9]{0,3}.[0-9]{0,3}[.][0-9]{2}$");
            Matcher matcher = pattern.matcher(ganhosExtras);
            found = matcher.find();
            if (found) {
                wr.write("Ganhos Extras: R$ " + ganhosExtras);
                wr.newLine();
                wr.close();
            } else {
                JOptionPane.showMessageDialog(null,"foemato de ganho extra nao permitido");
                break;
            }
        }while (!found);
    }
    public static void calcularRendaTotal() throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        scan = new Scanner(cadastroCliente);
        String salario1;
        double salario = 0, rendaExtra = 0, rendaTotal;
        while (scan.hasNextLine()){
            salario1 = scan.nextLine();
            if (salario1.contains("Sal�rio Atual: R$ ")){
                salario = Double.parseDouble(salario1.substring(salario1.indexOf('$')+2));
            }
            if (salario1.contains("Ganhos Extras: R$ ")){
                rendaExtra = Double.parseDouble(salario1.substring(salario1.indexOf('$')+2));
            }
        }
        rendaTotal = salario + rendaExtra;
        wr.write("Renda Total: R$ " + rendaTotal);
        wr.newLine();
        wr.close();
        System.out.println("Renda Total: R$ " + rendaTotal);
    }
    public static void abrirConta() throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        int comecoNumero = random.nextInt(00,99);
        int meioNumero = random.nextInt(100,999);
        int digito = random.nextInt(10,99);
        wr.write("Numero Conta: " + comecoNumero + "." + meioNumero + "-" + digito);
        wr.newLine();
        wr.close();
    }
    public static void inserirConta(){

    }
}
