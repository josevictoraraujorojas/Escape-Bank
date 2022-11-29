import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaInicial extends JFrame
{
    Image iconTitulo = new Icons().icon1();
    Icon avatar = new ImageIcon(new Icons().icon5());
    Icon menu = new ImageIcon(new Icons().icon6());
    Icon pix = new ImageIcon(new Icons().icon2());
    Icon emprestimo = new ImageIcon(new Icons().icon3());
    Icon credito = new ImageIcon(new Icons().icon4());

    Color cor1 = new LigthMode().cor1();
    Color cor2 = new LigthMode().cor2();
    Color cor4 = new LigthMode().cor4();
    Color cor5 = new LigthMode().cor5();
    JButton JB1,JB2,JB3,JB4,JB5,JB6;
    JLabel JL1,JL2,JL3, JL4,JL5,JL6;
    UserName userName = new UserName();
    SaldoUser saldoUser = new SaldoUser();
    int Y1 =300, Y2 =150;

    public TelaInicial(){

        setSize(800, 600);
        setIconImage(iconTitulo);
        setTitle("Scape Bank");
        getContentPane().setBackground(cor1);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        int Userlength = new UserName().User().length();
        Userlength = Userlength *20;
        int Saldolenght = (int) saldoUser.SaldoUsuario()*10;

        JL1 = new JLabel("olá, "+ userName.User());
        JL1.setFont(new Font("arial", Font.BOLD, 20));
        JL1.setForeground(cor2);
        JL1.setBounds(110, 20, Userlength, 30);
        JL1.setVisible(true);


        JL2 = new JLabel("saldo-> R$ "+new SaldoUser().SaldoUsuario());
        JL2.setFont(new Font("arial", Font.BOLD, 20));
        JL2.setForeground(cor5);
        JL2.setBounds(100, Y2 +6, 150+ Saldolenght, 30);
        JL2.setOpaque(false);
        JL2.setVisible(true);

        JL3 = new JLabel();
        JL3.setBounds(92, Y1 -30,600,200);
        JL3.setBackground(cor2);
        JL3.setOpaque(true);
        JL3.setVisible(true);

        JL4 = new JLabel();
        JL4.setBounds(92, Y2 -30,600,100);
        JL4.setBackground(cor4);
        JL4.setOpaque(true);
        JL4.setVisible(true);

        JL5 = new JLabel("menu");
        JL5.setFont(new Font("arial", Font.BOLD, 20));
        JL5.setForeground(cor2);
        JL5.setBounds(590, 20,60, 30);
        JL5.setVisible(true);

        JL6 =new JLabel();
        JL6.setBounds(500, 0,800,600);
        JL6.setBackground(Color.black);
        JL6.setOpaque(true);
        JL6.setVisible(true);


        JB1 = new JButton(" extrato -> ");
        JB1.setBorderPainted(false);
        JB1.setFocusPainted(false);
        JB1.setOpaque(false);
        JB1.setBounds(550, Y2 +5, 140, 30);
        JB1.setFont(new Font("arial", Font.BOLD, 20));
        JB1.setForeground(cor5);
        JB1.setBackground(cor4);

        JB2 = new JButton(pix);
        JB2.setBounds(93, Y1 +20, 100, 100);
        JB2.setBackground(cor2);
        JB2.setBorderPainted(false);
        JB2.setVisible(true);
        JB2.setOpaque(false);
        JB2.addActionListener(e -> {
            dispose();
            new AreaPix();
        });

        JB3 = new JButton(emprestimo);
        JB3.setBounds(343, Y1 +20, 100, 100);
        JB3.setBackground(cor2);
        JB3.setBorderPainted(false);
        JB3.setFocusPainted(false);
        JB3.setVisible(true);
        JB3.setOpaque(false);
        JB3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JB3.setBackground(cor1);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                JB3.setBackground(cor1);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                JB3.setBackground(cor1);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JB3.setBackground(cor1);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                JB3.setBackground(cor1);

            }
        });

        JB4 = new JButton(credito);
        JB4.setBounds(594, Y1 +20, 100, 100);
        JB4.setBackground(cor2);
        JB4.setBorderPainted(false);
        JB4.setVisible(true);
        JB4.setOpaque(false);

        JB5 = new JButton(avatar);
        JB5.setBounds(50,10,50,50);
        JB5.setBackground(cor2);
        JB5.setBorderPainted(false);
        JB5.setVisible(true);
        JB5.setOpaque(false);

        JB6 = new JButton(menu);
        JB6.setBounds(650,10,50,50);
        JB6.setFont(new Font("arial", Font.BOLD, 20));
        JB6.setForeground(cor2);
        JB6.setBackground(cor2);
        JB6.setOpaque(false);
        JB6.setBorderPainted(false);
        JB6.setFocusPainted(false);
        JB6.setVisible(true);
        JB6.addActionListener(e -> {

            dispose();
            new menu();

        });




         add(JB1);
         add(JB2);
         add(JB3);
         add(JB4);
         add(JB5);
         add(JB6);
         add(JL1);
         add(JL2);
         add(JL3);
         add(JL5);
         add(JL4);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        super.paint(g);

        g.setColor(cor2);
        g.fillArc(10, Y1,180,200,90,180);
        g.fillArc(610, Y1,180,200,270,180);

        g.setColor(cor4);
        g.fillArc(60, Y2,80,100,90,180);
        g.fillArc(660, Y2,80,100,270,180);

        g.dispose();
    }

    public static void main(String[] args) {
        new TelaInicial();
    }
}
class menu extends JFrame{
    Image iconTitulo = new Icons().icon1();
    Color cor1 = new LigthMode().cor1();
    Icon menu = new ImageIcon(new Icons().icon6());

