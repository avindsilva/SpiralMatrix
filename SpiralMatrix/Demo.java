import java.util.Scanner;
import java.lang.System.*;
import com.ion.training.desilva.*;


class Demo {
  public static void main(String[] args) {
    //Creating a instance of the Spiral Matrix using a constructor (Square matrix of order 5)
    //SpiralMatrix s = new SpiralMatrix(5);
    //s.setMatrix();
    //s.printMatrix();
    //s.printSpiral();

    //Creating another instance using the default constructor
    //SpiralMatrix s2 = new SpiralMatrix();
    //s2.setMatrix();
    //s2.printMatrix();
    //s2.printSpiral();

    //Loading a matrix from a CSV file
    SpiralMatrix s3 = new SpiralMatrix(args[0]);
  }
}
