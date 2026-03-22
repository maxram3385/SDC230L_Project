/*******************************************************************
 * Name: Max Ramos
 * Date: March 21, 2026
 * Assignment: Week 2 Project - Calculator Application
 *
 * This program displays a project header, welcomes the user,
 * shows a calculator menu, performs basic math operations,
 * repeats until the user chooses to quit, and ends with a
 * closing message.
 *******************************************************************/

import java.util.Scanner;

public class BasicCalculatorApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();

        int choice;
        double num1;
        double num2;
        double result;

        displayHeader();
        displayWelcome();

        do {
            displayMenu();
            choice = getUserChoice(input);

            switch (choice) {
                case 1:
                    System.out.println("Addition");
                    num1 = getFirstNumber(input);
                    num2 = getSecondNumber(input);
                    result = calc.add(num1, num2);
                    System.out.printf("Result: %.2f + %.2f = %.2f%n%n", num1, num2, result);
                    break;

                case 2:
                    System.out.println("Subtraction");
                    num1 = getFirstNumber(input);
                    num2 = getSecondNumber(input);
                    result = calc.subtract(num1, num2);
                    System.out.printf("Result: %.2f - %.2f = %.2f%n%n", num1, num2, result);
                    break;

                case 3:
                    System.out.println("Multiplication");
                    num1 = getFirstNumber(input);
                    num2 = getSecondNumber(input);
                    result = calc.multiply(num1, num2);
                    System.out.printf("Result: %.2f * %.2f = %.2f%n%n", num1, num2, result);
                    break;

                case 4:
                    System.out.println("Division");
                    num1 = getFirstNumber(input);
                    num2 = getSecondNumber(input);

                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.\n");
                    } else {
                        result = calc.divide(num1, num2);
                        System.out.printf("Result: %.2f / %.2f = %.2f%n%n", num1, num2, result);
                    }
                    break;

                case 5:
                    displayGoodbye();
                    break;

                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 5.\n");
            }

        } while (choice != 5);

        input.close();
    }

    public static void displayHeader() {
        System.out.println("Project Week 2 - Calculator Application");
        System.out.println("Created by Max Ramos");
        System.out.println();
    }

    public static void displayWelcome() {
        System.out.println("Welcome to the Calculator Application.");
        System.out.println("Choose an option from the menu to perform a calculation.");
        System.out.println("Enter 5 when you are ready to quit.");
        System.out.println();
    }

    public static void displayMenu() {
        System.out.println("Calculator Menu");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Quit");
    }

    public static int getUserChoice(Scanner input) {
        System.out.print("Enter your choice: ");
        return input.nextInt();
    }

    public static double getFirstNumber(Scanner input) {
        System.out.print("Enter the first number: ");
        return input.nextDouble();
    }

    public static double getSecondNumber(Scanner input) {
        System.out.print("Enter the second number: ");
        return input.nextDouble();
    }

    public static void displayGoodbye() {
        System.out.println();
        System.out.println("Thank you for using the Calculator Application.");
        System.out.println("Goodbye.");
    }
}