    Color cor2 = new LigthMode().cor2();
    Color cor4 = new LigthMode().cor4();
    Color cor5 = new LigthMode().cor5();

JButton JB6;

    public menu(){
        setSize(300, 600);
        setIconImage(iconTitulo);
        setTitle("Scape Bank");
        getContentPane().setBackground(cor1);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JB6 = new JButton(menu);
        JB6.setBounds(10,10,50,50);
        JB6.setFont(new Font("arial", Font.BOLD, 20));
        JB6.setForeground(cor2);
        JB6.setBackground(cor2);
        JB6.setOpaque(false);
        JB6.setBorderPainted(false);
        JB6.setFocusPainted(false);
        JB6.setVisible(true);
        JB6.addActionListener(e -> {
            dispose();
            new TelaInicial();
        });
        add(JB6);

        setVisible(true);


    }

}
class AreaPix extends JFrame{

    Image iconTitulo = new Icons().icon1();
    Color cor1 = new LigthMode().cor1();
    Color cor2 = new LigthMode().cor2();
    Color cor4 = new LigthMode().cor4();
    Color cor5 = new LigthMode().cor5();
    Icon menu = new ImageIcon(new Icons().icon6());

String usuario, valor;
    JButton JB1,JB6;
    JTextField JT1,Jt2;
    public AreaPix(){
        setSize(800, 600);
        setIconImage(iconTitulo);
        setTitle("area pix");
        getContentPane().setBackground(cor1);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JB6 = new JButton(menu);
        JB6.setBounds(10,10,50,50);
        JB6.setFont(new Font("arial", Font.BOLD, 20));
        JB6.setForeground(cor2);
        JB6.setBackground(cor2);
        JB6.setOpaque(false);
        JB6.setBorderPainted(false);
        JB6.setFocusPainted(false);
        JB6.setVisible(true);
        JB6.addActionListener(e -> {
            dispose();
            new TelaInicial();
        });

        JT1 = new JTextField();
        JT1.setBounds(140, 266, 300, 30);
        JT1.setBackground(Color.MAGENTA);
        JT1.setForeground(Color.WHITE);
        JT1.setFont(new Font("Arial", Font.BOLD, 15));
        JT1.setVisible(true);

        Jt2 = new JTextField();
        Jt2.setBounds(140, 466, 300, 30);
        Jt2.setBackground(Color.MAGENTA);
        Jt2.setForeground(Color.WHITE);
        Jt2.setFont(new Font("Arial", Font.BOLD, 15));
        Jt2.setVisible(true);
        JB1 = new JButton("ok");
        JB1.setBounds(460, 500, 100, 40);
        JB1.setBackground(Color.MAGENTA);
        JB1.setFont(new Font("Arial", Font.BOLD, 20));
        JB1.setForeground(Color.WHITE);
        JB1.setVisible(true);
        JB1.addActionListener(e ->
        {
            UIManager.getDefaults().put("OptionPane.background",cor1);
            UIManager.put ("Panel.background", cor1);
            usuario = JT1.getText();
            valor = Jt2.getText();

/*            try
            { *//*preciso de que "new Cadastro().CadastroLoginESenha(Login,Senha);"
                estiver certo e gravou me retorne int 1; se der erro me retorne:
                JOptionPane.showMessageDialog(null, esse nome de usuario não e valido); seguido de return "2";
                JOptionPane.showMessageDialog(null,esse senha invalida, atente-se aos requisitos); seguido de return "3";*//*
                switch (mada){
                    case 1 ->{
                    }
                    case 2 -> JT1.setBackground(Color.red);
                    case 3 -> Jt2.setBackground(Color.red);
                }

            } catch (IOException a)
            {
                throw new RuntimeException(a);
            }*/
        });

        add(JB6);
        add(JT1);
        add(Jt2);
        add(JB1);
        setVisible(true);

    }

}