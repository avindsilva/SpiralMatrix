/*
 * This is a implementation of the Spiral Matrix
 *@author Avin D'Silva
 */

package com.ion.training.desilva;

import java.util.Scanner;
import java.lang.System.*;
import java.io.Console.*;
import java.io.*;
import com.opencsv.*;
//import au.com.bytecode.opencsv.*;
import java.lang.Integer;
import java.util.Arrays;
import java.lang.Thread;
/*
 * A SpiralMatrix class to store a square matrix
 */
public class SpiralMatrix {

    /** Center index of the matrix, as it is a square matrix both the indexes are the same */
    int center;
    /** Current x index at any given time */
    int cx;
    /** Current y index at any given time */
    int cy;
    /** Order of the matrix */
    int order;
    /** Internal Spiral matrix implementation */
    int matrix[][];
    
    Boolean fancy = false;
    int array[][];

    /** Creating a default constructor */
    public SpiralMatrix() {
        this.order = 0;
    }

    /** Creating a contructor which accepts the order as a parameter */
    public SpiralMatrix(int o) {
        this.order = o;
        this.matrix = new int[order][order];
        System.out.println("Square Matrix of order " + this.order + " created.");
    }

    /** This constructor accepts a file as an input and loads it into the SpiralMatrix object */
    public SpiralMatrix(String source) {
        int lines = 0;
        this.order = 0;
        int i = 0, j = 0;
        int row[] = null;

        try {
            CSVReader reader = new CSVReader(new FileReader(source));
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                if (lines == 0) {
                    this.order = nextLine.length;
                    this.matrix = new int[order][order];
                }
                j = 0;
                row = new int[this.order];
                for (String element :nextLine) {
                    row[j++] = Integer.parseInt(element);
                }

                matrix[i++] = row;
                lines++;
                if (lines > this.order) break;
            }
        } catch(Exception e) {
            System.out.println("*************** Exception Occured ******************");
            e.printStackTrace();
        }
    }

    /** Method that populates the matrix */
    public SpiralMatrix setMatrix() {
        // If the order is not specified, input the order, else populate the matrix
        if (order == 0) {
            System.out.print("Enter the matrix of order : ");
            Scanner in = new Scanner(System.in);
            this.order=in.nextInt();
            this.matrix = new int[order][order];
        }
        int counter = 10;
        for (int i=0; i<this.order; i++) {
            for (int j=0; j<this.order; j++) {
                this.matrix[i][j] = counter++;
            }
        }
        return this;
    }

    /** Method that prints the matrix in the form of rows and columns */
    public void printMatrix() {
        for (int i=0; i<this.order; i++) {
            for (int j=0; j<this.order; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /** This method prints the matrix in a spiral matrix from the center element clockwise */
    public void printSpiral() {
        System.out.println("Spiral form in clockwise format");
        center = this.order/2;
        this.cx = center;
        this.cy = center;
        int round = 1;

        if (fancy) {
            array[cx][cy] = getCell();
            printArray();
        }
        else
            this.printCell();

        do {
            down(1);
            left((round*2)-1);
            up(round*2);
            right(round*2);
            down(round*2);
        } while(round++ < order/2);

        System.out.println(" ");
    }

    public void printSpiralFancy() {
        fancy = true;
        array = new int[this.order][this.order];
        for (int[] row : array) 
            Arrays.fill(row,0);

        this.printSpiral();
    }

    void printArray() {
        for (int i = 0; i < this.order; i++) {
            for (int j = 0; j < this.order; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("");
    }
    
    private void printCell() {
        System.out.print(this.matrix[cx][cy] + " ");
    }

    private int getCell() {
        return this.matrix[cx][cy];
    }

    private void  down(int i) {
        for (int j=0; j<i; j++) {
            this.cx++;
            if(fancy) {
                array[cx][cy] = getCell();
                printArray();
            }
            else
                this.printCell();
        }
    }

    private void left(int i) {
        for (int j=0; j<i; j++) {
            this.cy--;
            if (fancy) {
                array[cx][cy] = getCell();
                printArray();
            }
            else
                this.printCell();
        }
    }

    private void up(int i) {
        for (int j=0; j<i; j++) {
            this.cx--;
            if (fancy) {
                array[cx][cy] = getCell();
                printArray();
            }
            else
                this.printCell();
        }
    }

    private void right(int i) {
        for (int j=0; j<i; j++) {
            this.cy++;
            if (fancy) {
                array[cx][cy] = getCell();
                printArray();
            }
            else
                this.printCell();
        }
    }
}
