import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

public class TelaDeLogin extends JFrame
{

    JButton JB1, JB2, JB3;
    JTextField JTF;
    JPasswordField JPF;
    JLabel JL1, JL2, JL3;


    JCheckBox JCB;

    static  String Login = "";
    static String Senha = "";
    Image iconeTitulo = new Icons().icon1();

    Color cor1 = new LigthMode().cor1();
    Color cor2 = new LigthMode().cor2();
    Color cor3 = new LigthMode().cor3();


    public  TelaDeLogin() {

        /* configurações do JFrame */
        setLayout(null);
        setTitle("tela de login");
        setSize(800, 600);
        getContentPane().setBackground(cor1);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
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
            Login = JTF.getText();
            Senha = String.valueOf(JPF.getPassword());


                /*Preciso que Login().VerificaLogin(Login,Senha)
               estiver certo e gravou me retorne int 1;
               se der erro me retorne:
               JOptionPane.showMessageDialog(null,usuario não existe);seguido de: 2";
               ou
               JOptionPane.showMessageDialog(null,senha incorreta);seguido de: return "3";*/


            try {
                switch (new Login().VerificaLogin(Login,Senha)){
                    case 1-> {
                        new SetPaths().SavePaths(new StringBuilder(Login),new URIpadrao().URICacheUserName(),false);
                        JOptionPane.showMessageDialog(null,new SetPaths().GetPaths(new URIpadrao().URICacheUserName()));
                        boolean a = true;
                        dispose();
                        Main.VerificarLogin(a);
                        String[] args = new String[0];
                        Main.main(args);
                    }
                    case 2->{}
                    case 3->{
                        System.out.println("p");
                    }
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
                    JTF.setBackground(Color.red);
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
                JCB.setSelected(false);
                JPF.setEchoChar('•');
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
                    JPF.setEchoChar((char)0);
                    JPF.setBackground(Color.red);

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
            if (JCB.isSelected())
            {
                JPF.setEchoChar('\u0000');
            }
            else JPF.setEchoChar('•');
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