import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kalkulator - dodaje, odejmuje, mnoży lub dzieli dwie liczby rzeczywiste.");

        System.out.print("Wprowadź pierwszą liczbę: ");

        double number1;
        while (!scanner.hasNextDouble()) {
            System.out.println("Błąd: To nie jest liczba!");
            System.out.print("Wprowadź pierwszą liczbę: ");
            scanner.next();
        }
        number1 = scanner.nextDouble();

        System.out.print("Wprowadź symbol operacji arytmetycznej (+, -, *, /): ");
        char operator;
        while (true) {
            String input = scanner.next();
            if (input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {
                operator = input.charAt(0);
                break;
            } else {
                System.out.println("Błąd: Nieprawidłowy symbol!");
                System.out.print("Wprowadź symbol operacji arytmetycznej (+, -, *, /): ");
            }
        }

        System.out.print("Wprowadź drugą liczbę: ");

        double number2;
        while (!scanner.hasNextDouble()) {
            System.out.println("Błąd: To nie jest liczba!");
            System.out.print("Wprowadź drugą liczbę: ");
            scanner.next();
        }
        number2 = scanner.nextDouble();

        double result;
        boolean validOperation = true;

        switch (operator) {
            case '+':
                result = number1 + number2;
                System.out.println("Wynik: " + result);
                break;
            case '-':
                result = number1 - number2;
                System.out.println("Wynik: " + result);
                break;
            case '*':
                result = number1 * number2;
                System.out.println("Wynik: " + result);
                break;
            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                    System.out.println("Wynik: " + result);
                } else {
                    System.out.println("Błąd: Dzielenie przez zero!");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Błąd: Nieznany symbol!");
                validOperation = false;
                break;
        }

        if (validOperation) {
            System.out.println("Naciśnij Enter, aby zamknąć program.");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
