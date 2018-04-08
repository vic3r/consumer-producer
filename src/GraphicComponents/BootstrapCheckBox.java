package GraphicComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;

public class BootstrapCheckBox extends JCheckBox {

	private static final long serialVersionUID = 1L;
	private String text = "";
	private Color primaryColor;
	private Color secundaryColor;
	private int iconSize;
	private int borderSize;
	
	public BootstrapCheckBox(String text, Color primary, Color secundary){
		this.text = text;
		this.primaryColor = primary;
		this.secundaryColor = secundary;
		this.iconSize = 20;
		this.borderSize = 1;
		loadCheckBox();
	}
	
	public void loadCheckBox(){
		setText(text);
		setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 16));
		setBorder(BorderFactory.createLineBorder(new Color(201, 208, 232)));
		setForeground(new Color(115,115,115));
		
		loadIcon();
	}
	
	public void loadIcon(){
		setIcon(new BootstrapCheckBoxIcon(primaryColor, secundaryColor, BootstrapCheckBoxIcon.NORMAL, borderSize, iconSize, iconSize));
		setSelectedIcon(new BootstrapCheckBoxIcon(primaryColor, secundaryColor, BootstrapCheckBoxIcon.SELECTED, borderSize, iconSize, iconSize));
		setRolloverIcon(new BootstrapCheckBoxIcon(primaryColor, secundaryColor, BootstrapCheckBoxIcon.ROLLOVER, borderSize, iconSize, iconSize));
		setPressedIcon(new BootstrapCheckBoxIcon(primaryColor, secundaryColor, BootstrapCheckBoxIcon.PRESSED, borderSize, iconSize, iconSize));
		setDisabledIcon(new BootstrapCheckBoxIcon(primaryColor, secundaryColor, BootstrapCheckBoxIcon.DISABLED, borderSize, iconSize, iconSize));
		setDisabledSelectedIcon(new BootstrapCheckBoxIcon(primaryColor, secundaryColor, BootstrapCheckBoxIcon.DISABLED_SELECTED, borderSize, iconSize, iconSize));
		setRolloverSelectedIcon(new BootstrapCheckBoxIcon(primaryColor, secundaryColor, BootstrapCheckBoxIcon.ROLLOVER_SELECTED, borderSize, iconSize, iconSize));
	}
	
	@Override
	public String getText(){
		return text;
	}
	
	@Override
	public void setText(String text){
		this.text = text;
	}
	
	public void setBorderSize(int size){
		borderSize = size;
		loadIcon();
	}
	
	public void setIconSize(int size){
		iconSize = size;
		loadIcon();
	}
	
    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    }

}