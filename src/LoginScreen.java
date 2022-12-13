import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.ParseException;

public class LoginScreen extends JFrame
{

    JButton JB1, JB2, JB3;
    JTextField JTF;
    JPasswordField JPF;
    JLabel JL1, JL2, JL3;


    JCheckBox JCB;
    static  String login = "";
    static String senha = "";
    Image iconeTitulo = new Icons().icon1();

    Color cor1 = new PaletaDeCores().cor1();
    Color cor2 = new PaletaDeCores().cor2();
    Color cor3 = new PaletaDeCores().cor3();


    Color cor6 = new PaletaDeCores().cor6();


    public LoginScreen() {

        /* configurações do JFrame */
        setLayout(null);
        setTitle("tela de login");
        setIconImage(iconeTitulo);
        setSize(800, 600);
        getContentPane().setBackground(cor1);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
            }
        });
        setIconImage(iconeTitulo);

        /* configurações do JButton */
        JB1 = new JButton("ok");
        JB1.setBounds(500, 480, 100, 40);
        JB1.setBackground(cor2);
        JB1.setFont(new Font("Arial", Font.BOLD, 20));
        JB1.setForeground(cor3);
        JB1.setVisible(true);
        JB1.addActionListener(e ->
        {
            login = JTF.getText();
            senha = String.valueOf(JPF.getPassword());


                /*Preciso que Login().VerificaLogin(Login,Senha)
               estiver certo e gravou me retorne int 1;
               se der erro me retorne:
               JOptionPane.showMessageDialog(null,usuario não existe);seguido de: 2";
               ou
               JOptionPane.showMessageDialog(null,senha incorreta);seguido de: return "3";*/


            try {
                switch (new Login().VerificaLogin(login, senha)){
                    case 1-> {
                        new SetPaths().SavePaths(new StringBuilder(login),new URIpadrao().URICacheUserName(),false);
                        if (Senha.CriarSenha()){
                            dispose();
                            Main.VerificarLogin(true);
                            String[] args = new String[0];
                            Main.main(args);}
                    }
                    case 2->{}
                    case 3-> System.out.println("p");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


        });

        JB2 = new JButton("Primeiro acesso");
        JB2.setBounds(170, 480, 200, 40);
        JB2.setBackground(cor2);
        JB2.setFont(new Font("Arial", Font.BOLD, 20));
        JB2.setForeground(cor3);
        JB2.setVisible(true);
        JB2.addActionListener(e ->
        {
            new TelaDeCadastro();
            dispose();
        });

        JB3 = new JButton("esqueci minha senha");
        JB3.setBorderPainted(false);
        JB3.setBounds(150, 390, 150, 20);
        JB3.setFont(new Font("Arial", Font.BOLD, 10));
        JB3.setForeground(cor2);
        JB3.setBackground(cor1);
        JB3.setVisible(true);




        /* configurações do JTextField */
        JTF = new JTextField("digite seu nome de usuario");
        JTF.setBounds(300, 276, 300, 40);
        JTF.setBackground(cor2);
        JTF.setForeground(cor3);
        JTF.setFont(new Font("Arial", Font.BOLD, 15));
        JTF.setVisible(true);
        JTF.addFocusListener(new FocusListener()
        {
            public void focusGained(FocusEvent e)
            {
                if (JTF.getText().equals("digite seu nome de usuario"))
                {
                    JTF.setText("");
                    JTF.setBackground(cor2);
                }
            }

            public void focusLost(FocusEvent e)
            {
                if (JTF.getText().isEmpty())
                {
                    JTF.setText("digite seu nome de usuario");
                    JTF.setBackground(cor6);
                }
            }
        });

        JPF = new JPasswordField("digite a sua senha");
        JPF.setBounds(300, 336, 300, 40);
        JPF.setBackground(cor2);
        JPF.setForeground(cor3);
        JPF.setFont(new Font("Arial", Font.BOLD, 15));
        JPF.setVisible(true);
        JPF.setEchoChar('\u0000');
        JPF.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JCB.isSelected())
                {
                    JPF.setEchoChar('\u0000');
                }
                else JPF.setEchoChar('•');

                String password = String.valueOf(JPF.getPassword());

                if(password.equalsIgnoreCase("digite a sua senha"))
                {
                    JPF.setText("");
                    JPF.setBackground(cor2);
                }

            }
            @Override
            public void focusLost(FocusEvent e)
            {
                String password = String.valueOf(JPF.getPassword());


                if(password.equalsIgnoreCase("") || password.equalsIgnoreCase("digite a sua senha"))
                {
                    JPF.setText("digite a sua senha");
                    if (JCB.isSelected())
                    {
                        JPF.setEchoChar('\u0000');
                    }
                    else JPF.setEchoChar('\u0000');
                    JPF.setBackground(cor6);

                }

            }
        });


        /* configurações do JLabel */
        JL1 = new JLabel("usuario:");
        JL1.setFont(new Font("arial", Font.BOLD, 20));
        JL1.setForeground(cor2);
        JL1.setBounds(170, 280, 80, 30);
        JL1.setVisible(true);

        JL2 = new JLabel("senha:");
        JL2.setFont(new Font("arial", Font.BOLD, 20));
        JL2.setForeground(cor2);
        JL2.setBounds(170, 340, 70, 30);
        JL2.setVisible(true);

        JL3 = new JLabel("<html> Scape<br>&nbsp;&nbsp; Bank</html>");
        JL3.setFont(new Font("arial", Font.BOLD, 60));
        JL3.setForeground(cor2);
        JL3.setBounds(280, 0, 240, 300);
        JL3.setVisible(true);

        /* configurações do JCheckBox */
        JCB = new JCheckBox();
        JCB.setBounds(610,340,30,30);
        JCB.setBackground(cor1);
        JCB.setForeground(cor2);
        JCB.setVisible(true);
        JCB.addActionListener(e ->
        {
            String password = String.valueOf(JPF.getPassword());
            if (JCB.isSelected())
            {
                JPF.setEchoChar('\u0000');
            }
            else if(password.equalsIgnoreCase("") || password.equalsIgnoreCase("digite a sua senha"))
            {
                JPF.setEchoChar('\u0000');
            } else JPF.setEchoChar('•');
        });


        /* adicionando componentes */
        add(JCB);
        add(JL3);
        add(JL1);
        add(JTF);
        add(JL2);
        add(JPF);
        add(JB3);
        add(JB1);
        add(JB2);
        add(JB2);

        /* inicializando os componentes e o JFrame */
        setVisible(true);


    }
}
class
TelaDeCadastro extends JFrame {
    Image iconeTitulo = new Icons().icon1();

    Color cor1 = new PaletaDeCores().cor1();
    Color cor2 = new PaletaDeCores().cor2();
    Color cor3 = new PaletaDeCores().cor3();
    Color cor6 = new PaletaDeCores().cor6();

    JButton JB1, JB2;
    JTextField JTF1, JTF2;

    JLabel JL1, JL2, JL3, JL4, JL5, Icon1, Icon2;

    static  String Login = "";
    static String Senha = "";




    public TelaDeCadastro()
    {


        /* configurações do JFrame */
        setLayout(null);
        setTitle("tela de login");
        setIconImage(iconeTitulo);
        setSize(800, 600);
        getContentPane().setBackground(cor1);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
            }
        });
        setUndecorated(true);
        setLocationRelativeTo(null);

        /* configurações do JButton */
        JB1 = new JButton("ok");
        JB1.setBounds(460, 500, 100, 40);
        JB1.setBackground(cor2);
        JB1.setFont(new Font("Arial", Font.BOLD, 20));
        JB1.setForeground(cor3);
        JB1.setVisible(true);
        JB1.addActionListener(e ->
        {
            UIManager.getDefaults().put("OptionPane.background",cor1);
            UIManager.put ("Panel.background", cor1);
            Login = JTF1.getText();
            Senha = JTF2.getText();

            try
            { /*preciso de que "new Cadastro().CadastroLoginESenha(Login,Senha);"
                estiver certo e gravou me retorne int 1; se der erro me retorne:
                JOptionPane.showMessageDialog(null, esse nome de usuario não e valido); seguido de return "2";
                JOptionPane.showMessageDialog(null,esse senha invalida, atente-se aos requisitos); seguido de return "3";*/

                switch (new Cadastro().CadastroLoginESenha(Login,Senha)){
                    case 1 ->{
                        new TelaDeCadastroCliente();
                        dispose();
                    }
                    case 2 -> JTF1.setBackground(cor6);
                    case 3 -> JTF2.setBackground(cor6);
                }

            } catch (IOException a)
            {
                throw new RuntimeException(a);
            }
        });

        JB2 = new JButton("<- voltar");
        JB2.setBounds(170, 500, 120, 40);
        JB2.setBackground(cor2);
        JB2.setFont(new Font("Arial", Font.BOLD, 20));
        JB2.setForeground(cor3);
        JB2.setVisible(true);
        JB2.addActionListener(e ->
        {
            new LoginScreen();
            dispose();
        });

        /* configurações do JTextField */

        JTF1 = new JTextField("digite um nome de usuario");
        JTF1.setBounds(140, 145, 300, 30);//x=130 y= 4
        JTF1.setBackground(cor2);
        JTF1.setForeground(cor3);
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
        JTF2.setBackground(cor2);
        JTF2.setForeground(cor3);
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
        JL1.setForeground(cor2);
        JL1.setBounds(10, 144, 80, 30);
        JL1.setVisible(true);

        JL2 = new JLabel("senha:");
        JL2.setFont(new Font("arial", Font.BOLD, 20));
        JL2.setForeground(cor2);
        JL2.setBounds(10, 267, 70, 30);
        JL2.setVisible(true);

        JL3 = new JLabel("<html>Bem vindo ao Escape-Bank<br> de um Escape na burocracia!</html>");
        JL3.setFont(new Font("arial", Font.BOLD, 20));
        JL3.setForeground(cor2);
        JL3.setBounds(10, 10, 450, 60);
        JL3.setVisible(true);

        JL4 = new JLabel("<html>seu usuario deve conter:<br> - começar com uma letra ou underline<br> - pode conter apenas letras, numeros e underline<br> - mínimo de 8 letrar e máximo de 16<br> - nao pode conter caterer especial<br> - nao pode conter espaços em branco</html>");
        JL4.setFont(new Font("arial", Font.BOLD, 10));
        JL4.setForeground(cor2);
        JL4.setBounds(10, 180, 450, 75);
        JL4.setVisible(true);

        JL5 = new JLabel("<html>sua senha deve conter:<br> - no mínimo de 8 digitos e máximo de 16 digitos<br> -deve incluir pelo menos um numero e 2 letras<br> -deve incluir pelo menos uma letra maiuscula e uma minuscula<br> -pode conter caracteres especiais<br> -nao pode conter numeros em sequencia<br> -não pode conter espaço em branco</html>");
        JL5.setFont(new Font("arial", Font.BOLD, 10));
        JL5.setForeground(cor2);
        JL5.setBounds(10,303 , 450, 90);
        JL5.setVisible(true);

        Icon1 = new JLabel("S");
        Icon1.setBounds(450,11,500,400);
        Icon1.setFont(new Font("arial", Font.ITALIC, 500));
        Icon1.setForeground(cor2);
        Icon1.setVisible(true);

        Icon2 = new JLabel("bank!");
        Icon2.setBounds(700,370,60,50);
        Icon2.setFont(new Font("arial", Font.ITALIC, 20));
        Icon2.setForeground(cor2);
        Icon2.setVisible(true);


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
class TelaDeCadastroCliente extends JFrame {
    Image iconeTitulo = new Icons().icon1();

