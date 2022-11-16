import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Abrir conta, cadastrar conta, deletar conta -> josé
        - cadastro da pessoa - nome, endereço, cpf salário atual, ganhos extras; ok
        - abertura de conta - baseada em salário atual - possibilidade de cheque especial com porcentagem salário;
        - cadastrar conta aleatoria - ele informar um nome e senha ficticio - abrir um valor random;
        - deletar conta - onde e como fazer.*/
public class CadastroCliente {
    public static File cadastroCliente = new File("C:\\Users\\arian\\OneDrive\\Sistemas Informação\\2.1. LTPII\\LTPII\\src\\Projeto\\CadastroCliente.txt");
    public static Scanner scan = new Scanner(System.in);
    public static String nome;
    public static String cpf;
    public static String endereco;
    public static String numero;
    public static String cep;
    public static String cidade;
    public static String estado;
    public static String salarioAtual;
    public static String ganhosExtras;
    public static boolean found;
    static Random random = new Random();

    public static void cadastrarConta() throws IOException {
        confereNome();
        confereCPF();
        confereEndereco();
        confereSalario();
        confereGanhosExtras();
        calcularRendaTotal();
        abrirConta();
        System.out.println("Cadastro finalizado.");
    }

    public static void confereCPF() throws IOException {
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
                System.out.println("Você digitou errado! Tente novamente!");
            }
        }while (!found);
    }
        public static void confereNome() throws IOException {
            BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
            do {
                System.out.println("Digite o seu nome:");
                nome = scan.nextLine();
                Pattern pattern = Pattern.compile("^[A-Za-z\\s]{8,}$");
                Matcher matcher = pattern.matcher(nome);
                found = matcher.find();
                if (found) {
                    wr.write("Nome: " + nome);
                    wr.newLine();
                    wr.close();
                } else {
                    System.out.println("Você digitou errado! O nome não pode conter números ou caracteres especiais. Tente novamente.");
                }
            }while (!found);
        }
    public static void confereEndereco() throws IOException{
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        do {
            System.out.println("Digite o seu endereço (só o nome, não coloque números):");
            endereco = scan.nextLine();
            wr.write("Endereço: " + endereco);
        }while (!found);
        do {
            System.out.println("Digite o número do edifício residencial (padrão: 111, 1.111):");
            numero = scan.nextLine();
            Pattern pattern = Pattern.compile("^[0-9]{0,3}.[0-9]{0,3}$");
            Matcher matcher = pattern.matcher(numero);
            found = matcher.find();
            if (found) {
                wr.write(", nº.: " + numero);
            } else {
                System.out.println("Você digitou errado, volte e siga o padrão!");
            }
        }while (!found);
        do {
            System.out.println("Digite o seu CEP (padrão: 11.111-111):");
            cep = scan.nextLine();
            Pattern pattern = Pattern.compile("^[0-9]{2}.[0-9]{3}[-][0-9]{3}$");
            Matcher matcher = pattern.matcher(cep);
            found = matcher.find();
            if (found) {
                wr.write("- CEP: " + cep);
            } else {
                System.out.println("Você digitou errado, volte e siga o padrão!");
            }
        }while (!found);
        do {
            System.out.println("Digite o nome da cidade:");
            cidade = scan.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z\\s]{2,20}$");
            Matcher matcher = pattern.matcher(cidade);
            found = matcher.find();
            if (found) {
                wr.write("- cidade: " + cidade);
            } else {
                System.out.println("Você digitou números ou caracteres, volte e escreva utilizando somente letras.");
            }
        }while (!found);
        do {
            System.out.println("Digite a sigla do Estado (Padrão: GO, DF, MA, AM, etc):");
            estado = scan.nextLine();
            Pattern pattern = Pattern.compile("^[A-Z]{2}$");
            Matcher matcher = pattern.matcher(estado);
            found = matcher.find();
            if (found) {
                wr.write("/ " + estado + ".");
                wr.newLine();
                wr.close();
            } else {
                System.out.println("Você não seguiu o padrão! Tente novamente!");
            }
        }while (!found);
    }
    public static void confereSalario() throws IOException{
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        do {
            System.out.println("Digite o seu salário atual (padrão: 11,11 ou 111,11 ou 1.111,11):");
            salarioAtual = scan.nextLine();
            Pattern pattern = Pattern.compile("^[0-9]{0,3}.[0-9]{0,3}[.][0-9]{2}$");
            Matcher matcher = pattern.matcher(salarioAtual);
            found = matcher.find();
            if (found) {
                wr.write("Salário Atual: R$ " + salarioAtual);
                wr.newLine();
                wr.close();
            } else {
                System.out.println("Você não seguiu o padrão! Tente novamente!");
            }
        }while (!found);
    }
    public static void confereGanhosExtras() throws IOException{
        BufferedWriter wr = new BufferedWriter(new FileWriter(cadastroCliente, true));
        do {
            System.out.println("Digite seu valor de Renda Extra (além do salário, ganhos com rendimentos, aluguéis, etc. padrão: mesmo de salário):");
            ganhosExtras = scan.nextLine();
            Pattern pattern = Pattern.compile("^[0-9]{0,3}.[0-9]{0,3}[.][0-9]{2}$");
            Matcher matcher = pattern.matcher(ganhosExtras);
            found = matcher.find();
            if (found) {
                wr.write("Ganhos Extras: R$ " + ganhosExtras);
                wr.newLine();
                wr.close();
            } else {
                System.out.println("Você não seguiu o padrão! Tente novamente!");
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
            if (salario1.contains("Salário Atual: R$ ")){
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
        int começoNumero = random.nextInt(00,99);
        int meioNumero = random.nextInt(100,999);
        int digito = random.nextInt(10,99);
        wr.write("Número Conta: " + começoNumero + "." + meioNumero + "-" + digito);
        wr.newLine();
        wr.close();
    }
    public static void inserirConta(){

    }
}
