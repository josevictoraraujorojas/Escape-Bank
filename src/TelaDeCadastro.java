import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;



public class TelaDeCadastro extends JFrame {

    JButton JB1, JB2;
    JTextField JTF1, JTF2;

    JLabel JL1, JL2, JL3, JL4, JL5, Icon1, Icon2;
    Color cor = new Color(98, 0, 158);

    static  String Login = "";
    static String Senha = "";




    public TelaDeCadastro()
    {


        /* configurações do JFrame */
        setLayout(null);
        setTitle("tela de login");
        setSize(800, 600);
        getContentPane().setBackground(cor);
        setLocationRelativeTo(null);
        setUndecorated(true);

        /* configurações do JButton */
        JB1 = new JButton("ok");
        JB1.setBounds(460, 500, 100, 40);
        JB1.setBackground(Color.MAGENTA);
        JB1.setFont(new Font("Arial", Font.BOLD, 20));
        JB1.setForeground(Color.WHITE);
        JB1.setVisible(true);
        JB1.addActionListener(e ->
        {
            UIManager.getDefaults().put("OptionPane.background",cor);
            UIManager.put ("Panel.background", cor);
            Login = JTF1.getText();
            Senha = JTF2.getText();

            try
            { /*preciso de que "new Cadastro().CadastroLoginESenha(Login,Senha);"
                estiver certo e gravou me retorne int 1; se der erro me retorne:
                JOptionPane.showMessageDialog(null, esse nome de usuario não e valido);seguido de return "2";
                JOptionPane.showMessageDialog(null,esse senha invalida, atente-se aos requisitos);seguido de return "3";*/

                switch (new Cadastro().CadastroLoginESenha(Login,Senha)){
                    case 1 ->{
                        new TelaDeCadastroCliente();
                        dispose();
                    }
                    case 2 -> JTF1.setBackground(Color.red);
                    case 3 -> JTF2.setBackground(Color.red);
                }

            } catch (IOException a)
            {
                throw new RuntimeException(a);
            }
        });

        JB2 = new JButton("<- voltar");
        JB2.setBounds(170, 500, 120, 40);
        JB2.setBackground(Color.MAGENTA);
        JB2.setFont(new Font("Arial", Font.BOLD, 20));
        JB2.setForeground(Color.WHITE);
        JB2.setVisible(true);
        JB2.addActionListener(e ->
        {
            new TelaDeLogin();
            dispose();
        });

        /* configurações do JTextField */

        JTF1 = new JTextField("digite um nome de usuario");
        JTF1.setBounds(140, 145, 300, 30);//x=130 y= 4
        JTF1.setBackground(Color.MAGENTA);
        JTF1.setForeground(Color.WHITE);
        JTF1.setFont(new Font("Arial", Font.BOLD, 15));
        JTF1.setVisible(true);
        JTF1.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JTF1.getText().equals("digite um nome de usuario"))
                {
                    JTF1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JTF1.getText().isEmpty())
                {
                    JTF1.setText("digite um nome de usuario");
                }
            }
        });

        JTF2 = new JTextField("digite uma senha");
        JTF2.setBounds(140, 266, 300, 30);
        JTF2.setBackground(Color.MAGENTA);
        JTF2.setForeground(Color.WHITE);
        JTF2.setFont(new Font("Arial", Font.BOLD, 15));
        JTF2.setVisible(true);
        JTF2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JTF2.getText().equals("digite uma senha")){
                    JTF2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JTF2.getText().isEmpty())
                {
                    JTF2.setText("digite uma senha");
                }
            }
        });

        /* configurações JLabel */
        JL1 = new JLabel("usuario:");
        JL1.setFont(new Font("arial", Font.BOLD, 20));
        JL1.setForeground(Color.MAGENTA);
        JL1.setBounds(10, 144, 80, 30);
        JL1.setVisible(true);

        JL2 = new JLabel("senha:");
        JL2.setFont(new Font("arial", Font.BOLD, 20));
        JL2.setForeground(Color.MAGENTA);
        JL2.setBounds(10, 267, 70, 30);
        JL2.setVisible(true);

        JL3 = new JLabel("<html>Bem vindo ao Escape-Bank<br> de um Escape na burocracia!</html>");
        JL3.setFont(new Font("arial", Font.BOLD, 20));
        JL3.setForeground(Color.MAGENTA);
        JL3.setBounds(10, 10, 450, 60);
        JL3.setVisible(true);

        JL4 = new JLabel("<html>seu usuario deve conter:<br> - começar com uma letra ou underline<br> - pode conter apenas letras, numeros e underline<br> - mínimo de 8 letrar e máximo de 16<br> - nao pode conter caterer especial<br> - nao pode conter espaços em branco</html>");
        JL4.setFont(new Font("arial", Font.BOLD, 10));
        JL4.setForeground(Color.MAGENTA);
        JL4.setBounds(10, 180, 450, 75);
        JL4.setVisible(true);

        JL5 = new JLabel("<html>sua senha deve conter:<br> - no mínimo de 8 digitos e máximo de 16 digitos<br> -deve incluir pelo menos um numero e 2 letras<br> -deve incluir pelo menos uma letra maiuscula e uma minuscula<br> -pode conter caracteres especiais<br> -nao pode conter numeros em sequencia<br> -não pode conter espaço em branco</html>");
        JL5.setFont(new Font("arial", Font.BOLD, 10));
        JL5.setForeground(Color.MAGENTA);
        JL5.setBounds(10,303 , 450, 90);
        JL5.setVisible(true);

        Icon1 = new JLabel("E");
        Icon1.setBounds(480,11,500,400);
        Icon1.setFont(new Font("arial", Font.ITALIC, 500));
        Icon1.setForeground(Color.MAGENTA);
        Icon1.setVisible(true);

        Icon2 = new JLabel("bank!");
        Icon2.setBounds(700,370,60,50);
        Icon2.setFont(new Font("arial", Font.ITALIC, 20));
        Icon2.setForeground(Color.MAGENTA);
        Icon2.setVisible(true);

        /* adicionando componentes */
        add(Icon1);
        add(JL3);
        add(JL1);
        add(JTF1);
        add(JL2);
        add(JTF2);
        add(JB1);
        add(JB2);
        add(JB2);
        add(JL4);
        add(JL5);
        add(Icon2);

        /* inicializando componentes e JFrame */
        setVisible(true);
    }
}
