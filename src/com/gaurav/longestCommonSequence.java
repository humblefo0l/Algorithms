package com.gaurav;

public class longestCommonSequence {
    public static void main(String[] args) {

        String string1 = "afsdsb";
        String string2 = "sfvsbdb";
        System.out.println("Longest Common Sequence is: " + lcs(string1, string2));
    }

    static int lcs(String string1, String string2){
        char[] char1 = string1.toCharArray();
        char[] char2 = string2.toCharArray();

        int length1 = char1.length;
        int length2 = char2.length;

        return _lcs(char1, char2, length1, length2);
    }

    static int _lcs(char[] char1, char[] char2, int length1, int length2){

        if (length1 == 0 || length2 == 0)
            return 0;

        if (char1[length1-1] == char2[length2-1]){
            return 1 + _lcs(char1, char2, length1-1, length2-1);
        }else {
            return max(_lcs(char1, char2, length1, length2-1), _lcs(char1, char2, length1-1, length2));
        }

    }

    static int max(int a, int b){
        return a > b ? a: b ;
    }

}
