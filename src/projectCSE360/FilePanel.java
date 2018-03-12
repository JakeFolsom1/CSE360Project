package projectCSE360;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FilePanel extends JPanel implements ActionListener {
	private Canvas canvas;
	static private String newline =  "/n";
	private JButton inputButton;
	private JButton outputButton;
	private JButton leftJustification;
	private JButton rightJustification;
	private JTextField wordsProcessedField;
	private JTextField linesField;
	private JTextField blankLinesRemoved;
	private JTextField averageWordsField;
	private JTextField averageLinesField;
	private JPanel filePanel;
	private JPanel buttonPanel;
	private JPanel importPanel;
	private JTextField averageLineLengthField;
	private JTextArea fact;
	private JLabel importedFileName;
	private JLabel wordsProcessedLabel;
	private JLabel averageWordsLabel;
	private JLabel blankLinesRemovedLabel;
	private JLabel linesLabel;
	private JLabel averageLineLengthLabel;
	private JLabel averageLinesLabel;
	private JLabel justificationLabel;
	private File fileSelected;
	
	 public FilePanel() { 
		/*
		 * Note: I need the components left aligned, I am not sure how to go about doing this properly without
		 *  adding a fuckton of layouts, i've tried a lot of different methods go ahead and try it out yourself.  
		 *  
		 *  
		 *   
		 */
		 	fileSelected = null; 
		 	this.setLayout(new FlowLayout(FlowLayout.LEFT));
	    	filePanel = new JPanel();
	    	buttonPanel = new JPanel();
	    	importPanel = new JPanel();
	    	
			wordsProcessedLabel = new JLabel ("Words Processed");
			wordsProcessedField = new JTextField(20);					
			wordsProcessedField.setEditable(false);
			
			linesField = new JTextField(20);
			linesField.setEditable(false);
			linesLabel = new JLabel("Lines");
			
			blankLinesRemovedLabel = new JLabel("Blank Lines Removed");
			blankLinesRemoved = new JTextField(20);
			blankLinesRemoved.setEditable(false);
			
			averageWordsLabel = new JLabel("Average Words Per Line");
			averageWordsField = new JTextField(20);
			averageWordsField.setEditable(false);
			
			averageLineLengthLabel = new JLabel("Average Line Length");
			averageLineLengthField = new JTextField(20);
			averageLineLengthField.setEditable(false);
			
			importedFileName = new JLabel();
			outputButton = new JButton ("Output a File");
			outputButton.addActionListener(this);
	
			inputButton = new JButton("Import");
			inputButton.addActionListener(this);
	
			justificationLabel = new JLabel("Justification:");
			leftJustification = new JButton("Left");
			rightJustification = new JButton("Right");
			
	    	buttonPanel.setLayout(new FlowLayout());
	    	buttonPanel.add(justificationLabel);
	    	buttonPanel.add(leftJustification);
	    	buttonPanel.add(rightJustification);
	    	
	    	importPanel.setLayout(new FlowLayout());
	    	importPanel.add(inputButton);
	    	importPanel.add(importedFileName);
	    	filePanel.setSize(WIDTH, HEIGHT);
	    	filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.PAGE_AXIS));
	    	filePanel.setAlignmentX(LEFT_ALIGNMENT);
	    	filePanel.add(wordsProcessedLabel, BorderLayout.WEST);
	    	filePanel.add(wordsProcessedField);
	    	filePanel.add(linesLabel);
	    	filePanel.add(linesField);
	    	filePanel.add(blankLinesRemovedLabel);
	    	filePanel.add(blankLinesRemoved);
	    	filePanel.add(averageWordsLabel);
	    	filePanel.add(averageWordsField);
	    	filePanel.add(averageLineLengthLabel);
	    	filePanel.add(averageLineLengthField);
	    	filePanel.add(buttonPanel);
	    	filePanel.add(importPanel);
	    	filePanel.add(outputButton);
	    	
	    	add(filePanel);
	    	if(fileSelected != null){   		
	    	try
	    	{
	    	BufferedReader reader = new BufferedReader(new FileReader(fileSelected));
	    	}
	    	catch(Exception ex)
	    	{
	    		System.out.println("We encountered an error while parsing your file");
	    	}	
	    }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputButton)
		{
	//TODO: Test against missing filetypes, jfc wrapper should prevent this but nest in try{} catch{} later for bad file types
			
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Select a .txt file");
			jfc.setAcceptAllFileFilterUsed(false);
			jfc.setMultiSelectionEnabled(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files only", "txt");
			jfc.addChoosableFileFilter(filter);
			int returnValue = jfc.showDialog(null,"Import .txt file!");
			if(returnValue == JFileChooser.APPROVE_OPTION){
				fileSelected = jfc.getSelectedFile();
				System.out.println("File Found at " + fileSelected.getPath());
		    		importedFileName.setText(fileSelected.getName());
				/*
				 * 
				 * TODO: WE REALLY NEED TO ADD FUNCTIONALITY TO WHERE I CAN ACTUALLY CHECK BUFFER
				 * 
				 * 
				 */
			}
		}
	}

	
	
	
	
	
	
	
	
	
}
