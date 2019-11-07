/*
 * Vitalii Chernetskyi
 * Encrypting with Public Key
 * 06.11.2019
 * CS-522a
 * Faculty of Cybersecurity, Computer and Software Engineering
 * National Aviation University
 */

package main;

import encryption.*;
import io.*;

public class Main {

    public static void main(String[] args) {

        Read read = new Read();
        Write write = new Write();
        KeysGen keysGen = new KeysGen();
        Coding coding = new Coding();

        String com, result;

        System.out.println("Input number of command\n1 - Generate Keys\n2 - Encode with Public Key\n3 - Decode with " +
                "Private Key");
        com = read.readString();
        if(com.equals("1")){
            keysGen.keysGen();
            System.out.println("Keys Generated! Look for them in the files!");
        }
        else if(com.equals("2")){
            System.out.println("Input file name with text to code:");
            String fileName = read.readString();
            String text = read.readStringFile(fileName);
            System.out.println("Input first public key:");
            int key1 = read.readInt();
            System.out.println("Input second public key:");
            int key2 = read.readInt();
            result = coding.encode(text, key1, key2);
            System.out.println("Result:\n" + result + "\nResult will be written to the file.");
            write.writeToFile("Result.txt", result);
        }
        else if(com.equals("3")){
            System.out.println("Input file name with text to decode:");
            String fileName = read.readString();
            String text = read.readStringFile(fileName);
            System.out.println("Input first private key:");
            int key1 = read.readInt();
            System.out.println("Input second private key:");
            int key2 = read.readInt();
            result = coding.decode(text, key1, key2);
            System.out.println("Result:\n" + result + "\nResult will be written to the file.");
            write.writeToFile("Result.txt", result);
        }


    }
}
