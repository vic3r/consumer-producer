package Multithreading;

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
    
    private Queue<Character> bufferStorage;
    
    public Buffer() {
        this.bufferStorage = new LinkedList<Character>();
    }
    
    synchronized char consume() {
         if(this.bufferStorage.isEmpty()) {
            try {
                wait(1000);
            } catch(InterruptedException e) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        char product = this.bufferStorage.poll();
        notifyAll();
        
        return product;
    }
    
    synchronized void produce(char product) {

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
