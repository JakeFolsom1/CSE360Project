package projectCSE360;

import javax.swing.*;

public class FormatGUI extends JApplet {
	public void init(){
		FilePanel fpanel = new FilePanel();
		getContentPane().add(fpanel);
		
		this.setSize(500, 400);
	}
}
