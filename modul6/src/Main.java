import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {

    static int targetNumber;
    static Random random = new Random();

    public static void main(String[] args) {

        targetNumber = random.nextInt(100) + 1;

        JFrame frame = new JFrame("Game Tebak Angka");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();

        JLabel title = new JLabel(
                "<html><h1>GAME TEBAK ANGKA</h1></html>"
        );

        headerPanel.add(title);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(5, 1, 10, 10));
        contentPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        JLabel instruction = new JLabel(
                "Tebak angka dari 1 - 100",
                SwingConstants.CENTER
        );

        JTextField inputField = new JTextField();

        JButton guessButton = new JButton("Tebak");

        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setForeground(Color.RED);

        JButton replayButton = new JButton("Main Lagi");
        replayButton.setVisible(false);

        contentPanel.add(instruction);
        contentPanel.add(inputField);
        contentPanel.add(guessButton);
        contentPanel.add(resultLabel);
        contentPanel.add(replayButton);

        // EVENT TOMBOL TEBAK
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int guess = Integer.parseInt(
                            inputField.getText()
                    );

                    if (guess < 1 || guess > 100) {

                        JOptionPane.showMessageDialog(
                                frame,
                                "Masukkan angka 1 - 100!"
                        );

                        return;
                    }

                    if (guess > targetNumber) {

                        resultLabel.setForeground(Color.RED);

                        resultLabel.setText(
                                "<html><h2>Terlalu Tinggi!</h2></html>"
                        );

                    } else if (guess < targetNumber) {

                        resultLabel.setForeground(Color.ORANGE);

                        resultLabel.setText(
                                "<html><h2>Terlalu Rendah!</h2></html>"
                        );

                    } else {

                        resultLabel.setForeground(Color.GREEN);

                        resultLabel.setText(
                                "<html><h2>BENAR! Angkanya "
                                        + targetNumber
                                        + "</html>"
                        );

                        replayButton.setVisible(true);

                        guessButton.setEnabled(false);
                    }

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Masukkan angka yang valid!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // EVENT TOMBOL MAIN LAGI
        replayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                targetNumber = random.nextInt(100) + 1;

                inputField.setText("");

                resultLabel.setText("");

                resultLabel.setForeground(Color.RED);

                replayButton.setVisible(false);

                guessButton.setEnabled(true);

                inputField.requestFocus();

                System.out.println(
                        "Angka baru dibuat: " + targetNumber
                );
            }
        });

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}