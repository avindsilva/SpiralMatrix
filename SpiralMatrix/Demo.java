import java.util.Scanner;
import java.lang.System.*;


class Demo {
  public static void main(String[] args) {
    SpiralMatrix s = new SpiralMatrix(5);
    s.setMatrix();
    s.printMatrix();
    s.printSpiral();

    SpiralMatrix s2 = new SpiralMatrix();
    s2.setMatrix();
    s2.printMatrix();
    s2.printSpiral();
  }
}
