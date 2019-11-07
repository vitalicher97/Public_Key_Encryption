/*
 * Vitalii Chernetskyi
 * Encrypting with Public Key
 * 06.11.2019
 * CS-522a
 * Faculty of Cybersecurity, Computer and Software Engineering
 * National Aviation University
 */

package io;

import java.io.FileWriter;
import java.io.IOException;

public class Write {

    public void writeToFile(String fileName, String textWrite){
        try{
            FileWriter file = new FileWriter(fileName);
            file.write(textWrite);
            file.close();
        } catch (IOException e){
            System.out.println("\nio.Write.writeToFile error occurred.");
            e.printStackTrace();
        }
    }
}