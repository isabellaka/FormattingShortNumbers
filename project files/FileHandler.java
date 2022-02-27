/*
 * FileHandler
 * This class is responsible for writing the numbers in a file for which the user has given a path in the class Numbers.
 * Author: Isabella Kainer
 * Last Change: 19/01/2022
 */

import java.io.*;

public class FileHandler {

    //takes a path as a parameter (which the user has given --> path has not been checked yet --> IOException might be thrown); prints the numbers in a certain format into the file (if the file does not exist yet, the file is created); if the whole process turns out as successful, a proper message is given to the user.
    public static void writeIntoFile(String path, ShortNumber[] shArray) throws IOException {
        BufferedWriter buffer = new BufferedWriter(new FileWriter(path));
        for (int i = 0; i < shArray.length; i++) {
            buffer.write("#" + (i + 1) + ": " + shArray[i].getNumber());
            buffer.newLine();

        }
        buffer.close();
        System.out.printf("Numbers successfully saved in: %s\n", path);
    }

}
