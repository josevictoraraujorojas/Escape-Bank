import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class HomeScreen extends JFrame
{
    Image iconTitulo = new Icons().icon1();
    Icon avatar = new ImageIcon(new Icons().icon5());
    Icon menu = new ImageIcon(new Icons().icon6());
    Icon pix = new ImageIcon(new Icons().icon2());
    Icon emprestimo = new ImageIcon(new Icons().icon3());
    Icon credito = new ImageIcon(new Icons().icon4());

    Color cor1 = new PaletaDeCores().cor1();
    Color cor2 = new PaletaDeCores().cor2();
    Color cor4 = new PaletaDeCores().cor4();
    Color cor5 = new PaletaDeCores().cor5();
    Color cor7 = new PaletaDeCores().cor7();
    Color cor8 = new PaletaDeCores().cor8();
    JButton JB1,JB2,JB3,JB4,JB5,JB6;
    JLabel JL1,JL2,JL3, JL4,JL5,JL6;
    UserName userName = new UserName();
    SaldoUser saldoUser = new SaldoUser();
    int Y1 =300, Y2 =150;

    public HomeScreen(){
        if (userName == null && avatar == null && pix == null && emprestimo == null){
            JOptionPane.showMessageDialog(null,"erro!!!\n sem internet\nverifique sua conexão com a internet");
        }

        setSize(800, 600);
        setIconImage(iconTitulo);
        setTitle("Scape Bank");
        getContentPane().setBackground(cor1);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
            }
        });





        int Userlength = new UserName().User().length();
        Userlength = Userlength *20;
        int Saldolenght = (int) saldoUser.SaldoUsuario()*110;

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
        JL3.setBounds(92, Y1 -30,602,200);
        JL3.setBackground(cor2);
        JL3.setOpaque(true);
        JL3.setVisible(true);

        JL4 = new JLabel();
        JL4.setBounds(92, Y2 -30,601,100);
        JL4.setBackground(cor4);
        JL4.setOpaque(true);
        JL4.setVisible(true);

        JL5 = new JLabel("sair");
        JL5.setFont(new Font("arial", Font.BOLD, 20));
        JL5.setForeground(cor2);
        JL5.setBounds(600, 20,60, 30);
        JL5.setVisible(true);

        JL6 =new JLabel();
        JL6.setBounds(500, 0,800,600);
        JL6.setBackground(cor5);
        JL6.setOpaque(true);
        JL6.setVisible(true);


        JB1 = new JButton(" extrato -> ");
        JB1.setBorderPainted(false);
        JB1.setFocusPainted(false);
        JB1.setBounds(550, Y2 +5, 140, 30);
        JB1.setFont(new Font("arial", Font.BOLD, 20));
        JB1.setForeground(cor5);
        JB1.setBackground(cor4);
        JB1.addActionListener(e -> {
            new AreaPix.TelaDeExtrato();
            dispose();
        });
        JB1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {JB1.setBackground(cor7);}

            @Override
            public void mouseExited(MouseEvent e) {
                JB1.setBackground(cor4);
            }
        });

        JB2 = new JButton(pix);
        JB2.setBounds(93, Y1 +20, 100, 100);
        JB2.setBackground(cor2);
        JB2.setBorderPainted(false);
        JB2.setVisible(true);
        JB2.addActionListener(e -> {
            dispose();
            new AreaPix();
        });
        JB2.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {JB2.setBackground(cor8);}

            @Override
            public void mouseExited(MouseEvent e) {
                                     JB2.setBackground(cor2);
                                 }
        });

        JB3 = new JButton(emprestimo);
        JB3.setBounds(343, Y1 +20, 100, 100);
        JB3.setBackground(cor2);
        JB3.setBorderPainted(false);
        JB3.setFocusPainted(false);
        JB3.setVisible(true);
        JB3.addActionListener(e -> {
            dispose();
            new AreaPix.TelaDeEmprestimo();

        });
        JB3.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {JB3.setBackground(cor8);}

            @Override
            public void mouseExited(MouseEvent e) {
                JB3.setBackground(cor2);
            }
        });

        JB4 = new JButton(credito);
        JB4.setBounds(594, Y1 +20, 100, 100);
        JB4.setBackground(cor2);
        JB4.setBorderPainted(false);
        JB4.setVisible(true);
        JB4.addActionListener(e -> {
            try {
                new TelaDeCartaoDeCredito();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        });
        JB4.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {JB4.setBackground(cor8);}

            @Override
            public void mouseExited(MouseEvent e) {
                JB4.setBackground(cor2);
            }
        });

        JB5 = new JButton(avatar);
        JB5.setBounds(50,10,50,50);
        JB5.setBackground(cor2);
        JB5.setBorderPainted(false);
        JB5.setVisible(true);
        JB5.setOpaque(false);

        JB6 = new JButton(menu);
        JB6.setBounds(650,10,50,50);
        JB6.setBackground(cor2);
        JB6.setBorderPainted(false);
        JB6.setVisible(true);
        JB6.setOpaque(false);
        JB6.addActionListener(e -> {
            dispose();
            Main.VerificarLogin(false);
            String[] args = new String[0];
            try {
                Main.main(args);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        JB6.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {JB6.setBackground(cor7);}

            @Override
            public void mouseExited(MouseEvent e) {
                JB6.setBackground(cor1);
            }
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

}
class AreaPix extends JFrame{

    Image iconTitulo = new Icons().icon1();
    Color cor1 = new PaletaDeCores().cor1();
    Color cor2 = new PaletaDeCores().cor2();
    Color cor3 = new PaletaDeCores().cor3();
    Color cor6 = new PaletaDeCores().cor6();
    Icon menu = new ImageIcon(new Icons().icon6());
String usuario, valor;
    JButton JB,JB1,JB2,JB3, JB4;
    JTextField JTF1, JtF2;
    JLabel JL1,JL2, JL3,Icon1, Icon2;
    public AreaPix(){
        setSize(800, 600);
        setIconImage(iconTitulo);
        setTitle("area pix");
        getContentPane().setBackground(cor1);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
            }
        });

        JB = new JButton("<- voltar");
        JB.setBounds(170, 500, 120, 40);
        JB.setBackground(cor2);
        JB.setFont(new Font("Arial", Font.BOLD, 20));
        JB.setForeground(cor3);
        JB.setVisible(true);
        JB.addActionListener(e ->
        {
            remove(JB2);
            add(JB1);
            remove(JtF2);
            remove(JL2);
            remove(JB);
            add(JB3);
            JtF2.setText("R$______.__");
            setSize(801,601);
            setSize(800,600);
        });

        JB1 = new JButton("ok");
        JB1.setBounds(460, 500, 100, 40);
        JB1.setBackground(cor2);
        JB1.setFont(new Font("Arial", Font.BOLD, 20));
        JB1.setForeground(cor3);
        JB1.setVisible(true);
        JB1.addActionListener(e ->
        {
            remove(JB3);
            add(JB);
            remove(JB1);
            add(JB2);
            add(JtF2);
            add(JL2);
            setSize(801,601);
            setSize(800,600);
        });
        JB2 = new JButton("ok");
        JB2.setBounds(460, 500, 100, 40);
        JB2.setBackground(cor2);
        JB2.setFont(new Font("Arial", Font.BOLD, 20));
        JB2.setForeground(cor3);
        JB2.setVisible(true);
        JB2.addActionListener(e ->
        {
            UIManager.getDefaults().put("OptionPane.background",cor1);
            UIManager.put ("Panel.background", cor1);
            usuario = JTF1.getText();
            valor = JtF2.getText();
            valor = valor.substring(2);
            try {
                if (Pix.fazerPix(usuario,valor)){
                    Notificacao.GravarNotificao(usuario, valor);
                    new HomeScreen();
                    dispose();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        JB3 = new JButton("<- voltar");
        JB3.setBounds(170, 500, 120, 40);
        JB3.setBackground(cor2);
        JB3.setFont(new Font("Arial", Font.BOLD, 20));
        JB3.setForeground(cor3);
        JB3.setVisible(true);
        JB3.addActionListener(e ->
        {
            new HomeScreen();
            dispose();
        });

        JB4 = new JButton(menu);
        JB4.setBounds(650,10,50,50);
        JB4.setFont(new Font("arial", Font.BOLD, 20));
        JB4.setForeground(cor2);
        JB4.setBackground(cor2);
        JB4.setOpaque(false);
        JB4.setBorderPainted(false);
        JB4.setFocusPainted(false);
        JB4.setVisible(true);
        JB4.addActionListener(e ->
        {
            dispose();
            new HomeScreen();
        });

        JTF1 = new JTextField("digite um nome de usuario");
        JTF1.setBounds(340, 300, 300, 30);
        JTF1.setBackground(cor2);
        JTF1.setForeground(cor3);
        JTF1.setFont(new Font("Arial", Font.BOLD, 15));
        JTF1.setVisible(true);
        JTF1.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e) {
                remove(JB2);
                add(JB1);
                remove(JtF2);
                remove(JL2);
                JtF2.setText("R$______.__");
                if (JTF1.getText().equals("digite um nome de usuario"))
                {
                    JTF1.setText("");
                }
                setSize(801,601);
                setSize(800,600);
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

        JtF2 = new JTextField("R$______.__");
        JtF2.setBounds(340, 400, 300, 30);
        JtF2.setBackground(cor2);
        JtF2.setForeground(cor3);
        JtF2.setFont(new Font("Arial", Font.BOLD, 15));
        JtF2.setVisible(true);
        JtF2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e) {
                if (JtF2.getText().equals("R$______.__"))
                {
                    JtF2.setBackground(cor2);
                    JtF2.setText("R$");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if (JtF2.getText().equals("R$")|| JtF2.getText().equals(""))
                {
                    JtF2.setBackground(cor6);
                    JtF2.setText("R$______.__");
                }

            }
        });

        JL1 = new JLabel("para quem voce quer enviar?");
        JL1.setBounds(100,300,230,30);
        JL1.setBackground(cor2);
        JL1.setForeground(cor2);
        JL1.setFont(new Font("Arial", Font.BOLD, 15));
        JL1.setVisible(true);


        JL2 = new JLabel("quantos R$ voce quer enviar?");
        JL2.setBounds(100,400,230,30);
        JL2.setBackground(cor2);
        JL2.setForeground(cor2);
        JL2.setFont(new Font("Arial", Font.BOLD, 15));
        JL2.setVisible(true);

        JL3 = new JLabel("menu");
        JL3.setFont(new Font("arial", Font.BOLD, 20));
        JL3.setForeground(cor2);
        JL3.setBounds(590, 20,60, 30);
        JL3.setVisible(true);

        Icon1 = new JLabel("$");
        Icon1.setBounds(280,11,300,250);
        Icon1.setFont(new Font("arial", Font.ITALIC, 200));
        Icon1.setForeground(cor2);
        Icon1.setVisible(true);

        Icon2 = new JLabel("pix!");
        Icon2.setBounds(400,160,60,50);
        Icon2.setFont(new Font("arial", Font.ITALIC, 20));
        Icon2.setForeground(cor2);
        Icon2.setVisible(true);

        add(JB1);
        add(JB3);
        add(JB4);
        add(JTF1);
        add(JL1);
        add(Icon1);
        add(Icon2);
        setVisible(true);
    }

public static class TelaDeEmprestimo extends JFrame{


    Image iconTitulo = new Icons().icon1();
    Color cor1 = new PaletaDeCores().cor1();
    Color cor2 = new PaletaDeCores().cor2();
    Color cor3 = new PaletaDeCores().cor3();
    Color cor6 = new PaletaDeCores().cor6();
    Icon menu = new ImageIcon(new Icons().icon6());

    Float valorDoEmprestimo;
    int parcelas;
    JButton JB1,JB2, JB3,JB4,JB5;
    JTextField JT1;
    JComboBox<String> JCB;

    JLabel JL1,JL2,JL3,JL4,JL5,JL6;
    public TelaDeEmprestimo() {
        setSize(800, 600);
        setIconImage(iconTitulo);
        setTitle("emprestimo");
        getContentPane().setBackground(cor1);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
            }
        });


        JB1 = new JButton("ok");
        JB1.setBounds(460, 500, 100, 40);
        JB1.setBackground(cor2);
        JB1.setFont(new Font("Arial", Font.BOLD, 20));
        JB1.setForeground(cor3);
        JB1.setVisible(true);
        JB1.addActionListener(e -> {

            remove(JB1);
            add(JB2);
            remove(JB3);
            add(JB4);
            atualiza();

            valorDoEmprestimo = Float.valueOf(JT1.getText().substring(2));
                    String[] s1;
                    try {
                        s1 = new Emprestimo().emprestimo(valorDoEmprestimo);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    int j = 0;
                    for (int i = 0; i < s1.length; i++)
                    {
                        j= i;
                    }
                    if (j==0){
                        s1[0]="não há parcelas disponíveis";
                    }

                    JCB = new JComboBox<>(s1);
                    JCB.setBounds(330, 250, 300, 30);
                    JCB.setBackground(cor2);
                    JCB.setForeground(cor1);
                    JCB.setFont(new Font("Arial", Font.BOLD, 15));
                    JCB.setVisible(true);
                    add(JCB);
                    add(JL2);
                    atualiza();
        }
        );

        JB2 = new JButton("ok");
        JB2.setBounds(460, 500, 100, 40);
        JB2.setBackground(cor2);
        JB2.setFont(new Font("Arial", Font.BOLD, 20));
        JB2.setForeground(cor3);
        JB2.setVisible(true);
        JB2.addActionListener(e -> {
            String a = Objects.requireNonNull((String) JCB.getSelectedItem()).substring(0,2);
            parcelas= Integer.parseInt(a.replaceAll("\\D",""));
            try {
               switch (new Emprestimo().processar(valorDoEmprestimo,parcelas,(String) JCB.getSelectedItem())){
                   case 1->{
                       dispose();
                       new HomeScreen();
                   }
                   case 2-> System.out.println("cancelado");
               }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        JB3 = new JButton("<- voltar");
        JB3.setBounds(170, 500, 120, 40);
        JB3.setBackground(cor2);
        JB3.setFont(new Font("Arial", Font.BOLD, 20));
        JB3.setForeground(cor3);
        JB3.setVisible(true);
        JB3.addActionListener(e ->
        {
            new HomeScreen();
            dispose();
        });

        JB4 = new JButton("<- voltar");
        JB4.setBounds(170, 500, 120, 40);
        JB4.setBackground(cor2);
        JB4.setFont(new Font("Arial", Font.BOLD, 20));
        JB4.setForeground(cor3);
        JB4.setVisible(true);
        JB4.addActionListener(e -> {
            JT1.setText("R$______.__");
            remove(JCB);
            add(JB1);
            remove(JB2);
            add(JB3);
            remove(JB4);
            remove(JL2);
            atualiza();
        });
        JB5 = new JButton(menu);
        JB5.setBounds(650,10,50,50);
        JB5.setFont(new Font("arial", Font.BOLD, 20));
        JB5.setForeground(cor2);
        JB5.setBackground(cor2);
        JB5.setOpaque(false);
        JB5.setBorderPainted(false);
        JB5.setFocusPainted(false);
        JB5.setVisible(true);
        JB5.addActionListener(e ->
        {
            dispose();
            new HomeScreen();
        });


        JT1 = new JTextField("R$______.__");
        JT1.setBounds(330, 100, 300, 30);
        JT1.setBackground(cor2);
        JT1.setForeground(cor3);
        JT1.setFont(new Font("Arial", Font.BOLD, 15));
        JT1.setVisible(true);
        JT1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (JT1.getText().equals("R$______.__")) {
                    JT1.setBackground(cor2);
                    JT1.setText("R$");
                }

                remove(JCB);
                add(JB1);
                remove(JB2);
                add(JB3);
                remove(JB4);
                remove(JL2);
                atualiza();
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (JT1.getText().equals("")||JT1.getText().equals("R$")) {
                    JT1.setBackground(cor6);
                    JT1.setText("R$______.__");
                }
            }
        });
        JL1 = new JLabel("digite o valor do emprestimo");
        JL1.setBounds(100, 100, 230, 30);
        JL1.setForeground(cor2);
        JL1.setFont(new Font("Arial", Font.BOLD, 15));
        JL1.setVisible(true);

        JL2 = new JLabel("parcelar em quantas vezes?");
        JL2.setBounds(100, 250, 230, 30);
        JL2.setForeground(cor2);
        JL2.setFont(new Font("Arial", Font.BOLD, 15));
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

        JL5 = new JLabel("$cape");
        JL5.setFont(new Font("arial", Font.BOLD, 30));
        JL5.setForeground(cor2);
        JL5.setBounds(250, 5, 100, 30);
        JL5.setVisible(true);

        JL6 = new JLabel("emprestimo");
        JL6.setFont(new Font("arial", Font.BOLD, 30));
        JL6.setForeground(cor2);
        JL6.setBounds(320, 25, 250, 30);
        JL6.setVisible(true);



        add(JB5);
        add(JT1);
        add(JB1);
        add(JB3);
        add(JL1);
        add(JL3);
        add(JL4);
        add(JL5);
        add(JL6);
        setVisible(true);
    }

    public void atualiza(){
        setSize(801,600);
        setSize(800,600);
        setVisible(true);
    }


}
static class TelaDeExtrato extends JFrame
{
    Image iconTitulo = new Icons().icon1();

