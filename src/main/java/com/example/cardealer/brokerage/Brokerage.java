package com.example.cardealer.brokerage;

public class Brokerage {

  private static double BROKERAGE_AMOUNT = 0.05;

  public static final double calculateBrokerage(Long price){
    return price * BROKERAGE_AMOUNT;
  }
}
