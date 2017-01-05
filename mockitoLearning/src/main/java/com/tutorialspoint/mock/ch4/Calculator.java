package com.tutorialspoint.mock.ch4;

class Calculator implements CalculatorService {

  public double add(double input1, double input2) {
    return input1 + input2;
  }

  public double subtract(double input1, double input2) {
    throw new UnsupportedOperationException("Method not implemented yet!");
  }

  public double multiply(double input1, double input2) {
    throw new UnsupportedOperationException("Method not implemented yet!");
  }

  public double divide(double input1, double input2) {
    throw new UnsupportedOperationException("Method not implemented yet!");
  }
}

