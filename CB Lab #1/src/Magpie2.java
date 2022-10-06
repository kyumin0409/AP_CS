/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		String trimmed = statement.trim();
		if(trimmed.length()<1){
			response = "Say something, please.";
		}
		else if ((findKeyword(statement, "no", 0)) >= 0)
		{
			response = "Why so negative?";
		}
		else if ((findKeyword(statement, "mother", 0)) >= 0
				|| (findKeyword(statement, "father", 0)) >= 0
				|| (findKeyword(statement, "sister", 0)) >= 0
				|| (findKeyword(statement, "brother", 0)) >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (findKeyword(statement, "dog", 0) >= 0 || findKeyword(statement, "cat", 0) >= 0){
			response = "Tell me more about your pets.";
		}
		else if (findKeyword(statement, "Mr.", 0) >= 0){
			response = "He sounds like a good teacher.";
		}
		else if (findKeyword(statement, "Mrs.", 0) >= 0 || findKeyword(statement, "Ms.", 0) >= 0){
			response = "She sounds like a good teacher.";
		}
		else if (findKeyword(statement, "yes", 0) >= 0){
			response = "Yay!";		
		}
		else if (findKeyword(statement, "tired", 0) >= 0){
			response = "Me too...";
		}
		else if (findKeyword(statement, "hungry", 0) >= 0){
			response = "Give me food";
		}
		else if (findKeyword(statement, "I want", 0) >= 0){
			response = phrase(statement, "I want");
		}
		else if (findKeyword(statement, "I", 0) >= 0){
			response = phrase(statement, "I");
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}
	
	/**
	 * finds keywords (not words included in another word)
	 * @param statement the user statement
	 * @param goal keyword we're looking for
	 * @param startPos starting position of the search in the statement (index)
	 * @return the index of keyword location in the statement
	 */
	private int findKeyword(String statement, String goal, int startPos){
		statement = statement.toLowerCase();//making everything lowercase
		goal = goal.toLowerCase();
		String plural = goal+"s";//plural
		int length = goal.length();
		int wholeLength = statement.length();
		
		if(length>wholeLength){//when the goal is longer than statement
			return -1;
		}
		if(length == wholeLength){//when the goal and the statement have the same length
			if(statement.equals(goal)){//when the statement is the goal
				return 0;
			}else{
				return -1;
			}
		}
		//when goal or plural is found as a word in the statement
		if(statement.indexOf(" " + goal + " ")!= -1){
			return statement.indexOf(" " + goal + " ")+1;
		}
		if(statement.indexOf(" " + plural + " ")!= -1){
			return statement.indexOf(" " + plural + " ")+1;
		}
		//when the goal or plural is the very first word of the statement
		if(statement.substring(0, length).equals(goal)){
			return 0;
		}
		if(statement.substring(0, length+1).equals(plural)){
			return 0;
		}
		//when the goal or plural is the very last word of the statement
		if(statement.substring(wholeLength - length -1).equals(" " + goal)){
			return wholeLength-length;
		}
		if(statement.substring(wholeLength - length -2).equals(" " + plural)){
			return wholeLength - length -1;
		}
		//when the statement ends with punctuation
		if(statement.substring(wholeLength-1).equals(".") || 
				statement.substring(wholeLength-1).equals("?") || 
				statement.substring(wholeLength-1).equals("!")){
			if(statement.substring(wholeLength - length -2, wholeLength - 1).equals(" " + goal)){
				return wholeLength-length- 1;
			}
			if(statement.substring(wholeLength - length -3, wholeLength - 1).equals(" " + plural)){
				return wholeLength - length - 2;
			}
		}
			return -1;//when the keyword is not found in the statement

	}
	
	/**
	 * searches for a certain phrase, then returns specific response
	 * @param statement user input statement
	 * @param goal the phrase we're looking for
	 * @return the response
	 */
	private String phrase(String statement, String goal){
		statement = statement.toLowerCase();//making everything lowercase
		goal = goal.toLowerCase();
		int wholeLength = statement.length();
		int length = goal.length();
		
		if(wholeLength<=length){//when the statement is shorter than the phrase
			return getRandomResponse();
		}
		if(goal.equals("i want")){//when the phrase is "i want"
			String something = statement.substring(statement.indexOf("i want")+ 7);//check what comes after "i want"
			return "Would you really be happy if you had " + something + "?";	
		}
		if(goal.equals("i")){//when the phrase has "i"
			statement = statement.substring(statement.indexOf("i ")+2);
			String something = statement.substring(0, statement.indexOf(" "));//checks what comes after "i"
			statement = statement.substring(statement.indexOf(something) + something.length() +1);
			if(statement.equals("you")){//checks if the phrase is "i" + something + "you"
				return "Why do you " + something + " me?";
			}
			if(statement.substring(0, 4).equals("you ")){//checks if the phrase is "i" + something + "you" and if the statement goes on
				return "Why do you " + something + " me?";
			}else{
				return getRandomResponse();
			}
		}
		return getRandomResponse();//when the phrase doesn't exist
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 10;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		String[] randomResponse = {"Say that again?", "What?", "Uhh okay", "Alright"};
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "What did you say?";
		}
		else if (whichResponse == 5)
		{
			response = "That's not true.";
		}
		else
		{
			response = randomResponse[whichResponse-6];
		}
		return response;
	}
}
