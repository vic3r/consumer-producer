package Screen;

import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import GraphicComponents.BootstrapButton;
import GraphicComponents.BootstrapPanel;
import GraphicPanels.BottomPanel;
import GraphicPanels.TitlePanel;

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

	private BootstrapPanel rangeValues;

	private BootstrapPanel rangeValuesTime;
	
	public MainPanel(){
		super("Programming Languages Project");
		setSize(1200,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		addWindowListener(this);
		
		leadContainer = getContentPane();
		leadContainer.setLayout(null);
		
		initComponents();
		
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
		//END - ARQUIVO
		
		titlePanel = new TitlePanel(new Rectangle(0, 35, 800, 100));
		leadContainer.add(titlePanel);
		
		content = new JPanel();
		content.setBounds(new Rectangle(0,135,800,440));
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
		
		bufferSize = new BootstrapPanel("/Images/fantasma.png", "Buffer Size");
		bufferSize.setBounds(40,180,340,60);
		content.add(bufferSize);
		
		rangeValues = new BootstrapPanel("/Images/fantasma.png", "Values Range (n, m)");
		rangeValues.setBounds(40,260,340,60);
		content.add(rangeValues);
		
		rangeValuesTime = new BootstrapPanel("/Images/timeEnemy.png", "Range Time (ms)");
		rangeValuesTime.setBounds(400, 260,360,60);
		content.add(rangeValuesTime);
		
		jbStop = new BootstrapButton("Stop", BootstrapButton.DANGER_TYPE);
		jbStop.setBounds(590,365,150,50);
		content.add(jbStop);
		
		jbStart = new BootstrapButton("Start", BootstrapButton.SUCCESS_TYPE);
		jbStart.setBounds(420,365,150,50);
		content.add(jbStart);
		
		
		bpPanel = new BottomPanel(new Rectangle(0,575,800,100));
		leadContainer.add(bpPanel);
		
		
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