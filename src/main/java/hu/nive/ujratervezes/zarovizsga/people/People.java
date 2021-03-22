package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String path) {
        String line;
        int manNumber = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            while ((line = reader.readLine()) != null) {
                String[] peopleArray = line.split(",");
                if (peopleArray[4].equals("Male")) {
                    manNumber++;
                }
            }
            return manNumber;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}

