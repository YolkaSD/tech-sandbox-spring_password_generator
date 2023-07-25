package org.example.model.passwordGenerator.passwordConfig.builder;
import org.example.model.passwordGenerator.passwordConfig.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordConfigBuilder {
    @Autowired
    private PasswordConfig password;
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

    public PasswordConfig build() {
        password.setPassLength(passLength);
        password.setLowerCaseLetters(lowerCaseLetters);
        password.setUpperCaseLetters(upperCaseLetters);
        password.setNumbers(numbers);
        password.setSpecialSymbols(specialSymbols);
        return password;
    }
}
