package projectCSE360;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.jnlp.*;

 

public class FilePanel extends JPanel implements ActionListener{
	static private String newline =  "/n";
	private JButton inputButton;
	private JButton outputButton;
	private JTextField wordsProcessedField;
	private JTextField linesField;
	private JTextField blankLinesRemoved;
	private JTextField averageWords;
	private JTextField averageLines;
	private JTextField averageLineLength;
	private JTextArea fact;
	private JLabel wordsProcessedLabel;
	

    public FilePanel() {
        super(new BorderLayout());
	
       fact = new JTextArea(5,20);
       fact.setMargin(new Insets(10,10,10,10));
       fact.setEditable(false);
       JScrollPane logScrollPane = new JScrollPane(fact);
	inputButton = new JButton ("Input a File");
	inputButton.addActionListener(this);
	
	outputButton = new JButton ("Output a File");
	outputButton.addActionListener(this);
	
	
	JPanel buttonPanel = new JPanel();
    buttonPanel.add(inputButton);
    buttonPanel.add(outputButton);

    add(buttonPanel, BorderLayout.PAGE_START);
    add(logScrollPane, BorderLayout.CENTER);
    }
 


	private class ButtonListener implements ActionListener
	{
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()== inputButton)
		{
			FileOpenService fos = null;
			FileContests fileContents = null;
		}
	}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
