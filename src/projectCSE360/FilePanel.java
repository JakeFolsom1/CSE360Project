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
	private String[][] wordArray; 
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
	private JPanel exportPanel;
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
	private JLabel errorLabel; 
	private JLabel exportedFileName;
	private File importedFileSelected;
	private File exportFileSelected;
	private ArrayList[][] wordsList = new ArrayList[0][0];
	public FilePanel() { 
		/*
		 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
		 *	Below is the Code for the GUI, TODO's will be listed below for work with the GUI
		 *	TODO: FIX THE ALIGNMENT ON THE GUI
		 *	TODO: ACTIONLISTENERS FOR BUTTONS
		 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
		 */

		exportFileSelected = null;
		importedFileSelected = null; 
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

		errorLabel = new JLabel(" ");
		errorLabel.setForeground(Color.red);

		importPanel.setLayout(new FlowLayout());
		importPanel.add(inputButton);
		importPanel.add(importedFileName);

		exportedFileName = new JLabel();
		exportPanel = new JPanel();
		exportPanel.setLayout(new FlowLayout());
		exportPanel.add(outputButton);
		exportPanel.add(exportedFileName);

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
		filePanel.add(exportPanel);
		filePanel.add(errorLabel);
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
			 *	TODO: Move logic to seperate classes
			 *
			 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
			 */
			ArrayList<String[]> listOfWords = new ArrayList<String[]>();
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Select a .txt file for import");
			jfc.setAcceptAllFileFilterUsed(false);
			jfc.setMultiSelectionEnabled(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files only", "txt");
			jfc.addChoosableFileFilter(filter);
			int returnValue = jfc.showDialog(null,"Import .txt file!");
			if(returnValue == JFileChooser.APPROVE_OPTION){
				importedFileSelected = jfc.getSelectedFile();
				System.out.println("File Found at " + importedFileSelected.getPath());
				importedFileName.setText(importedFileSelected.getName());
				try {
					String tempWord;
					int lineCount = 0;
					int WordCount = 0;
					FileReader in = new FileReader(importedFileSelected);
					Scanner scan = new Scanner(importedFileSelected);
					Scanner scan2 = new Scanner(importedFileSelected);
					while(scan.hasNext())		//Counts the words in the .txt file used to form the X axis of the 2D array
					{
						scan.next();
						WordCount++;
					}
					while(scan2.hasNextLine())		//Counts the lines of the .txt file, used to form the Y axis of the 2D array
					{
						scan2.nextLine();
						lineCount++;
					}
					int wordsInLine = 0;
					int numberOfLines = 0;
					wordsProcessedField.setText(Integer.toString(WordCount));
					linesField.setText(Integer.toString(lineCount));
					wordArray = new String[WordCount][lineCount];
					while(scan.hasNext())		//This will be used to define the new file format, we will copy words into a 2D array then count # of words
					{
						String name = scan.next();
						if( name.equals(" ")){
							
						}
						else if(currentLineLength(wordsInLine,numberOfLines) + name.length() < 80){
							wordArray[wordsInLine][numberOfLines] = name; 
							wordsInLine++;
						}
						else{
							numberOfLines++;
							wordsInLine = 0;
							wordArray[wordsInLine][numberOfLines] = name;
						}
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		if(e.getSource() == outputButton)
		{
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Select a .txt file for export");
			jfc.setAcceptAllFileFilterUsed(false);
			jfc.setMultiSelectionEnabled(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files only", "txt");
			jfc.addChoosableFileFilter(filter);
			int returnValue = jfc.showDialog(null,"export .txt file!");
			if(returnValue == JFileChooser.APPROVE_OPTION){
				exportFileSelected = jfc.getSelectedFile();
				exportedFileName.setText(exportFileSelected.getName());
				if((exportFileSelected.getPath().compareTo(importedFileSelected.getPath()) == 0))
				{
					System.out.println("File Found at " + exportFileSelected.getPath());
					errorLabel.setText("Error: You cannot export to the same file");
				}	
				else
				{
					/* \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
					 *	Take 2D array and then allow exporting into the system.
					 * \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ */
					System.out.println("Exported Successfully");
					errorLabel.setText(" ");
				}
			}

		}

	}

}









