package org.example.model.passwordGenerator.password;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class PasswordDTO implements Password {
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
    @Value("${password}")
    private String password;

    private PasswordDTO() {
    }

    @Override
    public String getPasswordProperties() {
        return "Length: " + passLength + "\n" +
                "Is lower case letters: " + lowerCaseLetters + "\n" +
                "Is up case letters: " + upperCaseLetters + "\n" +
                "Numbers: " + numbers + "\n" +
                "Special symbol: " + specialSymbols + "\n";
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassLength(int passLength) {
        this.passLength = passLength;
    }

    @Override
    public void setLowerCaseLetters(boolean lowerCaseLetters) {
        this.lowerCaseLetters = lowerCaseLetters;
    }

    @Override
    public void setUpperCaseLetters(boolean upperCaseLetters) {
        this.upperCaseLetters = upperCaseLetters;
    }

    @Override
    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    @Override
    public void setSpecialSymbols(boolean specialSymbols) {
        this.specialSymbols = specialSymbols;
    }

    @Override
    public int getPassLength() {
        return passLength;
    }

    @Override
    public boolean getLowerCaseLetters() {
        return lowerCaseLetters;
    }

    @Override
    public boolean getUpperCaseLetters() {
        return upperCaseLetters;
    }

    @Override
    public boolean getNumbers() {
        return numbers;
    }

    @Override
    public boolean getSpecialSymbols() {
        return specialSymbols;
    }

    @Override
    public void createPassword(String password) {
        this.password = password;
    }
}
