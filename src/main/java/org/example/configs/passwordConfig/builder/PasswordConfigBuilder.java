package org.example.configs.passwordConfig.builder;
import org.example.configs.passwordConfig.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordConfigBuilder {
    @Autowired
    private PasswordConfig config;
    @Value("${passLength}")
    private int passLength;
    @Value("${lowerCaseLetters}")
    private boolean lowerCaseLetters;
    @Value("${upperCaseLetters}")
    private boolean upperCaseLetters;
    @Value("${numbers}")
    private boolean numbers;
    @Value("${specialSymbols}")
    private boolean specialSymbols;

    public PasswordConfigBuilder setPassLength(int passLength) {
        this.passLength = passLength;
        return this;
    }

    public PasswordConfigBuilder setLowerCaseLetters(boolean lowerCaseLetters) {
        this.lowerCaseLetters = lowerCaseLetters;
        return this;
    }

    public PasswordConfigBuilder setUpperCaseLetters(boolean upperCaseLetters) {
        this.upperCaseLetters = upperCaseLetters;
        return this;
    }

    public PasswordConfigBuilder setNumbers(boolean numbers) {
        this.numbers = numbers;
        return this;
    }

    public PasswordConfigBuilder setSpecialSymbol(boolean specialSymbol) {
        this.specialSymbols = specialSymbol;
        return this;
    }

    public void build() {
        config.setPassLength(passLength);
        config.setLowerCaseLetters(lowerCaseLetters);
        config.setUpperCaseLetters(upperCaseLetters);
        config.setNumbers(numbers);
        config.setSpecialSymbols(specialSymbols);
    }
}
