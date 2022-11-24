import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.text.ParseException;

public class TelaDeCadastroCliente extends JFrame {

    JButton JB1, JB2;
    JTextField JT1, JT2, JT3, JT4, JT5;
    JFormattedTextField JFT1, JFT2, JFT3, JFT4;
    JLabel JL1, JL2, JL3, JL4;
    Color cor = new Color(98, 0, 158);
    public static String Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras;

    public TelaDeCadastroCliente()
    {

        /* configurações do JFrame */
        setLayout(null);
        setTitle("tela de login");
        setSize(800, 600);
        getContentPane().setBackground(cor);
        setLocationRelativeTo(null);
        setUndecorated(true);

        int x = 280;
        int X = x-110;

        /* configurações do JButton */
        JB1 = new JButton("ok");
        JB1.setBounds(460, 500, 100, 40);
        JB1.setBackground(Color.MAGENTA);
        JB1.setFont(new Font("Arial", Font.BOLD, 20));
        JB1.setForeground(Color.WHITE);
        JB1.setVisible(true);
        JB1.addActionListener(e ->
                {
                    Nome = JT1.getText();
                    Cpf = JFT1.getText();
                    Endereco = JFT2.getText();
                    Numero = JT2.getText();
                    Cep = JFT3.getText();
                    Cidade = JT3.getText();
                    Estado = JFT4.getText();
                    SalarioAtual = JT4.getText();
                    GanhosExtras = JT5.getText();
                    SalarioAtual = SalarioAtual.substring(2);
                    GanhosExtras = GanhosExtras.substring(2);
            /*
               Preciso que "CadastroCliente.cadastrarConta(Nome,Cpf,Endereco,Numero,Cep,Cidade,Estado,SalarioAtual,GanhosExtras)"
               estiver certo e gravou me retorne int 1; caso esteja errado me retorne:
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo nome não pode conter números ou caracteres especiais. Tente novamente.");
               seguido de return "1"; ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo cpf tem que conter 11 digitos. Tente novamente.");
               seguido de return "2"; ou
               OBS: endereço nao precisa me retornar nada!ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo numero pode conter até 3 numeros. Tente novamente.");
               seguido de return "3"; ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo cep tem que conter 8 digitos. Tente novamente.");
               seguido de return "4"; ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo cidade não pode conter numeros e nem caracteres especiais. Tente novamente.");
               seguido de return "5"; ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo estado não pode conter numeros e nem caracteres especiais. Tente novamente.");
               seguido de return "6"; ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! Ariana o campo Salario atual ariana aqui fica ao seu dispor. Tente novamente.");
               seguido de return "7"; ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! Ariana o campo Salario renda extra ariana aqui fica ao seu dispor. Tente novamente.");
               seguido de return "8";
             */

                    try {
                        new CadastroCliente();
                        switch (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras))
                        {
                            case 1 -> {
                                JOptionPane.showMessageDialog(null, "usuario cadastrado com sucesso");
                                dispose();
                            }
                            case 2 -> JT1.setBackground(Color.red);
                            case 3 -> JFT1.setBackground(Color.red);
                            case 4 -> JT2.setBackground(Color.red);
                            case 5 -> JFT3.setBackground(Color.red);
                            case 6 -> JT3.setBackground(Color.red);
                            case 7 -> JFT4.setBackground(Color.red);
                            case 8 -> JT4.setBackground(Color.red);
                            case 9-> JT5.setBackground(Color.red);
                            default -> System.out.println("erro");
                        }
                    }catch (IOException ex) {
                        throw new RuntimeException(ex);
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
            new TelaDeCadastro();
            dispose();
        });

        /* mascarando as caixas de textos */
        MaskFormatter cpf = null;
        MaskFormatter numero;
        MaskFormatter estado = null;
        MaskFormatter cep = null;


        try
        {

            cpf = new MaskFormatter("###.###.###-##");
            numero = new MaskFormatter("#####");
            estado = new MaskFormatter("UU");
            cep = new MaskFormatter("##.###-###");
            cpf.setPlaceholderCharacter('_');
            numero.setPlaceholderCharacter('_');
            estado.setPlaceholderCharacter('_');
            cep.setPlaceholderCharacter('_');


        } catch(ParseException exe)
        {
            System.err.println("Erro na formatação: " + exe.getMessage());
            System.exit(-1);
        }

        /* configurações do JTextField e o JFormatTextField */
        JT1 = new JTextField("digite seu nome");
        JT1.setBounds(x, 104, 280, 20);//x=130 y= 4
        JT1.setBackground(Color.MAGENTA);
        JT1.setForeground(Color.WHITE);
        JT1.setFont(new Font("Arial", Font.BOLD, 15));
        JT1.setVisible(true);
        JT1.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT1.getText().equals("digite seu nome"))
                {
                    JT1.setBackground(Color.MAGENTA);
                    JT1.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT1.getText().equals(""))
                {
                    JT1.setBackground(Color.red);
                    JT1.setText("digite seu nome");
                }
            }
        });

        JFT1 = new JFormattedTextField(cpf);
        JFT1.setBounds(x, 146, 280, 20);//x=130 y= 4
        JFT1.setBackground(Color.MAGENTA);
        JFT1.setForeground(Color.WHITE);
        JFT1.setFont(new Font("Arial", Font.BOLD, 15));
        JFT1.setVisible(true);
        JFT1.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JFT1.getText().equals("___.___.___-__"))
                {
                    JFT1.setBackground(Color.magenta);
                    JFT1.setText("___.___.___-__");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (JFT1.getText().equals("___.___.___-__")){
                    JFT1.setBackground(Color.red);
                    JFT1.setText("___.___.___-__");


                }

            }
        });

        JFT2 = new JFormattedTextField("digite seu endereco");
        JFT2.setBounds(x, 188, 280, 20);//x=130 y= 4
        JFT2.setBackground(Color.MAGENTA);
        JFT2.setForeground(Color.WHITE);
        JFT2.setFont(new Font("Arial", Font.BOLD, 15));
        JFT2.setVisible(true);
        JFT2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JFT2.getText().equals("digite seu endereco"))
                {
                    JFT2.setBackground(Color.MAGENTA);
                    JFT2.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (JFT2.getText().equals(""))
                {
                    JFT2.setBackground(Color.red);
                    JFT2.setText("digite seu endereco");
                }
            }
        });

        JT2 = new JTextField("digite o numero do seu endereco");
        JT2.setBounds(x, 230, 280, 20);//x=130 y= 4
        JT2.setBackground(Color.MAGENTA);
        JT2.setForeground(Color.WHITE);
        JT2.setFont(new Font("Arial", Font.BOLD, 15));
        JT2.setVisible(true);
        JT2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT2.getText().equals("digite o numero do seu endereco"))
                {
                    JT2.setBackground(Color.MAGENTA);
                    JT2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT2.getText().equals(""))
                {
                    JT2.setBackground(Color.red);
                    JT2.setText("digite o numero do seu endereco");
                }

            }
        });


        JFT3 = new JFormattedTextField(cep);
        JFT3.setBounds(x, 272, 280, 20);//x=130 y= 4
        JFT3.setBackground(Color.MAGENTA);
        JFT3.setForeground(Color.WHITE);
        JFT3.setFont(new Font("Arial", Font.BOLD, 15));
        JFT3.setVisible(true);
        JFT3.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JFT3.getText().equals("__.___-___"))
                {
                    JFT3.setBackground(Color.magenta);
                    JFT3.setText("__.___-___");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JFT3.getText().equals("__.___-___"))
                {
                    JFT3.setBackground(Color.red);
                    JFT3.setText("__.___-___");
                }
            }
        });


        JT3 = new JTextField("digite o nome da sua cidade");
        JT3.setBounds(x, 314, 280, 20);//x=130 y= 4
        JT3.setBackground(Color.MAGENTA);
        JT3.setForeground(Color.WHITE);
        JT3.setFont(new Font("Arial", Font.BOLD, 15));
        JT3.setVisible(true);
        JT3.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT3.getText().equals("digite o nome da sua cidade"))
                {
                    JT3.setBackground(Color.MAGENTA);
                    JT3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT3.getText().equals(""))
                {
                    JT3.setBackground(Color.red);
                    JT3.setText("digite o nome da sua cidade");
                }

            }
        });

        JFT4 = new JFormattedTextField(estado);
        JFT4.setBounds(x, 356, 280, 20);//x=130 y= 4
        JFT4.setBackground(Color.MAGENTA);
        JFT4.setForeground(Color.WHITE);
        JFT4.setFont(new Font("Arial", Font.BOLD, 15));
        JFT4.setVisible(true);
        JFT4.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JFT4.getText().equals("__"))
                {
                    JFT4.setBackground(Color.MAGENTA);
                    JFT4.setText("__");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (JFT4.getText().equals("__"))
                {
                    JFT4.setBackground(Color.red);
                    JFT4.setText("__");
                }
            }
        });

        JT4 = new JTextField("R$______.__");
        JT4.setBounds(x, 398, 280, 20);//x=130 y= 4
        JT4.setBackground(Color.MAGENTA);
        JT4.setForeground(Color.WHITE);
        JT4.setFont(new Font("Arial", Font.BOLD, 15));
        JT4.setVisible(true);
        JT4.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT4.getText().equals("R$______.__"))
                {
                    JT4.setBackground(Color.MAGENTA);
                    JT4.setText("R$");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT4.getText().equals("R$")|| JT4.getText().equals(""))
                {
                    JT4.setBackground(Color.red);
                    JT4.setText("R$______.__");
                }

            }
        });

        JT5 = new JTextField("R$______.__");
        JT5.setBounds(x, 440, 280, 20);//x=130 y= 4
        JT5.setBackground(Color.MAGENTA);
        JT5.setForeground(Color.WHITE);
        JT5.setFont(new Font("Arial", Font.BOLD, 15));
        JT5.setVisible(true);
        JT5.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT5.getText().equals("R$______.__"))
                {
                    JT5.setBackground(Color.MAGENTA);
                    JT5.setText("R$");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT5.getText().equals("R$")|| JT5.getText().equals(""))
                {
                    JT5.setBackground(Color.red);
                    JT5.setText("R$______.__");
                }

            }
        });

        /* configurações do JLabel */
        JL1 = new JLabel("<html>nome:<br><br>cpf:<br><br>endereco:<br><br>numero:<br><br>cep:<br><br>cidade:<br><br>estado:<br><br>salario:<br><br>renda extra: </html>");
        JL1.setFont(new Font("arial", Font.BOLD, 17));
        JL1.setForeground(Color.MAGENTA);
        JL1.setBounds(X, 80, 100, 400);
        JL1.setVisible(true);

        JL2 = new JLabel("<html>Bem vindo ao Escape-Bank<br> dê um Escape na burocracia!</html>");
        JL2.setFont(new Font("arial", Font.BOLD, 20));
        JL2.setForeground(Color.MAGENTA);
        JL2.setBounds(10, 10, 450, 60);
        JL2.setVisible(true);

        JL3 = new JLabel("<html>$<br>$</html>");
        JL3.setFont(new Font("arial", Font.BOLD, 100));
        JL3.setForeground(Color.MAGENTA);
        JL3.setBounds(30, 0, 100, 600);
        JL3.setVisible(true);

        JL4 = new JLabel("<html>$<br>$</html>");
        JL4.setFont(new Font("arial", Font.BOLD, 100));
        JL4.setForeground(Color.MAGENTA);
        JL4.setBounds(700, 0, 100, 600);
        JL4.setVisible(true);
         /* adicionando components */
        add(JL2);
        add(JL1);
        add(JT1);
        add(JFT1);
        add(JFT2);
        add(JT2);
        add(JFT3);
        add(JT3);
        add(JFT4);
        add(JT4);
        add(JT5);
        add(JB1);
        add(JB2);
        add(JB2);
        add(JL3);
        add(JL4);

        /* inicializando componentes e JFrame */
        setVisible(true);
    }
}