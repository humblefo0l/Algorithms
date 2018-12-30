package com.gaurav;

public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = {2,4,5,7,8,88};
        int x = 88;

        int result =  binarySearch(arr, x);

        if (result >-1){
            System.out.println(x + " is present at " + result);
        }else {
            System.out.println(x + " is not present");
        }

    }


    private static int binarySearch(int arr[], int x){
        int start = 0;
        int stop = arr.length-1;
        int middle = 0;
        while (true){
            System.out.println('-');
            if (start > stop){
                break;
            }
            System.out.println(start + ", " + stop);
            middle = stop +(start - stop) / 2;
            System.out.println(middle +": "+ arr[middle]);
            if (arr[middle] == x){
                return middle;
            }

            else if(arr[middle] > x){
                stop = middle - 1;
            }else if (arr[middle] < x){
                start = middle +1;
            }


        }

        return -1;
    }
}