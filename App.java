import java.util.ArrayList;
import java.util.Scanner;

/*
 * Project 3 - Memory Calculator
 * Author: Max Ramos
 *
 * This application demonstrates a calculator-style memory system.
 * It allows the user to:
 * 1. Store and manage one single numeric value.
 * 2. Store and manage a collection of up to 10 integer values.
 * 3. Display summaries and perform simple calculations on stored values.
 */

public class App {

    // Single numeric memory value
    private static Double singleMemory = null;

    // Collection memory for integers
    private static ArrayList<Integer> integerMemory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        printHeader();
        printWelcomeMessage();

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");

            int choice;
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number from the menu.");
                input.next(); // clear bad input
                continue;
            }

            switch (choice) {
                case 1:
                    storeSingleValue(input);
                    break;
                case 2:
                    retrieveSingleValue();
                    break;
                case 3:
                    clearSingleValue();
                    break;
                case 4:
                    replaceSingleValue(input);
                    break;
                case 5:
                    addIntegerValues(input);
                    break;
                case 6:
                    displayAllIntegers();
                    break;
                case 7:
                    displayIntegerCount();
                    break;
                case 8:
                    removeIntegerValue(input);
                    break;
                case 9:
                    sumIntegers();
                    break;
                case 10:
                    averageIntegers();
                    break;
                case 11:
                    differenceFirstLast();
                    break;
                case 12:
                    running = false;
                    printClosingMessage();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid menu option.");
            }
        }

        input.close();
    }

    /*
     * Prints the project header information.
     */
    public static void printHeader() {
        System.out.println("==========================================");
        System.out.println("Project Week 3 - Memory Calculator");
        System.out.println("Assignment Title: Project 3");
        System.out.println("Name: Max Ramos");
        System.out.println("==========================================");
    }

    /*
     * Prints the welcome/instructions message.
     */
    public static void printWelcomeMessage() {
        System.out.println("Welcome to the Memory Calculator!");
        System.out.println("This program lets you store one numeric value");
        System.out.println("and also manage a collection of up to 10 integers.");
        System.out.println("Use the menu below to interact with the program.");
        System.out.println();
    }

    /*
     * Displays the menu options.
     */
    public static void printMenu() {
        System.out.println("\n----------- MENU -----------");
        System.out.println("1. Store single numeric value");
        System.out.println("2. Retrieve single numeric value");
        System.out.println("3. Clear single numeric value");
        System.out.println("4. Replace single numeric value");
        System.out.println("5. Add integer values to collection");
        System.out.println("6. Display all integer values");
        System.out.println("7. Display count of integer values");
        System.out.println("8. Remove an integer value");
        System.out.println("9. Get sum of integer collection");
        System.out.println("10. Get average of integer collection");
        System.out.println("11. Get difference of first and last values");
        System.out.println("12. Quit");
        System.out.println("----------------------------");
    }

    /*
     * Stores a single numeric value in memory.
     */
    public static void storeSingleValue(Scanner input) {
        if (singleMemory != null) {
            System.out.println("A value is already stored. Use replace if you want to change it.");
            return;
        }

        System.out.print("Enter a numeric value to store: ");
        if (input.hasNextDouble()) {
            singleMemory = input.nextDouble();
            System.out.println("Single value stored successfully.");
        } else {
            System.out.println("Invalid input. Please enter a numeric value.");
            input.next();
        }
    }

    /*
     * Retrieves and displays the single numeric value.
     */
    public static void retrieveSingleValue() {
        if (singleMemory == null) {
            System.out.println("No single value is currently stored.");
        } else {
            System.out.println("Stored single value: " + singleMemory);
        }
    }

    /*
     * Clears the single numeric value from memory.
     */
    public static void clearSingleValue() {
        if (singleMemory == null) {
            System.out.println("No single value is currently stored.");
        } else {
            singleMemory = null;
            System.out.println("Single value cleared.");
        }
    }

    /*
     * Replaces the current single numeric value.
     */
    public static void replaceSingleValue(Scanner input) {
        System.out.print("Enter the new numeric value: ");
        if (input.hasNextDouble()) {
            singleMemory = input.nextDouble();
            System.out.println("Single value replaced successfully.");
        } else {
            System.out.println("Invalid input. Please enter a numeric value.");
            input.next();
        }
    }

    /*
     * Adds integer values to the collection until the user stops
     * or the collection reaches 10 values.
     */
    public static void addIntegerValues(Scanner input) {
        if (integerMemory.size() >= 10) {
            System.out.println("The collection is already full (10 values max).");
            return;
        }

        System.out.println("Enter integers to add to the collection.");
        System.out.println("Type -999 to stop adding.");

        while (integerMemory.size() < 10) {
            System.out.print("Enter an integer: ");

            if (input.hasNextInt()) {
                int value = input.nextInt();

                if (value == -999) {
                    break;
                }

                integerMemory.add(value);
                System.out.println("Added: " + value);

                if (integerMemory.size() == 10) {
                    System.out.println("Collection is now full.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }
    }

    /*
     * Displays all integer values in the collection.
     */
    public static void displayAllIntegers() {
        if (integerMemory.isEmpty()) {
            System.out.println("No integer values are currently stored.");
        } else {
            System.out.println("Stored integer values: " + integerMemory);
        }
    }

    /*
     * Displays the count of integer values stored.
     */
    public static void displayIntegerCount() {
        System.out.println("Count of stored integers: " + integerMemory.size());
    }

    /*
     * Removes one specified integer value from the collection.
     */
    public static void removeIntegerValue(Scanner input) {
        if (integerMemory.isEmpty()) {
            System.out.println("The integer collection is empty.");
            return;
        }

        System.out.print("Enter the integer value to remove: ");
        if (input.hasNextInt()) {
            int valueToRemove = input.nextInt();

            if (integerMemory.remove(Integer.valueOf(valueToRemove))) {
                System.out.println("Value removed successfully.");
            } else {
                System.out.println("That value was not found in the collection.");
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
            input.next();
        }
    }

    /*
     * Calculates and displays the sum of the integer collection.
     */
    public static void sumIntegers() {
        if (integerMemory.isEmpty()) {
            System.out.println("The integer collection is empty.");
            return;
        }

        int sum = 0;
        for (int value : integerMemory) {
            sum += value;
        }

        System.out.println("Sum of stored integers: " + sum);
    }

    /*
     * Calculates and displays the average of the integer collection.
     */
    public static void averageIntegers() {
        if (integerMemory.isEmpty()) {
            System.out.println("The integer collection is empty.");
            return;
        }

        int sum = 0;
        for (int value : integerMemory) {
            sum += value;
        }

        double average = (double) sum / integerMemory.size();
        System.out.println("Average of stored integers: " + average);
    }

    /*
     * Calculates and displays the difference between the first
     * and last values in the integer collection.
     */
    public static void differenceFirstLast() {
        if (integerMemory.size() < 2) {
            System.out.println("You need at least two values in the collection.");
            return;
        }

        int first = integerMemory.get(0);
        int last = integerMemory.get(integerMemory.size() - 1);
        int difference = first - last;

        System.out.println("Difference of first and last values: " + difference);
    }

    /*
     * Prints the closing message.
     */
    public static void printClosingMessage() {
        System.out.println("\nThank you for using the Memory Calculator!");
        System.out.println("Program terminated successfully.");
    }
}