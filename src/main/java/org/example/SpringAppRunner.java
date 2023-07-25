package org.example;
import org.example.model.passwordGenerator.PasswordGenerator;
import org.example.configs.passwordConfig.builder.PasswordConfigBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:password.properties")
public class SpringAppRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAppRunner.class);
        context.getBean("passwordConfigBuilder", PasswordConfigBuilder.class)
                .setLowerCaseLetters(true)
                .setNumbers(true)
                .setUpperCaseLetters(true)
                .setSpecialSymbol(true)
                .setPassLength(1)
                .build();


        PasswordGenerator passwordGenerator = context.getBean("passwordGenerator", PasswordGenerator.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(passwordGenerator.createPassword());
        }
    }
}