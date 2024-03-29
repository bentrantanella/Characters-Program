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
	JTextArea outputArea = addTextArea("", 6,1,3,5);
	
	public CharactersGUI() {
		clearButton.setEnabled(false);
	}
	String input;
	Characters character = new Characters();
	
	int inputcounter = 0;
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == inputButton) {
			outputArea.setText("");
			String output = "";
			
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
			
			output = output.concat(numofchar + " characters" + "\n");
			
			String[] words = new String[numofwords];
			words = character.findWords(newinput, numofwords);
			
			int realwords = 0;
			for (int b = 0; b < words.length; b++) {
				if (words[b].equals("") == false)
						realwords++;
			}
			
			if (realwords == 1)
				output = output.concat(realwords + " word" + "\n");
			else output = output.concat(realwords + " words" + "\n");
			
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

			int counter = 0;
			for(int j = 0; j < norepeats.length; j++) {
				if (norepeats[j] == null || norepeats[j].contentEquals("") == true)
					continue;
				
				for(int i = 0; i < words.length; i++) {
					if (norepeats[j].equals(words[i]) == true )
						counter++;
				}
				output = output.concat(norepeats[j] + "    " + counter + "\n");
				counter = 0;
			}
			
			outputArea.setText(output);
		}
		
		if(buttonObj == clearButton) {
			inputField.setText("");
			outputArea.setText("");
			clearButton.setEnabled(false);
		}
		
		if (buttonObj == exitButton) {
			System.exit(1);
		}
	}
}
