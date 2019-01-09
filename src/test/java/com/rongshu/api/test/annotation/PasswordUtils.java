package com.rongshu.api.test.annotation;

public class PasswordUtils {
    @UseCase(id=47,description = "password must contain at least one numeric")
    public boolean validatePassword(String password){
        return (password.matches("//w*//d//w*"));
    }

}
