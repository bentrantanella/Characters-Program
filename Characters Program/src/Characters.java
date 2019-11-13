
public class Characters {
	public String removeExtraSpaces (String input) {
		String newstring = "";
		
		for (int j = 0; j < input.length(); j++) {
			if (input.charAt(j) != ' ')
				newstring = newstring.concat(input.charAt(j) + "");
				
			if (input.charAt(j) == ' ' && input.charAt(j + 1) != ' ')
				newstring = newstring.concat(input.charAt(j) + "");
		}
		
		return newstring;
	}
}
