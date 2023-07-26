package org.example;

import org.example.configs.spring.SpringConfig;
import org.example.model.passwordGenerator.PasswordGenerator;
import org.example.configs.passwordConfig.builder.PasswordConfigBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAppRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.getBean("passwordConfigBuilder", PasswordConfigBuilder.class)
                .setLowerCaseLetters(true)
                .setNumbers(true)
                .setUpperCaseLetters(true)
                .setSpecialSymbol(true)
                .setPassLength(15)
                .build();

        PasswordGenerator passwordGenerator = context.getBean("passwordGenerator", PasswordGenerator.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(passwordGenerator.createPassword());
        }
    }
}