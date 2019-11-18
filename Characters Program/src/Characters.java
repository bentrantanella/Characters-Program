
public class Characters {
	
	public String removeExtraSpaces (String input) {
		String newstring = "";
		
		input = input.trim();
		
		for (int j = 0; j < input.length(); j++) {
			if (input.charAt(j) != ' ' || input.charAt(j) != '\t')
				newstring = newstring.concat(input.charAt(j) + "");
				
			if ((input.charAt(j) == ' ' || input.charAt(j) == '\t') && (input.charAt(j + 1) != ' ' || input.charAt(j) != '\t'))
				newstring = newstring.concat(input.charAt(j) + "");
		}
		
		return newstring;
	}
	
	public int numofCharacters (String str) {
		int counter = 0;
		
		for (int x = 0; x < str.length(); x++) {
			if (str.charAt(x) != ' ' && str.charAt(x) != '\t')
				counter++;
		}
		
		return counter;
	}
	
	public int numofWords (String str) {
		int counter = 1;
		
		for (int x = 0; x < str.length(); x++) {
			if (str.charAt(x) == ' ' || str.charAt(x) == '\t')
				counter++;
			
		}
		
		return counter;
	}
	
	public String[] findWords (String str, int num) {
		String[] words = new String[num];
		int counter = 0, start = 0, end = 0;
		for (int j = 0; j < str.length(); j++) {
			if (j == str.length() - 1) {
				if (str.charAt(str.length() - 1)=='.' || str.charAt(str.length() - 1)=='?' || str.charAt(str.length() - 1)=='!') {
					words[counter] = str.substring(start, str.length() - 1);
					words[counter] = words[counter].toLowerCase();
				} else words[counter] = str.substring(start);
				break;
			}
			if (str.charAt(j) == ' ' || str.charAt(j) == '\t') {
				end = j;
				if (str.charAt(end - 1)=='.' || str.charAt(end - 1)=='?' || str.charAt(end - 1)=='!') {
					end--;
					words[counter] = str.substring(start, end);
					words[counter] = words[counter].toLowerCase();
					start = end + 2;
				} else {
					words[counter] = str.substring(start, end);
					words[counter] = words[counter].toLowerCase();
					start = end + 1;
				}
				counter++;
			}
		}
		
		return words;
	}
	
	public String[] noRPT (String[] norpt, String[] words) {
		norpt[0] = words[0];
		int count = 0;
		
		for(int j = 1; j < words.length; j++) {
			boolean find = false;
			if (words[j].contentEquals("") == true)
				continue;
			
			for(int k = 0; k <= count; k++) {
				if (words[j].equals(norpt[k]) == true) {
					find = true;
				}
			}
			if (find == false) {
				count++;
				norpt[count] = words[j];
			}
		}
		
		return norpt;
	}
	
	public void errorCheck (int num) throws InvalidInput {
		if (num == 0) {
			throw new InvalidInput("You must enter a string of words");
		}
	}
}