    Color cor1 = new PaletaDeCores().cor1();
    Color cor2 = new PaletaDeCores().cor2();
    Color cor3 = new PaletaDeCores().cor3();

    Color cor7 = new PaletaDeCores().cor7();
    JButton JB1,JB3;
    JLabel JL1,JL2;
    JComboBox<String> JCB;
    static String palavra;

    public TelaDeExtrato()
    {
        setSize(1100, 600);
        setIconImage(iconTitulo);
        setTitle("Scape Bank");
        getContentPane().setBackground(cor1);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
            }
        });

        JL1 = new JLabel("$                       $xtrato                       $");
        JL1.setBounds(100, 100, 1000, 50);
        JL1.setForeground(cor2);
        JL1.setFont(new Font("Arial", Font.BOLD, 50));
        JL1.setVisible(true);String b = " ";
        String text =b.repeat(22) +"operacão"+b.repeat(23+24)+"destino"+b.repeat(24+23)+"transação"+b.repeat(23+25)+"valor"+b.repeat(25);

        JL2 = new JLabel(text);
        JL2.setBounds(50, 220, 1000, 30);
        JL2.setForeground(cor2);
        JL2.setBackground(cor7);
        JL2.setOpaque(true);
        JL2.setFont(new Font("Arial", Font.BOLD, 15));
        JL2.setVisible(true);

        try {
            JCB = new JComboBox<>(ProcessarVetor(SaldoEExtrato.mandarvetor()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JCB.setBounds(50, 250, 1000, 30);
        JCB.setBackground(cor2);
        JCB.setForeground(cor1);
        JCB.setFont(new Font("Arial", Font.BOLD, 15));
        JCB.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
               JCB.showPopup();
            }
        });
        JCB.setVisible(true);
        JB1 = new JButton("abrir->");
        JB1.setBounds(760, 500, 100, 40);
        JB1.setBackground(cor2);
        JB1.setFont(new Font("Arial", Font.BOLD, 20));
        JB1.setForeground(cor3);
        JB1.setVisible(true);
        JB1.addActionListener(e -> {
            String a = Objects.requireNonNull((String) JCB.getSelectedItem()).replace(" &nbsp;"," ").substring(46,77);
            a= a.replace(" ","");
            System.out.println(a);
            String usuario = String.valueOf(Cadastro.criptografia(String.valueOf(new SetPaths().GetPaths(new URIpadrao().URICacheUserName()))));
            try {
                Comprovante.chamarComprovante(usuario, a);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        JB3 = new JButton("<- voltar");
        JB3.setBounds(170, 500, 120, 40);
        JB3.setBackground(cor2);
        JB3.setFont(new Font("Arial", Font.BOLD, 20));
        JB3.setForeground(cor3);
        JB3.setVisible(true);
        JB3.addActionListener(e ->
        {
            new HomeScreen();
            dispose();
        });


        add(JL1);
        add(JL2);
        add(JB1);
        add(JB3);
        getContentPane().add(JCB);

        setVisible(true);

    }

    public static String[] ProcessarVetor(String[] vetor){

        String[] vetor2;




        for (int i = 0; i < vetor.length; i++) {
            vetor2 = vetor[i].split(", ");

            for (int j = 0; j < vetor2.length; j++) {
                vetor2[j] = "." + vetor2[j] + ".|";
                recursao(vetor2[j]);
                vetor2[j] = palavra;


            }
            String array = Arrays.toString(vetor2);
            vetor[i] = array;


        }
        StringBuilder concat = new StringBuilder();


        for (String s : vetor) {
            String a = s + "_";
            concat.append(a);
        }

        String arrumar = String.valueOf(concat);
        arrumar= arrumar.replace(", .","");
        arrumar= arrumar.replace("]","").replace("[","");
        arrumar= arrumar.replace(".","");
        arrumar= arrumar.replace("|","");
        arrumar= arrumar.replace(" "," &nbsp;");

        vetor=arrumar.split("_");

        for (int i = 0; i < vetor.length; i++) {
            vetor[i]="<html><font color=#ff0000  face=arial><i><b>"+vetor[i];

        }

        return vetor;
    }



    public static void recursao(String tratamento) {

        if (tratamento.length() < 33)
        {
            recursao(tratamento.replace(".", ". "));
        }
        else if (tratamento.length() > 33)
        {
            recursao(tratamento.replace(" |", "|"));
        } else {palavra = tratamento;}
    }
}}