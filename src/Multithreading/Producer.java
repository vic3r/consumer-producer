package Multithreading;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import Screen.MainPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Producer extends Thread {
    
    private Buffer buffer;
    private boolean isStart;
    private LispOperations randomOperations;
	private long sleepTime;
	private MainPanel mainPanel;
    
    public Producer( Buffer buffer, int n, int m, MainPanel mainPanel) {
        this.buffer = buffer;
        this.isStart = true;
        this.randomOperations = new LispOperations(n,m);
        this.sleepTime = 1000;
        this.mainPanel = mainPanel;
    }
    
    @Override
    public void run() {
       System.out.println("Running producer...");
       //String products = "AEIOU";
       //Random r = new Random(System.currentTimeMillis());
       
       //char product = 0;
       
       while (isStart) {
         //  product = products.charAt(r.nextInt(5));
    	   String product = this.randomOperations.createOperation();
           this.buffer.produce(product);
           System.out.println("Producer produced: " + product);
           mainPanel.addElementToRemainingList("Producer produced: " + product);
          
           try {
               Thread.sleep(this.sleepTime);
           } catch(InterruptedException e) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, e);
           }
       }
    }
    
    public void setCancel() {
    	this.isStart = false;
    }
    
}
