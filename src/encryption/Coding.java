/*
 * Vitalii Chernetskyi
 * Encrypting with Public Key
 * 06.11.2019
 * CS-522a
 * Faculty of Cybersecurity, Computer and Software Engineering
 * National Aviation University
 */

package encryption;

import java.lang.Math;
import java.math.BigDecimal;

public class Coding {

    public String encode(String text, int e, int N){

        int textLen;
        String result = "";

        textLen = text.length();

        if(textLen < 1 || textLen > N){
            return "This text can not be encrypted with these keys!";
        }

        char[] textArr = text.toCharArray();
        BigDecimal bdN = new BigDecimal(N);
        BigDecimal[] charCodeArr = new BigDecimal[textLen]; // Obvious for needed level of precise and for very big nums

        // Algorithm to encrypt with public key
        for(int i = 0; i < textLen; i++){
            charCodeArr[i] = BigDecimal.valueOf(textArr[i]);
            charCodeArr[i] = charCodeArr[i].pow(e);
            charCodeArr[i] = charCodeArr[i].remainder(bdN);
            result = result + charCodeArr[i].toPlainString() + ":";
        }

        return result;

    }

    public String decode(String text, int d, int N){

        int textLen, textArrLen;
        String result = "";

        textLen = text.length();

        String[] textArr = text.split(":");
        textArrLen = textArr.length;
        char[] charTextArr = new char[textArrLen];
        int[] resultNum = new int[textArrLen];
        BigDecimal bdN = new BigDecimal(N); // Obvious for needed level of precise and for very big nums
        BigDecimal[] codeArr = new BigDecimal[textLen];

        // Algorithm to decrypt with private key
        for(int i = 0; i < textArrLen; i++){
            codeArr[i] = new BigDecimal(textArr[i]);
            codeArr[i] = codeArr[i].pow(d);
            codeArr[i] = codeArr[i].remainder(bdN);
            resultNum[i] = codeArr[i].intValue();
            charTextArr[i] = (char) resultNum[i];
        }
        result = String.valueOf(charTextArr);

        return result;
    }

}
