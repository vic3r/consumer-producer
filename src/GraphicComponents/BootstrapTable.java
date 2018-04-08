package GraphicComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;

public class BootstrapTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int height;

	private JLabel label;
	
	public BootstrapTable() {
		// TODO Auto-generated constructor stub
		
		setBackground(new Color(201, 208, 232));
		height = this.getHeight() - 4;
		
		this.setBounds(2, 2, getWidth() - (height + 2), height);
		this.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
		this.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, (height / 2)));
		this.setForeground(new Color(154, 154, 154));
		this.setName("Tasks");
	}

}
