import javax.swing.*;
import BreezySwing.*;

public class CharactersGUI extends GBFrame {
	
	public static void main(String[] args) {
		JFrame frm = new CharactersGUI();
		frm.setTitle("Longest Non-Decreasing Sequence");
		frm.setSize(400, 400);
		frm.setVisible(true);
	}

	JLabel inputLabel = addLabel("Input a string of words", 1,1,3,1);
	JTextField inputField = addTextField("", 2,1,3,1);
	JButton inputButton = addButton("Input",3,1,1,1);
	JButton clearButton = addButton("Clear",3,2,1,1);
	JButton exitButton = addButton("Exit",3,3,1,1);
	JLabel numofcharactersLabel = addLabel("",4,1,3,1);
	JLabel numofwordsLabel = addLabel("",5,1,3,1);
	
	public CharactersGUI() {
		clearButton.setEnabled(false);
	}
	String input;
	Characters character = new Characters();
	JLabel[] wordcounterLabel;
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == inputButton) {
			
			input = inputField.getText();
			
			String newinput = character.removeExtraSpaces(input);
			int numofchar = character.numofCharacters(newinput);
			try {
				character.errorCheck(numofchar);
			} catch (InvalidInput e) {
				messageBox(e.getMessage());
				inputField.setText("");
				return;
			}
			clearButton.setEnabled(true);
			int numofwords = character.numofWords(newinput);
			
			numofcharactersLabel.setText(numofchar + " characters");
			
			String[] words = new String[numofwords];
			words = character.findWords(newinput, numofwords);
			
			int realwords = 0;
			for (int b = 0; b < words.length; b++) {
				if (words[b].equals("") == false)
						realwords++;
			}
			
			if (realwords == 1)
				numofwordsLabel.setText(realwords + " word");
			else numofwordsLabel.setText(realwords + " words");
			
			String[] newwords = new String[realwords];
			int bounter = 0;
			for(int c = 0; c < words.length; c++) {
				if (words[c].contentEquals("") == false) {
					newwords[bounter] = words[c];
					bounter++;
				}
			}
			if (realwords == 0)
				return;
			String[] norepeats = new String[realwords];
			
			norepeats = character.noRPT(norepeats, newwords);
			
			wordcounterLabel = new JLabel[norepeats.length];
			int counter = 0;
			for(int j = 0; j < norepeats.length; j++) {
				if (norepeats[j] == null || norepeats[j].contentEquals("") == true)
					continue;
				
				for(int i = 0; i < words.length; i++) {
					if (norepeats[j].equals(words[i]) == true )
						counter++;
				}
				
				wordcounterLabel[j] = addLabel(norepeats[j] + "   " + counter, 6 + j, 1,3,1);
				revalidate();
			
				counter = 0;
			}
		}
		
		if(buttonObj == clearButton) {
			inputField.setText("");
			numofcharactersLabel.setText("");
			numofwordsLabel.setText("");
			try {
				for (int j = 0; j < wordcounterLabel.length; j++) {
					wordcounterLabel[j].setText("");
					revalidate();
				}
			} catch (Exception e) {
				return;
			}
		}
		
		if (buttonObj == exitButton) {
			System.exit(1);
		}
	}
}
