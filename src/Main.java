import Screen.MainPanel;
import Utils.AlterFonts;

public class Main {

	public static void main(String[] args) {
		AlterFonts.alterFonts();
				
		MainPanel cpGeneral = new MainPanel();
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
