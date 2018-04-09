package Multithreading;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 public class Buffer {
    
    private Queue<String> bufferStorage;
    private int bufferLength;
    private int sleepConsumer, sleepProductor;
    
    public Buffer(int length, int sleepConsumer, int sleepProductor) {
       // this.bufferStorage = new LinkedList<>(Arrays.asList(new String[length]));
        this.bufferStorage = new LinkedList<String>();
        this.bufferLength = length;
        this.sleepConsumer = sleepConsumer;
        this.sleepProductor = sleepProductor;
    }
    
    synchronized String consume() {
    	System.out.println(bufferStorage.size());
         while(this.bufferStorage.isEmpty() || this.bufferLength == this.bufferStorage.size()) {
            try {
                wait(1000);
            } catch(InterruptedException e) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        String product = this.bufferStorage.poll();
        notifyAll();
        
        return product;
    }
    
    synchronized void produce(String product) {

        if(!this.bufferStorage.isEmpty()){
               try {
                wait(1000);
            } catch(InterruptedException e) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        this.bufferStorage.add(product);
        
        notifyAll();
    }
    
    private int getStorageLength() {
        int storageLength = this.bufferStorage.size();
        return storageLength;
    }
}
