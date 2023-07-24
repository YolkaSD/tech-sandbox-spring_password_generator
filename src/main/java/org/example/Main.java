package org.example;

import org.example.model.passwordGenerator.PasswordGenerator;
import org.example.model.passwordGenerator.password.Password;
import org.example.model.passwordGenerator.password.builder.PasswordBuilder;
import org.example.model.springconfig.PasswordGeneratorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PasswordGeneratorConfig.class);
        Password password = context.getBean("passwordBuilder", PasswordBuilder.class)
                .setLowerCaseLetters(true)
                .setNumbers(true)
                .setUpperCaseLetters(true)
                .setSpecialSymbol(true)
                .setPassLength(20)
                .build();

        PasswordGenerator passwordGenerator = context.getBean("passwordGenerator", PasswordGenerator.class);

        System.out.println(password.getPasswordProperties());
        System.out.println(password.getPassword());

        System.out.println(passwordGenerator.createPassword());

    }
}