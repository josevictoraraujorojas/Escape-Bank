import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

public class TelaDeCartaoDeCredito extends JFrame {
    Image iconTitulo = new Icons().icon1();
    Icon cartaofrente = new ImageIcon(new Icons().icon7());
    Icon cartaoverso = new ImageIcon(new Icons().icon8());


    Color cor1 = new PaletaDeCores().cor1();
    Color cor2 = new PaletaDeCores().cor2();
    Color cor4 = new PaletaDeCores().cor4();
    Color cor5 = new PaletaDeCores().cor5();
    JButton JB1,JB2,JB3,JB4,JB5,JB6;
    JLabel JL1,JL2,JL3, JL4,JL5,JL6;
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
                add(JL2);
                aatualiza();
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
                add(JL3);
                add(JL1);

                aatualiza();
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
        JL3.setForeground(new Color(2, 67, 93));
        JL3.setFont(new Font("Arial", Font.BOLD, 21));
        JL3.setVisible(true);

        JL4 = new JLabel(LerCartao.nome());
        JL4.setBounds(242, 260, 140, 30);
        JL4.setForeground(new Color(2, 67, 93));
        JL4.setFont(new Font("Arial", Font.BOLD, 21));
        JL4.setVisible(true);

        add(JL3);
        add(JL4);
        add(JL1);

        setVisible(true);

    }

    public static void main(String[] args) {
        try {
            new TelaDeCartaoDeCredito();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void aatualiza(){
        setSize(801,600);
        setSize(800,600);
        setVisible(true);
    }
}
