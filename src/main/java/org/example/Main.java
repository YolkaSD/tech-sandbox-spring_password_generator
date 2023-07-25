package org.example;
import org.example.model.passwordGenerator.PasswordGenerator;
import org.example.configs.passwordConfig.builder.PasswordConfigBuilder;
import org.example.configs.springconfig.PasswordGeneratorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PasswordGeneratorConfig.class);
        context.getBean("passwordConfigBuilder", PasswordConfigBuilder.class)
                .setLowerCaseLetters(true)
                .setNumbers(true)
                .setUpperCaseLetters(true)
                .setSpecialSymbol(true)
                .setPassLength(20)
                .build();


        PasswordGenerator passwordGenerator = context.getBean("passwordGenerator", PasswordGenerator.class);
        for (int i = 0; i < 100; i++) {
            System.out.println(passwordGenerator.createPassword());
        }
    }
}