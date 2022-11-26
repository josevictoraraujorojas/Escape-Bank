import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {
    Image iconeTitulo = new Icons().icon1();
    Icon iconeoix = new ImageIcon(new Icons().icon2());
    Color cor1 = new LigthMode().cor1();
    Color cor2 = new LigthMode().cor2();
    Color cor3 = new LigthMode().cor3();
    JButton JB1,JB2,JB3,JB4;
    JLabel JL1,JL2,JL3, JL4,JL5;

    public TelaInicial(){
        setSize(800, 600);
        setTitle("Scape Bank");
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(cor1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(iconeTitulo);
        int p = new UserName().User().length();
        p=p*20;
        JL1 = new JLabel("olá, "+ new UserName().User());
        JL1.setFont(new Font("arial", Font.BOLD, 20));
        JL1.setForeground(cor2);
        JL1.setBounds(10, 10,p, 30);
        JL1.setVisible(true);

        int c = (int) new SaldoUser().SaldoUsuario()*10;
        JL2 = new JLabel("saldo-> R$ "+new SaldoUser().SaldoUsuario());
        JL2.setFont(new Font("arial", Font.BOLD, 20));
        JL2.setForeground(cor2);
        JL2.setBounds(10, 50, 150+c, 30);
        JL2.setVisible(true);

        JL3 = new JLabel();
        JL3.setBounds(0,130,800,200);
        JL3.setBackground(cor2);
        JL3.setOpaque(true);
        JL3.setVisible(true);

        JB1 = new JButton(" extrato -> ");
        JB1.setBorderPainted(false);
        JB1.setFocusPainted(false);
        JB1.setBounds(650, 10, 150, 30);
        JB1.setFont(new Font("arial", Font.BOLD, 20));
        JB1.setForeground(cor2);
        JB1.setBackground(cor1);


        JB2 = new JButton(iconeoix);
        JB2.setBounds(100, 180, 100, 100);
        JB2.setBackground(cor1);
        JB2.setVisible(true);

        JB3 = new JButton("empréstimo");
        JB3.setBounds(230, 180, 100, 100);
        JB3.setBackground(cor1);
        JB3.setFont(new Font("Arial", Font.BOLD, 20));
        JB3.setForeground(cor3);
        JB3.setOpaque(true);
        JB3.setVisible(true);

        JB4 = new JButton("<html> cartão<br>&nbsp;&nbsp; de <br> credito</html>");
        JB4.setBounds(350, 180, 100, 100);
        JB4.setBackground(cor1);
        JB4.setFont(new Font("Arial", Font.BOLD, 20));
        JB4.setForeground(cor3);
        JB4.setVisible(true);

        add(JL3);
        add(JL1);
        add(JL2);

        add(JB1);
        add(JB2);
        add(JB3);
        add(JB4);
        setVisible(true);
    }


        public static void main(String[] args) {
        new TelaInicial();
    }}

