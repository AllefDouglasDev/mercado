package com.allef.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.allef.view.components.Button;
import com.allef.view.components.Input;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;

public class Playground extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Playground frame = new Playground();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Playground() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button defaultButton = new Button();
		defaultButton.setText("New button");
		defaultButton.setFocusPainted(false);
		defaultButton.setOpaque(true);
		defaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		defaultButton.setBorderPainted(false);
		defaultButton.setBorder(null);
		defaultButton.setBackground(new Color(204, 51, 51));
		defaultButton.setForeground(Color.WHITE);
		defaultButton.setBounds(19, 21, 200, 40);
		contentPane.add(defaultButton);
		
		Input input = new Input("new-field", "Input field");
		input.setLocation(19, 70);
		input.setError("Required.");
		input.removeError();
		contentPane.add(input.getContainer());
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(91, 172, 191, 16);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(29, 197, 343, 26);
		contentPane.add(passwordField);
		
		JPanel inputContainer = new JPanel();
		inputContainer.setBounds(29, 281, 300, 70);
		contentPane.add(inputContainer);
		inputContainer.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 20, 300, 30);
		inputContainer.add(textField);
		textField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(206, 206, 206)));
		textField.setColumns(10);
		
		JLabel fieldLabel = new JLabel("New label");
		fieldLabel.setForeground(Color.DARK_GRAY);
		fieldLabel.setBounds(0, 0, 61, 16);
		inputContainer.add(fieldLabel);
		
		JLabel fieldError = new JLabel("New label");
		fieldError.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		fieldError.setForeground(Color.RED);
		fieldError.setBounds(0, 52, 61, 16);
		inputContainer.add(fieldError);
		
		
//		Input input = new Input("Usuário");
//        input.setLocation(100, 270);
//        contentPane.add(input.getContainer());
	}
}
