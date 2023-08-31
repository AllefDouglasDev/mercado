package com.allef.view.components;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class Button extends JButton {
	private final int WIDTH = 300;
	private final int HEIGHT = 40;

	public Button() {
        super();
        init();
    }

	public Button(String text) {
        super(text);
        init();
    }

    private void init() {
		setFocusPainted(false);
		setOpaque(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBounds(19, 21, WIDTH, HEIGHT);
        toDefault();
    }
    
	public void setWidth(int width) {
		setSize(width, HEIGHT);
	}

    public void toDefault() {
		setBorder(null);
		setBorderPainted(false);
		setBackground(new Color(204, 51, 51));
		setForeground(Color.WHITE);
    }

    public void toOutlined() {
        setBorderPainted(true);
        setBorder(new MatteBorder(1, 1, 1, 1, Color.RED));
        setBackground(Color.WHITE);
        setForeground(Color.RED); 
    }

    public int getXEnd() {
        return this.getX() + this.getWidth();
    }

    public int getYEnd() {
        return this.getY() + this.getHeight();
    }
}
