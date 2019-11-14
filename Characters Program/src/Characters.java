
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
		int counter = 0, start = 0, end = 0;
		for (int j = 0; j < str.length(); j++) {
			if (j == str.length() - 1) {
				words[counter] = str.substring(start);
				break;
			}
			if (str.charAt(j) == ' ') {
				end = j;
				words[counter] = str.substring(start, end);
				start = end + 1;
				counter++;
			}
		}
		
		return words;
	}
	
	public String[] noRepeats (String[] input, int num) {
		int counter = 0;
		
		boolean[] isrpt = new boolean[num];
		
		for (int j = 0; j < input.length; j++) {
			for (int i = 0; i < input.length; i++) {
				if (input[j] == input[i])
					counter++;
			}
			if (counter > 1)
				isrpt[j] = true;
			
			counter = 0;
		}
		int newstrcount = num;
		for(int k = 0; k < isrpt.length; k++) {
			if (isrpt[k] == true)
				newstrcount--;
		}
		
		//new method start
		
		String[] newstr = new String[newstrcount];
		int count = 0;
		for(int h = 0; h < isrpt.length; h++) {
			if (isrpt[h] == false) {
				newstr[count] = input[h];
				count++;
			}
		}
		
		return newstr;
		
	}
	
	public int wordCounter (String[] str, String word) {
		int counter = 0;
		
		for (int j = 0; j < str.length; j++) {
			if (str[j] == word)
				counter++;
		}
		
		return counter;
	}
}
