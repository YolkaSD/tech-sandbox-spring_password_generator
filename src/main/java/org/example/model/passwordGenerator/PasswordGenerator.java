package org.example.model.passwordGenerator;

import org.example.model.passwordGenerator.passwordConfig.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class PasswordGenerator implements Generator {
    @Autowired
    private PasswordConfig password;
    @Value("${lowerCaseLettersArr}")
    private String lowerCaseLetters;
    @Value("${upperCaseLettersArr}")
    private String upperCaseLetters;
    @Value("${numbersArr}")
    private String numbers;
    @Value("${specialSymbolsArr}")
    private String specialSymbols;
    private final Random random = new Random();

    @Override
    public String createPassword() {
        List<Character> characters = new ArrayList<>();
        StringBuilder allCharacters = new StringBuilder();

        if (password.getLowerCaseLetters()) {
            characters.add(getRandomCharacter(lowerCaseLetters));
            allCharacters.append(lowerCaseLetters);
        }
        if (password.getUpperCaseLetters()) {
            characters.add(getRandomCharacter(upperCaseLetters));
            allCharacters.append(upperCaseLetters);
        }
        if (password.getNumbers()) {
            characters.add(getRandomCharacter(numbers));
            allCharacters.append(numbers);
        }
        if (password.getSpecialSymbols()) {
            characters.add(getRandomCharacter(specialSymbols));
            allCharacters.append(specialSymbols);
        }

        while (characters.size() < password.getPassLength()) {
            characters.add(getRandomCharacter(allCharacters.toString()));
        }

        Collections.shuffle(characters);
        return characters.stream().map(String::valueOf).collect(Collectors.joining());

    }

    private char getRandomCharacter(String characters) {
        return characters.charAt(random.nextInt(characters.length()));
    }

}
