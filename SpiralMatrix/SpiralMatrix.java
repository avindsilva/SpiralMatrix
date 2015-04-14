//package com.datoin.training.desilva;

import java.util.*;

public class SquareMatrix {
    public SquareMatrix(int o) {
	int order = o;
	int matrix[][] = new int[order][order];
	return matrix;
    }

    public SquareMatrix setMatrix() {
	System.out.println("Enter the matrix of order " + order);
	Scanner in = new Scanner();
	for(int i=0; i<order; i++) {
	    for(int j=0; j<order; j++) {
		this.matrix[i][j] = in.nextInt();
	    }
	}
    }

    public void printMatrix() {
	for(int i=0; i<order; i++) {
	    for(int j=0; j<order; j++) {
		System.out.println(this.matrix[i][j] + " ");
	    }
	    System.out.println("\n");
	}
    }

    public void printSpiral() {
	int center = order/2;
    }
}



