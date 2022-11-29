import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emprestimo {
    public static float valortotal = 0;
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder impressao = new StringBuilder();
        Scanner ler = new Scanner(System.in);
        System.out.println("informe o valor do emprestimo");
        float valorDoEmprestimo = Float.parseFloat(JOptionPane.showInputDialog(null,"informe o valor do emprestimo"));
        JOptionPane.showMessageDialog(null,possibilidadesDeParcela(impressao,valorDoEmprestimo, 0.04f,1,12));

        System.out.println("escolha as parcelas de 1 a 12");
        int parcelas = Integer.parseInt(JOptionPane.showInputDialog("escolha as parcelas de 1 a 12"));
        JOptionPane.showMessageDialog(null,valorEmprestimoEscolhido(valorDoEmprestimo,0.04f, parcelas));

        String id = new String(new SetPaths().GetPaths(new URIpadrao().CacheIdUserName()));
        id = String.valueOf(Cadastro.criptografia(id));
        String caminho = new URIpadrao().URI()+ id +"\\CadastroCliente.txt";


    }

    public static StringBuilder possibilidadesDeParcela(StringBuilder impressao, float valor, float taxaDeJuros, int parcelaInicial, int parcelaFinal){
        if (parcelaInicial <= parcelaFinal){
            StringBuilder montante = new StringBuilder(String.valueOf((valor * Math.pow((1 + taxaDeJuros), parcelaInicial))/ parcelaInicial));
            impressao.append(parcelaInicial).append(" parcela fica R$");
            impressao.append(montante, 0, montante.indexOf(".")+3);
            impressao.append("\n");
            possibilidadesDeParcela(impressao, valor,taxaDeJuros, parcelaInicial +1, parcelaFinal);
        }
        return impressao;
    }

    public static float valorEmprestimoEscolhido(float valor, float taxaDeJuros, int parcela){
        return (float) (valor * Math.pow((1 + taxaDeJuros), parcela));
    }

}
