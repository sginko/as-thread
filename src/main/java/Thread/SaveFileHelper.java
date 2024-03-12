package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileHelper {
    private static final String RESULT_FILE = "factorial_results.txt";

    static synchronized void saveResultToFile(String result, long pid, long tid) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESULT_FILE, true))) {
            writer.write(result + " PID id =" + pid + " TID id = "+ tid);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania wyniku do pliku: " + e.getMessage());
        }
    }
}