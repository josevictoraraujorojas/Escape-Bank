import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emprestimo {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder impressao = new StringBuilder();

        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        id = String.valueOf(Cadastro.criptografia(id));
        String caminho = new URIpadrao().URI() + id + "\\CadastroCliente.txt";
        float renda = rendaTotal(caminho);

        float valorDoEmprestimo = Float.parseFloat(JOptionPane.showInputDialog(null, "informe o valor do emprestimo"));

        JOptionPane.showMessageDialog(null, possibilidadesDeParcela(impressao, valorDoEmprestimo, 0.04f, 1, 12,valorEmprestimoEscolhido(valorDoEmprestimo,0.04f,12)/12,rendaTotal(caminho)));

        int parcelas = Integer.parseInt(JOptionPane.showInputDialog("escolha as parcelas de 1 a 12"));
        JOptionPane.showMessageDialog(null, valorEmprestimoEscolhido(valorDoEmprestimo, 0.04f, parcelas));

    }

    public static StringBuilder possibilidadesDeParcela(StringBuilder impressao, float valor, float taxaDeJuros, int parcelaInicial, int parcelaFinal,float parcela,float renda) {
        if (parcelaFinal >= parcelaInicial && parcela <= renda * 0.3)
        {
            float parcelaVerificacao =(float) ((valor * Math.pow((1 + taxaDeJuros), parcelaFinal+1)) / parcelaFinal+1);
            parcela= (float) ((valor * Math.pow((1 + taxaDeJuros), parcelaFinal)) / parcelaFinal);
            StringBuilder montante = new StringBuilder(String.valueOf(parcela));
            impressao.append(parcelaFinal).append(" parcela fica R$");
            impressao.append(montante, 0, montante.indexOf(".") + 2);
            impressao.append("\n");
            possibilidadesDeParcela(impressao, valor, taxaDeJuros, parcelaInicial , parcelaFinal-1,parcelaVerificacao,renda);
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

    public void processar(Float valorDoEmprestimo, int parcelas) throws FileNotFoundException {
        StringBuilder impressao = new StringBuilder("<html>");

        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        id = String.valueOf(Cadastro.criptografia(id));
        String caminho = new URIpadrao().URI() + id + "\\CadastroCliente.txt";
        float renda = rendaTotal(caminho);

        if (valorDoEmprestimo >= 0.30 * renda) {
            valorDoEmprestimo = Float.parseFloat(JOptionPane.showInputDialog(null, "informe o valor do emprestimo"));
        }
        rendaTotal(caminho);
        StringBuilder imprsso = possibilidadesDeParcela(impressao, valorDoEmprestimo, 0.04f, 1, 12,valorEmprestimoEscolhido(valorDoEmprestimo,0.04f,12), rendaTotal(caminho));

        JOptionPane.showMessageDialog(null, valorEmprestimoEscolhido(valorDoEmprestimo, 0.04f, parcelas));

    }

    public StringBuilder valoremprestimo(Float valorDoEmprestimo) throws FileNotFoundException {
        StringBuilder impressao = new StringBuilder("<html>");

        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        id = String.valueOf(Cadastro.criptografia(id));
        String caminho = new URIpadrao().URI() + id + "\\CadastroCliente.txt";
        float renda = 0;
        try {
            renda = rendaTotal(caminho);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (valorDoEmprestimo >= 0.30 * renda) {
            JOptionPane.showMessageDialog(null, "valor ecedido");
        }

        StringBuilder impresso = possibilidadesDeParcela(impressao, valorDoEmprestimo, 0.04f, 1, 12,valorEmprestimoEscolhido(valorDoEmprestimo,0.04f,12), rendaTotal(caminho));
        impresso.append("</html>");
        return impresso;

    }
}
