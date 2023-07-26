package org.example.configs.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:password.properties")
public class SpringConfig {

    @Bean
    public char[] getLowerCaseLetters() {
        return "abcdefghijklmnopqrstuvwxyz".toCharArray();
    }

    @Bean
    public char[] getUpperCaseLetters() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    @Bean
    public char[] getNumbers() {
        return "0123456789".toCharArray();
    }

    @Bean
    public char[] getSpecialSymbols() {
        return "!@#&()\"[{}]:;',?/*~$^+=<>".toCharArray();
    }
}
