/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.radixsort;
// Garin McCullick

import java.util.*;

public class App {
    public static void main(String[] args) {
        int[] arr = new int[1000000];//setting 1 mil for max array amount
        int max = 10000; // maximum value for the generated integers
        Random rand = new Random();//creating instance for random class

        // generating 1,000,000 random integers in the range of 0 and 10000
        for (int i = 0; i < arr.length; i++) {//for loop adding up to length of array (1000000)
            arr[i] = rand.nextInt(max);//generating and storing integers inside array
        }

        // sorting the array using radix sort buckets
        for (int exp = 1; max / exp > 0; exp *= 10) {//for loop going through each int of 1000000
            int[] bucket = new int[10];//creating array to hold the integer count
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / exp) % 10]++;//counting the number of integers in the digits place, ones, tens, hundreds, thousands ex: 1 = 1 | 24 = 2 | 234 = 3
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];//finding the position of every integer in sorted array
            }
            int[] sortedArr = new int[arr.length];//making a new array to put sorted array into
            for (int i = arr.length - 1; i >= 0; i--) {
                sortedArr[--bucket[(arr[i] / exp) % 10]] = arr[i];//making sure integer is in correct place in sorted arr
            }
            arr = sortedArr;//overwriting old arr with sorted array
        }

        System.out.println("sorted array:" + Arrays.toString(arr));//printing the sorted array with text
        System.out.println("length of array:" + arr.length);//printing the max length of array
    }
}