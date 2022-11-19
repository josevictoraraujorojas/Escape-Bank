import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.text.ParseException;

public class TelaDeCadastroCliente extends JFrame {

    JButton jb1,jb2;
    JTextField jt1;
    JFormattedTextField jt2;
    JFormattedTextField jt3;
    JTextField jt4;
    JFormattedTextField jt5;
    JTextField jt6;
    JFormattedTextField jt7;
    JTextField jt8;
    JTextField jt9;
    JLabel jl1,jl2,jl3, jl4, jl5;
    Color cor = new Color(98, 0, 158);
    public static String Nome;
    public static String Cpf;
    public static String Endereco;
    public static String Numero;
    public static String Cep;
    public static String Cidade;
    public static String Estado;
    public static String SalarioAtual;
    public static String GanhosExtras;

    public TelaDeCadastroCliente()
    {

        //configurações do jframe//
        setLayout(null);
        setTitle("tela de login");
        setSize(800, 600);
        getContentPane().setBackground(cor);
        setLocationRelativeTo(null);
        setUndecorated(true);

        int x = 280;
        int X = x-110;

        //configuracão do jbotton//
        jb1 = new JButton("ok");
        jb1.setBounds(460, 500, 100, 40);
        jb1.setBackground(Color.MAGENTA);
        jb1.setFont(new Font("Arial", Font.BOLD, 20));
        jb1.setForeground(Color.WHITE);
        jb1.setVisible(true);
        jb1.addActionListener(e ->
                {
                    Nome = jt1.getText();
                    Cpf = jt2.getText();
                    Endereco = jt3.getText();
                    Numero = jt4.getText();
                    Cep = jt5.getText();
                    Cidade = jt6.getText();
                    Estado = jt7.getText();
                    SalarioAtual = jt8.getText();
                    GanhosExtras = jt9.getText();
            /*
               Preciso que "CadastroCliente.cadastrarConta(Nome,Cpf,Endereco,Numero,Cep,Cidade,Estado,SalarioAtual,GanhosExtras);"
               estiver certo e gravou me retorne int "1"; caso esteja errado me retorne:
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo nome não pode conter números ou caracteres especiais. Tente novamente.");
               seguido de return "1"; ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo cpf tem que conter 11 digitos. Tente novamente.");
               seguido de return "2"; ou
               OBS: endereço nao precisa me retornar nada!ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo numero pode conter até 3 numeros. Tente novamente.");
               seguido de return "3";ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo cep tem que conter 8 digitos. Tente novamente.");
               seguido de return "4";ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo cidade não pode conter numeros e nem caracteres especiais. Tente novamente.");
               seguido de return "5"; ou
               JOptionPane.showMessageDialog(null,"Você digitou errado! O campo estado não pode conter numeros e nem caracteres especiais. Tente novamente.");
               seguido de return "6";ou
               JOptionPane.showMessageDialog(null,"Você digitou errado!  ariana o campo Salario atual ariana aqui fica ao seu dispor. Tente novamente.");
               seguido de return "7";ou
               JOptionPane.showMessageDialog(null,"Você digitou errado!  ariana o campo Salario renda extra ariana aqui fica ao seu dispor. Tente novamente.");
               seguido de return "8";
             */

                    try {
                        if (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras)==1)
                        {
                            JOptionPane.showMessageDialog(null, "usuario cadastrado com sucesso");
                            dispose();
                            new TelaDeLogin();
                        } else if (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras)==2)
                        {
                            jt1.setBackground(Color.red);
                        } else if (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras)==3)
                        {
                            jt2.setBackground(Color.red);
                        } else if (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras)==4)
                        {
                            jt4.setBackground(Color.red);
                        } else if (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras) == 5)
                        {
                            jt5.setBackground(Color.red);
                        } else if (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras)==6)
                        {
                            jt6.setBackground(Color.red);
                        } else if (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras)==7)
                        {
                           jt7.setBackground(Color.red);
                        } else if (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras)==8)
                        {
                           jt8.setBackground(Color.red);
                        } else if (CadastroCliente.cadastrarConta(Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras)==9)
                        {
                            jt9.setBackground(Color.red);
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });






        jb2 = new JButton("<- voltar");
        jb2.setBounds(170, 500, 120, 40);
        jb2.setBackground(Color.MAGENTA);
        jb2.setFont(new Font("Arial", Font.BOLD, 20));
        jb2.setForeground(Color.WHITE);
        jb2.setVisible(true);
        jb2.addActionListener(e ->
        {
            new TelaDeCadastro();
            dispose();
        });

        MaskFormatter cpf = null;
        MaskFormatter numero;
        MaskFormatter estado = null;
        MaskFormatter cep = null;
        MaskFormatter salarioatual;
        MaskFormatter ganhoextras;


        try
        {

            cpf = new MaskFormatter("###.###.###-##");
            numero = new MaskFormatter("#####");
            estado = new MaskFormatter("UU");
            cep = new MaskFormatter("##.###-###");
            salarioatual = new MaskFormatter("R$#######.##");
            ganhoextras = new MaskFormatter("R$************");
            cpf.setPlaceholderCharacter('_');
            numero.setPlaceholderCharacter('_');
            estado.setPlaceholderCharacter('_');
            cep.setPlaceholderCharacter('_');
            salarioatual.setPlaceholderCharacter(' ');
            ganhoextras.setPlaceholderCharacter('_');


        } catch(ParseException excp)
        {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }

        //configuraçao do Jtextfield//
        jt1  = new JTextField("digite seu nome");
        jt1.setBounds(x, 104, 280, 20);//x=130 y= 4
        jt1.setBackground(Color.MAGENTA);
        jt1.setForeground(Color.WHITE);
        jt1.setFont(new Font("Arial", Font.BOLD, 15));
        jt1.setVisible(true);
        jt1.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jt1.getText().equals("digite seu nome"))
                {
                    jt1.setBackground(Color.MAGENTA);
                    jt1.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (jt1.getText().equals(""))
                {
                    jt1.setBackground(Color.red);
                    jt1.setText("digite seu nome");
                }
            }
        });

        jt2  = new JFormattedTextField(cpf);
        jt2.setBounds(x, 146, 280, 20);//x=130 y= 4
        jt2.setBackground(Color.MAGENTA);
        jt2.setForeground(Color.WHITE);
        jt2.setFont(new Font("Arial", Font.BOLD, 15));
        jt2.setVisible(true);
        jt2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jt2.getText().equals("___.___.___-__"))
                {
                    jt2.setBackground(Color.magenta);
                    jt2.setText("___.___.___-__");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jt2.getText().equals("___.___.___-__")){
                    jt2.setBackground(Color.red);
                    jt2.setText("___.___.___-__");


                }

            }
        });

        jt3  = new JFormattedTextField("digite seu endereco");
        jt3.setBounds(x, 188, 280, 20);//x=130 y= 4
        jt3.setBackground(Color.MAGENTA);
        jt3.setForeground(Color.WHITE);
        jt3.setFont(new Font("Arial", Font.BOLD, 15));
        jt3.setVisible(true);
        jt3.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jt3.getText().equals("digite seu endereco"))
                {
                    jt3.setBackground(Color.MAGENTA);
                    jt3.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (jt3.getText().equals(""))
                {
                    jt3.setBackground(Color.red);
                    jt3.setText("digite seu endereco");
                }
            }
        });

        jt4  = new JTextField("digite o numero do seu endereco");
        jt4.setBounds(x, 230, 280, 20);//x=130 y= 4
        jt4.setBackground(Color.MAGENTA);
        jt4.setForeground(Color.WHITE);
        jt4.setFont(new Font("Arial", Font.BOLD, 15));
        jt4.setVisible(true);
        jt4.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jt4.getText().equals("digite o numero do seu endereco"))
                {
                    jt4.setBackground(Color.MAGENTA);
                    jt4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (jt4.getText().equals(""))
                {
                    jt4.setBackground(Color.red);
                    jt4.setText("digite o numero do seu endereco");
                }

            }
        });


        jt5  = new JFormattedTextField(cep);
        jt5.setBounds(x, 272, 280, 20);//x=130 y= 4
        jt5.setBackground(Color.MAGENTA);
        jt5.setForeground(Color.WHITE);
        jt5.setFont(new Font("Arial", Font.BOLD, 15));
        jt5.setVisible(true);
        jt5.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jt5.getText().equals("__.___-___"))
                {
                    jt5.setBackground(Color.magenta);
                    jt5.setText("__.___-___");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (jt5.getText().equals("__.___-___"))
                {
                    jt5.setBackground(Color.red);
                    jt5.setText("__.___-___");
                }
            }
        });


        jt6  = new JTextField("digite o nome da sua cidade");
        jt6.setBounds(x, 314, 280, 20);//x=130 y= 4
        jt6.setBackground(Color.MAGENTA);
        jt6.setForeground(Color.WHITE);
        jt6.setFont(new Font("Arial", Font.BOLD, 15));
        jt6.setVisible(true);
        jt6.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jt6.getText().equals("digite o nome da sua cidade"))
                {
                    jt6.setBackground(Color.MAGENTA);
                    jt6.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (jt6.getText().equals(""))
                {
                    jt6.setBackground(Color.red);
                    jt6.setText("digite o nome da sua cidade");
                }

            }
        });

        jt7  = new JFormattedTextField(estado);
        jt7.setBounds(x, 356, 280, 20);//x=130 y= 4
        jt7.setBackground(Color.MAGENTA);
        jt7.setForeground(Color.WHITE);
        jt7.setFont(new Font("Arial", Font.BOLD, 15));
        jt7.setVisible(true);
        jt7.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jt7.getText().equals("__"))
                {
                    jt7.setBackground(Color.MAGENTA);
                    jt7.setText("__");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (jt7.getText().equals("__"))
                {
                    jt7.setBackground(Color.red);
                    jt7.setText("__");
                }
            }
        });

        jt8  = new JTextField("R$___.__,__");
        jt8.setBounds(x, 398, 280, 20);//x=130 y= 4
        jt8.setBackground(Color.MAGENTA);
        jt8.setForeground(Color.WHITE);
        jt8.setFont(new Font("Arial", Font.BOLD, 15));
        jt8.setVisible(true);
        jt8.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jt8.getText().equals("R$___.__,__"))
                {
                    jt8.setBackground(Color.MAGENTA);
                    jt8.setText("R$");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (jt8.getText().equals("R$")||jt8.getText().equals(""))
                {
                    jt8.setBackground(Color.red);
                    jt8.setText("R$___.__,__");
                }

            }
        });

        jt9  = new JTextField("R$___.__,__");
        jt9.setBounds(x, 440, 280, 20);//x=130 y= 4
        jt9.setBackground(Color.MAGENTA);
        jt9.setForeground(Color.WHITE);
        jt9.setFont(new Font("Arial", Font.BOLD, 15));
        jt9.setVisible(true);
        jt9.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (jt9.getText().equals("R$___.__,__"))
                {
                    jt9.setBackground(Color.MAGENTA);
                    jt9.setText("R$");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (jt9.getText().equals("R$")||jt9.getText().equals(""))
                {
                    jt9.setBackground(Color.red);
                    jt9.setText("R$___.__,__");
                }

            }
        });




        //configurar jlabel//
        jl1 = new JLabel("<html>nome:<br><br>cpf:<br><br>endereco:<br><br>numero:<br><br>cep:<br><br>cidade:<br><br>estado:<br><br>salario:<br><br>rendaextra: </html>");
        jl1.setFont(new Font("arial", Font.BOLD, 17));
        jl1.setForeground(Color.MAGENTA);
        jl1.setBounds(X, 80, 100, 400);
        jl1.setVisible(true);

        jl2 = new JLabel("senha:");
        jl2.setFont(new Font("arial", Font.BOLD, 20));
        jl2.setForeground(Color.MAGENTA);
        jl2.setBounds(10, 267, 70, 30);
        jl2.setVisible(true);

        jl3 = new JLabel("<html>Bem vindo ao Escape-Bank<br> dê um Escape na burocracia!</html>");
        jl3.setFont(new Font("arial", Font.BOLD, 20));
        jl3.setForeground(Color.MAGENTA);
        jl3.setBounds(10, 10, 450, 60);
        jl3.setVisible(true);

        jl4 = new JLabel("<html>$<br>$</html>");
        jl4.setFont(new Font("arial", Font.BOLD, 100));
        jl4.setForeground(Color.MAGENTA);
        jl4.setBounds(30, 0, 100, 600);
        jl4.setVisible(true);

        jl5 = new JLabel("<html>$<br>$</html>");
        jl5.setFont(new Font("arial", Font.BOLD, 100));
        jl5.setForeground(Color.MAGENTA);
        jl5.setBounds(700, 0, 100, 600);
        jl5.setVisible(true);



        add(jl3);
        add(jl1);
        add(jt1);
    /*    add(jl2);*/
        add(jt2);
        add(jt3);
        add(jt4);
        add(jt5);
        add(jt6);
        add(jt7);
        add(jt8);
        add(jt9);
        add(jb1);
        add(jb2);
        add(jb2);
        add(jl4);
        add(jl5);

        setVisible(true);
    }
}

