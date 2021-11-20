package com.pb.tkachenkoya.hw8;

public class Auth {
    String login;
    String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    boolean signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        while (true) {

            if (login.length() < 5 || login.length() > 20 || login.matches("[/W]") || login.equals((""))) {
                throw new WrongLoginException("Логин не соответствует требованиям");
            } else if (password.length() < 5 || password.contains("[/W]") || password.equals((""))) {
                throw new WrongPasswordException("Пароль не соответствует требованиям");
            } else if (password.equals(confirmPassword)) {
                System.out.println("Учетная запись успешно создана, пожалуйста, войдите на сайт");
                setLogin(login);
                setPassword(password);
                return true;
            } else System.out.println("Пароли не совпадают");
                return false;
        }
    }


    void signIn(String login, String password, String tempLogin,String tempPassword) throws WrongLoginException {

        if (tempLogin.equals(login) && tempPassword.equals(password)){
            System.out.println("Вход успешно выполнен");
            }else throw new WrongLoginException("Не верный логин и/или пароль");
    }

    class WrongLoginException extends Exception {
        public WrongLoginException() {
        }

        public WrongLoginException(String getMessage) {
            System.out.println(getMessage);
        }
    }

    class WrongPasswordException extends Exception {
        public WrongPasswordException() {
        }

        public WrongPasswordException(String getMessage) {
            System.out.println(getMessage);
        }
    }
}