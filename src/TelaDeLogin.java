import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaDeLogin extends JFrame implements ActionListener
{

    JButton jb1,jb2,jb3;
    JTextField jt1,jt2;
    JLabel jl1,jl2,jl3;
    Color cor = new Color(98, 0, 158);

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
        jb1.setBounds(500, 500, 100, 40);
        jb1.setBackground(Color.MAGENTA);
        jb1.setFont(new Font("Arial", Font.BOLD, 20));
        jb1.setForeground(Color.WHITE);
        jb1.setVisible(true);

        jb2 = new JButton("Primeiro acesso");
        jb2.setBounds(170, 500, 200, 40);
        jb2.setBackground(Color.MAGENTA);
        jb2.setFont(new Font("Arial", Font.BOLD, 20));
        jb2.setForeground(Color.WHITE);
        jb2.setVisible(true);
        jb2.addActionListener(this::cadastrarNovoUser);

        jb3 = new JButton("esqueci minha senha");
        jb3.setBorderPainted(false);
        jb3.setBounds(150, 410, 150, 20);
        jb3.setFont(new Font("Arial", Font.BOLD, 10));
        jb3.setForeground(Color.MAGENTA);
        jb3.setBackground(cor);
        jb3.setVisible(true);

        jb1.addActionListener(this);



        //configuraçao do Jtextfield//
        jt1 = new JTextField();
        jt1.setBounds(300, 286, 300, 40);
        jt1.setBackground(Color.MAGENTA);
        jt1.setForeground(Color.WHITE);
        jt1.setFont(new Font("Arial", Font.BOLD, 15));
        jt1.setVisible(true);

        jt2 = new JTextField();
        jt2.setBounds(300, 346, 300, 40);
        jt2.setBackground(Color.MAGENTA);
        jt2.setForeground(Color.WHITE);
        jt2.setFont(new Font("Arial", Font.BOLD, 15));
        jt2.setVisible(true);



        //configurar jlabel//
        jl1 = new JLabel("usuario:");
        jl1.setFont(new Font("arial", Font.BOLD, 20));
        jl1.setForeground(Color.MAGENTA);
        jl1.setBounds(170, 290, 80, 30);
        jl1.setVisible(true);

        jl2 = new JLabel("senha:");
        jl2.setFont(new Font("arial", Font.BOLD, 20));
        jl2.setForeground(Color.MAGENTA);
        jl2.setBounds(170, 350, 70, 30);
        jl2.setVisible(true);

        jl3 = new JLabel("<html> Scape<br>&nbsp;&nbsp; Bank</html>");
        jl3.setFont(new Font("arial", Font.BOLD, 60));
        jl3.setForeground(Color.MAGENTA);
        jl3.setBounds(280, 0, 240, 300);
        jl3.setVisible(true);


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

    private void cadastrarNovoUser(ActionEvent actionEvent) {
        new TelaDeCadastro();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Login = jt1.getText();
        Senha = jt2.getText();
        try {
            gravar();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        JOptionPane.showMessageDialog(null, Login+Senha);


    }
    public static void gravar() throws IOException {
        new Login(Login,Senha);

    }



}