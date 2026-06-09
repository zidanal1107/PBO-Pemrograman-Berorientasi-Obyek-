import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class GUI extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    private JComboBox<String> typeCombo;
    private JComboBox<String> statusCombo;

    private JTextField nameField;
    private JTextField addressField;
    private JTextField floorField;
    private JTextField revenueField;
    private JTextField searchField;

    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;

    private TableRowSorter<DefaultTableModel> sorter;

    public GUI() {

        setTitle("Smart City Management System (GUI)");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initializeComponents();

        setVisible(true);
    }

    private void initializeComponents() {

        setLayout(new BorderLayout());

        //-----------------------------------
        // HEADER
        //-----------------------------------

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(230, 230, 230));

        JLabel titleLabel = new JLabel(
                "Selamat datang di Smart City System",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 28));

        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(20, 0, 20, 0));

        headerPanel.add(titleLabel);

        add(headerPanel, BorderLayout.NORTH);

        //-----------------------------------
        // TABLE
        //-----------------------------------

        String[] columns = {
                "Name",
                "Address",
                "Status",
                "Type",
                "Floors",
                "Monthly Revenue"
        };

        model = new DefaultTableModel(columns, 0);

        model.addRow(new Object[]{
                "RS Sehat",
                "disini",
                "ACTIVE",
                "Hospital",
                "10",
                "50000000"
        });

        model.addRow(new Object[]{
                "IndoMarket",
                "disana",
                "ACTIVE",
                "Market",
                "2",
                "25000000"
        });

        table = new JTable(model);
        table.setRowHeight(25);

        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        JScrollPane tableScrollPane =
                new JScrollPane(table);

        //-----------------------------------
        // FORM PANEL
        //-----------------------------------

        JPanel formPanel = new JPanel();
        formPanel.setPreferredSize(
                new Dimension(350, 0));

        formPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20));

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc =
                new GridBagConstraints();

        formPanel.setLayout(gbl);

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        // SEARCH

        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(new JLabel("Search:"), gbc);

        gbc.gridx = 1;
        searchField = new JTextField();
        formPanel.add(searchField, gbc);

        row++;

        // TYPE

        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(new JLabel("Type:"), gbc);

        gbc.gridx = 1;
        typeCombo = new JComboBox<>(
                new String[]{
                        "Market",
                        "Hospital"
                });

        formPanel.add(typeCombo, gbc);

        row++;

        // NAME

        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField();
        formPanel.add(nameField, gbc);

        row++;

        // ADDRESS

        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        addressField = new JTextField();
        formPanel.add(addressField, gbc);

        row++;

        // FLOORS

        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(new JLabel("Floors:"), gbc);

        gbc.gridx = 1;
        floorField = new JTextField();
        formPanel.add(floorField, gbc);

        row++;

        // STATUS

        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;

        statusCombo = new JComboBox<>(
                new String[]{
                        "ACTIVE",
                        "INACTIVE",
                        "UNDER CONSTRUCTION"
                });

        formPanel.add(statusCombo, gbc);

        row++;

        // REVENUE

        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(
                new JLabel("Monthly Revenue:"),
                gbc);

        gbc.gridx = 1;

        revenueField = new JTextField();

        formPanel.add(
                revenueField,
                gbc);

        row++;

        //-----------------------------------
        // BUTTON PANEL
        //-----------------------------------

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT));

        addButton =
                new JButton("Add Building");

        updateButton =
                new JButton("Update");

        deleteButton =
                new JButton("Delete");

        addButton.setBackground(
                new Color(76, 175, 80));

        updateButton.setBackground(
                new Color(255, 193, 7));

        deleteButton.setBackground(
                new Color(244, 67, 54));

        addButton.setForeground(Color.WHITE);
        updateButton.setForeground(Color.WHITE);
        deleteButton.setForeground(Color.WHITE);

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;

        formPanel.add(buttonPanel, gbc);

        //-----------------------------------
        // SPLIT PANE
        //-----------------------------------

        JSplitPane splitPane =
                new JSplitPane(
                        JSplitPane.HORIZONTAL_SPLIT,
                        tableScrollPane,
                        formPanel
                );

        splitPane.setDividerLocation(800);

        add(splitPane, BorderLayout.CENTER);

        //-----------------------------------
        // EVENTS
        //-----------------------------------

        addButton.addActionListener(e -> addBuilding());

        updateButton.addActionListener(
                e -> updateBuilding());

        deleteButton.addActionListener(
                e -> deleteBuilding());

        table.getSelectionModel()
                .addListSelectionListener(
                        e -> loadSelectedRow());

        searchField.getDocument()
                .addDocumentListener(
                        new DocumentListener() {

                            public void insertUpdate(
                                    DocumentEvent e) {
                                search();
                            }

                            public void removeUpdate(
                                    DocumentEvent e) {
                                search();
                            }

                            public void changedUpdate(
                                    DocumentEvent e) {
                                search();
                            }
                        });
    }

    //-----------------------------------
    // CREATE
    //-----------------------------------

    private void addBuilding() {

        if (nameField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Name tidak boleh kosong!"
            );

            return;
        }

        model.addRow(new Object[]{
                nameField.getText(),
                addressField.getText(),
                statusCombo.getSelectedItem(),
                typeCombo.getSelectedItem(),
                floorField.getText(),
                revenueField.getText()
        });

        clearForm();
    }

    //-----------------------------------
    // UPDATE
    //-----------------------------------

    private void updateBuilding() {

        int row = table.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Pilih data terlebih dahulu!"
            );

            return;
        }

        int modelRow =
                table.convertRowIndexToModel(row);

        model.setValueAt(
                nameField.getText(),
                modelRow,
                0);

        model.setValueAt(
                addressField.getText(),
                modelRow,
                1);

        model.setValueAt(
                statusCombo.getSelectedItem(),
                modelRow,
                2);

        model.setValueAt(
                typeCombo.getSelectedItem(),
                modelRow,
                3);

        model.setValueAt(
                floorField.getText(),
                modelRow,
                4);

        model.setValueAt(
                revenueField.getText(),
                modelRow,
                5);

        JOptionPane.showMessageDialog(
                this,
                "Data berhasil diupdate!"
        );
    }

    //-----------------------------------
    // DELETE
    //-----------------------------------

    private void deleteBuilding() {

        int row = table.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Pilih data terlebih dahulu!"
            );

            return;
        }

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Yakin ingin menghapus data?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION
                );

        if (confirm ==
                JOptionPane.YES_OPTION) {

            model.removeRow(
                    table.convertRowIndexToModel(row));

            clearForm();
        }
    }

    //-----------------------------------
    // READ
    //-----------------------------------

    private void loadSelectedRow() {

        int row = table.getSelectedRow();

        if (row == -1)
            return;

        int modelRow =
                table.convertRowIndexToModel(row);

        nameField.setText(
                model.getValueAt(modelRow, 0).toString());

        addressField.setText(
                model.getValueAt(modelRow, 1).toString());

        statusCombo.setSelectedItem(
                model.getValueAt(modelRow, 2));

        typeCombo.setSelectedItem(
                model.getValueAt(modelRow, 3));

        floorField.setText(
                model.getValueAt(modelRow, 4).toString());

        revenueField.setText(
                model.getValueAt(modelRow, 5).toString());
    }

    //-----------------------------------
    // SEARCH
    //-----------------------------------

    private void search() {

        String text =
                searchField.getText().trim();

        if (text.isEmpty()) {

            sorter.setRowFilter(null);

        } else {

            sorter.setRowFilter(
                    RowFilter.regexFilter(
                            "(?i)" + text));
        }
    }

    //-----------------------------------
    // CLEAR
    //-----------------------------------

    private void clearForm() {

        nameField.setText("");
        addressField.setText("");
        floorField.setText("");
        revenueField.setText("");

        typeCombo.setSelectedIndex(0);
        statusCombo.setSelectedIndex(0);

        table.clearSelection();
    }
}