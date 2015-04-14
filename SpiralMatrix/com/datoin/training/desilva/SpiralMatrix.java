package com.datoin.training.desilva;

import java.util.Scanner;
import java.lang.System.*;
import java.io.Console.*;

public class SpiralMatrix {

  int center;
  int cx;
  int cy;
  int order;
  int matrix[][];

  //Creating a default constructor
  public SpiralMatrix() {
    this.order = 0;
  }

  //Creating a constructor
  public SpiralMatrix(int o) {
    this.order = o;
    this.matrix = new int[order][order];
    System.out.println("Square Matrix of order " + this.order + " created.");
  }

  public SpiralMatrix setMatrix() {
    if(order==0){
      System.out.print("Enter the matrix of order : ");
      Scanner in = new Scanner(System.in);
      this.order=in.nextInt();
      this.matrix = new int[order][order];
    }
    int counter = 10;
    for(int i=0; i<this.order; i++) {
      for(int j=0; j<this.order; j++) {
        this.matrix[i][j] = counter++;
      }
    }
    return this;
  }

  public void printMatrix() {
    for(int i=0; i<this.order; i++) {
      for(int j=0; j<this.order; j++) {
        System.out.print(this.matrix[i][j] + " ");
      }
      System.out.println(" ");
    }
  }

  public void printSpiral() {
    center = this.order/2;
  	this.cx = center;
  	this.cy = center;
    int round = 1;

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

  private void printCell() {
    System.out.print(this.matrix[cx][cy] + " ");
  }

  private void down(int i) {
    for(int j=0; j<i; j++) {
      this.cx++;
      this.printCell();
    }
  }

  private void left(int i) {
    for(int j=0; j<i; j++) {
      this.cy--;
      this.printCell();
    }
  }

  private void up(int i) {
    for(int j=0; j<i; j++) {
      this.cx--;
      this.printCell();
    }
  }

  private void right(int i) {
    for(int j=0; j<i; j++){
      this.cy++;
      this.printCell();
    }
  }
}
