package fr.miage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    public static void main(String[] args) {
        String filePath = "data.txt"; // Chemin du fichier
        int numberOfLines = 100000; // Nombre de lignes à générer

        try (FileWriter writer = new FileWriter(filePath)) {
            Random random = new Random();
            for (int i = 0; i < numberOfLines; i++) {
                int randomNumber = random.nextInt(1000000); // Générer un nombre aléatoire
                writer.write(randomNumber + "\n"); // Écrire dans le fichier
            }
            System.out.println("Fichier généré avec succès : " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
