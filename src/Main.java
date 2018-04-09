import Screen.MainPanel;
import Utils.AlterFonts;

public class Main {

	public static void main(String[] args) {
		AlterFonts.alterFonts();
				
		MainPanel cpGeneral = new MainPanel();
		cpGeneral.setVisible(true);

	}

}