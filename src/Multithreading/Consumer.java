package Multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Consumer extends Thread {
    private Buffer buffer;
    private int timeInMillis;
    
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
        timeInMillis = 1000;
    }
    
    @Override
    public void run() {
        System.out.println("Running Consumer...");
        char product = 0;
        
        while (true) {
            product = this.buffer.consume();
            System.out.println("Consumer consumed: " + product);
            
            try {
               Thread.sleep(this.timeInMillis);
           } catch(InterruptedException e) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, e);
           }
        } 
    }
    
    public void setTime(int timeInMillis) {
        this.timeInMillis = timeInMillis;
    }
}
