import Screen.CPGeneral;
import Utils.AlterFonts;

public class Main {

	public static void main(String[] args) {
		AlterFonts.alterFonts();
				
		CPGeneral cpGeneral = new CPGeneral();
		cpGeneral.setVisible(true);
		//ProducerConsumer produceConsumer = new ProducerConsumer();
		//     Buffer buffer = new Buffer();
		    
		//    
		//    Producer producer = new Producer(buffer);
		//    producer.start();
		//    
		//    Consumer consumer = new Consumer(buffer);
		//    consumer.start();

	}

}
