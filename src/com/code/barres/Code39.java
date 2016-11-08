package com.code.barres;

/**
 * Created by germain on 03/11/16.
 */
public class Code39 {

    public static char allowedChars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','-','.',' ','$','/','+','%'};

    public static String encode(String input) {
        return '*' +  removeSpecialChars(input.toUpperCase()) + '*';
    }

    public static String encodeWithModulo(String input) {
        String encodedString = encode(input);
        char modulo43 = getModulo43(encodedString);
        return encodedString.substring(0, encodedString.length() - 1) + modulo43 + '*';
    }

    private static String removeSpecialChars(String input) {
        String res = "";
        for(int i=0; i<input.length(); i++) {
            for(int j=0; j<allowedChars.length; j++) {
                if(input.charAt(i) == allowedChars[j]) {
                    res += input.charAt(i);
                    break;
                }
            }
        }
        return res;
    }

    private static char getModulo43(String input) {
        int sum = 0;
        int currVal;
        for(int i=0; i<input.length(); i++) {
            currVal = new String(allowedChars).indexOf(input.charAt(i));
            if(currVal != -1)
                sum += currVal;
        }
        return allowedChars[sum%43];
    }
}
