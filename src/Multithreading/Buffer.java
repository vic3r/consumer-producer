package Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import Screen.MainPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 public class Buffer {
    
    private Queue<String> bufferStorage;
    private int bufferLength;
    private int sleepConsumer, sleepProductor;
    private int consumerOperations, producerOperations;
    private MainPanel mainPanel;
    
    public Buffer(int length, int sleepConsumer, int sleepProductor, MainPanel mainPanel) {
       // this.bufferStorage = new LinkedList<>(Arrays.asList(new String[length]));
        this.bufferStorage = new LinkedList<String>();
        this.bufferLength = length;
        this.sleepConsumer = sleepConsumer;
        this.sleepProductor = sleepProductor;
        this.consumerOperations = 0;
        this.producerOperations = 0;
        this.mainPanel = mainPanel;
    }
    
    synchronized String consume() {
    	System.out.println(bufferStorage.size());
         while(this.bufferStorage.isEmpty() || this.bufferLength == this.bufferStorage.size()) {
            try {
                wait(sleepConsumer);
            } catch(InterruptedException e) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        String product = this.bufferStorage.poll();
        consumerOperations++;
        producerOperations--;
        mainPanel.addRemainingCounter(producerOperations);
        mainPanel.addCompletedCounter(consumerOperations);
        
        notifyAll();
        
        return product;
    }
    
    synchronized void produce(String product) {

        if(!this.bufferStorage.isEmpty()){
               try {
                wait(sleepProductor);
            } catch(InterruptedException e) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        this.bufferStorage.add(product);
        producerOperations++;
        mainPanel.addRemainingCounter(producerOperations);
        mainPanel.addRemainingDividedByBufferSize(producerOperations, bufferLength);
        
        
        notifyAll();
    }
    
}
