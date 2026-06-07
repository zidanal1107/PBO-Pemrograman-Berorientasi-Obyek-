import javax.swing.*;

class MyFrame extends JFrame {

    JLabel label = new JLabel("Test");

    public MyFrame() {
        setSize(500, 300);
        label.setLayout(null);
        label.setBounds(10,10,10,10);
        add(label);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
    }
}

public class Main {
    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
        mf.setVisible(true);
    }
}