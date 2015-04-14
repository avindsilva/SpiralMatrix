//package com.datoin.training.desilva;

import java.util.Scanner;
import java.lang.System.*;

public class Spiral {
    public static int center; //= order/2;
    public static int cx; //= center;
    public static int cy;// = center;
    public static int order;
    public static int matrix[][]; //= new int [][];

    public static void main(String[] args) {
	System.out.println("Enter the order of the odd square matrix");

	//BufferReader br = new BufferReader(new InputStreamReader(System.in));
	Scanner in = new Scanner(System.in);
	order = in.nextInt();
	center = order/2;
	cx = center;
	cy = center;

	matrix = new int[order][order];
	int number = 10;

	for(int i=0; i < order; i++) {
	    for(int j=0; j < order; j++) {
		matrix[i][j] = number ++; //in.nextInt();
	    }
	}

	for(int i=0; i < order; i++) {
	    for(int j=0; j < order; j++) {
		System.out.print(matrix[i][j] + " ");
	    }
	    System.out.println();
	}
	spiral();
    }
    public static void spiral() {
	int round = 1;

	printCell();

	do {
	    down(1);
	    left((round*2)-1);
	    up(round*2);
	    right(round*2);
	    down(round*2);
	} while(round++ < order/2);
    }

    public static void printCell() {
	System.out.print(matrix[cx][cy] + " ");
    }

    public static void down(int i) {
	for(int j=0; j<i; j++) {
	    cx++;
	    printCell();
	}    
    }

    public static void left(int i) {
	for(int j=0; j<i; j++) {
	    cy--;
	    printCell();
	}   
    }

    public static void up(int i) {
	for(int j=0; j<i; j++) {
	    cx--;
	    printCell();
	}
    }

    public static void right(int i) {
	for(int j=0; j<i; j++){
	    cy++;
	    printCell();
	}
    }
}