    Color cor1 = new PaletaDeCores().cor1();
    Color cor2 = new PaletaDeCores().cor2();
    Color cor3 = new PaletaDeCores().cor3();
    Color cor6 = new PaletaDeCores().cor6();

    JButton JB1, JB2;
    JTextField JT1, JT2, JT3, JT4, JT5;
    JFormattedTextField JFT1, JFT2, JFT3, JFT4;
    JLabel JL1, JL2, JL3, JL4;
    public static String Nome, Cpf, Endereco, Numero, Cep, Cidade, Estado, SalarioAtual, GanhosExtras;

    public TelaDeCadastroCliente()
    {

        /* configurações do JFrame */
        setLayout(null);
        setTitle("tela de login");
        setIconImage(iconeTitulo);
        setSize(800, 600);
        getContentPane().setBackground(cor1);
        setLocationRelativeTo(null);
        setUndecorated(true);

        int x = 280;
        int X = x-110;

        /* configurações do JButton */
        JB1 = new JButton("ok");
        JB1.setBounds(460, 500, 100, 40);
        JB1.setBackground(cor2);
        JB1.setFont(new Font("Arial", Font.BOLD, 20));
        JB1.setForeground(cor1);
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
                        Cartao.cartao();
                        String[] args = new String[0];
                        Main.main(args);
                    }
                    case 2 -> JT1.setBackground(cor6);
                    case 3 -> JFT1.setBackground(cor6);
                    case 4 -> JT2.setBackground(cor6);
                    case 5 -> JFT3.setBackground(cor6);
                    case 6 -> JT3.setBackground(cor6);
                    case 7 -> JFT4.setBackground(cor6);
                    case 8 -> JT4.setBackground(cor6);
                    case 9-> JT5.setBackground(cor6);
                    default -> System.out.println("erro");
                }
            }catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        JB2 = new JButton("<- voltar");
        JB2.setBounds(170, 500, 120, 40);
        JB2.setBackground(cor2);
        JB2.setFont(new Font("Arial", Font.BOLD, 20));
        JB2.setForeground(cor3);
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
        JT1.setBackground(cor2);
        JT1.setForeground(cor3);
        JT1.setFont(new Font("Arial", Font.BOLD, 15));
        JT1.setVisible(true);
        JT1.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT1.getText().equals("digite seu nome"))
                {
                    JT1.setBackground(cor2);
                    JT1.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT1.getText().equals(""))
                {
                    JT1.setBackground(cor6);
                    JT1.setText("digite seu nome");
                }
            }
        });

        JFT1 = new JFormattedTextField(cpf);
        JFT1.setBounds(x, 146, 280, 20);//x=130 y= 4
        JFT1.setBackground(cor2);
        JFT1.setForeground(cor3);
        JFT1.setFont(new Font("Arial", Font.BOLD, 15));
        JFT1.setVisible(true);
        JFT1.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JFT1.getText().equals("___.___.___-__"))
                {
                    JFT1.setBackground(cor2);
                    JFT1.setText("___.___.___-__");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (JFT1.getText().equals("___.___.___-__")){
                    JFT1.setBackground(cor6);
                    JFT1.setText("___.___.___-__");


                }

            }
        });

        JFT2 = new JFormattedTextField("digite seu endereco");
        JFT2.setBounds(x, 188, 280, 20);//x=130 y= 4
        JFT2.setBackground(cor2);
        JFT2.setForeground(cor3);
        JFT2.setFont(new Font("Arial", Font.BOLD, 15));
        JFT2.setVisible(true);
        JFT2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JFT2.getText().equals("digite seu endereco"))
                {
                    JFT2.setBackground(cor2);
                    JFT2.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (JFT2.getText().equals(""))
                {
                    JFT2.setBackground(cor6);
                    JFT2.setText("digite seu endereco");
                }
            }
        });

        JT2 = new JTextField("digite o numero do seu endereco");
        JT2.setBounds(x, 230, 280, 20);//x=130 y= 4
        JT2.setBackground(cor2);
        JT2.setForeground(cor3);
        JT2.setFont(new Font("Arial", Font.BOLD, 15));
        JT2.setVisible(true);
        JT2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT2.getText().equals("digite o numero do seu endereco"))
                {
                    JT2.setBackground(cor2);
                    JT2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT2.getText().equals(""))
                {
                    JT2.setBackground(cor6);
                    JT2.setText("digite o numero do seu endereco");
                }

            }
        });


        JFT3 = new JFormattedTextField(cep);
        JFT3.setBounds(x, 272, 280, 20);//x=130 y= 4
        JFT3.setBackground(cor2);
        JFT3.setForeground(cor3);
        JFT3.setFont(new Font("Arial", Font.BOLD, 15));
        JFT3.setVisible(true);
        JFT3.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JFT3.getText().equals("__.___-___"))
                {
                    JFT3.setBackground(cor2);
                    JFT3.setText("__.___-___");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JFT3.getText().equals("__.___-___"))
                {
                    JFT3.setBackground(cor6);
                    JFT3.setText("__.___-___");
                }
            }
        });


        JT3 = new JTextField("digite o nome da sua cidade");
        JT3.setBounds(x, 314, 280, 20);//x=130 y= 4
        JT3.setBackground(cor2);
        JT3.setForeground(cor3);
        JT3.setFont(new Font("Arial", Font.BOLD, 15));
        JT3.setVisible(true);
        JT3.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT3.getText().equals("digite o nome da sua cidade"))
                {
                    JT3.setBackground(cor2);
                    JT3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT3.getText().equals(""))
                {
                    JT3.setBackground(cor6);
                    JT3.setText("digite o nome da sua cidade");
                }

            }
        });

        JFT4 = new JFormattedTextField(estado);
        JFT4.setBounds(x, 356, 280, 20);//x=130 y= 4
        JFT4.setBackground(cor2);
        JFT4.setForeground(cor3);
        JFT4.setFont(new Font("Arial", Font.BOLD, 15));
        JFT4.setVisible(true);
        JFT4.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JFT4.getText().equals("__"))
                {
                    JFT4.setBackground(cor2);
                    JFT4.setText("__");
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (JFT4.getText().equals("__"))
                {
                    JFT4.setBackground(cor6);
                    JFT4.setText("__");
                }
            }
        });

        JT4 = new JTextField("R$______.__");
        JT4.setBounds(x, 398, 280, 20);//x=130 y= 4
        JT4.setBackground(cor2);
        JT4.setForeground(cor3);
        JT4.setFont(new Font("Arial", Font.BOLD, 15));
        JT4.setVisible(true);
        JT4.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT4.getText().equals("R$______.__"))
                {
                    JT4.setBackground(cor2);
                    JT4.setText("R$");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT4.getText().equals("R$")|| JT4.getText().equals(""))
                {
                    JT4.setBackground(cor6);
                    JT4.setText("R$______.__");
                }

            }
        });

        JT5 = new JTextField("R$______.__");
        JT5.setBounds(x, 440, 280, 20);//x=130 y= 4
        JT5.setBackground(cor2);
        JT5.setForeground(cor3);
        JT5.setFont(new Font("Arial", Font.BOLD, 15));
        JT5.setVisible(true);
        JT5.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (JT5.getText().equals("R$______.__"))
                {
                    JT5.setBackground(cor2);
                    JT5.setText("R$");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (JT5.getText().equals("R$")|| JT5.getText().equals(""))
                {
                    JT5.setBackground(cor6);
                    JT5.setText("R$______.__");
                }

            }
        });

        /* configurações do JLabel */
        JL1 = new JLabel("<html>nome:<br><br>cpf:<br><br>endereco:<br><br>numero:<br><br>cep:<br><br>cidade:<br><br>estado:<br><br>salario:<br><br>renda extra: </html>");
        JL1.setFont(new Font("arial", Font.BOLD, 17));
        JL1.setForeground(cor2);
        JL1.setBounds(X, 80, 100, 400);
        JL1.setVisible(true);

        JL2 = new JLabel("<html>Bem vindo ao Escape-Bank<br> dê um Escape na burocracia!</html>");
        JL2.setFont(new Font("arial", Font.BOLD, 20));
        JL2.setForeground(cor2);
        JL2.setBounds(10, 10, 450, 60);
        JL2.setVisible(true);

        JL3 = new JLabel("<html>$<br>$</html>");
        JL3.setFont(new Font("arial", Font.BOLD, 100));
        JL3.setForeground(cor2);
        JL3.setBounds(30, 0, 100, 600);
        JL3.setVisible(true);

        JL4 = new JLabel("<html>$<br>$</html>");
        JL4.setFont(new Font("arial", Font.BOLD, 100));
        JL4.setForeground(cor2);
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