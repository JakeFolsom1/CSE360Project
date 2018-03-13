package projectCSE360;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
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
	private ArrayList[][] wordsList = new ArrayList[0][0];
	 public FilePanel() { 
		/*
		 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
		 *	Below is the Code for the GUI, TODO's will be listed below for work with the GUI
		 *	TODO: FIX THE ALIGNMENT ON THE GUI
		 *	TODO: ACTIONLISTENERS FOR BUTTONS
		 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
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
	    	
			/*
			 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
			 *	Depreciated code, keeping it here for bug testing on file selection it has no other purpose in life
			 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
			 */
//	    	if(fileSelected != null){   		
//	    	try
//	    	{
//	    	BufferedReader reader = new BufferedReader(new FileReader(fileSelected));
//	    	}
//	    	catch(Exception ex)
//	    	{
//	    		System.out.println("We encountered an error while parsing your file");
//	    	}	
//	    }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputButton)
		{
			/*
			 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
			 *	Below is the code for most of the action that happens behind the scenes (AKA Backend) TODO will be listed below
			 *	TODO: Fix handling for input
			 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
			 */
			ArrayList<String[]> listOfWords = new ArrayList<String[]>();
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
		    		try {
		    			String tempWord;
		    			int lineCount = 0;
		    			int WordCount = 0;
						FileReader in = new FileReader(fileSelected);
						BufferedReader br = new BufferedReader(in);
						Scanner scan = new Scanner(fileSelected);
						while(scan.hasNext())		//Counts the words in the .txt file used to form the X axis of the 2D array
						{
							scan.next();
							WordCount++;
						}
						while(scan.hasNextLine())		//Counts the lines of the .txt file, used to form the Y axis of the 2D array
						{
							scan.nextLine();
							lineCount++;
						}
						String[][] wordArray = new String[WordCount][lineCount];							//Define the array here :)
						while(scan.hasNext())		//This will be used to define the new file format, we will copy words into a 2D array then count # of words
						{
							int x = 0;
							int y = 0;
							tempWord = scan.next();
						}
						wordsProcessedField.setText(Integer.toString(WordCount));
						linesField.setText(Integer.toString(lineCount));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
			}
		}
	}

	
	
	
	
	
	
	
	
	
}
