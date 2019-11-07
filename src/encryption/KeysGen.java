/*
 * Vitalii Chernetskyi
 * Encrypting with Public Key
 * 06.11.2019
 * CS-522a
 * Faculty of Cybersecurity, Computer and Software Engineering
 * National Aviation University
 */

package encryption;

import java.util.Random;

import io.*;

public class KeysGen {

    public int[] keysGen(){

        int p, q, N, M, d, randNum, e = 0;
        int[] keys = new int[4];
        boolean ifCoprime, ifPrime;
        String fileName, text;

        Random rand = new Random();
        Write write = new Write();

        // Algorithm for generating keys
        do{
            p = rand.nextInt(100);
            ifPrime = isPrime(p);
        }
        while(!ifPrime);

        do{
            q = rand.nextInt(100);
            ifPrime = isPrime(q);
        }
        while(!ifPrime);

        N = p * q;
        M = (p - 1) * (q - 1);

        do{
            d = rand.nextInt(100);
            ifCoprime = coprime(d, M);
        }
        while(!ifCoprime);

        while(!((e * d) % M == 1)){
            e++;
        }

        fileName = "PublicKey " + p + "_" + q + ".txt";
        text = e + " " + N;
        write.writeToFile(fileName, text);

        fileName = "PrivateKey " + p + "_" + q + ".txt";
        text = d + " " + N;
        write.writeToFile(fileName, text);

        keys[0] = d;
        keys[1] = N;
        keys[2] = e;
        keys[3] = M;

        return keys;


    }

    // To to check if number is prime
    private boolean isPrime(int n){

        // Corner cases
        if(n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip middle five numbers in below loop
        if(n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

            return true;

    }

    // To check if two numbers are co-prime or not
    private boolean coprime(int a, int b){

        if (greatCommDiv(a, b) == 1)
            return true;
        else
            return false;

    }

    // Find Greatest Common Divisor
    private int greatCommDiv(int a, int b){

        // Everything divides 0
        if(a == 0 || b == 0)
            return 0;
        // Base case
        if(a == b)
            return a;
        // a is greater
        if (a > b)
            return greatCommDiv(a-b, b);

        return greatCommDiv(a, b-a);

    }

}
