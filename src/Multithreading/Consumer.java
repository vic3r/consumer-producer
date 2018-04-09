package Multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

import Screen.MainPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Consumer extends Thread {
    private Buffer buffer;
	private long sleepTime;
	private MainPanel mainPanel;
    
    public Consumer(Buffer buffer, MainPanel mainPanel, int sleepTime) {
        this.buffer = buffer;
        this.sleepTime = sleepTime;
        this.mainPanel = mainPanel;
    }
    
    @Override
    public void run() {
        System.out.println("Running Consumer...");
        String product;
        
        while (true) {
            try {
				product = this.buffer.consume();
			
            if (product != null) {
            	double result = getResult(product);
            	System.out.println("Consumer consumed: " + result); 
	            mainPanel.removeElementOfRemainingList();
	            mainPanel.addElementToCompletedList(product+"= "+result);
            	}
            } catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}try {
	               Thread.sleep(this.sleepTime);
	           } catch(InterruptedException e) {
	                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, e);
	           }
           }
        
       
    }
    
    public double getResult(String product) {
    	String[] result = product.split("\\s+");
    	String operand = result[0]; 
    	Double valueToShow = 0.0;
    	switch(operand.charAt(0)) {
	    	case '+':
	    		valueToShow = (double) (Integer.parseInt(result[1]) + Integer.parseInt(result [2]));
	    		break;
	    	case '-':
	    		valueToShow = (double) (Integer.parseInt(result[1]) - Integer.parseInt(result [2]));
	    		break;
	    	case '*':
	    		valueToShow = (double) (Integer.parseInt(result[1]) * Integer.parseInt(result [2]));
	    		break;
	    	case '/':
	    		valueToShow = Double.parseDouble(result[1]) / Double.parseDouble(result [2]);
	    		break;
    	}
    	
    	return valueToShow;
    }
}
