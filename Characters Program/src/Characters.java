
public class Characters {
	public String removeExtraSpaces (String input) {
		String newstring = "";
		
		input = input.trim();
		
		for (int j = 0; j < input.length(); j++) {
			if (input.charAt(j) != ' ')
				newstring = newstring.concat(input.charAt(j) + "");
				
			if (input.charAt(j) == ' ' && input.charAt(j + 1) != ' ')
				newstring = newstring.concat(input.charAt(j) + "");
		}
		
		return newstring;
	}
	
	public int numofCharacters (String str) {
		int counter = 0;
		
		for (int x = 0; x < str.length(); x++) {
			if (str.charAt(x) != ' ')
				counter++;
		}
		
		return counter;
	}
	
	public int numofWords (String str) {
		int counter = 1;
		
		for (int x = 0; x < str.length(); x++) {
			if (str.charAt(x) == ' ')
				counter++;
		}
		
		return counter;
	}
	
	public String[] findWords (String str, int num) {
		String[] words = new String[num];
		int counter = 0;
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == ' ')
				counter++;
			else {
				words[counter] = words[counter].concat(str.charAt(j) + "");
				
			}
		}
		
		return words;
	}
	
}
