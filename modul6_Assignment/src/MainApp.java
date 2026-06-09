import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends JFrame {

    private BuildingManager manager = new BuildingManager();

    private JTable table;
    private DefaultTableModel model;

    private JTextField txtName, txtAddress, txtFloors, txtBeds, txtRevenue;
    private JComboBox<BuildingStatus> cbStatus;
    private JComboBox<String> cbType;
    private JPanel specialPanel;
    private JLabel lblSpecial;

    public MainApp() {
        setTitle("Smart City Management System");
        setSize(1000, 600); // Disesuaikan agar lebih proporsional
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        refreshTable();
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        // --------------------------------
        // HEADER
        // --------------------------------
        JLabel title = new JLabel("SMART CITY MANAGEMENT SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // --------------------------------
        // TABLE
        // --------------------------------
        String[] columns = {"Name", "Address", "Floors", "Status", "Type", "Detail"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // --------------------------------
        // FORM COMPONENTS
        // --------------------------------
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtName = new JTextField();
        txtAddress = new JTextField();
        txtFloors = new JTextField();
        cbStatus = new JComboBox<>(BuildingStatus.values());
        cbType = new JComboBox<>(new String[]{"Hospital", "Market"});
        txtBeds = new JTextField();
        txtRevenue = new JTextField();
        lblSpecial = new JLabel("Number Of Beds");

        // --------------------------------
        // SPECIAL PANEL (CardLayout)
        // --------------------------------
        specialPanel = new JPanel(new CardLayout());
        specialPanel.add(txtBeds, "Hospital");
        specialPanel.add(txtRevenue, "Market");

        // Event saat Tipe Bangunan diubah
        cbType.addActionListener(e -> {
            CardLayout cl = (CardLayout) specialPanel.getLayout();
            if (cbType.getSelectedItem().equals("Hospital")) {
                lblSpecial.setText("Number Of Beds");
                cl.show(specialPanel, "Hospital");
            } else {
                lblSpecial.setText("Monthly Revenue");
                cl.show(specialPanel, "Market");
            }
        });

        // Menambahkan komponen ke Form
        formPanel.add(new JLabel("Name:"));
        formPanel.add(txtName);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(txtAddress);
        formPanel.add(new JLabel("Floors:"));
        formPanel.add(txtFloors);
        formPanel.add(new JLabel("Status:"));
        formPanel.add(cbStatus);
        formPanel.add(new JLabel("Type:"));
        formPanel.add(cbType);
        formPanel.add(lblSpecial);
        formPanel.add(specialPanel);

        // --------------------------------
        // BUTTONS & EVENTS
        // --------------------------------
        JButton btnAdd = new JButton("Add Building");
        JButton btnDelete = new JButton("Delete Building");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);

        btnAdd.addActionListener(e -> addBuildingEvent());
        btnDelete.addActionListener(e -> deleteBuildingEvent());

        // --------------------------------
        // RIGHT PANEL
        // --------------------------------
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(350, 0));
        rightPanel.add(formPanel, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        // --------------------------------
        // SPLITPANE
        // --------------------------------
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, rightPanel);
        splitPane.setResizeWeight(0.7); // 70% area untuk tabel, 30% untuk form
        add(splitPane, BorderLayout.CENTER);
    }

    private void addBuildingEvent() {
        try {
            if (txtName.getText().trim().isEmpty() || txtAddress.getText().trim().isEmpty() || txtFloors.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String name = txtName.getText().trim();
            String address = txtAddress.getText().trim();
            int floors = Integer.parseInt(txtFloors.getText().trim());
            BuildingStatus status = (BuildingStatus) cbStatus.getSelectedItem();
            Building building;

            if (cbType.getSelectedItem().equals("Hospital")) {
                int beds = Integer.parseInt(txtBeds.getText().trim());
                building = new Hospital(name, address, floors, status, beds);
            } else {
                double revenue = Double.parseDouble(txtRevenue.getText().trim());
                building = new Market(name, address, floors, status, revenue);
            }

            manager.addBuilding(building);
            refreshTable();
            clearForm();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Floors, Beds or Revenue must be valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteBuildingEvent() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Building selected = manager.getBuildings().get(row);
        manager.removeBuilding(selected);
        refreshTable();
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (Building b : manager.getBuildings()) {
            model.addRow(new Object[]{
                    b.getName(),
                    b.getAddress(),
                    b.getFloors(),
                    b.getStatus(),
                    b.getType(),
                    b.getDetail()
            });
        }
    }

    private void clearForm() {
        txtName.setText("");
        txtAddress.setText("");
        txtFloors.setText("");
        txtBeds.setText("");
        txtRevenue.setText("");
        cbStatus.setSelectedIndex(0);
        cbType.setSelectedIndex(0);
        txtName.requestFocus();
    }

    public static void main(String[] args) {
        // Menggunakan Look and Feel bawaan OS agar UI lebih rapi
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(MainApp::new);
    }
}