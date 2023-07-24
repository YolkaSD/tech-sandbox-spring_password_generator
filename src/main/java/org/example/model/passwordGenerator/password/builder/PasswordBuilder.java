package org.example.model.passwordGenerator.password.builder;
import org.example.model.passwordGenerator.Generator;
import org.example.model.passwordGenerator.password.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordBuilder {
    @Autowired
    private Password password;
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

    public PasswordBuilder setPassLength(int passLength) {
        this.passLength = passLength;
        return this;
    }

    public PasswordBuilder setLowerCaseLetters(boolean lowerCaseLetters) {
        this.lowerCaseLetters = lowerCaseLetters;
        return this;
    }

    public PasswordBuilder setUpperCaseLetters(boolean upperCaseLetters) {
        this.upperCaseLetters = upperCaseLetters;
        return this;
    }

    public PasswordBuilder setNumbers(boolean numbers) {
        this.numbers = numbers;
        return this;
    }

    public PasswordBuilder setSpecialSymbol(boolean specialSymbol) {
        this.specialSymbols = specialSymbol;
        return this;
    }

    public Password build() {
        password.setPassLength(passLength);
        password.setLowerCaseLetters(lowerCaseLetters);
        password.setUpperCaseLetters(upperCaseLetters);
        password.setNumbers(numbers);
        password.setSpecialSymbols(specialSymbols);
        return password;
    }
}
