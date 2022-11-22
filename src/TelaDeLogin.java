import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

public class TelaDeLogin extends JFrame
{

    JButton jb1,jb2,jb3;
    JTextField jt1;
    JPasswordField jps2;
    JLabel jl1,jl2,jl3;
    Color cor = new Color(98, 0, 158);
    JCheckBox jc;

    static  String Login = "";
    static String Senha = "";


    public  TelaDeLogin() {
        //configurações do jframe//
        setLayout(null);
        setTitle("tela de login");
        setSize(800, 600);
        getContentPane().setBackground(cor);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //configuracão do jbotton//
        jb1 = new JButton("ok");
        jb1.setBounds(500, 480, 100, 40);
        jb1.setBackground(Color.MAGENTA);
        jb1.setFont(new Font("Arial", Font.BOLD, 20));
        jb1.setForeground(Color.WHITE);
        jb1.setVisible(true);
        jb1.addActionListener(e ->
        {
            Login = jt1.getText();
            Senha = String.valueOf(jps2.getPassword());


                /*Preciso que Login().VerificaLogin(Login,Senha)
               estiver certo e gravou me retorne int 1;
               se der erro me retorne:
               JOptionPane.showMessageDialog(null,usuario não existe);seguido de: 2";
               ou
               JOptionPane.showMessageDialog(null,senha incorreta);seguido de: return "3";*/

            try {
                if (new Login().VerificaLogin(Login,Senha)==1)
                {

                    System.out.println("proxima tela ainda em desenvolvimento");
                } else if (new Login().VerificaLogin(Login,Senha)==2 )
                {
                    jt1.setBackground(Color.red);
                    jps2.setBackground(Color.red);
                } else if (new Login().VerificaLogin(Login,Senha)==3)
                {
                    jps2.setBackground(Color.red);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


        });

        jb2 = new JButton("Primeiro acesso");
        jb2.setBounds(170, 480, 200, 40);
        jb2.setBackground(Color.MAGENTA);
        jb2.setFont(new Font("Arial", Font.BOLD, 20));
        jb2.setForeground(Color.WHITE);
        jb2.setVisible(true);
        jb2.addActionListener(e ->
        {
            new TelaDeCadastro();
            dispose();
        });

        jb3 = new JButton("esqueci minha senha");
        jb3.setBorderPainted(false);
        jb3.setBounds(150, 390, 150, 20);
        jb3.setFont(new Font("Arial", Font.BOLD, 10));
        jb3.setForeground(Color.MAGENTA);
        jb3.setBackground(cor);
        jb3.setVisible(true);




        //configuraçao do Jtextfield//
        jt1 = new JTextField("digite seu nome de usuario");
        jt1.setBounds(300, 276, 300, 40);
        jt1.setBackground(Color.MAGENTA);
        jt1.setForeground(Color.WHITE);
        jt1.setFont(new Font("Arial", Font.BOLD, 15));
        jt1.setVisible(true);
        jt1.addFocusListener(new FocusListener()
        {
            public void focusGained(FocusEvent e)
            {
                if (jt1.getText().equals("digite seu nome de usuario"))
                {
                    jt1.setText("");
                    jt1.setBackground(Color.magenta);
                }
            }

            public void focusLost(FocusEvent e)
            {
                if (jt1.getText().isEmpty())
                {
                    jt1.setText("digite seu nome de usuario");
                    jt1.setBackground(Color.red);
                }
            }
        });

        jps2 = new JPasswordField("digite a sua senha");
        jps2.setBounds(300, 336, 300, 40);
        jps2.setBackground(Color.MAGENTA);
        jps2.setForeground(Color.WHITE);
        jps2.setFont(new Font("Arial", Font.BOLD, 15));
        jps2.setVisible(true);
        jps2.setEchoChar('\u0000');
        jps2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                jc.setSelected(false);
                jps2.setEchoChar('*');
                String password = String.valueOf(jps2.getPassword());

                if(password.equalsIgnoreCase("digite a sua senha"))
                {
                    jps2.setText("");
                    jps2.setBackground(Color.magenta);
                }

            }
            @Override
            public void focusLost(FocusEvent e)
            {
                String password = String.valueOf(jps2.getPassword());
                if(password.equalsIgnoreCase("") || password.equalsIgnoreCase("digite a sua senha"))
                {
                    jps2.setText("digite a sua senha");
                    jps2.setEchoChar((char)0);
                    jps2.setBackground(Color.red);

                }
            }
        });


        //configurar jlabel//
        jl1 = new JLabel("usuario:");
        jl1.setFont(new Font("arial", Font.BOLD, 20));
        jl1.setForeground(Color.MAGENTA);
        jl1.setBounds(170, 280, 80, 30);
        jl1.setVisible(true);

        jl2 = new JLabel("senha:");
        jl2.setFont(new Font("arial", Font.BOLD, 20));
        jl2.setForeground(Color.MAGENTA);
        jl2.setBounds(170, 340, 70, 30);
        jl2.setVisible(true);

        jl3 = new JLabel("<html> Scape<br>&nbsp;&nbsp; Bank</html>");
        jl3.setFont(new Font("arial", Font.BOLD, 60));
        jl3.setForeground(Color.MAGENTA);
        jl3.setBounds(280, 0, 240, 300);
        jl3.setVisible(true);

        jc = new JCheckBox();
        jc.setBounds(610,340,30,30);
        jc.setBackground(cor);
        jc.setVisible(true);
        jc.addActionListener(e ->
        {
            if (jc.isSelected())
            {
                jps2.setEchoChar('\u0000');
            }
            else jps2.setEchoChar('*');
        });



        add(jc);
        add(jl3);
        add(jl1);
        add(jt1);
        add(jl2);
        add(jps2);
        add(jb3);
        add(jb1);
        add(jb2);
        add(jb2);

        setVisible(true);

    }
}