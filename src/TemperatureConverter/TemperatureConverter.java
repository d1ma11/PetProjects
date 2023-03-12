package TemperatureConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

public class TemperatureConverter extends javax.swing.JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JCheckBox jCheckBox;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JLabel jLabel;
    private JPanel jPanel;
    private JSpinner jSpinner;
    private JTextField jTextField1;
    private JTextField jTextField2;

    public TemperatureConverter() {
        initComponents();
    }

    private void initComponents() {
        jCheckBox = new JCheckBox();
        jSpinner = new JSpinner();
        jPanel = new JPanel();
        jLabel = new JLabel();
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        jCheckBox.setText("jCheckBox");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Temperature Converter");

        jPanel.setBackground(new Color(51, 51, 51));

        jLabel.setBackground(new Color(255,255,255));
        jLabel.setFont(new Font("Segue UI", Font.BOLD, 14));
        jLabel.setForeground(new Color(255,255,255));
        jLabel.setText("Temperature Converter");

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);

        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(142,142,142)
                                .addComponent(jLabel)
                                .addContainerGap(161, Short.MAX_VALUE))
        );

        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(19,19,19)
                                .addComponent(jLabel)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] {"Celsius", "Fahrenheit"}));
        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] {"Celsius", "Fahrenheit"}));

        jTextField2.setEditable(false);

        jButton1.setFont(new Font("Segue UI", Font.BOLD | Font.ITALIC, 14));
        jButton1.setText("Convert");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed();
            }
        });

        jButton2.setFont(new Font("Segue UI", Font.BOLD | Font.ITALIC, 14));
        jButton2.setText("Clear");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed();
            }
        });

        jButton3.setFont(new Font("Segue UI", Font.BOLD | Font.ITALIC, 14));
        jButton3.setText("Exit");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton3ActionPerformed();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, 0, 116, Short.MAX_VALUE))
                                .addGap(133, 133, 133)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton3)
                                        .addComponent(jButton2))
                                .addGap(29, 29, 29))
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(37, 37, 37))
        );

        pack();
    }

    private void jButton3ActionPerformed() {
        System.exit(0);
    }

    private void jButton2ActionPerformed() {
        jTextField1.setText("");
        jTextField2.setText("");
    }

    private void jButton1ActionPerformed() {
        String value1 = (String) jComboBox1.getSelectedItem();
        String value2 = (String) jComboBox2.getSelectedItem();

        if (value1.equals("Celsius") && value2.equals("Fahrenheit")) {
            double celsius = Double.parseDouble(jTextField1.getText());
            double fahrenheit = (9.0/5.0)*celsius + 32;

            jTextField2.setText(String.valueOf(fahrenheit));

        } else if (value1.equals("Celsius") && value2.equals("Celsius")) {
            double celsius = Double.parseDouble(jTextField1.getText());

            jTextField2.setText(String.valueOf(celsius));

        } if (value1.equals("Fahrenheit") && value2.equals("Celsius")) {
            double fahrenheit = Double.parseDouble(jTextField1.getText());
            double celsius = (fahrenheit - 32)*(5.0/9.0);

            jTextField2.setText(String.valueOf(Math.round(celsius)));

        } else if (value1.equals("Fahrenheit") && value2.equals("Fahrenheit")) {
            double fahrenheit = Double.parseDouble(jTextField1.getText());

            jTextField2.setText(String.valueOf(Math.round(fahrenheit)));
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            java.util.logging.Logger.getLogger(TemperatureConverter.class.getName()).log(Level.SEVERE, null, e);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverter().setVisible(true);
            }
        });
    }
}
