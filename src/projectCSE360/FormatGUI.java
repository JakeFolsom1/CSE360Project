package projectCSE360;

import javax.swing.JFrame;


public class FormatGUI {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame ("File Formatted");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FilePanel panel = new FilePanel();
		frame.getContentPane().add(panel);
		
		
		
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	
}
