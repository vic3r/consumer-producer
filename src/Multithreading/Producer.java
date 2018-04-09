package Multithreading;

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
    
    public Producer( Buffer buffer, int n, int m, MainPanel mainPanel, int sleepTime) {
        this.buffer = buffer;
        this.isStart = true;
        this.randomOperations = new LispOperations(n,m);
        this.sleepTime = sleepTime;
        this.mainPanel = mainPanel;
    }
    
    @Override
    public void run() {
       System.out.println("Running producer...");
       
       while (isStart) {
    	   String product = this.randomOperations.createOperation();
           try {
			this.buffer.produce(product);
           } catch (InterruptedException e1) {
        	   e1.printStackTrace();
           }
           System.out.println("Producer produced: " + product);
           mainPanel.addElementToRemainingList("Producer produced: " + product);
           try {
               Thread.sleep(sleepTime);
           } catch(InterruptedException e) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, e);
           }
       }
    }
    
    public void setCancel() {
    	this.isStart = false;
    }
    
}
