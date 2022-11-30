import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emprestimo {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder impressao = new StringBuilder();

        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        id = String.valueOf(Cadastro.criptografia(id));
        String caminho = new URIpadrao().URI()+ id +"\\CadastroCliente.txt";
        float renda = rendaTotal(caminho);

        float valorDoEmprestimo = Float.parseFloat(JOptionPane.showInputDialog(null,"informe o valor do emprestimo"));
        if (valorDoEmprestimo>=0.30*renda)
        {
            valorDoEmprestimo = Float.parseFloat(JOptionPane.showInputDialog(null,"informe o valor do emprestimo"));
        }

        JOptionPane.showMessageDialog(null,possibilidadesDeParcela(impressao,valorDoEmprestimo, 0.04f,1,12));

        int parcelas = Integer.parseInt(JOptionPane.showInputDialog("escolha as parcelas de 1 a 12"));
        JOptionPane.showMessageDialog(null,valorEmprestimoEscolhido(valorDoEmprestimo,0.04f, parcelas));

    }

    public static StringBuilder possibilidadesDeParcela(StringBuilder impressao, float valor, float taxaDeJuros, int parcelaInicial, int parcelaFinal){
        if (parcelaInicial <= parcelaFinal)
        {
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
    public static float rendaTotal(String caminho) throws FileNotFoundException {
        float renda = 0;
        Scanner lerArquivo = new Scanner(new File(caminho));
        while (lerArquivo.hasNext())
        {
            String linha = lerArquivo.nextLine();
            if (linha.contains("Renda Total: R$"))
            {
                renda = Float.parseFloat(linha.substring(linha.indexOf(":")+5));
            }
        }
        return renda;
    }


}
