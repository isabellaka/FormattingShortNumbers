/*
 * Numbers
 * This class represents the main class of this project and holds the main method and methods for getting user input and printing the output in the right format.
 * Author: Isabella Kainer
 * Last Change: 27/02/2022
 */

import java.io.IOException;
import java.util.Scanner;

public class Numbers {
    private static final String separator = "=";
    private static final Scanner scanner = new Scanner(System.in);

    //prints a separator line
    public static void separatorLine() {
        System.out.println(separator.repeat(3));
    }

    //takes short input from the user
    static short shortInput(String text) {
        short number = 0;

        while (true) {
            try {
                System.out.print(text);
                number = Short.parseShort(scanner.nextLine());
                if (number <= 0) {
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        }

        return number;
    }

    //prints the short numbers in reversed order (section 2)
    public static void printReversed(ShortNumber[] shArray) {
        for (int i = shArray.length - 1; i >= 0; i--) {
            System.out.println(shArray[i].getNumber());
        }
    }

    //prints all the odd numbers until the short number for every short number; all numbers have the same length as the biggest number (max) by filling them up with 0s. (section 3)
    public static void printOddNumbers(ShortNumber[] shArray) {
        int totalLength = String.valueOf(ShortNumber.getMax()).length();
        for (int i = 0; i < shArray.length; i++) {
            short lastNumber = shArray[i].getNumber();
            boolean firstNumber = true;
            for (short num = 1; num <= lastNumber; num++) {

                if (num % 2 == 1) {
                    if (firstNumber) {
                        firstNumber = false;
                    } else {
                        System.out.print(" ");
                    }
                    int numLength = String.valueOf(num).length();
                    System.out.print("0".repeat(totalLength - numLength) + num);

                }
                //the for-loop has to be stopped after the last number has been processed, because otherwise num++ would be executed, which leads to a problem when the last number is the highest possible short number (32767) --> infinite loop
                if (num == lastNumber) {
                    break;
                }

            }
            System.out.println();
        }
    }

    //prints the short numbers in reversed order, but it takes the parameter numbersPerLine, which specifies how many numbers are printed in one line; all numbers have the same length as the biggest number (max) by filling them up with spaces. (section 4)
    public static void printReversedCustomized(short numbersPerLine, ShortNumber[] shArray) {
        int totalLength = String.valueOf(ShortNumber.getMax()).length();
        short numberCount = 0;
        for (int i = shArray.length - 1; i >= 0; i--) {
            short num = shArray[i].getNumber();
            System.out.print(" ".repeat(totalLength - String.valueOf(num).length()) + num);
            numberCount++;
            if (numberCount == numbersPerLine || i == 0) {
                System.out.println();
                numberCount = 0;
            } else {
                System.out.print(" ");

            }
        }
    }

    //main method
    public static void main(String[] args) {

        //section 1
        separatorLine();
        short amount = shortInput("Amount: ");
        ShortNumber[] shArray = new ShortNumber[amount];
        for (int i = 1; i <= amount; i++) {
            ShortNumber shNumber = new ShortNumber(shortInput("#" + i + ": "));
            shArray[i - 1] = shNumber;
        }

        //section 2
        separatorLine();
        printReversed(shArray);

        //section 3
        separatorLine();
        printOddNumbers(shArray);

        //section 4
        separatorLine();
        short numbersPerLine = 0;
        while (!(numbersPerLine > 0 && numbersPerLine <= amount)) {
            numbersPerLine = shortInput("Numbers per line (max. " + amount + "): ");
        }
        printReversedCustomized(numbersPerLine, shArray);

        //section 5
        separatorLine();
        while (true) {
            System.out.print("Path: ");
            String path = scanner.nextLine();
            try {
                FileHandler.writeIntoFile(path, shArray);
                break;
            } catch (IOException e) {
                System.out.printf("Error saving numbers in: %s\n", path);
            }
        }
        scanner.close();
        separatorLine();


    }
}
