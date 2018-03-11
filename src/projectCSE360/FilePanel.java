import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

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
<<<<<<< Updated upstream
=======
	private JPanel filePanel;
	private JPanel buttonPanel;
	private JPanel leftPanel;
>>>>>>> Stashed changes
	private JTextField averageLineLengthField;
	private JTextArea fact;

	private JLabel wordsProcessedLabel;
	private JLabel averageWordsLabel;
	private JLabel blankLinesRemovedLabel;
	private JLabel linesLabel;
	private JLabel averageLineLengthLabel;
	private JLabel averageLinesLabel;
<<<<<<< Updated upstream
	//FileProcessed file;
	
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
	
	wordsProcessedLabel = new JLabel ("Words Processed");
	wordsProcessedField = new JTextField(20);
	
	averageWordsLabel = new JLabel("Average Words");
	averageWordsField = new JTextField(20);
	
	lol;
=======
	private JLabel justificationLabel;
	
	 public FilePanel() { 
		/*
		 * Note: I need the components left aligned, I am not sure how to go about doing this properly without
		 *  adding a fuckton of layouts, i've tried a lot of different methods go ahead and try it out yourself.  
		 *  
		 *  
		 *   
		 */
		 
		 	this.setLayout(new FlowLayout(FlowLayout.LEFT));
	    	filePanel = new JPanel();
	    	buttonPanel = new JPanel();
	    	
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
			
			outputButton = new JButton ("Output a File");
			outputButton.addActionListener(this);
>>>>>>> Stashed changes
	
			inputButton = new JButton("Import");
			justificationLabel = new JLabel("Justification:");
			leftJustification = new JButton("Left");
			rightJustification = new JButton("Right");
			
	    	buttonPanel.setLayout(new FlowLayout());
			buttonPanel.add(inputButton, BorderLayout.WEST);
	    	buttonPanel.add(justificationLabel);
	    	buttonPanel.add(leftJustification);
	    	buttonPanel.add(rightJustification);
	    	
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
	    	filePanel.add(outputButton);
	    	
	    	add(filePanel);
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub ADD METHODS HERE~~~~!!!!!
		
	}

	
	
	
	
	
	
	
	
	
}
