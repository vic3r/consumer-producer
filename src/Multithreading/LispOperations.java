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
   Random random;
   
   LispOperations() {
       random = new Random();
   }
   
   public char getOperand(int i) {
       int randOperand = random.nextInt(4);
       return operands[randOperand];
   }
   
   public int getNumber() {
       int randNumber = random.nextInt(10);
       return randNumber;
   }
}
