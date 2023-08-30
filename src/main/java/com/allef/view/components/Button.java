package com.allef.view.components;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;

public class Button extends JButton {
	private final int WIDTH = 200;
	private final int HEIGHT = 40;

	public Button() {
        super();
		setFocusPainted(false);
		setOpaque(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBorderPainted(false);
		setBorder(null);
		setBackground(new Color(204, 51, 51));
		setForeground(Color.WHITE);
		setBounds(19, 21, WIDTH, HEIGHT);
    }
    
	public void setWidth(int width) {
		setSize(width, HEIGHT);
	}
    
}
