package com.allef.controller;

import com.allef.dao.UserDAO;
import com.allef.exception.AppException;
import com.allef.model.User;

public class AuthController {
    private UserDAO userDao;

    public AuthController() {
        this.userDao = new UserDAO();
    }

    public String login(String username, String password) throws AppException {
        User user = this.userDao.getByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new AppException("Erro ao autenticar", "Usuário ou senha inválido.");
        }
        return user.getUsername();
    }
}
