package com.allef.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.allef.view.components.Button;

public class Home extends JFrame {
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;

    private JPanel mainPanel;

    public Home() {
		setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, WIDTH, HEIGHT);

        getContentPane().add(mainPanel);
        mainPanel.setLayout(new BorderLayout(0, 0));
        
        JPanel headerPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) headerPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        Button createProductBtn = new Button();
        createProductBtn.setText("Criar Produto");
        headerPanel.add(createProductBtn);
    }
    
}
