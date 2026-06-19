import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private JTextField textDisplay;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Main() {
        setTitle("Kalkulator");
        setSize(280, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 2. PENYESUAIAN TEKS LAYAR: Ukuran font diperbesar menjadi 30
        textDisplay = new JTextField();
        textDisplay.setFont(new Font("Arial", Font.BOLD, 30));
        textDisplay.setHorizontalAlignment(JTextField.RIGHT);
        textDisplay.setEditable(false);
        textDisplay.setPreferredSize(new Dimension(280, 60)); // Memberi tinggi ekstra pada layar
        add(textDisplay, BorderLayout.NORTH);

        // Membuat panel untuk tombol-tombol
        JPanel panelTombol = new JPanel();
        // 3. PENYESUAIAN JARAK: Menambahkan margin di sekeliling tombol dan jarak antar tombol (10px)
        panelTombol.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelTombol.setLayout(new GridLayout(4, 4, 10, 10));

        String[] labelTombol = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        // Menambahkan tombol ke panel
        for (String label : labelTombol) {
            JButton tombol = new JButton(label);
            // 4. PENYESUAIAN TEKS TOMBOL: Font diperbesar menjadi 22
            tombol.setFont(new Font("Arial", Font.BOLD, 22));
            tombol.setFocusPainted(false); // Menghilangkan garis kotak saat tombol diklik agar lebih rapi
            tombol.addActionListener(this);
            panelTombol.add(tombol);
        }

        add(panelTombol, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String perintah = e.getActionCommand();

        if (perintah.charAt(0) >= '0' && perintah.charAt(0) <= '9') {
            textDisplay.setText(textDisplay.getText() + perintah);
        }
        else if (perintah.equals("C")) {
            textDisplay.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
        else if (perintah.equals("=")) {
            if (!textDisplay.getText().isEmpty()) {
                num2 = Double.parseDouble(textDisplay.getText());

                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textDisplay.setText("Error");
                            return;
                        }
                        break;
                }

                if (result % 1 == 0) {
                    textDisplay.setText(String.valueOf((int) result));
                } else {
                    textDisplay.setText(String.valueOf(result));
                }
            }
        }
        else {
            if (!textDisplay.getText().isEmpty()) {
                num1 = Double.parseDouble(textDisplay.getText());
                operator = perintah.charAt(0);
                textDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main kalkulator = new Main();
            kalkulator.setVisible(true);
        });
    }
}