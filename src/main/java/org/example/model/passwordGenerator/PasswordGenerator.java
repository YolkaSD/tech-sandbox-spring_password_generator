package org.example.model.passwordGenerator;

import org.example.configs.passwordConfig.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class PasswordGenerator implements Generator {
    private PasswordConfig config;
    private char[] lowerCaseLetters;
    private char[] upperCaseLetters;
    private char[] numbers;
    private char[] specialSymbols;
    private final Random random = new Random();

    @Autowired
    public PasswordGenerator(
            PasswordConfig config,
            @Qualifier("getLowerCaseLetters") char[] lowerCaseLetters,
            @Qualifier("getUpperCaseLetters") char[] upperCaseLetters,
            @Qualifier("getNumbers") char[] numbers,
            @Qualifier("getSpecialSymbols") char[] specialSymbols) {
        this.config = config;
        this.lowerCaseLetters = lowerCaseLetters;
        this.upperCaseLetters = upperCaseLetters;
        this.numbers = numbers;
        this.specialSymbols = specialSymbols;
    }

    @Override
    public String createPassword() {
        List<Character> characters = new ArrayList<>();
        StringBuilder allCharacters = new StringBuilder();

        if (config.getLowerCaseLetters()) {
            characters.add(getRandomCharacter(lowerCaseLetters));
            allCharacters.append(lowerCaseLetters);
        }
        if (config.getUpperCaseLetters()) {
            characters.add(getRandomCharacter(upperCaseLetters));
            allCharacters.append(upperCaseLetters);
        }
        if (config.getNumbers()) {
            characters.add(getRandomCharacter(numbers));
            allCharacters.append(numbers);
        }
        if (config.getSpecialSymbols()) {
            characters.add(getRandomCharacter(specialSymbols));
            allCharacters.append(specialSymbols);
        }

        while (characters.size() < config.getPassLength()) {
            characters.add(getRandomCharacter(allCharacters.toString().toCharArray()));
        }

        Collections.shuffle(characters);
        return characters.stream().map(String::valueOf).collect(Collectors.joining());

    }

    private char getRandomCharacter(char[] characters) {
        if (characters.length == 0) {
            return '\0';
        }
        return characters[random.nextInt(characters.length)];
    }

}
