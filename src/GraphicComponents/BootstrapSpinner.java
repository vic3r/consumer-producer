package GraphicComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import GraphicImage.CustomImageIcon;

public class BootstrapSpinner extends JPanel{
	private static final long serialVersionUID = 1L;
	private JSpinner spinner;
	private JLabel label;
	
	private String iconPath;
	private int height;
	
	public BootstrapSpinner(String iconPath) {
		setBackground(new Color(201, 208, 232));
		this.iconPath = iconPath;
		setLayout(null);
		
		loadFormField();
	}
	
	private void loadFormField(){
		removeAll();
		
		height = this.getHeight() - 4;
		
		spinner = new JSpinner();
		spinner.setBounds(2, 2, getWidth() - (height + 2), height);
		spinner.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
		spinner.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, (height / 2)));
		spinner.setForeground(new Color(154, 154, 154));
		add(spinner);
		
		label = new JLabel();
		label.setBounds(getWidth() - height, 2, height, height);
		label.setBackground(new Color(220, 220, 220));
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		
		setIcon(iconPath);
	}
	
	@Override
	public void setFont(Font font) {
		if(spinner != null)
			spinner.setFont(font);
	}
	
	public int getValue(){
		return (int) spinner.getValue();
	}
	
	
	public void setIcon(String iconPath){
		label.setIcon(new CustomImageIcon(iconPath, "Spinner", (height / 2), (height / 2)));
	}
	
	@Override
	public void setForeground(Color color){
		if(spinner != null)
			spinner.setForeground(color);
	}
	
	@Override
	public void setBounds(Rectangle bounds){
		super.setBounds(bounds);
		loadFormField();
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height){
		super.setBounds(x, y, width, height);
		loadFormField();
	}
	
	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		loadFormField();
	}
	
	@Override
	public void setSize(Dimension d) {
		super.setSize(d);
		loadFormField();
	}
}
