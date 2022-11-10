import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class TelaDeCadastro extends JFrame{

    JButton jb1,jb2;
    JTextField jt1,jt2;
    JLabel jl1,jl2,jl3, jl4, jl5;
    Color cor = new Color(98, 0, 158);

    static  String Login = "";
    static String Senha = "";
    static Boolean B;



    public TelaDeCadastro(){


        //configurações do jframe//
        setUndecorated(true);

        setLayout(null);
        setTitle("tela de login");
        setSize(800, 600);
        getContentPane().setBackground(cor);
        setLocationRelativeTo(null);
        setVisible(true);

        //configuracão do jbotton//
        jb1 = new JButton("ok");
        jb1.setBounds(460, 500, 100, 40);
        jb1.setBackground(Color.MAGENTA);
        jb1.setFont(new Font("Arial", Font.BOLD, 20));
        jb1.setForeground(Color.WHITE);
        jb1.setVisible(true);
        jb1.addActionListener(this::acesscadastro);

        jb2 = new JButton("<- voltar");
        jb2.setBounds(170, 500, 120, 40);
        jb2.setBackground(Color.MAGENTA);
        jb2.setFont(new Font("Arial", Font.BOLD, 20));
        jb2.setForeground(Color.WHITE);
        jb2.setVisible(true);
        jb2.addActionListener(this::close);

        //configuraçao do Jtextfield//
        jt1 = new JTextField();
        jt1.setBounds(140, 145, 300, 30);//x=130 y= 4
        jt1.setBackground(Color.MAGENTA);
        jt1.setForeground(Color.WHITE);
        jt1.setFont(new Font("Arial", Font.BOLD, 15));
        jt1.setVisible(true);

        jt2 = new JTextField();
        jt2.setBounds(140, 266, 300, 30);
        jt2.setBackground(Color.MAGENTA);
        jt2.setForeground(Color.WHITE);
        jt2.setFont(new Font("Arial", Font.BOLD, 15));
        jt2.setVisible(true);

        //configurar jlabel//
        jl1 = new JLabel("usuario:");
        jl1.setFont(new Font("arial", Font.BOLD, 20));
        jl1.setForeground(Color.MAGENTA);
        jl1.setBounds(10, 144, 80, 30);
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

        jl4 = new JLabel("<html>seu usuario deve tconter:<br> - comecar com uma letra ou underline<br> - pode conter apenas letras, numeros e underline<br> - minimo de 8 letrar e maximo de 16<br> - nao pode conter carcterer especial<br> - nao pode conter espacos em branco</html>");
        jl4.setFont(new Font("arial", Font.BOLD, 10));
        jl4.setForeground(Color.MAGENTA);
        jl4.setBounds(10, 180, 450, 75);
        jl4.setVisible(true);

        jl5 = new JLabel("<html>sua senha deve conter:<br> -minimo de 8 digitos e maximo de 16 digitos<br> -deve incluir pelo menos um numero e 2 letras<br> -deve incluir pelo menos uma letra maiuscula e uma minuscula<br> -pode conter caracteres especiais<br> -nao pode conter numeros em sequencia<br> -não pode conter espaco em branco</html>");
        jl5.setFont(new Font("arial", Font.BOLD, 10));
        jl5.setForeground(Color.MAGENTA);
        jl5.setBounds(10,303 , 450, 90);
        jl5.setVisible(true);


        add(jl3);
        add(jl1);
        add(jt1);
        add(jl2);
        add(jt2);
        add(jb1);
        add(jb2);
        add(jb2);
        add(jl4);
        add(jl5);
     /*   setExtendedState(getState()| JFrame.MAXIMIZED_BOTH);
        setExtendedState(getState()| JFrame.NORMAL);*/





    }

    private void close(ActionEvent actionEvent) {
        dispose();
    }

    private void acesscadastro(ActionEvent actionEvent)
    {
        UIManager.getDefaults().put("OptionPane.background",cor);
        UIManager.put ("Panel.background", cor);
        Login = jt1.getText();
        Senha = jt2.getText();

        try
        {
            gravar();
            if (B)
            {
                dispose();
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void gravar() throws IOException
    {
        new Cadastro(Login,Senha);
    }
    public static void fechartela(Boolean b)
    {
        B=b;
    }
}