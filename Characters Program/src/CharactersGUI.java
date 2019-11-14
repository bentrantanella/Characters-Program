import javax.swing.*;
import BreezySwing.*;

public class CharactersGUI extends GBFrame {
	
	public static void main(String[] args) {
		JFrame frm = new CharactersGUI();
		frm.setTitle("Longest Non-Decreasing Sequence");
		frm.setSize(300, 300);
		frm.setVisible(true);
	}

	JLabel inputLabel = addLabel("Input a string of words", 1,1,3,1);
	JTextField inputField = addTextField("", 2,1,3,1);
	JButton inputButton = addButton("Input",3,1,1,1);
	JButton clearButton = addButton("Clear",3,2,1,1);
	JButton exitButton = addButton("Exit",3,3,1,1);
	JLabel numofcharactersLabel = addLabel("",4,1,3,1);
	JLabel numofwordsLabel = addLabel("",5,1,3,1);
	
	String input;
	Characters character = new Characters();
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == inputButton) {
			input = inputField.getText();
			
			String newinput = character.removeExtraSpaces(input);
			int numofchar = character.numofCharacters(newinput);
			int numofwords = character.numofWords(newinput);
			
			numofcharactersLabel.setText(numofchar + " characters");
			numofwordsLabel.setText(numofwords + " words");
			
			String[] words = new String[numofwords];
			words = character.findWords(newinput, numofwords);
			JLabel[] wordcounterLabel = new JLabel[numofwords];
			
			int[] wordcount = new int[numofwords];
			
			for (int x = 0; x < words.length; x++) {
				wordcount[x] = character.wordCounter(words, words[x]);
				wordcounterLabel[x] = addLabel(words[x] + "    " + wordcount[x], 6 + x, 1,3,1);
				revalidate();
			}
			
		}
		
		if(buttonObj == clearButton) {
			inputField.setText("");
		}
		 
		if (buttonObj == exitButton) {
			System.exit(1);
		}
	}
}
