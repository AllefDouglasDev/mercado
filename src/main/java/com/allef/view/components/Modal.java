package com.allef.view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Modal {
    private final int HEADER_HEIGHT = 70;
    private final int FOOTER_HEIGHT = 60;

    private JDialog dialog;
    private JPanel mainPanel;


    private int width = 660;
    private int height = 380;
    private String title;

    private Button confirmButton;
    private Button cancelButton;

    public Modal(String title) {
        this.title = title;
        init();
    }

    public Modal(String title, int width, int heigh) {
        this.width = width;
        this.height = heigh;
        this.title = title;
        init();
    }

    private void init() {
        dialog = new JDialog();
        dialog.setResizable(false);
        dialog.setLayout(null);
        dialog.setBackground(Colors.BACKGROUND.getColor());

        dialog.getContentPane().setLayout(null);
        dialog.getContentPane().setPreferredSize(new Dimension(width, height));

        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, width, HEADER_HEIGHT);
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(null);
        dialog.getContentPane().add(headerPanel);

        JLabel titleLabel = new JLabel(this.title);
        titleLabel.setForeground(Color.DARK_GRAY);
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        titleLabel.setBounds(20, HEADER_HEIGHT / 2 - 15, width - 40, 30);
        headerPanel.add(titleLabel);

        mainPanel = new JPanel();
        mainPanel.setBackground(Colors.BACKGROUND.getColor());
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, HEADER_HEIGHT, width, height - HEADER_HEIGHT - FOOTER_HEIGHT);
        dialog.getContentPane().add(mainPanel);

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setBounds(0, height - FOOTER_HEIGHT, width, FOOTER_HEIGHT);
        footerPanel.setLayout(null);
        dialog.getContentPane().add(footerPanel, BorderLayout.SOUTH);

        confirmButton = new Button("Confirmar");
        confirmButton.setWidth(100);
        confirmButton.setLocation(width - confirmButton.getWidth() - 10, 10);
        footerPanel.add(confirmButton);
        dialog.getRootPane().setDefaultButton(confirmButton);

        cancelButton = new Button("Cancelar");
        cancelButton.toOutlined();
        cancelButton.setWidth(100);
        cancelButton.setLocation(confirmButton.getX() - cancelButton.getWidth() - 10, 10);
        footerPanel.add(cancelButton);

        dialog.pack();
    }

    public void add(Component component) {
        mainPanel.add(component);
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public JDialog getDialog() {
        return dialog;
    }

    public void setVisible(boolean visible) {
        dialog.setVisible(visible);
    }

    public void dispose() {
        dialog.dispose();
    }

    public void setOnConfirmListener(ActionListener onConfirmListener) {
        confirmButton.addActionListener(onConfirmListener);
    }

    public void setOnCancelListener(ActionListener onCancelListener) {
        cancelButton.addActionListener(onCancelListener);
    }
}
