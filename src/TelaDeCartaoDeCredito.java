import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TelaDeCartaoDeCredito extends JFrame {
    Image iconTitulo = new Icons().icon1();
    ImageIcon cartaofrente = new ImageIcon(new Icons().icon7());
    ImageIcon cartaoverso = new ImageIcon(new Icons().icon8());
    Color cor1 = new PaletaDeCores().cor1();
    Color cor2 = new PaletaDeCores().cor2();
    Color cor3 = new PaletaDeCores().cor3();
    JLabel JL1,JL2,JL3, JL4,JL5,JL6,JL7,JL8;
    JButton JB3;
    public TelaDeCartaoDeCredito() throws FileNotFoundException {
        setSize(800, 600);
        setIconImage(iconTitulo);
        setTitle("Scape Bank");
        getContentPane().setBackground(cor1);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JL1 = new JLabel(cartaofrente);
        JL1.setBounds(200, 35, 350, 350);
        JL1.setBackground(cor1);
        JL1.setOpaque(false);
        JL1.setVisible(true);
        JL1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(JL1);
                remove(JL1);
                remove(JL3);
                remove(JL4);
                remove(JL5);
                JL6.setBounds(250,250,140,30);
                JL7.setVisible(true);
                add(JL7);
                add(JL8);
                add(JL2);

                atualizar();
                atualizar();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JL2 = new JLabel(cartaoverso);
        JL2.setBounds(200, 100, 350, 226);
        JL2.setBackground(cor1);
        JL2.setVisible(true);
        JL2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(JL2);
                remove(JL7);
                remove(JL8);
                JL6.setBounds(250, 100, 140, 30);

                add(JL6);
                add(JL5);
                add(JL3);
                add(JL4);
                add(JL1);


                atualizar();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JL3 = new JLabel(LerCartao.numeroDoCartao());
        JL3.setBounds(242, 227, 270, 30);
        JL3.setForeground(cor2);
        JL3.setFont(new Font("Arial", Font.BOLD, 21));
        JL3.setVisible(true);

        JL4 = new JLabel(LerCartao.nome());
        int a = LerCartao.nome().length();
        a = a*4;
        JL4.setBounds(290-a, 260, 130, 30);
        JL4.setForeground(cor2);
        JL4.setFont(new Font("Arial", Font.BOLD, 21));
        JL4.setVisible(true);

        JL5 = new JLabel(LerCartao.validadeCartao());
        JL5.setBounds(392, 260, 140, 30);
        JL5.setForeground(cor2);
        JL5.setFont(new Font("Arial", Font.BOLD, 21));
        JL5.setVisible(true);

        JL6 = new JLabel("Scape Card");
        JL6.setBounds(250, 100, 140, 30);
        JL6.setForeground(cor2);
        JL6.setFont(new Font("Arial", Font.BOLD, 21));
        JL6.setVisible(true);

        JL7 = new JLabel(LerCartao.numeroDaConta());
        JL7.setBounds(260, 218, 200, 30);
        JL7.setForeground(cor2);
        JL7.setFont(new Font("Arial", Font.BOLD, 21));
        JL7.setVisible(true);

        JL8 = new JLabel(LerCartao.codigoDeSeguranca());
        JL8.setBounds(493, 216, 200, 30);
        JL8.setForeground(cor2);
        JL8.setFont(new Font("Arial", Font.BOLD, 12));
        JL8.setVisible(true);

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


        add(JL6);
        add(JL5);
        add(JL3);
        add(JL4);
        add(JL1);
        add(JB3);

        setVisible(true);

    }

    public static void main(String[] args) {
        try {
            new TelaDeCartaoDeCredito();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void atualizar(){
        setSize(801,600);
        setSize(800,600);
        setVisible(true);
    }
}
