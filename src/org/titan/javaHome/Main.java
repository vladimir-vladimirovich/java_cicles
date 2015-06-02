package org.titan.javaHome;

import java.util.Random;

/**
 * Created by vladymir.ovcharov on 02/06/2015.
 */


public class Main {
    public static void main(String[] args) {
        int n = 15;
        int[] mas = new int[n]; //TODO find better names
        int[] mas1 = new int[n];
        Random rand = new Random();
        System.out.println("========================Find max element=================================");
//  Generating a mas //TODO use code style
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rand.nextInt(20);
        }

//  Copying a mas in mas1
        for (int i = 0; i < mas.length; i++) {
            mas1[i] = mas[i];
        }

//  Output generated mass
        System.out.print("Generated mass: ");
        for (int i = 0; i < mas.length; i++) {
            System.out.print("[" + mas[i] + "]");
        }
        System.out.println();

//  Sotring a mas
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length - 1; j++) { //TODO find better algorithm
                if (mas[j] > mas[j + 1]) {
                    int temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        }
//  Output sorted mas
        System.out.println();
        System.out.print("Sorted mass: ");
        for (int i = 0; i < mas.length; i++) {
            System.out.print("[" + mas[i] + "]");
        }
        System.out.println();

//  Looking for a max number
        System.out.println();

        int max1 = mas1[0];
        for (int i = 0; i < mas.length; i++) {
            if(max1 > mas[i]){
                continue;
            } else max1 = mas[i]; //TODO optimize construction
        }

//  Output max
        System.out.println("Max element in mas(sorted) is: " + mas[mas.length-1]);
        System.out.println("Max element in mas1(copied) is: " + max1); // duplicates output??
        System.out.println();

        System.out.println("========================Arithmetic mean==================================");
        int sum = 0;
        for (int i = 0; i < mas1.length; i++) {
            sum = sum + mas1[i];
        }
        int arithmeticMean = sum/mas.length; //TODO use double or float
        System.out.println("Arithmetic mean is: " + arithmeticMean);
        System.out.println();

        System.out.println("===================The closest number to arithmetic mean=================");

        int difference = 99999;  //rly big number which will be never used //TODO use MAX_INT
//  Looking for minimal difference
        for (int i = 0; i < mas1.length; i++) {
            if(Math.abs(arithmeticMean - mas1[i]) < difference){
                difference = Math.abs(arithmeticMean - mas1[i]); //TODO try no duplicate code
            }
        }
//  Create masOfDifferences
        int[] masOfDifferences = new int[n];
        for (int i = 0; i < mas1.length; i++) {
            masOfDifferences[i] = Math.abs(arithmeticMean - mas1[i]);
        }
//  Output all the symbols, wich are equal to minimal
        System.out.print("The closest numbers to arithmetic mean are: ");
        for (int i = 0; i < masOfDifferences.length; i++) {
            if(masOfDifferences[i] == difference){
                System.out.print(mas1[i] + " ");
            }
        }
        System.out.println();
        System.out.println();

        System.out.println("======================Output all equal numbers===========================");

        int[] masEquals = new int[n];
        System.out.println();
        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < masEquals.length; j++) {
                if(i == j){
                    continue;
                } else if(mas1[i] == mas1[j]){
                    System.out.println(mas1[i]);
                }
            }
        }

        //TODO remove empty lines

    }
}


