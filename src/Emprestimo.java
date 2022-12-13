import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Emprestimo {
    public static void main(String[] args) {
//        float valorDoEmprestimo = Float.parseFloat(JOptionPane.showInputDialog(null, "informe o valor do emprestimo"));


//        int parcelas = Integer.parseInt(JOptionPane.showInputDialog("escolha a parcela disponível"));
//        JOptionPane.showMessageDialog(null, valorEmprestimoEscolhido(valorDoEmprestimo, 0.04f, parcelas));
    }

    public static StringBuilder possibilidadesDeParcela(StringBuilder impressao, float valor, float taxaDeJuros, int parcelaFinal, float parcelaInicial, float renda) {
        if (parcelaFinal >= 1 && parcelaInicial <= renda * 0.3) {
            int parcelaAuxiliar = parcelaFinal - 1;
            float parcelaVerificacao = (float) ((valor * Math.pow((1 + taxaDeJuros), parcelaAuxiliar) / parcelaAuxiliar));
            parcelaInicial = (float) ((valor * (Math.pow((1 + taxaDeJuros), parcelaFinal)) / parcelaFinal));
            System.out.println(parcelaInicial);
            StringBuilder montante = new StringBuilder(String.valueOf(parcelaInicial));
            impressao.append(parcelaFinal).append(" vezes de R$ ");
            impressao.append(montante, 0, montante.indexOf(".") + 2);
            impressao.append("\n");
            possibilidadesDeParcela(impressao, valor, taxaDeJuros, parcelaFinal - 1, parcelaVerificacao, renda);
        }
        return impressao;
    }
    public static float valorEmprestimoEscolhido(float valor, float taxaDeJuros, int parcela) {
        return (float) (valor * Math.pow((1 + taxaDeJuros), parcela));
    }
    public static float rendaTotal(String caminho) throws FileNotFoundException {
        float renda = 0;
        Scanner lerArquivo = new Scanner(new File(caminho));
        while (lerArquivo.hasNext()) {
            String linha = lerArquivo.nextLine();
            if (linha.contains("Renda Total: R$")) {
                renda = Float.parseFloat(linha.substring(linha.indexOf(":") + 5));
            }
        }
        return renda;
    }
    public int processar(Float valorDoEmprestimo, int parcelas, String imprimir) throws IOException
    {
        Color cor1 = new PaletaDeCores().cor1();
        UIManager.getDefaults().put("OptionPane.background",cor1);
        UIManager.put ("Panel.background", cor1);
        String valorTotal = String.valueOf(valorEmprestimoEscolhido(valorDoEmprestimo, 0.04f, parcelas));
        Object[] options = { "confirmar", "cancelar" };
        int opcao = JOptionPane.showOptionDialog(null, "<html><font color=#FF00FF face=arial>" +
                "<i><b> seu emprestimo ficará no<br>valor total de: R$ "+valorTotal.substring(0,
                valorTotal.indexOf(".")+2)+"<br> <br>valor que irá receber: R$ "+valorDoEmprestimo+"<br>em: "+
                imprimir+"<br> <br>se deseja continuar clique em confirmar", "emprestimo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (opcao == 0 && Senha.SolicitarSenha()){
            anotarResumo(valorDoEmprestimo, parcelas, imprimir);
            JOptionPane.showMessageDialog(null,"<html><font color=#FF00FF face=arial><i><b> Emprestimo feito com sucesso");
            return 1;
        }else {
            JOptionPane.showMessageDialog(null,"<html><font color=#FF00FF face=arial><i><b> Emprestimo cancelado");
            return 2;
        }

    }
    public String[] emprestimo(Float valorDoEmprestimo) throws FileNotFoundException {
        StringBuilder impressao = new StringBuilder("Parcelas Disponíveis:\n");
        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        id = String.valueOf(Cadastro.criptografia(id));
        String caminho = new URIpadrao().URI() + id + "\\CadastroCliente.txt";

        String possibildade = String.valueOf(possibilidadesDeParcela(impressao, valorDoEmprestimo,
                0.04f, 12, valorEmprestimoEscolhido(valorDoEmprestimo,
                        0.04f, 12) / 12, rendaTotal(caminho)));
        return possibildade.split("\n");
    }
    public static Scanner scan2;
    public static File userNome = new File("C:\\EscapeBankCache\\username.txt");
    static { try { scan2 = new Scanner(userNome); } catch (FileNotFoundException e) {
        throw new RuntimeException(e); } }
    public static String userEnvio;
    static Random random = new Random();
    public static void anotarResumo(float valorDoEmprestimo, int parcelas, String imprimir) throws IOException {
        String userLeitura = scan2.nextLine();
        userEnvio = String.valueOf(Cadastro.criptografia(userLeitura));
        String valorEmprestimo = String.valueOf(valorDoEmprestimo);
        String valorTotal = valorEmprestimo.replace('.',',').
                substring(0, valorEmprestimo.indexOf(',')+3);
        String vetor[] = Pix.criaVetor();
        Pix.preencheDados(vetor, "gggggggggggggggggggggggg", "//Parcelas:." + parcelas);
        Pix.dadosCadastroReceptor(userEnvio, vetor);
        String loginEnvio = Pix.dadosLogin(userEnvio);
        Pix.preencheDados(vetor, "iiiiiiiiiiiiiiii", "ScapeBank");
        String nickUser = Pix.dadosLogin(userEnvio);
        Pix.preencheDados(vetor, "eeeeeeeeeeeeeeee", nickUser);
        Pix.preencheDados(vetor, "bbbb", "empréstimo");
        Pix.preencheDados(vetor, "ffffffff", "Corrente");
        Pix.preencheDados(vetor, "hhhhhhhhhhhhhhhhhhhh", "ScapeBank");
        String numeroOp = String.valueOf(random.nextInt(0,100));
        Pix.preencheDados(vetor, "jjjj", loginEnvio.substring(0,3) + numeroOp);
        Pix.preencheDados(vetor, "aaaaaaaa", "R$:" + valorTotal);
        Pix.escrevePix(userEnvio, vetor);
    }
}
