package Screen;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DebugGraphics;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GraphicComponents.BootstrapButton;
import GraphicComponents.BootstrapPanel;
import GraphicPanels.BottomPanel;
import GraphicPanels.TitlePanel;
import Multithreading.Buffer;
import Multithreading.Consumer;
import Multithreading.Producer;

public class MainPanel extends JFrame implements ActionListener, WindowListener{
	
	private static final long serialVersionUID = 1L;

	private JMenuBar barMenu;
	private JMenu endBarMenu;
	private JMenuItem barMenuItem;
	
	static Container leadContainer;

	private BootstrapButton jbStop;
	private BootstrapButton jbStart;
	private BottomPanel bpPanel;
	private BootstrapPanel noConsumers;
	private BootstrapPanel timeProducers;
	private BootstrapPanel noProducers;
	private JPanel content;
	private TitlePanel titlePanel;
	private BootstrapPanel timeConsumers;
	private BootstrapPanel bufferSize;
	private BootstrapPanel valuesN;
	private BootstrapPanel valuesM;
	
	private ArrayList<Producer> producers;
	private ArrayList<Consumer> consumers;
	private Buffer buffer;

	private DefaultListModel<String> modelRemainingTasks;

	private DefaultListModel modelCompletedTasks;

	private JList<String> listRemainingOps;

	private JList<String> listRemainingOps2;

	private JList listCompletedOps;

	private JScrollPane completedOpsPanel;
	
	public MainPanel(){
		super("Programming Languages Project");
		setSize(1200,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		addWindowListener(this);
		
		leadContainer = getContentPane();
		leadContainer.setLayout(null);
		
		this.producers = new ArrayList<>();
		this.consumers = new ArrayList<>();
		
		initComponents();
		addButtonEvents();
		
		
		this.addComponentListener(new ComponentListener() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				
				for(Component c: leadContainer.getComponents()){
					//System.out.println(c.getClass().getSimpleName());
					if(
							c.getClass().getSimpleName().equals("JMenuBar") ||
							c.getClass().getSimpleName().equals("RainbowPanel") ||
							c.getClass().getSimpleName().equals("TitlePanel") ||
							c.getClass().getSimpleName().equals("BottomPanel"))
						c.setSize(getWidth(), c.getHeight());
				}
				
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void initComponents(){
		barMenu = new JMenuBar();
		barMenu.setBounds(0, 0, 800, 20);
		leadContainer.add(barMenu);
		
		//BEGIN - ARQUIVO
		endBarMenu = new JMenu("PPCDSALVC");
		barMenu.add(endBarMenu);
		
		barMenuItem = new JMenuItem("Sair");
		barMenuItem.addActionListener(this);
		endBarMenu.add(barMenuItem);
		
		titlePanel = new TitlePanel(new Rectangle(0, 35, 800, 100));
		leadContainer.add(titlePanel);
		
		content = new JPanel();
		content.setBounds(new Rectangle(0,135,1100,440));
		content.setLayout(null);
		leadContainer.add(content);
		
		noProducers = new BootstrapPanel("/Images/pacman.png", "No. Producers");
		noProducers.setBounds(40,20,340,60);
		content.add(noProducers);
		
		timeProducers = new BootstrapPanel("/Images/timeGood.png", "Time producers (ms)");
		timeProducers.setBounds(400,20,360,60);
		content.add(timeProducers);
		
		noConsumers = new BootstrapPanel("/Images/fantasma.png", "No. Consumers");
		noConsumers.setBounds(40,100,340,60);
		content.add(noConsumers);
		
		timeConsumers = new BootstrapPanel("/Images/timeEnemy.png", "Time consumers (ms)");
		timeConsumers.setBounds(400,100,360,60);
		content.add(timeConsumers);
		
		bufferSize = new BootstrapPanel("/Images/buffer.png", "Buffer Size");
		bufferSize.setBounds(40,180,340,60);
		content.add(bufferSize);
		
		valuesN = new BootstrapPanel("/Images/number.png", "Value n");
		valuesN.setBounds(40,260,340,60);
		content.add(valuesN);
		
		valuesM = new BootstrapPanel("/Images/timeValues.png", "Value m");
		valuesM.setBounds(400, 260,360,60);
		content.add(valuesM);
		
		jbStop = new BootstrapButton("Stop", BootstrapButton.DANGER_TYPE);
		jbStop.setBounds(590,365,150,50);
		content.add(jbStop);
		
		jbStart = new BootstrapButton("Start", BootstrapButton.SUCCESS_TYPE);
		jbStart.setBounds(420,365,150,50);
		content.add(jbStart);
		
		JLabel remaining = new JLabel("Remaining tasks");
		remaining.setBounds(900,-30,200,100);
		remaining.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 15));
		remaining.setForeground(new Color(115,115,115));
		content.add(remaining);
		
		
		modelRemainingTasks = new DefaultListModel<>();
		
		listRemainingOps = new JList<>(modelRemainingTasks); 
		
		JScrollPane remainingOpsPanel = new JScrollPane(listRemainingOps);
		remainingOpsPanel.setBounds(800,30,300,180);
		content.add(remainingOpsPanel);
		
		JLabel completed = new JLabel("Completed tasks");
		completed.setBounds(900,175,200,100);
		completed.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 15));
		completed.setForeground(new Color(115,115,115));
		content.add(completed);
		
