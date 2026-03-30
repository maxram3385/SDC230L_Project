/*
 * Name: Max Ramos
 * Course: SDC230L
 * Date: 3/29/2026
 * Assignment: Week 4 Calculator Project
 * Description:
 * This program allows the user to divide two numbers.
 * It demonstrates exception handling by catching invalid
 * numeric input and division by zero. The program continues
 * running until the user chooses to quit.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Week4Calculator {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        printHeader();
        printWelcome();

        boolean running = true;

        while (running) {
            runDivision();

            System.out.print("\nDo you want to perform another division? (y/n): ");
            String choice = input.next();

            if (choice.equalsIgnoreCase("n")) {
                running = false;
            }
        }

        printClosing();
        input.close();
    }

    /*
     * Method: printHeader
     * Description: Displays the project heading information.
     */
    public static void printHeader() {
        System.out.println("======================================");
        System.out.println("Week 4 Project - Calculator App");
        System.out.println("Assignment: Exception Handling");
        System.out.println("Name: Max Ramos");
        System.out.println("======================================\n");
    }

    /*
     * Method: printWelcome
     * Description: Displays instructions for the user.
     */
    public static void printWelcome() {
        System.out.println("Welcome to the Calculator App.");
        System.out.println("This program divides one number by another.");
        System.out.println("You will be asked to enter two numbers.");
        System.out.println("The program will handle invalid input and division by zero.\n");
    }

    /*
     * Method: runDivision
     * Description: Prompts the user for two numbers, handles
     * invalid input and division by zero, and displays the result.
     */
    public static void runDivision() {
        double num1 = 0;
        double num2 = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter the first number: ");
                num1 = input.nextDouble();

                System.out.print("Enter the second number: ");
                num2 = input.nextDouble();

                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }

                double result = num1 / num2;
                System.out.println("Result: " + result);
                validInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter numeric values only.");
                input.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /*
     * Method: printClosing
     * Description: Displays a thank-you message before the program ends.
     */
    public static void printClosing() {
        System.out.println("\nThank you for using the Calculator App!");
        System.out.println("Goodbye.");
    }
}