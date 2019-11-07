/*
 * Vitalii Chernetskyi
 * Encrypting with Public Key
 * 06.11.2019
 * CS-522a
 * Faculty of Cybersecurity, Computer and Software Engineering
 * National Aviation University
 */

package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read {

    public String readString(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public int readInt(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public String readStringFile(String fileName){
        String data = "";
        try{
            File file = new File(fileName);
            Scanner in = new Scanner(file);
            while(in.hasNextLine()){
                data = in.nextLine();
            }
            in.close();
        } catch (FileNotFoundException e){
            System.out.println("\nio.Read.readStringFile error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}