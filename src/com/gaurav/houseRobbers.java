/*
Find maximum possible stolen value from houses
There are n houses build in a line, each of which contains some value in it. A thief is going to steal the maximal
value of these houses, but he can’t steal in two adjacent houses because owner of the stolen houses will tell his two
neighbour left and right side. What is the maximum stolen value.
Examples:

Input  : hval[] = {6, 7, 1, 3, 8, 2, 4}
Output : 19
Thief will steal 6, 1, 8 and 4 from house.

Input  : hval[] = {5, 3, 4, 11, 2}
Output : 16
Thief will steal 5 and 11
*/

package com.gaurav;

public class houseRobbers {
    public static void main(String[] args) {
        int[] house = {5, 3, 4, 11, 2};
        System.out.println(robbHouse(house));
    }

    static int robbHouse(int[] house){
        int len = house.length;
        int even=0, odd=0;

        for (int i=0; i<len; i++){
                if (i % 2==0)
                    even = Math.max(even + house[i], odd);
                else
                    odd = Math.max(even, odd + house[i]);
        }

        return Math.max(even, odd);
    }
}
