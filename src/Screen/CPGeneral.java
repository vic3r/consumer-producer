package Screen;

import java.awt.Color;
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
import GraphicComponents.BootstrapCheckBox;
import GraphicPanels.BottomPanel;
import GraphicPanels.TitlePanel;

public class CPGeneral extends JFrame implements ActionListener, WindowListener{
	
	private static final long serialVersionUID = 1L;

	private JMenuBar barMenu;
	private JMenu endBarMenu;
	private JMenuItem barMenuItem;
	
	static Container C;

	private BootstrapCheckBox jcb;
	private BootstrapButton jb2;
	private BootstrapButton jb1;
	private BottomPanel bp;
	private BootstrapPanel jpEmail;
	private BootstrapPanel noConsumers;
	private BootstrapPanel noProducers;
	private JPanel content;
	private TitlePanel tp;
	
	public CPGeneral(){
		super("Programming Languages Project");
		setSize(1200,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		//setResizable(false);
		//setLayout(null);
		addWindowListener(this);
		
		C = getContentPane();
		C.setLayout(null);
		
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
				
				for(Component c: C.getComponents()){
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
		C.add(barMenu);
		
		//BEGIN - ARQUIVO
		endBarMenu = new JMenu("PPCDSALVC");
		barMenu.add(endBarMenu);
		
		barMenuItem = new JMenuItem("Sair");
		barMenuItem.addActionListener(this);
		endBarMenu.add(barMenuItem);
		//END - ARQUIVO
		
		tp = new TitlePanel(new Rectangle(0, 35, 800, 100));
		C.add(tp);
		
		content = new JPanel();
		content.setBounds(new Rectangle(0,135,800,340));
		content.setLayout(null);
		C.add(content);
		
		noProducers = new BootstrapPanel("/Images/pacman.png", "No. Producers");
		noProducers.setBounds(40,20,340,60);
		content.add(noProducers);
		
		noConsumers = new BootstrapPanel("/Images/fantasma.png", "No. Consumers");
		noConsumers.setBounds(400,20,340,60);
		content.add(noConsumers);
		
		jpEmail = new BootstrapPanel("/Images/mail.png", "E-Mail");
		jpEmail.setBounds(40,100,700,60);
		content.add(jpEmail);
		
		jcb = new BootstrapCheckBox("Send me promotions and offers", new Color(138, 147, 179), new Color(114, 132, 193));
		jcb.setBounds(40,180,700,60);
		content.add(jcb);
		
		jb2 = new BootstrapButton("Reset", BootstrapButton.DANGER_TYPE);
		jb2.setBounds(590,265,150,50);
		content.add(jb2);
		
		jb1 = new BootstrapButton("Submit", BootstrapButton.SUCCESS_TYPE);
		jb1.setBounds(420,265,150,50);
		content.add(jb1);
		
		bp = new BottomPanel(new Rectangle(0,475,800,100));
		C.add(bp);
		
		
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