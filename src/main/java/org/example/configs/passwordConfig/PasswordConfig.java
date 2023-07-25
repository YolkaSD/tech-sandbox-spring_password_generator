package org.example.model.passwordGenerator.passwordConfig;

public interface PasswordConfig {
    String getPasswordProperties();

    void setPassLength(int passLength);

    void setLowerCaseLetters(boolean lowerCaseLetters);

    void setUpperCaseLetters(boolean upperCaseLetters);

    void setNumbers(boolean numbers);

    void setSpecialSymbols(boolean specialSymbols);

    int getPassLength();

    boolean getLowerCaseLetters();

    boolean getUpperCaseLetters();

    boolean getNumbers();

    boolean getSpecialSymbols();
}
