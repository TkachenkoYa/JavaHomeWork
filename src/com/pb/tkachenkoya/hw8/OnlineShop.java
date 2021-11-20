package com.pb.tkachenkoya.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) throws Auth.WrongLoginException {

        String tempLogin;
        String tempPassword;
        Auth user1 = new Auth();

        System.out.println("Для регистрации на сайте введите логин");
        System.out.println("(только латинские буквы и цифры, длина от 5 до 20 символов)");

        try(Scanner in = new Scanner(System.in)) {

            user1.login = in.nextLine();
            System.out.println("Введите пароль (не менее 5 символов, только латинские буквы и цифры)");
            user1.password = in.nextLine();
            System.out.println("Повторите пароль");
            String confirmPassword = in.nextLine();
            //user1.signUp(user1.login, user1.password, confirmPassword);
            if (user1.signUp(user1.login, user1.password, confirmPassword)==true){
                System.out.println("Для входа введите логин");
                tempLogin = in.nextLine();
                System.out.println("Введите пароль");
                tempPassword = in.nextLine();
                user1.signIn(user1.login,user1.password,tempLogin, tempPassword);
            }else System.out.println("Регистрация не успешна, повторите попытку");
        } catch (Auth.WrongLoginException ex) {
            ex.getMessage();
        } catch (Auth.WrongPasswordException e) {
            e.getMessage();
        }

    }
}