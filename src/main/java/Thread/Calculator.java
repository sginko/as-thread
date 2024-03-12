package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu(scanner);
    }

    private static boolean printMenu(Scanner scanner) {
        System.out.println("1) Factorial");
        System.out.println("2) POW");
        System.out.println("3) Exit");
        System.out.print("Wpisz komendę: ");
        String command = scanner.nextLine();

        switch (command) {
            case "1":
                factorialMenu(scanner);
                break;
            case "2":
                powMenu(scanner);
                break;
            case "3":
                System.out.println("Zamykanie aplikacji...");
                return true;
            default:
                System.out.println("Nieznana komenda. Spróbuj ponownie.");
                break;
        }
        return false;
    }

    private static void factorialMenu(Scanner scanner) {
        while (true) {
            System.out.println("Wprowadź liczbę do obliczenia silni (lub 'exit' aby wyjść): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                printMenu(scanner);
                break;
            }

            try {
                int number = Integer.parseInt(input);
                new Factorial(number).start();
            } catch (NumberFormatException e) {
                System.out.println("Proszę wprowadzić poprawną liczbę całkowitą.");
            }
        }
        scanner.close();
    }

    private static void powMenu(Scanner scanner) {
        while (true) {
            System.out.println("Wprowadź value: ");
            String input = scanner.nextLine();
            System.out.println("Wprowadź powValue (lub 'exit' aby wyjść): ");
            String input2 = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                printMenu(scanner);
                break;
            }

            try {
                int value = Integer.parseInt(input);
                int powValue = Integer.parseInt(input2);
                new Pow(value, powValue).start();
            } catch (NumberFormatException e) {
                System.out.println("Proszę wprowadzić poprawną liczbę całkowitą.");
            }
        }
        scanner.close();
    }
}