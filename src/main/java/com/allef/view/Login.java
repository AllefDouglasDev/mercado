package com.allef.view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.allef.controller.AuthController;
import com.allef.exception.AppException;
import com.allef.view.components.Button;
import com.allef.view.components.Colors;
import com.allef.view.components.Input;

public class Login extends JFrame {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    private JPanel mainPanel;
    private Input usernameField;
    private Input passwordField;

    public Login() {
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Colors.BACKGROUND.getColor());

        JLabel title = new JLabel();
        title.setText("ENTRAR");
        title.setBounds(0, 30, 400, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        mainPanel.add(title);

        usernameField = new Input("username", "Usuário");
        usernameField.setLocation(50, 70);
        usernameField.setWidth(300);
        mainPanel.add(usernameField.getContainer());
        usernameField.focus();

        passwordField = new Input("password", "Senha");
        passwordField.setLocation(50,  usernameField.getYEnd());
        passwordField.setWidth(299);
        passwordField.toPassword();
        mainPanel.add(passwordField.getContainer());

        Button loginBtn = new Button();
        loginBtn.setText("Entrar");
        loginBtn.setLocation(50, passwordField.getYEnd() + 20);
        loginBtn.addActionListener(onSubmit());
        mainPanel.add(loginBtn);

        getContentPane().add(mainPanel);

        this.getRootPane().setDefaultButton(loginBtn);
    }

    private boolean validateFields() {
        boolean ok = true;
        usernameField.removeError();
        passwordField.removeError();
        String username = usernameField.getValue();
        String password = passwordField.getValue();
        if (username.isBlank()) {
            usernameField.setError("Informa o usuário.");
            ok = false;
        }
        if (password.isBlank()) {
            passwordField.setError("Informa a senha.");
            ok = false;
        }
        return ok;
    }

    private ActionListener onSubmit() {
        return e -> {
            if (validateFields()) {
                String username = usernameField.getValue();
                String password = passwordField.getValue();
                authenticate(username, password);
            }
        };
    }

    private void authenticate(String aUsername, String aPassword) {
        try {
            AuthController authController = new AuthController();
            authController.login(aUsername, aPassword);
            dispose();
            new Home().setVisible(true);
        } catch (AppException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), e.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
