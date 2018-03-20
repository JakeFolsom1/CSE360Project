1.1 Introduction

This is the user guide for group 6’s project for CSE360. This includes an overview of the functionality of the software, an installation guide, a beginner’s guide, as well as a description of the user interface and samples for the functionality of the software.
1.2 Overview

This program formats text files. Specifically, it allows the user to specify an input and output file and select justification for the output. The output file is formatted with 80 characters per line with words separated by a single space. As many words appear on a line as possible, with no partial words or blank lines.
During the formatting, analysis of the process is shown by the program. Additional information is given by the program after the input file has been processed. This includes the number of words processed, the number of lines, the number of bank lines removed, the average number of words per line, and the average line length.












2.1 Installation

Ensure that your computer has the current version of the Java Runtime Environment. (downloads here: http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
Download the newest version of our program from the internet.
Double click on the .jar file to run it.

2.2 Getting Started

Specify the input and output files to be processed.
Click the run button.
Watch the analysis as your file is formatted.
View the additional data provided by the program.
Enjoy your beautiful formatted text document.













3.1 UI Design
		 	
The text file modifier will feature an import option, a count of how many lines were removed/the average number of words per line. In addition to this, the software will be include a count of words processed in the text file as well as how many lines are in the text file. The software will include a justification option where users can left/right justify text content. 
4.1 Input/Output Format

The input for the software will be text files with the .txt file extension, the output will be placed in another .txt file chosen by the user. Files of extension .docx or any other file extension will not be compatible with the software. 

4.2 Example run descriptions

In  general cases, extra spaces and blank lines will be removed from the input file, leaving each line with 80 characters and only spaces between words and at the end of lines. Words will not be cut off if their length would cause the length of the line to exceed 80 characters, the word will simply be moved to the next line
An error message will appear if a user tries to use an invalid file format to import or export. Empty text files will run the same as a text file with text in it, and files that are already formatted correctly will also not cause a special case.
Special conditions include when a word is over 80 characters, in that case the entire word must be printed on a single line. This means that the line will not be justified with the other lines if right justification is chosen by the user, and the line will stick out.













5.1 Sample input and output files
Below are two examples of the software running:
Left justification selected


Right justification selected



6.1 Glossary

Java Runtime Environment (JRE): “The Java Runtime Environment (JRE) is a set of software tools for development of Java applications. It combines the Java Virtual Machine (JVM), platform core classes and supporting libraries.” - technopedia.com
File formats: “A file format refers to the way data are arranged logically within a file. File formatting allows a program to retrieve data, correctly interpret the information and continue with processing. “ - technopedia.com
.jar files: “java archive (JAR) is a file format that contains bundled Java class files along with associated image/sound files, resources and metadata. It is usually a single, compressed file mostly used for supplying the necessary Java libraries and application software on a Java programming platform.” - technopedia.com
.txt files: “A text file is a type of digital, non-executable file that contains letters, numbers, symbols and/or a combination. It enables the creation and storage of text without any special formatting.” - technopedia.com










