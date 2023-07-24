package org.example.model.passwordGenerator.password;

public interface Password {
    String getPasswordProperties();

    String getPassword();

    void setPassLength(int passLength);

    void setLowerCaseLetters(boolean lowerCaseLetters);

    void setUpperCaseLetters(boolean upperCaseLetters);

    void setNumbers(boolean numbers);

    void setSpecialSymbols(boolean specialSymbols);

    void createPassword(String password);

    int getPassLength();

    boolean getLowerCaseLetters();

    boolean getUpperCaseLetters();

    boolean getNumbers();

    boolean getSpecialSymbols();
}
