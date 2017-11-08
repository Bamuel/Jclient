import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Jclient {
    private JButton btn1;
    private JPanel panelMain;
    private JButton btn2;
    private JTextField tfield1;
    private JButton btn3;
    clientconcc SERVERCONC = new clientconcc();
    public Jclient() {
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, SERVERCONC.connect("INT"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, SERVERCONC.connect("MESSAGE"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    JOptionPane.showMessageDialog(null, SERVERCONC.connect(tfield1.getText()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("JCLIENT by SAMUEL");
        jFrame.setContentPane(new Jclient().panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
