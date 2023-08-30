package com.allef.view.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Input {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 70;

    private boolean hasError;
    private boolean isSecure;
    private JPanel container;
    private JLabel label;
    private JLabel error;
    private JTextField field;
    private JPasswordField passwordField;

    public Input(String labelText) {
        this.container = new JPanel();
        this.container.setSize(WIDTH, HEIGHT);
        this.container.setBackground(Colors.BACKGROUND.getColor());
        this.container.setLayout(null);

        this.label = new JLabel(labelText);
        this.label.setForeground(Color.DARK_GRAY);
        this.label.setBounds(0, 20, WIDTH, 16);
        this.container.add(this.label);

    	this.error = new JLabel();
    	this.error.setForeground(Color.RED);
		this.error.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		this.error.setBounds(0, 52, WIDTH, 16);
		this.container.add(this.error);
        this.hasError = false;

        this.setToText();

        this.getField().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                label.setLocation(0, 0); 
                label.setForeground(Colors.BLUE.getColor());
                getField().setBorder(getFocusedBorder());
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getValue().isEmpty()) {
                    label.setLocation(0, 20);
                }
                if (hasError) {
                    label.setForeground(Color.RED);
                    getField().setBorder(getErrorBorder());
                } else {
                    label.setForeground(Color.DARK_GRAY);
                    getField().setBorder(getDefaultBorder());
                }
            }
        });
    }
    
    public void focus() {
    	this.getField().grabFocus();
    }
    
    public void setToText() {
        this.field = new JTextField();
        this.field.setBounds(0, 20, WIDTH, 30);
		this.field.setText(this.getValue());
		this.field.setBorder(this.getDefaultBorder());
        this.field.setBackground(Colors.BACKGROUND.getColor());
        this.container.add(this.field, 1);

        this.isSecure = false;
		if (this.passwordField != null) {
			this.container.remove(this.passwordField);
			this.passwordField = null;
		}
    }
    
    public void setToPassword() {
    	this.passwordField = new JPasswordField();
        this.passwordField.setBounds(0, 20, WIDTH, 30);
		this.passwordField.setText(this.getValue());
		this.passwordField.setBorder(this.getDefaultBorder());
        this.field.setBackground(Colors.BACKGROUND.getColor());
        this.container.add(this.passwordField, 1);

    	this.isSecure = true;
		if (this.field != null) {
			this.container.remove(this.field);
			this.field = null;
		}
    }
    
    public void setError(String message) {
    	if (message.isEmpty()) {
    		this.removeError();
    	} else {
            this.hasError = true;
            this.label.setForeground(Color.RED);
			this.error.setText(message);
			this.getField().setBorder(this.getErrorBorder());
    	}
    }
    
    public void removeError() {
    	this.error.setText("");
        this.label.setForeground(Color.DARK_GRAY);
		this.getField().setBorder(this.getDefaultBorder());
        hasError = false;
    }

    public void setWidth(int width) {
		this.container.setSize(width, HEIGHT);    	
        this.getField().setSize(width, this.getField().getHeight());
    }

    public void setLocation(int x, int y) {
        this.container.setLocation(x, y);
    }

    public Component getContainer() {
        return this.container;
    }

    public String getValue() {
    	return this.isSecure 
    		? new String(this.passwordField.getPassword()) 
    		: this.field.getText();
    }

    public int getIntValue() {
        try {
            return Integer.parseInt(this.getValue());
        } catch (Exception e) {
            return -1;
        }
    }

    public int getWidth() {
        return this.container.getWidth();
    }

    public int getHeight() {
        return this.container.getHeight();
    }

    public int getX() {
        return this.container.getX();
    }

    public int getY() {
        return this.container.getY();
    }

    public int getXEnd() {
        return this.getX() + this.getWidth();
    }

    public int getYEnd() {
        return this.getY() + this.getHeight();
    }
    
    private EmptyBorder getDefaultBorder() {
		return new MatteBorder(0, 0, 2, 0, (Color) new Color(206, 206, 206));
    }

    private EmptyBorder getFocusedBorder() {
		return new MatteBorder(0, 0, 2, 0, Colors.BLUE.getColor());
    }

    private EmptyBorder getErrorBorder() {
		return new MatteBorder(0, 0, 1, 0, Color.RED);
    }

    private JTextField getField() {
    	return this.isSecure ? this.passwordField : this.field;
    }
}
