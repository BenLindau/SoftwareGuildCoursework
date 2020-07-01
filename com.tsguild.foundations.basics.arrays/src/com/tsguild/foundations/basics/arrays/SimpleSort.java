/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.arrays;

/**
 *
 * @author benli
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19,
            20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 
            21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < wholeNumbers.length - 1; i++) {
            if (firstHalf[x] < secondHalf[y]) {
                wholeNumbers[i] = firstHalf[x];
                x++;
                } else {
                wholeNumbers[i] = secondHalf[y];
                y++;
                }
            }
        for (int i = 0; i < wholeNumbers.length - 1; i++) {
            System.out.print(wholeNumbers[i] + " ");
            }      
    }
    
}
