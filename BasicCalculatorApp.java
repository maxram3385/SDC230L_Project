/*******************************************************************
 * Name: Max Ramos
 * Date: March 8, 2026
 * Assignment: Week 1 Project - Basic Calculator Application
 *
 * This program displays a project header, welcomes the user,
 * performs one integer addition operation, performs one
 * floating-point subtraction operation, and ends with a
 * closing message.
 *******************************************************************/

import java.util.Scanner;

public class BasicCalculatorApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Project header
        System.out.println("Project Week 1 - Basic Calculator");
        System.out.println("Created by Max Ramos");
        System.out.println();

        // Welcome and instructions
        System.out.println("Welcome to the Basic Calculator App.");
        System.out.println("You will enter two integers for addition.");
        System.out.println("Then you will enter two decimal numbers for subtraction.");
        System.out.println();

        // Integer addition section
        System.out.println("Integer Addition");
        System.out.print("Enter the first integer: ");
        int firstInt = input.nextInt();

        System.out.print("Enter the second integer: ");
        int secondInt = input.nextInt();

        int intSum = firstInt + secondInt;
        System.out.println("Result: " + firstInt + " + " + secondInt + " = " + intSum);
        System.out.println();

        // Floating-point subtraction section
        System.out.println("Floating-Point Subtraction");
        System.out.print("Enter the first decimal number: ");
        double firstDouble = input.nextDouble();

        System.out.print("Enter the second decimal number: ");
        double secondDouble = input.nextDouble();

        double difference = secondDouble - firstDouble;
        System.out.printf("Result: %.2f - %.2f = %.2f%n", secondDouble, firstDouble, difference);
        System.out.println();

        // Closing message
        System.out.println("Thank you for using the Basic Calculator App.");
        System.out.println("Goodbye.");

        input.close();
    }
}
