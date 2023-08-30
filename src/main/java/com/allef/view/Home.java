package com.allef.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.allef.view.components.Button;
import com.allef.view.product.CreateProduct;

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
        createProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateProduct().setVisible(true);
            }
        });
    }
    
}
