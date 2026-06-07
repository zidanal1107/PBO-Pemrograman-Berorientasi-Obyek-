import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CyberpunkGUI extends JFrame {

    // Definisikan Palet Warna Cyberpunk
    private final Color COLOR_BG = new Color(10, 10, 15);          // Hitam Pekat/Biru Gelap
    private final Color COLOR_PANEL = new Color(20, 20, 30);       // Abu-abu Gelap kebiruan
    private final Color COLOR_CYAN = new Color(0, 243, 255);       // Neon Cyan (Primary Accent)
    private final Color COLOR_PINK = new Color(255, 0, 127);       // Neon Pink/Magenta
    private final Color COLOR_TEXT = new Color(240, 240, 245);     // Putih Terang

    public CyberpunkGUI() {
        // --- 1. Pengaturan Utama Window ---
        setTitle("Tugas");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // --- 2. Panel Utama (Background) ---
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- 3. Header Panel (Judul Aplikasi) ---
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        headerPanel.setBackground(COLOR_BG);

        JLabel titleLabel = new JLabel("CYBER_SYSTEM v1.0", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 24));
        titleLabel.setForeground(COLOR_CYAN);

        JLabel subTitleLabel = new JLabel("--- ACCESS GRANTED ---", SwingConstants.CENTER);
        subTitleLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        subTitleLabel.setForeground(COLOR_PINK);

        headerPanel.add(titleLabel);
        headerPanel.add(subTitleLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // --- 4. Center Panel (Tempat Identitas Nama & NIM) ---
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(COLOR_PANEL);
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_CYAN, 2, true), // Border Neon Cyan
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Font Style
        Font labelFont = new Font("Consolas", Font.BOLD, 14);
        Font fieldFont = new Font("Courier New", Font.BOLD, 16);

        // Komponen Nama
        JLabel nameLabel = new JLabel(">> OPERATOR NAME:");
        nameLabel.setForeground(COLOR_PINK);
        nameLabel.setFont(labelFont);

        JTextField nameField = new JTextField("Muhammad Zidan Al-Ghifari"); // Silakan ubah dengan nama Anda
        nameField.setEditable(false);
        nameField.setBackground(COLOR_BG);
        nameField.setForeground(COLOR_TEXT);
        nameField.setCaretColor(COLOR_CYAN);
        nameField.setFont(fieldFont);
        nameField.setBorder(new LineBorder(COLOR_PINK, 1));

        // Komponen NIM
        JLabel nimLabel = new JLabel(">> OPERATOR ID (NIM):");
        nimLabel.setForeground(COLOR_PINK);
        nimLabel.setFont(labelFont);

        JTextField nimField = new JTextField("202510370110249");   // Silakan ubah dengan NIM Anda
        nimField.setEditable(false);
        nimField.setBackground(COLOR_BG);
        nimField.setForeground(COLOR_TEXT);
        nimField.setCaretColor(COLOR_CYAN);
        nimField.setFont(fieldFont);
        nimField.setBorder(new LineBorder(COLOR_PINK, 1));

        // Masukkan ke Center Panel
        centerPanel.add(nameLabel);
        centerPanel.add(nameField);
        centerPanel.add(nimLabel);
        centerPanel.add(nimField);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // --- 5. Footer Panel (Tombol Aksi Modern) ---
        JButton actionButton = new JButton("INITIALIZE SYSTEM");
        actionButton.setFont(new Font("Consolas", Font.BOLD, 16));
        actionButton.setBackground(COLOR_BG);
        actionButton.setForeground(COLOR_CYAN);
        actionButton.setFocusPainted(false);
        actionButton.setBorder(new LineBorder(COLOR_CYAN, 2));

        // Efek Interaksi Tombol saat diklik
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Welcome Back, Operator.\nConnection established safely.",
                        "SYSTEM NOTIFICATION",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        mainPanel.add(actionButton, BorderLayout.SOUTH);

        // Daftarkan main panel ke frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Jalankan GUI di Thread Event Dispatch
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CyberpunkGUI().setVisible(true);
            }
        });
    }
}