		modelCompletedTasks = new DefaultListModel<>();
		listCompletedOps = new JList<>(modelCompletedTasks); 
		modelCompletedTasks.addElement("Holi");
		
		completedOpsPanel = new JScrollPane(listCompletedOps);
		completedOpsPanel.setBounds(800,240,300,180);
		content.add(completedOpsPanel);
		
		
		bpPanel = new BottomPanel(new Rectangle(0,575,800,100));
		leadContainer.add(bpPanel);
		
	}
	
	public void addElementToRemainingList(String remainingElement) {
		modelRemainingTasks.addElement(remainingElement);
	}
	
	public void removeElementOfRemainingList() {
		int indexToRemove = 1;
		
		if(modelRemainingTasks.getElementAt(0) != null) {
			indexToRemove = 0; 
		}
		modelRemainingTasks.removeElementAt(indexToRemove);
		
	}
	
	public void addElementToCompletedList(String completedTask) {
		modelCompletedTasks.addElement(completedTask);
	}
	
	public void addButtonEvents() {
		
		jbStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					
					try {
						int producersQuantity = Integer.parseInt(noProducers.getText());
						int consumersQuantity = Integer.parseInt(noConsumers.getText());
						int waitTimeProducers = Integer.parseInt(timeProducers.getText());
						int waitTimeConsumers = Integer.parseInt(timeConsumers.getText());
						
						int bufferLength = Integer.parseInt(bufferSize.getText());
						
						buffer = new Buffer(bufferLength, waitTimeConsumers, waitTimeProducers);
						
						int n = Integer.parseInt(valuesN.getText());
						int m = Integer.parseInt(valuesM.getText());
						
						createProducer(producersQuantity, waitTimeProducers, n, m);
						createConsumer(consumersQuantity, waitTimeConsumers);
						
					} catch(Exception except) {
						JOptionPane.showMessageDialog(null, "Type only Integer positive digits");
					}
					
				}
			});
		
		jbStop.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Producer producer: producers) {
					producer.stop();
				}
				for(Consumer consumer: consumers) {
					consumer.stop();
				}
			}
		});
	}
	
	public boolean createProducer (int sizeProducers, int timeProducers, int n, int m) {
		while(sizeProducers != 0) {
			Producer producer = new Producer(buffer, n, m, this);
			producers.add(producer);
			producer.start();
			
			
			try {
				Thread.sleep(timeProducers);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return false;
			}
			sizeProducers--;
		}
		
		return sizeProducers == 0? true : false;
	}
	
	public boolean createConsumer (int sizeConsumers, int timeConsumers) {
		while(sizeConsumers!= 0) {
			Consumer consumer = new Consumer(buffer, this);
			consumers.add(consumer);
			consumer.start();
			try {
				Thread.sleep(timeConsumers);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return false;
			}
			sizeConsumers--;
		}
		
		return sizeConsumers == 0? true : false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(Component i :getContentPane().getComponents()){
			if(!i.equals(barMenu))
				i.setVisible(false);
		}
		
		if(e.getSource().equals(barMenuItem)){
			System.exit(EXIT_ON_CLOSE);
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent arg0) {}

	@Override
	public void windowDeactivated(WindowEvent arg0) {}

	@Override
	public void windowDeiconified(WindowEvent arg0) {}

	@Override
	public void windowIconified(WindowEvent arg0) {}
	
	@Override
	public void windowOpened(WindowEvent arg0) {}
}