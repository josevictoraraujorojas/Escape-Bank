import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

public class TelaDeLogin extends JFrame implements ActionListener {

    JButton jb1,jb2,jb3;
    JTextField jt1;
    JPasswordField jt2;
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
        setVisible(true);

        //configuracão do jbotton//
        jb1 = new JButton("ok");
        jb1.setBounds(500, 480, 100, 40);
        jb1.setBackground(Color.MAGENTA);
        jb1.setFont(new Font("Arial", Font.BOLD, 20));
        jb1.setForeground(Color.WHITE);
        jb1.setVisible(true);

        jb2 = new JButton("Primeiro acesso");
        jb2.setBounds(170, 480, 200, 40);
        jb2.setBackground(Color.MAGENTA);
        jb2.setFont(new Font("Arial", Font.BOLD, 20));
        jb2.setForeground(Color.WHITE);
        jb2.setVisible(true);
        jb2.addActionListener(this::cadastrarNovoUser);

        jb3 = new JButton("esqueci minha senha");
        jb3.setBorderPainted(false);
        jb3.setBounds(150, 390, 150, 20);
        jb3.setFont(new Font("Arial", Font.BOLD, 10));
        jb3.setForeground(Color.MAGENTA);
        jb3.setBackground(cor);
        jb3.setVisible(true);
        jb1.addActionListener(this);



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

        jt2 = new JPasswordField("digite a sua senha");
        jt2.setBounds(300, 336, 300, 40);
        jt2.setBackground(Color.MAGENTA);
        jt2.setForeground(Color.WHITE);
        jt2.setFont(new Font("Arial", Font.BOLD, 15));
        jt2.setVisible(true);
        jt2.setEchoChar('\u0000');
        jt2.addFocusListener(new FocusListener() {
                                 @Override
                                 public void focusGained(FocusEvent e) {
                                     jc.setSelected(false);
                                     jt2.setEchoChar('•');
                                     String password = String.valueOf(jt2.getPassword());

                                     if(password.toLowerCase().equals("digite a sua senha"))
                                     {
                                         jt2.setText("");
                                         jt2.setBackground(Color.magenta);
                                     }

                                 }

                                 @Override
                                 public void focusLost(FocusEvent e) {
                                     String password = String.valueOf(jt2.getPassword());


                                     if(password.toLowerCase().equals("") || password.toLowerCase().equals("digite a sua senha"))
                                     {
                                         jt2.setText("digite a sua senha");
                                         jt2.setEchoChar((char)0);
                                         jt2.setBackground(Color.red);

                                     }
                                 }
                             }
        );


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
        jc.addActionListener(this::mostrar);
        jc.setVisible(true);



        add(jc);
        add(jl3);
        add(jl1);
        add(jt1);
        add(jl2);
        add(jt2);
        add(jb3);
        add(jb1);
        add(jb2);
        add(jb2);
        setExtendedState(getState()| JFrame.MAXIMIZED_BOTH);
        setExtendedState(getState()| JFrame.NORMAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    private void mostrar(ActionEvent actionEvent) {
        if (jc.isSelected()){
            jt2.setEchoChar('\u0000');
        }else jt2.setEchoChar('•');
    }

    private void cadastrarNovoUser(ActionEvent actionEvent) {
        dispose();
        new TelaDeCadastro();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Login = jt1.getText();
        Senha = String.valueOf(jt2.getPassword());
        System.out.println(Senha);
        try {
            gravar();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void gravar() throws IOException {
        new Login(Login,Senha);

    }
}