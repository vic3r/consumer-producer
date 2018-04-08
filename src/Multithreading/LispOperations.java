package Multithreading;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victormanuel
 */
public class LispOperations {
   final char[] operands = {'+', '-', '/', '*'};
   private int n, m;
   Random random;
   
   LispOperations(int n, int m) {
	   this.n = n;
	   this.m = m;
       random = new Random();
   }
   
   public char getOperand() {
       int randOperand = random.nextInt(4);
       return operands[randOperand];
   }
   
   public int getNumber() {
       int randNumber = random.nextInt((m - n) + 1) + m;
       return randNumber;
   }
   
   public String createOperation() {
	   return getOperand()+ " "+getNumber()+" "+getNumber();
   }
   
}
