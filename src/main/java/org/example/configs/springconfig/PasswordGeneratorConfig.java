package org.example.model.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:password.properties")
public class PasswordGeneratorConfig {
}
