import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static javax.swing.JOptionPane.YES_NO_OPTION;

public class Emprestimo {
    public static void main(String[] args) throws FileNotFoundException {
        float valorDoEmprestimo = Float.parseFloat(JOptionPane.showInputDialog(null, "informe o valor do emprestimo"));


        int parcelas = Integer.parseInt(JOptionPane.showInputDialog("escolha a parcela disponivel"));
        JOptionPane.showMessageDialog(null, valorEmprestimoEscolhido(valorDoEmprestimo, 0.04f, parcelas));

    }

    public static StringBuilder possibilidadesDeParcela(StringBuilder impressao, float valor, float taxaDeJuros, int parcelaFinal, float parcelaInicial, float renda) {
        if (parcelaFinal >= 1 && parcelaInicial <= renda * 0.3) {
            int parcelaAuxiliar = parcelaFinal - 1;
            float parcelaVerificacao = (float) ((valor * Math.pow((1 + taxaDeJuros), parcelaAuxiliar) / parcelaAuxiliar));
            parcelaInicial = (float) ((valor * (Math.pow((1 + taxaDeJuros), parcelaFinal)) / parcelaFinal));
            System.out.println(parcelaInicial);
            StringBuilder montante = new StringBuilder(String.valueOf(parcelaInicial));
            impressao.append(parcelaFinal).append(" parcelaInicial fica R$");
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

    public void processar(Float valorDoEmprestimo, int parcelas) throws IOException {
       String valorTotal = String.valueOf(valorEmprestimoEscolhido(valorDoEmprestimo, 0.04f, parcelas));
       JOptionPane.showMessageDialog(null,valorTotal.substring(0,valorTotal.indexOf(".")+2));
       String senha = JOptionPane.showInputDialog(null,"informe a senha:");
       if (Senha.SolicitarSenha()){
           JOptionPane.showConfirmDialog(null,"senha correta");
           boolean resposta = Boolean.parseBoolean(JOptionPane.showInputDialog(null,"realmente deseja fazer o emprestimo",YES_NO_OPTION));
           if (resposta){
               JOptionPane.showConfirmDialog(null,"Emprestimo feito com sucesso");
           }else {
               JOptionPane.showConfirmDialog(null,"Emprestimo cancelado");
           }
       }else {
           JOptionPane.showConfirmDialog(null,"senha incorreta");
       }


    }
    public String[] emprestimo(Float valorDoEmprestimo) throws FileNotFoundException {
        StringBuilder impressao = new StringBuilder("Parcelas Disponiveis:\n");

        String id = new String(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
        id = String.valueOf(Cadastro.criptografia(id));
        String caminho = new URIpadrao().URI() + id + "\\CadastroCliente.txt";
        float renda = rendaTotal(caminho);

        String possibildade = String.valueOf(possibilidadesDeParcela(impressao, valorDoEmprestimo, 0.04f, 12, valorEmprestimoEscolhido(valorDoEmprestimo, 0.04f, 12) / 12, rendaTotal(caminho)));
        return possibildade.split("\n");



    }

}
