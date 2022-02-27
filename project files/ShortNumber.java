/*
 * ShortNumber
 * This class has for every object a variable of the data type short which stores the value of the short number which was entered by the user in the class Numbers. Moreover, there is a static variable max which stores the maximum value of all short numbers. Also getters for the numbers and max are implemented.
 * Author: Isabella Kainer
 * Last Change: 19/01/2022
 */

public class ShortNumber {
    private short number;
    private static short max;

    //constructor for creating a ShortNumber object with the number value of shNumber; also checks if the new number is greater than max --> if yes, max is updated
    ShortNumber(short shNumber) {
        number = shNumber;
        if (shNumber > max) {
            max = shNumber;
        }
    }

    //returns the value of number of the current object
    public short getNumber() {
        return number;
    }

    //returns the value of max (the maximum of all numbers)
    public static short getMax() {
        return max;
    }
}
