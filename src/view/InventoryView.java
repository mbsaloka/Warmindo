package view;

import controller.InventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class InventoryView extends JFrame {
    private InventoryController controller;
    private JTextField itemField;
    private JTextField jumlahField;
    private JPanel cards;

    public InventoryView(InventoryController controller) {
        this.controller = controller;
        setTitle("Warmindo Inventory");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        cards = new JPanel(new CardLayout());

        // HALAMAN UTAMA
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Warmindo Inventory");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton toInputItemButton = new JButton("Ke Halaman Input Item");
        JButton toListButton = new JButton("Ke Halaman Daftar Item");
        JButton toHapusButton = new JButton("Ke Halaman Hapus Item");

        toInputItemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        toListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        toHapusButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        toInputItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, "InputItem");
            }
        });

        toListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, "Daftar");
                updateListDisplay();
            }
        });

        toHapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, "Hapus");
                updateHapusDisplay();
            }
        });

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(toInputItemButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(toListButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(toHapusButton);

        // HALAMAN INPUT ITEM
        JPanel inputItemPanel = new JPanel();
        inputItemPanel.setLayout(new BoxLayout(inputItemPanel, BoxLayout.Y_AXIS));

        JLabel inputTitleLabel = new JLabel("Input Item");
        inputTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inputTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel itemLabel = new JLabel("Item:");
        itemField = new JTextField(15);
        itemField.setMaximumSize(new Dimension(200, 30));
        JLabel jumlahLabel = new JLabel("Jumlah:");
        jumlahField = new JTextField(5);
        jumlahField.setMaximumSize(new Dimension(100, 30));

        JButton tambahItemButton = new JButton("Tambah Item");
        JButton kurangiItemButton = new JButton("Kurangi Item");
        JButton backButtonInput = new JButton("Kembali");

        itemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemField.setAlignmentX(Component.CENTER_ALIGNMENT);
        jumlahLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jumlahField.setAlignmentX(Component.CENTER_ALIGNMENT);
        tambahItemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        kurangiItemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButtonInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        tambahItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = itemField.getText();
                String jumlah = jumlahField.getText();
                String result = controller.tambahItem(item, jumlah);
                updateDisplay(result);
                itemField.setText("");
                jumlahField.setText("");
            }
        });

        kurangiItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = itemField.getText();
                int jumlah = Integer.parseInt(jumlahField.getText());
                String result = controller.kurangiItem(item, jumlah);
                updateDisplay(result);
                itemField.setText("");
                jumlahField.setText("");
            }
        });

        backButtonInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, "Main");
            }
        });

        inputItemPanel.add(inputTitleLabel);
        inputItemPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputItemPanel.add(itemLabel);
        inputItemPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        inputItemPanel.add(itemField);
        inputItemPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        inputItemPanel.add(jumlahLabel);
        inputItemPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        inputItemPanel.add(jumlahField);
        inputItemPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        inputItemPanel.add(tambahItemButton);
        inputItemPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        inputItemPanel.add(kurangiItemButton);
        inputItemPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        inputItemPanel.add(backButtonInput);

        // HALAMAN DAFTAR
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JTextArea listDisplayArea = new JTextArea(10, 30);
        listDisplayArea.setEditable(false);
        JButton backButtonList = new JButton("Kembali");

        backButtonList.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButtonList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, "Main");
            }
        });

        listPanel.add(new JScrollPane(listDisplayArea));
        listPanel.add(backButtonList);

        // HALAMAN HAPUS ITEM
        JPanel hapusPanel = new JPanel();
        hapusPanel.setLayout(new BoxLayout(hapusPanel, BoxLayout.Y_AXIS));
        JButton backButtonHapus = new JButton("Kembali");

        backButtonHapus.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButtonHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, "Main");
            }
        });

        hapusPanel.add(backButtonHapus);

        cards.add(mainPanel, "Main");
        cards.add(inputItemPanel, "InputItem");
        cards.add(listPanel, "Daftar");
        cards.add(hapusPanel, "Hapus");

        add(cards);
    }

    private void updateDisplay(String text) {
        JOptionPane.showMessageDialog(this, text);
    }

    private void updateListDisplay() {
        String result = controller.tampilkanItem();
        JPanel listPanel = (JPanel) cards.getComponent(2);
        JTextArea listDisplayArea = (JTextArea) ((JScrollPane) listPanel.getComponent(0)).getViewport().getView();
        listDisplayArea.setText(result);
    }

    private void updateHapusDisplay() {
        JPanel hapusPanel = (JPanel) cards.getComponent(3);
        hapusPanel.removeAll();

        JLabel titleLabel = new JLabel("Hapus Item");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        hapusPanel.add(titleLabel);
        hapusPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        for (Map.Entry<String, Integer> entry : controller.getItemMap().entrySet()) {
            String item = entry.getKey();
            JButton itemButton = new JButton(item + " (jumlah: " + entry.getValue() + ")");
            itemButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            itemButton.setBackground(Color.RED);
            itemButton.setForeground(Color.WHITE);
            itemButton.setOpaque(true);

            itemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String result = controller.hapusItem(item);
                    updateHapusDisplay();
                    updateDisplay(result);
                }
            });
            hapusPanel.add(itemButton);
            hapusPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        JButton backButtonHapus = new JButton("Kembali");
        backButtonHapus.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButtonHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, "Main");
            }
        });

        hapusPanel.add(backButtonHapus);
        hapusPanel.revalidate();
        hapusPanel.repaint();
    }
}
