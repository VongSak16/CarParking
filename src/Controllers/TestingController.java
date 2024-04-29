/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author SAK
 */
public class TestingController {
    
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final List<String> provinceCodes = new ArrayList<>();

    static {
        provinceCodes.add("2"); // Phnom Penh
        provinceCodes.add("3"); // Kampong Cham
        provinceCodes.add("6"); // Siem Reap
        // Add more province codes here
    }

    public static String generatePlateId() {
        StringBuilder plateId = new StringBuilder();

        // Generate class number (random between 1 and 9)
        plateId.append(new Random().nextInt(9) + 1);

        // Generate random letters (2 characters)
        char[] letters = new char[2];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = ALPHABET.charAt(new Random().nextInt(ALPHABET.length()));
        }
        plateId.append(new String(letters));

        // Generate random numbers (0001 to 9999)
        String number = String.format("%04d", new Random().nextInt(10000));
        plateId.append("-");
        plateId.append(number);

        // Select province code
        String provinceCode = provinceCodes.get(new Random().nextInt(provinceCodes.size()));

        // Combine all parts with parentheses for province code
        //plateId.append(" (").append(provinceCode).append(")");

        return plateId.toString();
    }

    public static String generateUniquePlateId(List<String> usedIds) {
        String newId;
        do {
            newId = generatePlateId();
        } while (usedIds != null && usedIds.contains(newId));

        if (usedIds != null) {
            usedIds.add(newId);
        }

        return newId;
    }
}
